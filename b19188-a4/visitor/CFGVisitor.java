//
// Generated by JTB 1.3.2
//

package visitor;
import syntaxtree.*;
import java.util.*;

import in.ac.iitmandi.compl.datastructures.CFGNode;
import in.ac.iitmandi.compl.datastructures.NODETYPE;
import in.ac.iitmandi.compl.utils.CommonUtils;

/**
 * Provides default methods which visit each node in the tree in depth-first
 * order.  Your visitors may extend this class.
 */
public class CFGVisitor implements GJVisitor<List<CFGNode>,List<CFGNode>> {
   //
   // Auto class visitors--probably don't need to be overridden.
   //
   private int lineNumber;
   boolean printFinalAnswer;
   public CFGVisitor() {
      lineNumber = 0;
      printFinalAnswer = false;
   }

   public CFGVisitor(boolean printFinalAnswer) {
      lineNumber = 0;
      this.printFinalAnswer = printFinalAnswer;
   }

   public List<CFGNode> visit(NodeList n, List<CFGNode> predNodes) {
      List<CFGNode> _ret=null;
      int _count=0;
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
         e.nextElement().accept(this,predNodes);
         _count++;
      }
      return _ret;
   }

   public List<CFGNode> visit(NodeListOptional n, List<CFGNode> predNodes) {
      if ( n.present() ) {
         List<CFGNode> _ret=null;
         int _count=0;
         for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
            e.nextElement().accept(this,predNodes);
            _count++;
         }
         return _ret;
      }
      else
         return null;
   }

   public List<CFGNode> visit(NodeOptional n, List<CFGNode> predNodes) {
      if ( n.present() )
         return n.node.accept(this,predNodes);
      else
         return null;
   }

   public List<CFGNode> visit(NodeSequence n, List<CFGNode> predNodes) {
      List<CFGNode> _ret=null;
      int _count=0;
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
         e.nextElement().accept(this,predNodes);
         _count++;
      }
      return _ret;
   }

   public List<CFGNode> visit(NodeToken n, List<CFGNode> predNodes) { return null; }

   //
   // User-generated visitor methods below
   //

   /**
    * f0 -> MainClass()
    * f1 -> ( TypeDeclaration() )*
    * f2 -> <EOF>
    */
   public List<CFGNode> visit(Goal n, List<CFGNode> predNodes) {
      List<CFGNode> _ret=null;
      n.f0.accept(this, predNodes);
      n.f1.accept(this, predNodes);
      n.f2.accept(this, predNodes);
      return _ret;
   }

   /**
    * f0 -> "class"
    * f1 -> Identifier()
    * f2 -> "{"
    * f3 -> "public"
    * f4 -> "static"
    * f5 -> "void"
    * f6 -> "main"
    * f7 -> "("
    * f8 -> "String"
    * f9 -> "["
    * f10 -> "]"
    * f11 -> Identifier()
    * f12 -> ")"
    * f13 -> "{"
    * f14 -> ( VarDeclaration() )*
    * f15 -> ( Statement() )*
    * f16 -> "}"
    * f17 -> "}"
    */
   public List<CFGNode> visit(MainClass n, List<CFGNode> predNodes) {
      List<CFGNode> _ret=null;
      n.f0.accept(this, predNodes);
      n.f1.accept(this, predNodes);
      n.f2.accept(this, predNodes);
      n.f3.accept(this, predNodes);
      n.f4.accept(this, predNodes);
      n.f5.accept(this, predNodes);
      n.f6.accept(this, predNodes);
      n.f7.accept(this, predNodes);
      n.f8.accept(this, predNodes);
      n.f9.accept(this, predNodes);
      n.f10.accept(this, predNodes);
      n.f11.accept(this, predNodes);
      n.f12.accept(this, predNodes);
      n.f13.accept(this, predNodes);
      n.f14.accept(this, predNodes);
      n.f15.accept(this, predNodes);
      n.f16.accept(this, predNodes);
      n.f17.accept(this, predNodes);
      return _ret;
   }

   /**
    * f0 -> ClassDeclaration()
    *       | ClassExtendsDeclaration()
    */
   public List<CFGNode> visit(TypeDeclaration n, List<CFGNode> predNodes) {
      List<CFGNode> _ret=null;
      n.f0.accept(this, predNodes);
      return _ret;
   }

   /**
    * f0 -> "class"
    * f1 -> Identifier()
    * f2 -> "{"
    * f3 -> ( VarDeclaration() )*
    * f4 -> ( MethodDeclaration() )*
    * f5 -> "}"
    */
   public List<CFGNode> visit(ClassDeclaration n, List<CFGNode> predNodes) {
      List<CFGNode> _ret=null;
      n.f0.accept(this, predNodes);
      n.f1.accept(this, predNodes);
      n.f2.accept(this, predNodes);
      n.f3.accept(this, predNodes);
      n.f4.accept(this, predNodes);
      n.f5.accept(this, predNodes);
      return _ret;
   }

   /**
    * f0 -> "class"
    * f1 -> Identifier()
    * f2 -> "extends"
    * f3 -> Identifier()
    * f4 -> "{"
    * f5 -> ( VarDeclaration() )*
    * f6 -> ( MethodDeclaration() )*
    * f7 -> "}"
    */
   public List<CFGNode> visit(ClassExtendsDeclaration n, List<CFGNode> predNodes) {
      List<CFGNode> _ret=null;
      n.f0.accept(this, predNodes);
      n.f1.accept(this, predNodes);
      n.f2.accept(this, predNodes);
      n.f3.accept(this, predNodes);
      n.f4.accept(this, predNodes);
      n.f5.accept(this, predNodes);
      n.f6.accept(this, predNodes);
      n.f7.accept(this, predNodes);
      return _ret;
   }

   /**
    * f0 -> Type()
    * f1 -> Identifier()
    * f2 -> ";"
    */
   public List<CFGNode> visit(VarDeclaration n, List<CFGNode> predNodes) {
      List<CFGNode> _ret=null;
      n.f0.accept(this, predNodes);
      n.f1.accept(this, predNodes);
      n.f2.accept(this, predNodes);
      return _ret;
   }

   /**
    * f0 -> "public"
    * f1 -> Type()
    * f2 -> Identifier()
    * f3 -> "("
    * f4 -> ( FormalParameterList() )?
    * f5 -> ")"
    * f6 -> "{"
    * f7 -> ( VarDeclaration() )*
    * f8 -> ( Statement() )*
    * f9 -> "return"
    * f10 -> Identifier()
    * f11 -> ";"
    * f12 -> "}"
    */
   public List<CFGNode> visit(MethodDeclaration n, List<CFGNode> predNodes) {
      List<CFGNode> _ret=null;
      if(n.f8.present()) {
    	  Vector<Node> stmtNodes = n.f8.nodes;
    	  CFGNode startNode = new CFGNode(NODETYPE.STARTNODE, lineNumber);
        lineNumber++;
    	  List<CFGNode> predNode = new ArrayList<>();
		  predNode.add(startNode);
    	  for(Node stmtNode : stmtNodes) {
    		  predNode=stmtNode.accept(this,predNode);
    	  }
    	  CFGNode retNode = new CFGNode(n.f10,NODETYPE.RETURNNODE, lineNumber);
        lineNumber++;
    	  addEdges(predNode, retNode);
    	  CFGNode endNode = new CFGNode(NODETYPE.ENDNODE, lineNumber);
        lineNumber++;
    	  List<CFGNode> _retNodes= new ArrayList<>();
    	  _retNodes.add(retNode);
    	  addEdges(_retNodes, endNode);
    	  CommonUtils.addToMethodCFGMap(n, startNode);
      }
      return _ret;
   }

   /**
    * f0 -> FormalParameter()
    * f1 -> ( FormalParameterRest() )*
    */
   public List<CFGNode> visit(FormalParameterList n, List<CFGNode> predNodes) {
      List<CFGNode> _ret=null;
      n.f0.accept(this, predNodes);
      n.f1.accept(this, predNodes);
      return _ret;
   }

   /**
    * f0 -> Type()
    * f1 -> Identifier()
    */
   public List<CFGNode> visit(FormalParameter n, List<CFGNode> predNodes) {
      List<CFGNode> _ret=null;
      n.f0.accept(this, predNodes);
      n.f1.accept(this, predNodes);
      return _ret;
   }

   /**
    * f0 -> ","
    * f1 -> FormalParameter()
    */
   public List<CFGNode> visit(FormalParameterRest n, List<CFGNode> predNodes) {
      List<CFGNode> _ret=null;
      n.f0.accept(this, predNodes);
      n.f1.accept(this, predNodes);
      return _ret;
   }

   /**
    * f0 -> ArrayType()
    *       | BooleanType()
    *       | IntegerType()
    *       | FloatType()
    *       | Identifier()
    */
   public List<CFGNode> visit(Type n, List<CFGNode> predNodes) {
      List<CFGNode> _ret=null;
      n.f0.accept(this, predNodes);
      return _ret;
   }

   /**
    * f0 -> "int"
    * f1 -> "["
    * f2 -> "]"
    */
   public List<CFGNode> visit(ArrayType n, List<CFGNode> predNodes) {
      List<CFGNode> _ret=null;
      n.f0.accept(this, predNodes);
      n.f1.accept(this, predNodes);
      n.f2.accept(this, predNodes);
      return _ret;
   }

   /**
    * f0 -> "float"
    */
   public List<CFGNode> visit(FloatType n, List<CFGNode> predNodes) {
      List<CFGNode> _ret=null;
      n.f0.accept(this, predNodes);
      return _ret;
   }

   /**
    * f0 -> "boolean"
    */
   public List<CFGNode> visit(BooleanType n, List<CFGNode> predNodes) {
      List<CFGNode> _ret=null;
      n.f0.accept(this, predNodes);
      return _ret;
   }

   /**
    * f0 -> "int"
    */
   public List<CFGNode> visit(IntegerType n, List<CFGNode> predNodes) {
      List<CFGNode> _ret=null;
      n.f0.accept(this, predNodes);
      return _ret;
   }

   /**
    * f0 -> Block()
    *       | AssignmentStatement()
    *       | ArrayAssignmentStatement()
    *       | FieldAssignmentStatement()
    *       | IfStatement()
    *       | WhileStatement()
    *       | PrintStatement()
    *       | LivenessQueryStatement()
    */
   public List<CFGNode> visit(Statement n, List<CFGNode> predNodes) {
	   return n.f0.accept(this, predNodes);
   }

   /**
    * TO-DO
    * f0 -> "{"
    * f1 -> ( Statement() )*
    * f2 -> "}"
    */
   public List<CFGNode> visit(Block n, List<CFGNode> predNodes) {
      if(n.f1.present()) {
    	  Vector<Node> stmtNodes = n.f1.nodes;
    	  for(Node stmtNode : stmtNodes) {
    		  predNodes=stmtNode.accept(this,predNodes);
    	  }
      }
      return predNodes;
   }

   /**
    * f0 -> Identifier()
    * f1 -> "="
    * f2 -> Expression()
    * f3 -> ";"
    */
   public List<CFGNode> visit(AssignmentStatement n, List<CFGNode> predNodes) {
	   return constructCFGNode(n, predNodes);
   }


   /**
    * f0 -> Identifier()
    * f1 -> "["
    * f2 -> Identifier()
    * f3 -> "]"
    * f4 -> "="
    * f5 -> Identifier()
    * f6 -> ";"
    */
   public List<CFGNode> visit(ArrayAssignmentStatement n, List<CFGNode> predNodes) {
	   return constructCFGNode(n, predNodes);
   }

   /**
    * f0 -> Identifier()
    * f1 -> "."
    * f2 -> Identifier()
    * f3 -> "="
    * f4 -> Identifier()
    * f5 -> ";"
    */
   public List<CFGNode> visit(FieldAssignmentStatement n, List<CFGNode> predNodes) {
	   return constructCFGNode(n, predNodes);
   }

   /**
    * f0 -> IfthenElseStatement()
    *       | IfthenStatement()
    */
   public List<CFGNode> visit(IfStatement n, List<CFGNode> predNodes) {
	   return n.f0.accept(this, predNodes);
   }

   /**
    * f0 -> "if"
    * f1 -> "("
    * f2 -> Identifier()
    * f3 -> ")"
    * f4 -> Statement()
    */
   public List<CFGNode> visit(IfthenStatement n, List<CFGNode> predNodes) {
	   List<CFGNode> ifNode = constructCFGNode(n, predNodes);  
	   List<CFGNode> thenNodes = n.f4.accept(this, ifNode);
	   List<CFGNode> _ret = concatMaps(ifNode, thenNodes);
	   return _ret;
   }

   /**
    * f0 -> "if"
    * f1 -> "("
    * f2 -> Identifier()
    * f3 -> ")"
    * f4 -> Statement()
    * f5 -> "else"
    * f6 -> Statement()
    */
   public List<CFGNode> visit(IfthenElseStatement n, List<CFGNode> predNodes) {
	   List<CFGNode> ifNode = constructCFGNode(n, predNodes);  
	   List<CFGNode> thenNodes = n.f4.accept(this, ifNode);
	   List<CFGNode> elseNodes = n.f6.accept(this, ifNode);
	   return concatMaps(thenNodes, elseNodes);
   }

   /**
    * f0 -> "while"
    * f1 -> "("
    * f2 -> Identifier()
    * f3 -> ")"
    * f4 -> Statement()
    */
   public List<CFGNode> visit(WhileStatement n, List<CFGNode> predNodes) {
      List<CFGNode> whileNodes = constructCFGNode(n, predNodes);  
      List<CFGNode> thenNodes = n.f4.accept(this, whileNodes);
      if(CommonUtils.isNotNull(thenNodes)) {
    	  for(CFGNode node:thenNodes) {
    		  for(CFGNode whileNode : whileNodes) {
    			  node.addSuccessorNode(whileNode);
    			  whileNode.addPredecessorNode(node);
    		  }
    	  }
      }
      return whileNodes;
   }

   /**
    * f0 -> "System.out.println"
    * f1 -> "("
    * f2 -> Identifier()
    * f3 -> ")"
    * f4 -> ";"
    */
   public List<CFGNode> visit(PrintStatement n, List<CFGNode> predNodes) {
	   return constructCFGNode(n, predNodes);
   }

   /**
    * f0 -> <SCOMMENT1>
    * f1 -> <LIVENESSQUERY>
    * f2 -> <SCOMMENT2>
    */
   public List<CFGNode> visit(LivenessQueryStatement n, List<CFGNode> predNodes) {
      return constructCFGNodeLiveStmt(n, predNodes);
   }

   /**
    * f0 -> OrExpression()
    *       | AndExpression()
    *       | CompareExpression()
    *       | neqExpression()
    *       | PlusExpression()
    *       | MinusExpression()
    *       | TimesExpression()
    *       | DivExpression()
    *       | ArrayLookup()
    *       | ArrayLength()
    *       | MessageSend()
    *       | PrimaryExpression()
    */
   public List<CFGNode> visit(Expression n, List<CFGNode> predNodes) {
      List<CFGNode> _ret=null;
      n.f0.accept(this, predNodes);
      return _ret;
   }

   /**
    * f0 -> Identifier()
    * f1 -> "&&"
    * f2 -> Identifier()
    */
   public List<CFGNode> visit(AndExpression n, List<CFGNode> predNodes) {
      List<CFGNode> _ret=null;
      n.f0.accept(this, predNodes);
      n.f1.accept(this, predNodes);
      n.f2.accept(this, predNodes);
      return _ret;
   }

   /**
    * f0 -> Identifier()
    * f1 -> "||"
    * f2 -> Identifier()
    */
   public List<CFGNode> visit(OrExpression n, List<CFGNode> predNodes) {
      List<CFGNode> _ret=null;
      n.f0.accept(this, predNodes);
      n.f1.accept(this, predNodes);
      n.f2.accept(this, predNodes);
      return _ret;
   }

   /**
    * f0 -> Identifier()
    * f1 -> "<="
    * f2 -> Identifier()
    */
   public List<CFGNode> visit(CompareExpression n, List<CFGNode> predNodes) {
      List<CFGNode> _ret=null;
      n.f0.accept(this, predNodes);
      n.f1.accept(this, predNodes);
      n.f2.accept(this, predNodes);
      return _ret;
   }

   /**
    * f0 -> Identifier()
    * f1 -> "!="
    * f2 -> Identifier()
    */
   public List<CFGNode> visit(neqExpression n, List<CFGNode> predNodes) {
      List<CFGNode> _ret=null;
      n.f0.accept(this, predNodes);
      n.f1.accept(this, predNodes);
      n.f2.accept(this, predNodes);
      return _ret;
   }

   /**
    * f0 -> Identifier()
    * f1 -> "+"
    * f2 -> Identifier()
    */
   public List<CFGNode> visit(PlusExpression n, List<CFGNode> predNodes) {
      List<CFGNode> _ret=null;
      n.f0.accept(this, predNodes);
      n.f1.accept(this, predNodes);
      n.f2.accept(this, predNodes);
      return _ret;
   }

   /**
    * f0 -> Identifier()
    * f1 -> "-"
    * f2 -> Identifier()
    */
   public List<CFGNode> visit(MinusExpression n, List<CFGNode> predNodes) {
      List<CFGNode> _ret=null;
      n.f0.accept(this, predNodes);
      n.f1.accept(this, predNodes);
      n.f2.accept(this, predNodes);
      return _ret;
   }

   /**
    * f0 -> Identifier()
    * f1 -> "*"
    * f2 -> Identifier()
    */
   public List<CFGNode> visit(TimesExpression n, List<CFGNode> predNodes) {
      List<CFGNode> _ret=null;
      n.f0.accept(this, predNodes);
      n.f1.accept(this, predNodes);
      n.f2.accept(this, predNodes);
      return _ret;
   }

   /**
    * f0 -> Identifier()
    * f1 -> "/"
    * f2 -> Identifier()
    */
   public List<CFGNode> visit(DivExpression n, List<CFGNode> predNodes) {
      List<CFGNode> _ret=null;
      n.f0.accept(this, predNodes);
      n.f1.accept(this, predNodes);
      n.f2.accept(this, predNodes);
      return _ret;
   }

   /**
    * f0 -> Identifier()
    * f1 -> "["
    * f2 -> Identifier()
    * f3 -> "]"
    */
   public List<CFGNode> visit(ArrayLookup n, List<CFGNode> predNodes) {
      List<CFGNode> _ret=null;
      n.f0.accept(this, predNodes);
      n.f1.accept(this, predNodes);
      n.f2.accept(this, predNodes);
      n.f3.accept(this, predNodes);
      return _ret;
   }

   /**
    * f0 -> Identifier()
    * f1 -> "."
    * f2 -> "length"
    */
   public List<CFGNode> visit(ArrayLength n, List<CFGNode> predNodes) {
      List<CFGNode> _ret=null;
      n.f0.accept(this, predNodes);
      n.f1.accept(this, predNodes);
      n.f2.accept(this, predNodes);
      return _ret;
   }

   /**
    * f0 -> Identifier()
    * f1 -> "."
    * f2 -> Identifier()
    * f3 -> "("
    * f4 -> ( ArgList() )?
    * f5 -> ")"
    */
   public List<CFGNode> visit(MessageSend n, List<CFGNode> predNodes) {
      List<CFGNode> _ret=null;
      n.f0.accept(this, predNodes);
      n.f1.accept(this, predNodes);
      n.f2.accept(this, predNodes);
      n.f3.accept(this, predNodes);
      n.f4.accept(this, predNodes);
      n.f5.accept(this, predNodes);
      return _ret;
   }

   /**
    * f0 -> Identifier()
    * f1 -> ( ArgRest() )*
    */
   public List<CFGNode> visit(ArgList n, List<CFGNode> predNodes) {
      List<CFGNode> _ret=null;
      n.f0.accept(this, predNodes);
      n.f1.accept(this, predNodes);
      return _ret;
   }

   /**
    * f0 -> ","
    * f1 -> Identifier()
    */
   public List<CFGNode> visit(ArgRest n, List<CFGNode> predNodes) {
      List<CFGNode> _ret=null;
      n.f0.accept(this, predNodes);
      n.f1.accept(this, predNodes);
      return _ret;
   }

   /**
    * f0 -> IntegerLiteral()
    *       | FloatLiteral()
    *       | TrueLiteral()
    *       | FalseLiteral()
    *       | Identifier()
    *       | ThisExpression()
    *       | ArrayAllocationExpression()
    *       | AllocationExpression()
    *       | NotExpression()
    */
   public List<CFGNode> visit(PrimaryExpression n, List<CFGNode> predNodes) {
      List<CFGNode> _ret=null;
      n.f0.accept(this, predNodes);
      return _ret;
   }

   /**
    * f0 -> <INTEGER_LITERAL>
    */
   public List<CFGNode> visit(IntegerLiteral n, List<CFGNode> predNodes) {
      List<CFGNode> _ret=null;
      n.f0.accept(this, predNodes);
      return _ret;
   }

   /**
    * f0 -> <FLOAT_LITERAL>
    */
   public List<CFGNode> visit(FloatLiteral n, List<CFGNode> predNodes) {
      List<CFGNode> _ret=null;
      n.f0.accept(this, predNodes);
      return _ret;
   }

   /**
    * f0 -> "true"
    */
   public List<CFGNode> visit(TrueLiteral n, List<CFGNode> predNodes) {
      List<CFGNode> _ret=null;
      n.f0.accept(this, predNodes);
      return _ret;
   }

   /**
    * f0 -> "false"
    */
   public List<CFGNode> visit(FalseLiteral n, List<CFGNode> predNodes) {
      List<CFGNode> _ret=null;
      n.f0.accept(this, predNodes);
      return _ret;
   }

   /**
    * f0 -> <IDENTIFIER>
    */
   public List<CFGNode> visit(Identifier n, List<CFGNode> predNodes) {
      List<CFGNode> _ret=null;
      n.f0.accept(this, predNodes);
      return _ret;
   }

   /**
    * f0 -> "this"
    */
   public List<CFGNode> visit(ThisExpression n, List<CFGNode> predNodes) {
      List<CFGNode> _ret=null;
      n.f0.accept(this, predNodes);
      return _ret;
   }

   /**
    * f0 -> "new"
    * f1 -> "int"
    * f2 -> "["
    * f3 -> Identifier()
    * f4 -> "]"
    */
   public List<CFGNode> visit(ArrayAllocationExpression n, List<CFGNode> predNodes) {
      List<CFGNode> _ret=null;
      n.f0.accept(this, predNodes);
      n.f1.accept(this, predNodes);
      n.f2.accept(this, predNodes);
      n.f3.accept(this, predNodes);
      n.f4.accept(this, predNodes);
      return _ret;
   }

   /**
    * f0 -> "new"
    * f1 -> Identifier()
    * f2 -> "("
    * f3 -> ")"
    */
   public List<CFGNode> visit(AllocationExpression n, List<CFGNode> predNodes) {
      List<CFGNode> _ret=null;
      n.f0.accept(this, predNodes);
      n.f1.accept(this, predNodes);
      n.f2.accept(this, predNodes);
      n.f3.accept(this, predNodes);
      return _ret;
   }

   /**
    * f0 -> "!"
    * f1 -> Identifier()
    */
   public List<CFGNode> visit(NotExpression n, List<CFGNode> predNodes) {
      List<CFGNode> _ret=null;
      n.f0.accept(this, predNodes);
      n.f1.accept(this, predNodes);
      return _ret;
   }

   /**
    * @param n
    * @param predNodes
    * @return
    */
   private List<CFGNode> constructCFGNode(Node n, List<CFGNode> predNodes) {
	   List<CFGNode> _ret=new ArrayList<CFGNode>();
	   CFGNode cfgNode = new CFGNode(n, lineNumber);
      lineNumber++;
	   _ret.add(cfgNode);
	   addEdges(predNodes, cfgNode);
	   return _ret;
   }

   /**
    * @param n
    * @param predNodes
    * @return
    */
    private List<CFGNode> constructCFGNodeLiveStmt(Node n, List<CFGNode> predNodes) {
	   List<CFGNode> _ret=new ArrayList<CFGNode>();
	   CFGNode cfgNode = new CFGNode(n, NODETYPE.PRINTLIVENODE, lineNumber);
      lineNumber++;
	   _ret.add(cfgNode);
	   addEdges(predNodes, cfgNode);

      // Printing the final answer
      if (printFinalAnswer) {
         // inSet and outSet will be same, use any
         Set<String> liveVariables = Metadata.liveAnalysis.get(cfgNode.getStmtWithLine()).inSet;

         String ans = "";
         if (liveVariables.size() != 0) {
            Iterator<String> it = liveVariables.iterator();

            ans += it.next();
            while(it.hasNext()) {
               ans += "," + it.next();
            }
         }

         System.out.println(ans);
      }

	   return _ret;
   }
   
   /**
    * @param predNodes
    * @param cfgNode
    */
   private void addEdges(List<CFGNode> predNodes, CFGNode cfgNode) {
	   if(CommonUtils.isNotNull(predNodes)) {
		   for(CFGNode node : predNodes) {
			   node.addSuccessorNode(cfgNode);
			   cfgNode.addPredecessorNode(node);
		   }
	   }
   }
   
   /**
    * @param ifNode
    * @param thenNodes
    * @param _ret
    * @return
    */
   private List<CFGNode> concatMaps(List<CFGNode> ifNode, List<CFGNode> thenNodes) {
	   List<CFGNode> _ret = null;
	   if(CommonUtils.isNotNull(ifNode)) {
		   _ret = new ArrayList<>(ifNode);
		   if(CommonUtils.isNotNull(thenNodes)) {
			   for(CFGNode node:thenNodes) {
				   _ret.add(node);
			   }
		   }
	   }else if(CommonUtils.isNotNull(thenNodes)) {
		   _ret = new ArrayList<>(thenNodes);
	   }
	   return _ret;
   }
}
