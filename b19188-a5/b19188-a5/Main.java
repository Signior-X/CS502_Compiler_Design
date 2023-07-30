import syntaxtree.*;
import visitor.*;

import java.util.*;

public class Main {
   public static void main(String[] args) {
      try {
         Node root = new FriendTJ(System.in).Goal();
         CFGGen cfgGen = new CFGGen();
         root.accept(cfgGen);

         ProgramCFG programCFG = cfgGen.getCFG();
         // BB.printBBDOT(programCFG);

         RunAnalysis ra = new RunAnalysis(programCFG);
         ra.startAnalysisBackward();

         // Assignment Starts here
         // Result Map contains a mapping from statements to live variables at that
         // statement
         HashMap<Node, Set<String>> resultMap = ra.getResultMap();

         // System.out.println(resultMap);
         // root.accept(new ResultPrinter(resultMap));
         root.accept(new GraphVisitor(resultMap));

         // System.out.println(GraphVisitor.varDeclarations);
         // System.out.println(GraphVisitor.methodGraphs);

         // Now we will do the algorithm for
         int K = GraphVisitor.RegisterLimit;
         for (String methodKey : GraphVisitor.methodGraphs.keySet()) {
            // First get the graph
            // By doing a deep copy
            HashMap<String, HashSet<String>> graph = new HashMap<String, HashSet<String>>();
            for (String node : GraphVisitor.methodGraphs.get(methodKey).keySet()) {
               HashSet<String> pointingNodes = new HashSet<String>(GraphVisitor.methodGraphs.get(methodKey).get(node));
               graph.put(node, pointingNodes);
            }

            int spillCount = 0;
            LinkedList<String> stack = new LinkedList<String>();
            while (graph.keySet().size() > 0) {
               String choosenNode = "";
               String highestDegreeNode = "";
               int currentMax = 0;
               for (String node : graph.keySet()) {
                  if (graph.get(node).size() < K) {
                     // No need to spill
                     choosenNode = node;
                     break;
                  }

                  if (graph.get(node).size() > currentMax) {
                     currentMax = graph.get(node).size();
                     highestDegreeNode = node;
                  }
               }

               if (choosenNode.length() == 0) {
                  // spill is needed, spill any of the node
                  // we will take the first node in the set
                  // Heuristic
                  String spillVar = highestDegreeNode;

                  GraphVisitor.methodReplacements.get(methodKey).put(spillVar, "spill__" + spillCount);
                  spillCount++;
                  removeVarFromGraph(graph, spillVar);
               } else {
                  // no need to spill
                  // Add in the stack
                  stack.push(choosenNode);
                  removeVarFromGraph(graph, choosenNode);
               }
            }

            // System.out.println("stack for " + methodKey + " is: " + stack);
            while(stack.size() > 0) {
               String node = stack.pop();

               // we try finding the register number for this node
               for (int i = 0; i < K; i++) {
                  String tryRegister = "register__" + i;

                  // System.out.println("CONFLICTING: " + GraphVisitor.methodGraphs.get(methodKey));
                  if (registerIsPossible(methodKey, GraphVisitor.methodGraphs.get(methodKey).get(node), tryRegister)) {
                     GraphVisitor.methodReplacements.get(methodKey).put(node, tryRegister);
                     break;
                  }
               }
            }
         }

         // System.out.println(GraphVisitor.methodReplacements);
         // System.out.println(GraphVisitor.methodGraphs);

         // STEP 3: We will generate the code
         root.accept(new CodeGenerator(resultMap));
         System.out.println(CodeGenerator.finalCode);
      } catch (ParseException e) {
         System.out.println(e.toString());
      }
   }

   private static void removeVarFromGraph(HashMap<String, HashSet<String>> graph, String var) {
      // System.out.println("BEFORE GRAPH: " + var + " : " + graph);
      for (String node : graph.get(var)) {
         // Now remove var from node
         graph.get(node).remove(var);
      }
      graph.remove(var);
      // System.out.println("AFTER GRAPH: " + graph);
   }

   private static boolean registerIsPossible(String methodKey, HashSet<String> connectedNodes, String register) {
      // System.out.println("Checking register possible for " + register + " connected nodes: " + connectedNodes);

      for (String node : connectedNodes) {
         HashMap<String, String> replacements = GraphVisitor.methodReplacements.get(methodKey);
         if (replacements.containsKey(node)) {
            if (replacements.get(node).equals(register)) {
               // Not possible
               return false;
            }
         }
      }

      return true;
   }
}
