//
// Generated by JTB 1.3.2
//

package visitor;
import syntaxtree.*;
import java.util.*;

import in.ac.iitmandi.compl.utils.CommonUtils;
import in.ac.iitmandi.compl.utils.FileUtils;

/**
 * Provides default methods which visit each node in the tree in depth-first
 * order.  Your visitors may extend this class.
 */
public class DotPrintVisitor implements GJNoArguVisitor<StringBuffer> {
   //
   // Auto class visitors--probably don't need to be overridden.
   //
   public StringBuffer visit(NodeList n) {
      StringBuffer _ret=null;
      int _count=0;
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
         e.nextElement().accept(this);
         _count++;
      }
      return _ret;
   }

   public StringBuffer visit(NodeListOptional n) {
      if ( n.present() ) {
         StringBuffer _ret=null;
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

   public StringBuffer visit(NodeOptional n) {
      if ( n.present() )
         return n.node.accept(this);
      else
         return null;
   }

   public StringBuffer visit(NodeSequence n) {
      StringBuffer _ret=null;
      int _count=0;
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
         e.nextElement().accept(this);
         _count++;
      }
      return _ret;
   }

   public StringBuffer visit(NodeToken n) { return null; }

   //
   // User-generated visitor methods below
   //

   /**
    * f0 -> MainClass()
    * f1 -> ( TypeDeclaration() )*
    * f2 -> <EOF>
    */
   public StringBuffer visit(Goal n) {
      StringBuffer _ret=null;
      n.f0.accept(this);
      _ret=addExprWithSpace(n.f1.accept(this),_ret);
      _ret=addExprWithSpace(n.f2.accept(this),_ret);
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
    * f8 -> "StringBuffer"
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
   public StringBuffer visit(MainClass n) {
      StringBuffer _ret=null;
      _ret=addExprWithSpace(n.f0.accept(this),_ret);
      _ret=addExprWithSpace(n.f1.accept(this),_ret);
      _ret=addExprWithSpace(n.f2.accept(this),_ret);
      _ret=addExprWithSpace(n.f3.accept(this),_ret);
      _ret=addExprWithSpace(n.f4.accept(this),_ret);
      _ret=addExprWithSpace(n.f5.accept(this),_ret);
      _ret=addExprWithSpace(n.f6.accept(this),_ret);
      _ret=addExprWithSpace(n.f7.accept(this),_ret);
      _ret=addExprWithSpace(n.f8.accept(this),_ret);
      _ret=addExprWithSpace(n.f9.accept(this),_ret);
      _ret=addExprWithSpace(n.f10.accept(this),_ret);
      _ret=addExprWithSpace(n.f11.accept(this),_ret);
      _ret=addExprWithSpace(n.f12.accept(this),_ret);
      _ret=addExprWithSpace(n.f13.accept(this),_ret);
      _ret=addExprWithSpace(n.f14.accept(this),_ret);
      _ret=addExprWithSpace(n.f15.accept(this),_ret);
      _ret=addExprWithSpace(n.f16.accept(this),_ret);
      _ret=addExprWithSpace(n.f17.accept(this),_ret);
      return _ret;
   }

   /**
    * f0 -> ClassDeclaration()
    *       | ClassExtendsDeclaration()
    */
   public StringBuffer visit(TypeDeclaration n) {
      return n.f0.accept(this);
   }

   /**
    * f0 -> "class"
    * f1 -> Identifier()
    * f2 -> "{"
    * f3 -> ( VarDeclaration() )*
    * f4 -> ( MethodDeclaration() )*
    * f5 -> "}"
    */
   public StringBuffer visit(ClassDeclaration n) {
	   String className = n.f1.accept(this).toString();
	   FileUtils.createJavaFile(className);
	   StringBuffer _ret=new StringBuffer(n.f0.tokenImage);
	   _ret=addExprWithSpace(n.f1.accept(this),_ret);
	   _ret=addExprWithSpace(new StringBuffer(n.f2.tokenImage),_ret);
	   _ret = handleOptionalStmts(n.f3, _ret);
	   _ret = handleOptionalStmts(n.f4, _ret);
	   _ret=addExprInNewLine(new StringBuffer(n.f5.tokenImage),_ret);
	   FileUtils.writeJavaFile(className,_ret.toString());
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
   public StringBuffer visit(ClassExtendsDeclaration n) {
	  String className = n.f1.accept(this).toString();
	  FileUtils.createJavaFile(className);
	  StringBuffer _ret=new StringBuffer(n.f0.tokenImage);
	  _ret=addExprWithSpace(n.f1.accept(this),_ret);
	  _ret=addExprWithSpace(new StringBuffer(n.f2.tokenImage),_ret);
	  _ret=addExprWithSpace(n.f3.accept(this),_ret);
	  _ret=addExprWithSpace(new StringBuffer(n.f4.tokenImage),_ret);
	  _ret=addExprInNewLine(n.f5.accept(this),_ret);
	  _ret=addExprInNewLine(n.f6.accept(this),_ret);
	  _ret=addExprInNewLine(new StringBuffer(n.f7.tokenImage),_ret);
	  FileUtils.writeJavaFile(className,_ret.toString());
      return _ret;
   }

   /**
    * f0 -> Type()
    * f1 -> Identifier()
    * f2 -> ";"
    */
   public StringBuffer visit(VarDeclaration n) {
	  StringBuffer _ret=n.f0.accept(this);
	  _ret=addExprWithSpace(n.f1.accept(this),_ret);
	  _ret=addExprWithoutSpace(new StringBuffer(n.f2.tokenImage),_ret);
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
   public StringBuffer visit(MethodDeclaration n) {
	  StringBuffer _ret=new StringBuffer(n.f0.tokenImage);
      _ret=addExprWithSpace(n.f1.accept(this),_ret);
      _ret=addExprWithSpace(n.f2.accept(this),_ret);
      _ret=addExprWithoutSpace(new StringBuffer(n.f3.tokenImage),_ret);
      _ret=handleOptionalStmtsWithoutSpace(n.f4, _ret);
      _ret=addExprWithoutSpace(new StringBuffer(n.f5.tokenImage),_ret);
      _ret=addExprWithSpace(new StringBuffer(n.f6.tokenImage),_ret);
      _ret=handleOptionalStmts(n.f7, _ret);
      _ret=handleOptionalStmts(n.f8,_ret);
      _ret=addExprInNewLine(new StringBuffer(n.f9.tokenImage),_ret);
      _ret=addExprWithSpace(n.f10.accept(this),_ret);
      _ret=addExprWithoutSpace(new StringBuffer(n.f11.tokenImage),_ret);
      _ret=addExprInNewLine(new StringBuffer(n.f12.tokenImage),_ret);
      return _ret;
   }

   /**
    * f0 -> FormalParameter()
    * f1 -> ( FormalParameterRest() )*
    */
   public StringBuffer visit(FormalParameterList n) {
      StringBuffer _ret=n.f0.accept(this);
      _ret=addExprWithSpace(n.f1.accept(this),_ret);
      return _ret;
   }

   /**
    * f0 -> Type()
    * f1 -> Identifier()
    */
   public StringBuffer visit(FormalParameter n) {
      StringBuffer _ret=n.f0.accept(this);
      _ret=addExprWithSpace(n.f1.accept(this),_ret);
      return _ret;
   }

   /**
    * f0 -> ","
    * f1 -> FormalParameter()
    */
   public StringBuffer visit(FormalParameterRest n) {
      StringBuffer _ret=new StringBuffer(n.f0.tokenImage);
      _ret=addExprWithoutSpace(n.f1.accept(this),_ret);
      return _ret;
   }

   /**
    * f0 -> ArrayType()
    *       | BooleanType()
    *       | IntegerType()
    *       | FloatType()
    *       | Identifier()
    */
   public StringBuffer visit(Type n) {
      return n.f0.accept(this);
   }

   /**
    * f0 -> "int"
    * f1 -> "["
    * f2 -> "]"
    */
   public StringBuffer visit(ArrayType n) {
      StringBuffer _ret=new StringBuffer(n.f0.tokenImage);
      _ret=addExprWithoutSpace(new StringBuffer(n.f1.tokenImage),_ret);
      _ret=addExprWithoutSpace(new StringBuffer(n.f2.tokenImage),_ret);
      return _ret;
   }

   /**
    * f0 -> "float"
    */
   public StringBuffer visit(FloatType n) {
	   return new StringBuffer(n.f0.tokenImage);
   }

   /**
    * f0 -> "boolean"
    */
   public StringBuffer visit(BooleanType n) {
	   return new StringBuffer(n.f0.tokenImage);
   }

   /**
    * f0 -> "int"
    */
   public StringBuffer visit(IntegerType n) {
	   return new StringBuffer(n.f0.tokenImage);
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
   public StringBuffer visit(Statement n) {
      // System.out.println("priyam statement");
	   return n.f0.accept(this);
   }

   /**
    * f0 -> "{"
    * f1 -> ( Statement() )*
    * f2 -> "}"
    */
   public StringBuffer visit(Block n) {
	  StringBuffer _ret=new StringBuffer(n.f0.tokenImage);
      _ret=handleOptionalStmts(n.f1,_ret);
      _ret=addExprInNewLine(new StringBuffer(n.f2.tokenImage),_ret);
      return _ret;
   }

   /**
    * f0 -> Identifier()
    * f1 -> "="
    * f2 -> Expression()
    * f3 -> ";"
    */
   public StringBuffer visit(AssignmentStatement n) {
      StringBuffer _ret=n.f0.accept(this);
      _ret=addExprWithSpace(new StringBuffer(n.f1.tokenImage),_ret);
      _ret=addExprWithSpace(n.f2.accept(this),_ret);
      _ret=addExprWithoutSpace(new StringBuffer(n.f3.tokenImage),_ret);
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
   public StringBuffer visit(ArrayAssignmentStatement n) {
	  StringBuffer _ret=n.f0.accept(this);
      _ret=addExprWithoutSpace(new StringBuffer(n.f1.tokenImage),_ret);
      _ret=addExprWithoutSpace(n.f2.accept(this),_ret);
      _ret=addExprWithoutSpace(new StringBuffer(n.f3.tokenImage),_ret);
      _ret=addExprWithSpace(new StringBuffer(n.f4.tokenImage),_ret);
      _ret=addExprWithSpace(n.f5.accept(this),_ret);
      _ret=addExprWithoutSpace(new StringBuffer(n.f6.tokenImage),_ret);
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
   public StringBuffer visit(FieldAssignmentStatement n) {
      StringBuffer _ret=n.f0.accept(this);
      _ret=addExprWithoutSpace(new StringBuffer(n.f1.tokenImage),_ret);
      _ret=addExprWithoutSpace(n.f2.accept(this),_ret);
      _ret=addExprWithSpace(new StringBuffer(n.f3.tokenImage),_ret);
      _ret=addExprWithSpace(n.f4.accept(this),_ret);
      _ret=addExprWithoutSpace(new StringBuffer(n.f5.tokenImage),_ret);
      return _ret;
   }

   /**
    * f0 -> IfthenElseStatement()
    *       | IfthenStatement()
    */
   public StringBuffer visit(IfStatement n) {
      return n.f0.accept(this);
   }

   /**
    * f0 -> "if"
    * f1 -> "("
    * f2 -> Identifier()
    * f3 -> ")"
    * f4 -> Statement()
    */
   public StringBuffer visit(IfthenStatement n) {
	  StringBuffer _ret=new StringBuffer(n.f0.tokenImage);
	  _ret=addExprWithoutSpace(new StringBuffer(n.f1.tokenImage),_ret);
      _ret=addExprWithoutSpace(n.f2.accept(this),_ret);
      _ret=addExprWithoutSpace(new StringBuffer(n.f3.tokenImage),_ret);
//      _ret=addExprInNewLine(n.f4.accept(this),_ret);
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
   public StringBuffer visit(IfthenElseStatement n) {
      StringBuffer _ret=new StringBuffer(n.f0.tokenImage);
      _ret=addExprWithoutSpace(new StringBuffer(n.f1.tokenImage),_ret);
      _ret=addExprWithoutSpace(n.f2.accept(this),_ret);
      _ret=addExprWithoutSpace(new StringBuffer(n.f3.tokenImage),_ret);
//      _ret=addExprInNewLine(n.f4.accept(this),_ret);
//      _ret=addExprInNewLine(new StringBuffer(n.f5.tokenImage),_ret);
//      _ret=addExprInNewLine(n.f6.accept(this),_ret);
      return _ret;
   }

   /**
    * f0 -> "while"
    * f1 -> "("
    * f2 -> Identifier()
    * f3 -> ")"
    * f4 -> Statement()
    */
   public StringBuffer visit(WhileStatement n) {
	  StringBuffer _ret=new StringBuffer(n.f0.tokenImage);
	  _ret=addExprWithoutSpace(new StringBuffer(n.f1.tokenImage),_ret);
      _ret=addExprWithSpace(n.f2.accept(this),_ret);
      _ret=addExprWithoutSpace(new StringBuffer(n.f3.tokenImage),_ret);
//      _ret=addExprInNewLine(n.f4.accept(this),_ret);
      return _ret;
   }

   /**
    * f0 -> "System.out.println"
    * f1 -> "("
    * f2 -> Identifier()
    * f3 -> ")"
    * f4 -> ";"
    */
   public StringBuffer visit(PrintStatement n) {
	  StringBuffer _ret=new StringBuffer(n.f0.tokenImage);
      _ret=addExprWithoutSpace(new StringBuffer(n.f1.tokenImage),_ret);
      _ret=addExprWithoutSpace(n.f2.accept(this),_ret);
      _ret=addExprWithoutSpace(new StringBuffer(n.f3.tokenImage),_ret);
      _ret=addExprWithoutSpace(new StringBuffer(n.f4.tokenImage),_ret);
      return _ret;
   }

   /**
    * f0 -> <SCOMMENT1>
    * f1 -> <LIVENESSQUERY>
    * f2 -> <SCOMMENT2>
    */
   public StringBuffer visit(LivenessQueryStatement n) {
      return new StringBuffer("");
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
   public StringBuffer visit(Expression n) {
      return n.f0.accept(this);
   }

   /**
    * f0 -> Identifier()
    * f1 -> "&&"
    * f2 -> Identifier()
    */
   public StringBuffer visit(AndExpression n) {
	   return generateBinopString(n.f0,n.f1,n.f2);
   }

   /**
    * f0 -> Identifier()
    * f1 -> "||"
    * f2 -> Identifier()
    */
   public StringBuffer visit(OrExpression n) {
	   return generateBinopString(n.f0,n.f1,n.f2);
   }

   /**
    * f0 -> Identifier()
    * f1 -> "<="
    * f2 -> Identifier()
    */
   public StringBuffer visit(CompareExpression n) {
	   return generateBinopString(n.f0,n.f1,n.f2);
   }

   /**
    * f0 -> Identifier()
    * f1 -> "!="
    * f2 -> Identifier()
    */
   public StringBuffer visit(neqExpression n) {
	   return generateBinopString(n.f0,n.f1,n.f2);
   }

   /**
    * f0 -> Identifier()
    * f1 -> "+"
    * f2 -> Identifier()
    */
   public StringBuffer visit(PlusExpression n) {
	   return generateBinopString(n.f0,n.f1,n.f2);
   }

   /**
    * f0 -> Identifier()
    * f1 -> "-"
    * f2 -> Identifier()
    */
   public StringBuffer visit(MinusExpression n) {
	   return generateBinopString(n.f0,n.f1,n.f2);
   }

   /**
    * f0 -> Identifier()
    * f1 -> "*"
    * f2 -> Identifier()
    */
   public StringBuffer visit(TimesExpression n) {
	   return generateBinopString(n.f0,n.f1,n.f2);
   }

   /**
    * f0 -> Identifier()
    * f1 -> "/"
    * f2 -> Identifier()
    */
   public StringBuffer visit(DivExpression n) {
	   return generateBinopString(n.f0,n.f1,n.f2);
   }

   /**
    * f0 -> Identifier()
    * f1 -> "["
    * f2 -> Identifier()
    * f3 -> "]"
    */
   public StringBuffer visit(ArrayLookup n) {
	   StringBuffer _ret=new StringBuffer(n.f0.accept(this));
      _ret=addExprWithoutSpace(new StringBuffer(n.f1.tokenImage),_ret);
      _ret=addExprWithoutSpace(n.f2.accept(this),_ret);
      _ret=addExprWithoutSpace(new StringBuffer(n.f3.tokenImage),_ret);
      return _ret;
   }

   /**
    * f0 -> Identifier()
    * f1 -> "."
    * f2 -> "length"
    */
   public StringBuffer visit(ArrayLength n) {
	  StringBuffer _ret=new StringBuffer(n.f0.accept(this));
	  _ret=addExprWithoutSpace(new StringBuffer(n.f1.tokenImage),_ret);
	  _ret=addExprWithoutSpace(new StringBuffer(n.f2.tokenImage),_ret);
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
   public StringBuffer visit(MessageSend n) {
	  StringBuffer _ret=new StringBuffer(n.f0.accept(this));
      _ret=addExprWithoutSpace(new StringBuffer(n.f1.tokenImage),_ret);
      _ret=addExprWithoutSpace(n.f2.accept(this),_ret);
      _ret=addExprWithoutSpace(new StringBuffer(n.f3.tokenImage),_ret);
      _ret=handleOptionalStmtsWithoutSpace(n.f4, _ret);
      _ret=addExprWithoutSpace(new StringBuffer(n.f5.tokenImage),_ret);
      return _ret;
   }

   /**
    * f0 -> Identifier()
    * f1 -> ( ArgRest() )*
    */
   public StringBuffer visit(ArgList n) {
	  StringBuffer _ret=new StringBuffer(n.f0.accept(this));
      _ret=handleOptionalStmts(n.f1,_ret);
      return _ret;
   }

   /**
    * f0 -> ","
    * f1 -> Identifier()
    */
   public StringBuffer visit(ArgRest n) {
	   StringBuffer _ret=new StringBuffer(n.f0.tokenImage);
      _ret=addExprWithSpace(n.f1.accept(this),_ret);
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
   public StringBuffer visit(PrimaryExpression n) {
      return n.f0.accept(this);
   }

   /**
    * f0 -> <INTEGER_LITERAL>
    */
   public StringBuffer visit(IntegerLiteral n) {
	   return new StringBuffer(n.f0.tokenImage);
   }

   /**
    * f0 -> <FLOAT_LITERAL>
    */
   public StringBuffer visit(FloatLiteral n) {
	   return new StringBuffer(n.f0.tokenImage);
   }

   /**
    * f0 -> "true"
    */
   public StringBuffer visit(TrueLiteral n) {
	   return new StringBuffer(n.f0.tokenImage);
   }

   /**
    * f0 -> "false"
    */
   public StringBuffer visit(FalseLiteral n) {
	   return new StringBuffer(n.f0.tokenImage);
   }

   /**
    * f0 -> <IDENTIFIER>
    */
   public StringBuffer visit(Identifier n) {
      return new StringBuffer(n.f0.tokenImage);
   }

   /**
    * f0 -> "this"
    */
   public StringBuffer visit(ThisExpression n) {
	   return new StringBuffer(n.f0.tokenImage);
   }

   /**
    * f0 -> "new"
    * f1 -> "int"
    * f2 -> "["
    * f3 -> Identifier()
    * f4 -> "]"
    */
   public StringBuffer visit(ArrayAllocationExpression n) {
	   StringBuffer _ret=new StringBuffer(n.f0.tokenImage);
      _ret=addExprWithSpace(n.f1.accept(this),_ret);
      _ret=addExprWithoutSpace(new StringBuffer(n.f2.tokenImage),_ret);
      _ret=addExprWithoutSpace(n.f3.accept(this),_ret);
      _ret=addExprWithoutSpace(new StringBuffer(n.f4.tokenImage),_ret);
      return _ret;
   }

   /**
    * f0 -> "new"
    * f1 -> Identifier()
    * f2 -> "("
    * f3 -> ")"
    */
   public StringBuffer visit(AllocationExpression n) {
	   StringBuffer _ret=new StringBuffer(n.f0.tokenImage);
      _ret=addExprWithSpace(n.f1.accept(this),_ret);
      _ret=addExprWithoutSpace(new StringBuffer(n.f2.tokenImage),_ret);
      _ret=addExprWithoutSpace(new StringBuffer(n.f3.tokenImage),_ret);
      return _ret;
   }

   /**
    * f0 -> "!"
    * f1 -> Identifier()
    */
   public StringBuffer visit(NotExpression n) {
       StringBuffer _ret=new StringBuffer(n.f0.tokenImage);
      _ret=addExprWithoutSpace(n.f1.accept(this),_ret);
      return _ret;
   }

	private StringBuffer addExprInNewLine(StringBuffer expr, StringBuffer _ret) {
	   if(CommonUtils.isNotNull(_ret) && CommonUtils.isNotNull(expr)) {
		   _ret.append(System.getProperty("line.separator"));
		   return _ret.append(expr);
	   }else if(CommonUtils.isNotNull(expr)) {
		   StringBuffer buffer = new StringBuffer(System.getProperty("line.separator"));
		   return buffer.append(expr);
	   }
	   return _ret;
   }
   
   private StringBuffer addExprWithSpace(StringBuffer expr, StringBuffer _ret) {
	   if(CommonUtils.isNotNull(_ret) && CommonUtils.isNotNull(expr)) {
		   return _ret.append(" "+expr);
	   }else if(CommonUtils.isNotNull(expr)) {
		   return expr;
	   }
	   return _ret;
   }
   
   private StringBuffer addExprWithoutSpace(StringBuffer expr, StringBuffer _ret) {
	   if(CommonUtils.isNotNull(_ret) && CommonUtils.isNotNull(expr)) {
		   return _ret.append(expr);
	   }else if(CommonUtils.isNotNull(expr)) {
		   return expr;
	   }
	   return _ret;
   }
   
   private StringBuffer generateBinopString(Identifier f0, NodeToken f1, Identifier f2) {
	   StringBuffer _ret=new StringBuffer(f0.accept(this));
	   _ret=addExprWithSpace(new StringBuffer(f1.tokenImage),_ret);
	   _ret=addExprWithSpace(f2.accept(this),_ret);
	   return _ret;
   }
   
   /**
    * @param f4
    * @param _ret
    * @return
    */
   private StringBuffer handleOptionalStmts(NodeListOptional f4, StringBuffer _ret) {
	   if(f4.present()) {
		   Vector<Node> declStmts=f4.nodes;
		   for(Node declStmt:declStmts) {
			   _ret=addExprInNewLine(declStmt.accept(this),_ret);
		   }
	   }
	   return _ret;
   }
   
   private StringBuffer handleOptionalStmtsWithoutSpace(NodeOptional f4, StringBuffer _ret) {
	   if(f4.present()) {
		   _ret=addExprWithoutSpace(f4.node.accept(this),_ret);
	   }
	   return _ret;
   }
   
   private StringBuffer handleOptionalStmtsWithSpace(NodeListOptional f4, StringBuffer _ret) {
	   if(f4.present()) {
		   Vector<Node> declStmts=f4.nodes;
		   for(Node declStmt:declStmts) {
			   _ret=addExprWithSpace(declStmt.accept(this),_ret);
		   }
	   }
	   return _ret;
   }
   
}