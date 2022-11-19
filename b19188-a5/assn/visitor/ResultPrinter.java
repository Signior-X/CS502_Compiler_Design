//
// Generated by JTB 1.3.2
//

package visitor;

import syntaxtree.*;

import java.util.*;

/**
 * Provides default methods which visit each node in the tree in depth-first
 * order.  Your visitors may extend this class.
 */
public class ResultPrinter implements GJNoArguVisitor<Integer> {
   HashMap<Node, Set<String>> resultMap;

   public ResultPrinter(HashMap<Node, Set<String>> r) {
      resultMap = r;
   }

   //
   // Auto class visitors--probably don't need to be overridden.
   //
   public Integer visit(NodeList n) {
      Integer _ret=null;
      int _count=0;
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
         e.nextElement().accept(this);
         _count++;
      }
      return _ret;
   }

   public Integer visit(NodeListOptional n) {
      if ( n.present() ) {
         Integer _ret=null;
         int _count=0;
         for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
            e.nextElement().accept(this);
            _count++;
         }
         return _ret;
      }
      else
         return null;
   }

   public Integer visit(NodeOptional n) {
      if ( n.present() )
         return n.node.accept(this);
      else
         return null;
   }

   public Integer visit(NodeSequence n) {
      Integer _ret=null;
      int _count=0;
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
         e.nextElement().accept(this);
         _count++;
      }
      return _ret;
   }

   public Integer visit(NodeToken n) { return null; }

   //
   // User-generated visitor methods below
   //

   /**
    * f0 -> ( <REGLIMIT> )?
    * f1 -> MainClass()
    * f2 -> ( TypeDeclaration() )*
    * f3 -> <EOF>
    */
   public Integer visit(Goal n) {
      Integer _ret=null;
      // if (n.f0.present()) {
      //    System.out.println("Register Limit: " + n.f0.node);
      // }
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
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
   public Integer visit(MainClass n) {
      Integer _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      n.f5.accept(this);
      n.f6.accept(this);
      n.f7.accept(this);
      n.f8.accept(this);
      n.f9.accept(this);
      n.f10.accept(this);
      n.f11.accept(this);
      n.f12.accept(this);
      n.f13.accept(this);
      n.f14.accept(this);
      n.f15.accept(this);
      n.f16.accept(this);
      n.f17.accept(this);
      return _ret;
   }

   /**
    * f0 -> ClassDeclaration()
    *       | ClassExtendsDeclaration()
    */
   public Integer visit(TypeDeclaration n) {
      Integer _ret=null;
      n.f0.accept(this);
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
   public Integer visit(ClassDeclaration n) {
      Integer _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      n.f5.accept(this);
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
   public Integer visit(ClassExtendsDeclaration n) {
      Integer _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      n.f5.accept(this);
      n.f6.accept(this);
      n.f7.accept(this);
      return _ret;
   }

   /**
    * f0 -> Type()
    * f1 -> Identifier()
    * f2 -> ";"
    */
   public Integer visit(VarDeclaration n) {
      if (resultMap.containsKey(n)) {
         System.out.println("VarDeclaration : " + resultMap.get(n));
      } else {
         System.err.println("LivenessQueryStatement missing: " + n);
      }
      Integer _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
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
   public Integer visit(MethodDeclaration n) {
      Integer _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      n.f5.accept(this);
      n.f6.accept(this);
      n.f7.accept(this);
      n.f8.accept(this);
      n.f9.accept(this);
      n.f10.accept(this);
      n.f11.accept(this);
      n.f12.accept(this);
      if (resultMap.containsKey(n)) {
         System.out.println("Method Return : " + resultMap.get(n));
      } else {
         System.err.println("LivenessQueryStatement missing: " + n);
      }
      return _ret;
   }

   /**
    * f0 -> FormalParameter()
    * f1 -> ( FormalParameterRest() )*
    */
   public Integer visit(FormalParameterList n) {
      Integer _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> Type()
    * f1 -> Identifier()
    */
   public Integer visit(FormalParameter n) {
      Integer _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> ","
    * f1 -> FormalParameter()
    */
   public Integer visit(FormalParameterRest n) {
      Integer _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> ArrayType()
    *       | BooleanType()
    *       | IntegerType()
    *       | FloatType()
    *       | Identifier()
    */
   public Integer visit(Type n) {
      Integer _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> "int"
    * f1 -> "["
    * f2 -> "]"
    */
   public Integer visit(ArrayType n) {
      Integer _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      return _ret;
   }

   /**
    * f0 -> "float"
    */
   public Integer visit(FloatType n) {
      Integer _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> "boolean"
    */
   public Integer visit(BooleanType n) {
      Integer _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> "int"
    */
   public Integer visit(IntegerType n) {
      Integer _ret=null;
      n.f0.accept(this);
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
   public Integer visit(Statement n) {
      Integer _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> "{"
    * f1 -> ( Statement() )*
    * f2 -> "}"
    */
   public Integer visit(Block n) {
      Integer _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      return _ret;
   }

   /**
    * f0 -> Identifier()
    * f1 -> "="
    * f2 -> Expression()
    * f3 -> ";"
    */
   public Integer visit(AssignmentStatement n) {
      if (resultMap.containsKey(n)) {
         System.out.println("AssignmentStatement : " + resultMap.get(n));
      } else {
         System.err.println("LivenessQueryStatement missing: " + n);
      }
      Integer _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      return _ret;
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
   public Integer visit(ArrayAssignmentStatement n) {
      if (resultMap.containsKey(n)) {
         System.out.println("ArrayAssignmentStatement : " + resultMap.get(n));
      } else {
         System.err.println("LivenessQueryStatement missing: " + n);
      }
      Integer _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      n.f5.accept(this);
      n.f6.accept(this);
      return _ret;
   }

   /**
    * f0 -> Identifier()
    * f1 -> "."
    * f2 -> Identifier()
    * f3 -> "="
    * f4 -> Identifier()
    * f5 -> ";"
    */
   public Integer visit(FieldAssignmentStatement n) {
      if (resultMap.containsKey(n)) {
         System.out.println("FieldAssignmentStatement : " + resultMap.get(n));
      } else {
         System.err.println("LivenessQueryStatement missing: " + n);
      }
      Integer _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      n.f5.accept(this);
      return _ret;
   }

   /**
    * f0 -> IfthenElseStatement()
    *       | IfthenStatement()
    */
   public Integer visit(IfStatement n) {
      Integer _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> "if"
    * f1 -> "("
    * f2 -> Identifier()
    * f3 -> ")"
    * f4 -> Statement()
    */
   public Integer visit(IfthenStatement n) {
      if (resultMap.containsKey(n)) {
         System.out.println("IfthenStatement : " + resultMap.get(n));
      } else {
         System.err.println("LivenessQueryStatement missing: " + n);
      }
      Integer _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
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
   public Integer visit(IfthenElseStatement n) {
      if (resultMap.containsKey(n)) {
         System.out.println("IfthenElseStatement : " + resultMap.get(n));
      } else {
         System.err.println("LivenessQueryStatement missing: " + n);
      }
      Integer _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      n.f5.accept(this);
      n.f6.accept(this);
      return _ret;
   }

   /**
    * f0 -> "while"
    * f1 -> "("
    * f2 -> Identifier()
    * f3 -> ")"
    * f4 -> Statement()
    */
   public Integer visit(WhileStatement n) {
      if (resultMap.containsKey(n)) {
         System.out.println("WhileStatement : " + resultMap.get(n));
      } else {
         System.err.println("LivenessQueryStatement missing: " + n);
      }
      Integer _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      return _ret;
   }

   /**
    * f0 -> "System.out.println"
    * f1 -> "("
    * f2 -> Identifier()
    * f3 -> ")"
    * f4 -> ";"
    */
   public Integer visit(PrintStatement n) {
      if (resultMap.containsKey(n)) {
         System.out.println("PrintStatement : " + resultMap.get(n));
      } else {
         System.err.println("LivenessQueryStatement missing: " + n);
      }
      Integer _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      return _ret;
   }

   /**
    * f0 -> <SCOMMENT1>
    * f1 -> <LIVENESSQUERY>
    * f2 -> <SCOMMENT2>
    */
   public Integer visit(LivenessQueryStatement n) {
      Integer _ret=null;
      if (resultMap.containsKey(n)) {
         System.out.println("LivenessQueryStatement : " + resultMap.get(n));
      } else {
         System.err.println("LivenessQueryStatement missing: " + n);
      }

      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      return _ret;
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
   public Integer visit(Expression n) {
      Integer _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> Identifier()
    * f1 -> "&&"
    * f2 -> Identifier()
    */
   public Integer visit(AndExpression n) {
      Integer _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      return _ret;
   }

   /**
    * f0 -> Identifier()
    * f1 -> "||"
    * f2 -> Identifier()
    */
   public Integer visit(OrExpression n) {
      Integer _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      return _ret;
   }

   /**
    * f0 -> Identifier()
    * f1 -> "<="
    * f2 -> Identifier()
    */
   public Integer visit(CompareExpression n) {
      Integer _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      return _ret;
   }

   /**
    * f0 -> Identifier()
    * f1 -> "!="
    * f2 -> Identifier()
    */
   public Integer visit(neqExpression n) {
      Integer _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      return _ret;
   }

   /**
    * f0 -> Identifier()
    * f1 -> "+"
    * f2 -> Identifier()
    */
   public Integer visit(PlusExpression n) {
      Integer _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      return _ret;
   }

   /**
    * f0 -> Identifier()
    * f1 -> "-"
    * f2 -> Identifier()
    */
   public Integer visit(MinusExpression n) {
      Integer _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      return _ret;
   }

   /**
    * f0 -> Identifier()
    * f1 -> "*"
    * f2 -> Identifier()
    */
   public Integer visit(TimesExpression n) {
      Integer _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      return _ret;
   }

   /**
    * f0 -> Identifier()
    * f1 -> "/"
    * f2 -> Identifier()
    */
   public Integer visit(DivExpression n) {
      Integer _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      return _ret;
   }

   /**
    * f0 -> Identifier()
    * f1 -> "["
    * f2 -> Identifier()
    * f3 -> "]"
    */
   public Integer visit(ArrayLookup n) {
      Integer _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      return _ret;
   }

   /**
    * f0 -> Identifier()
    * f1 -> "."
    * f2 -> "length"
    */
   public Integer visit(ArrayLength n) {
      Integer _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
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
   public Integer visit(MessageSend n) {
      Integer _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      n.f5.accept(this);
      return _ret;
   }

   /**
    * f0 -> Identifier()
    * f1 -> ( ArgRest() )*
    */
   public Integer visit(ArgList n) {
      Integer _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> ","
    * f1 -> Identifier()
    */
   public Integer visit(ArgRest n) {
      Integer _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
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
   public Integer visit(PrimaryExpression n) {
      Integer _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> <INTEGER_LITERAL>
    */
   public Integer visit(IntegerLiteral n) {
      Integer _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> <FLOAT_LITERAL>
    */
   public Integer visit(FloatLiteral n) {
      Integer _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> "true"
    */
   public Integer visit(TrueLiteral n) {
      Integer _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> "false"
    */
   public Integer visit(FalseLiteral n) {
      Integer _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> <IDENTIFIER>
    */
   public Integer visit(Identifier n) {
      Integer _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> "this"
    */
   public Integer visit(ThisExpression n) {
      Integer _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> "new"
    * f1 -> "int"
    * f2 -> "["
    * f3 -> Identifier()
    * f4 -> "]"
    */
   public Integer visit(ArrayAllocationExpression n) {
      Integer _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      return _ret;
   }

   /**
    * f0 -> "new"
    * f1 -> Identifier()
    * f2 -> "("
    * f3 -> ")"
    */
   public Integer visit(AllocationExpression n) {
      Integer _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      return _ret;
   }

   /**
    * f0 -> "!"
    * f1 -> Identifier()
    */
   public Integer visit(NotExpression n) {
      Integer _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      return _ret;
   }

}
