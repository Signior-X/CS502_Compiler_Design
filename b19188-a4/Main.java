
import java.io.ByteArrayInputStream;

import in.ac.iitmandi.compl.datastructures.CFGNode;
import syntaxtree.*;
import visitor.*;
import java.util.*;

public class Main {
   public static void main(String[] args) {
      try {
         Node root = new FriendsTJ(System.in).Goal();
         CFGVisitor cfgVisitor = new CFGVisitor();
         root.accept(cfgVisitor, null);

         // DemoVisitor demoVisitor = new DemoVisitor(); //This is a demo visitor. You
         // need to construct a similar visitor for this assignment. You may also see
         // CFGVisitor class for more info.
         // root.accept(demoVisitor);

         // Defining the static metadata, so that data can be collected
         Metadata metadata = new Metadata();

         // This creates all the metaData needed
         InOutSetGenerator inOutSetGenerator = new InOutSetGenerator();
         root.accept(inOutSetGenerator);

         // Now we have the lhs and rhs of each statement
         // Metadata.printData();

         LiveVariableAnalyser analyser = new LiveVariableAnalyser();
         root.accept(analyser);

         // Now we have the lhs and rhs of each statement
         // Metadata.printData();
         CFGVisitor cfgVisitorAnswer = new CFGVisitor(true);
         root.accept(cfgVisitorAnswer, null);

      } catch (ParseException e) {
         System.out.println(e.toString());
      }
   }
}
