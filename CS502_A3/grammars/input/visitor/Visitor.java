//
// Generated by JTB 1.3.2
//

package visitor;
import syntaxtree.*;
import java.util.*;

/**
 * All void visitors must implement this interface.
 */

public interface Visitor {

   //
   // void Auto class visitors
   //

   public void visit(NodeList n);
   public void visit(NodeListOptional n);
   public void visit(NodeOptional n);
   public void visit(NodeSequence n);
   public void visit(NodeToken n);

   //
   // User-generated visitor methods below
   //

   /**
    * f0 -> MainClass()
    * f1 -> ( TypeDeclaration() )*
    * f2 -> <EOF>
    */
   public void visit(Goal n);

   /**
    * f0 -> "package"
    * f1 -> Identifier()
    * f2 -> ";"
    * f3 -> "public class"
    * f4 -> Identifier()
    * f5 -> "{"
    * f6 -> "public"
    * f7 -> "static"
    * f8 -> "void"
    * f9 -> "main"
    * f10 -> "("
    * f11 -> "String"
    * f12 -> "["
    * f13 -> "]"
    * f14 -> Identifier()
    * f15 -> ")"
    * f16 -> "{"
    * f17 -> ( VarDeclaration() )*
    * f18 -> ( Statement() )*
    * f19 -> "}"
    * f20 -> "}"
    */
   public void visit(MainClass n);

   /**
    * f0 -> ClassDeclaration()
    *       | ClassExtendsDeclaration()
    */
   public void visit(TypeDeclaration n);

   /**
    * f0 -> "class"
    * f1 -> Identifier()
    * f2 -> "{"
    * f3 -> ( FieldDeclaration() )*
    * f4 -> ( MethodDeclaration() )*
    * f5 -> "}"
    */
   public void visit(ClassDeclaration n);

   /**
    * f0 -> "class"
    * f1 -> Identifier()
    * f2 -> "extends"
    * f3 -> Identifier()
    * f4 -> "{"
    * f5 -> ( FieldDeclaration() )*
    * f6 -> ( MethodDeclaration() )*
    * f7 -> "}"
    */
   public void visit(ClassExtendsDeclaration n);

   /**
    * f0 -> Type()
    * f1 -> Identifier()
    * f2 -> ";"
    */
   public void visit(VarDeclaration n);

   /**
    * f0 -> IntegerType()
    * f1 -> Identifier()
    * f2 -> ";"
    */
   public void visit(FieldDeclaration n);

   /**
    * f0 -> "public"
    * f1 -> IntegerType()
    * f2 -> Identifier()
    * f3 -> "("
    * f4 -> ( FormalParameterList() )?
    * f5 -> ")"
    * f6 -> "{"
    * f7 -> ( VarDeclaration() )*
    * f8 -> ( Statement() )*
    * f9 -> "return"
    * f10 -> SubPrimaryExpression()
    * f11 -> ";"
    * f12 -> "}"
    */
   public void visit(MethodDeclaration n);

   /**
    * f0 -> FormalParameter()
    * f1 -> ( FormalParameterRest() )*
    */
   public void visit(FormalParameterList n);

   /**
    * f0 -> Type()
    * f1 -> Identifier()
    */
   public void visit(FormalParameter n);

   /**
    * f0 -> ","
    * f1 -> FormalParameter()
    */
   public void visit(FormalParameterRest n);

   /**
    * f0 -> BooleanType()
    *       | IntegerType()
    *       | StringType()
    *       | Identifier()
    */
   public void visit(Type n);

   /**
    * f0 -> "boolean"
    */
   public void visit(BooleanType n);

   /**
    * f0 -> "int"
    */
   public void visit(IntegerType n);

   /**
    * f0 -> "String"
    */
   public void visit(StringType n);

   /**
    * f0 -> Block()
    *       | AssignmentStatement()
    *       | FieldAssignmentStatement()
    *       | IfStatement()
    *       | WhileStatement()
    *       | PrintStatement()
    */
   public void visit(Statement n);

   /**
    * f0 -> "{"
    * f1 -> ( Statement() )*
    * f2 -> "}"
    */
   public void visit(Block n);

   /**
    * f0 -> Identifier()
    * f1 -> "="
    * f2 -> Expression()
    * f3 -> ";"
    */
   public void visit(AssignmentStatement n);

   /**
    * f0 -> Identifier()
    * f1 -> "."
    * f2 -> Identifier()
    * f3 -> "="
    * f4 -> Identifier()
    * f5 -> ";"
    */
   public void visit(FieldAssignmentStatement n);

   /**
    * f0 -> "if"
    * f1 -> "("
    * f2 -> Identifier()
    * f3 -> ")"
    * f4 -> Statement()
    * f5 -> "else"
    * f6 -> Statement()
    */
   public void visit(IfStatement n);

   /**
    * f0 -> "while"
    * f1 -> "("
    * f2 -> Identifier()
    * f3 -> ")"
    * f4 -> Statement()
    */
   public void visit(WhileStatement n);

   /**
    * f0 -> "System.out.println"
    * f1 -> "("
    * f2 -> SubPrimaryExpression()
    * f3 -> ")"
    * f4 -> ";"
    */
   public void visit(PrintStatement n);

   /**
    * f0 -> OrExpression()
    *       | AndExpression()
    *       | CompareExpression()
    *       | NeqExpression()
    *       | PlusExpression()
    *       | MinusExpression()
    *       | TimesExpression()
    *       | DivExpression()
    *       | MessageSend()
    *       | FieldReference()
    *       | PrimaryExpression()
    */
   public void visit(Expression n);

   /**
    * f0 -> SubPrimaryExpression()
    * f1 -> "&&"
    * f2 -> SubPrimaryExpression()
    */
   public void visit(AndExpression n);

   /**
    * f0 -> SubPrimaryExpression()
    * f1 -> "||"
    * f2 -> SubPrimaryExpression()
    */
   public void visit(OrExpression n);

   /**
    * f0 -> SubPrimaryExpression()
    * f1 -> "<"
    * f2 -> SubPrimaryExpression()
    */
   public void visit(CompareExpression n);

   /**
    * f0 -> SubPrimaryExpression()
    * f1 -> "!="
    * f2 -> SubPrimaryExpression()
    */
   public void visit(NeqExpression n);

   /**
    * f0 -> SubPrimaryExpression()
    * f1 -> "+"
    * f2 -> SubPrimaryExpression()
    */
   public void visit(PlusExpression n);

   /**
    * f0 -> SubPrimaryExpression()
    * f1 -> "-"
    * f2 -> SubPrimaryExpression()
    */
   public void visit(MinusExpression n);

   /**
    * f0 -> SubPrimaryExpression()
    * f1 -> "*"
    * f2 -> SubPrimaryExpression()
    */
   public void visit(TimesExpression n);

   /**
    * f0 -> SubPrimaryExpression()
    * f1 -> "/"
    * f2 -> SubPrimaryExpression()
    */
   public void visit(DivExpression n);

   /**
    * f0 -> Identifier()
    * f1 -> "."
    * f2 -> Identifier()
    */
   public void visit(FieldReference n);

   /**
    * f0 -> Identifier()
    * f1 -> "."
    * f2 -> Identifier()
    * f3 -> "("
    * f4 -> ( ArgList() )?
    * f5 -> ")"
    */
   public void visit(MessageSend n);

   /**
    * f0 -> SubPrimaryExpression()
    * f1 -> ( ArgRest() )*
    */
   public void visit(ArgList n);

   /**
    * f0 -> ","
    * f1 -> SubPrimaryExpression()
    */
   public void visit(ArgRest n);

   /**
    * f0 -> IntegerLiteral()
    *       | TrueLiteral()
    *       | FalseLiteral()
    *       | Identifier()
    *       | ThisExpression()
    *       | AllocationExpression()
    *       | NotExpression()
    */
   public void visit(PrimaryExpression n);

   /**
    * f0 -> IntegerLiteral()
    *       | TrueLiteral()
    *       | FalseLiteral()
    *       | Identifier()
    */
   public void visit(SubPrimaryExpression n);

   /**
    * f0 -> <INTEGER_LITERAL>
    */
   public void visit(IntegerLiteral n);

   /**
    * f0 -> "true"
    */
   public void visit(TrueLiteral n);

   /**
    * f0 -> "false"
    */
   public void visit(FalseLiteral n);

   /**
    * f0 -> <IDENTIFIER>
    */
   public void visit(Identifier n);

   /**
    * f0 -> "this"
    */
   public void visit(ThisExpression n);

   /**
    * f0 -> "new"
    * f1 -> Identifier()
    * f2 -> "("
    * f3 -> ")"
    */
   public void visit(AllocationExpression n);

   /**
    * f0 -> "!"
    * f1 -> Identifier()
    */
   public void visit(NotExpression n);

}

