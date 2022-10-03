//
// Generated by JTB 1.3.2
//

package syntaxtree;

/**
 * Grammar production:
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
public class MainClass implements Node {
   public NodeToken f0;
   public Identifier f1;
   public NodeToken f2;
   public NodeToken f3;
   public Identifier f4;
   public NodeToken f5;
   public NodeToken f6;
   public NodeToken f7;
   public NodeToken f8;
   public NodeToken f9;
   public NodeToken f10;
   public NodeToken f11;
   public NodeToken f12;
   public NodeToken f13;
   public Identifier f14;
   public NodeToken f15;
   public NodeToken f16;
   public NodeListOptional f17;
   public NodeListOptional f18;
   public NodeToken f19;
   public NodeToken f20;

   public MainClass(NodeToken n0, Identifier n1, NodeToken n2, NodeToken n3, Identifier n4, NodeToken n5, NodeToken n6, NodeToken n7, NodeToken n8, NodeToken n9, NodeToken n10, NodeToken n11, NodeToken n12, NodeToken n13, Identifier n14, NodeToken n15, NodeToken n16, NodeListOptional n17, NodeListOptional n18, NodeToken n19, NodeToken n20) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
      f3 = n3;
      f4 = n4;
      f5 = n5;
      f6 = n6;
      f7 = n7;
      f8 = n8;
      f9 = n9;
      f10 = n10;
      f11 = n11;
      f12 = n12;
      f13 = n13;
      f14 = n14;
      f15 = n15;
      f16 = n16;
      f17 = n17;
      f18 = n18;
      f19 = n19;
      f20 = n20;
   }

   public MainClass(Identifier n0, Identifier n1, Identifier n2, NodeListOptional n3, NodeListOptional n4) {
      f0 = new NodeToken("package");
      f1 = n0;
      f2 = new NodeToken(";");
      f3 = new NodeToken("public class");
      f4 = n1;
      f5 = new NodeToken("{");
      f6 = new NodeToken("public");
      f7 = new NodeToken("static");
      f8 = new NodeToken("void");
      f9 = new NodeToken("main");
      f10 = new NodeToken("(");
      f11 = new NodeToken("String");
      f12 = new NodeToken("[");
      f13 = new NodeToken("]");
      f14 = n2;
      f15 = new NodeToken(")");
      f16 = new NodeToken("{");
      f17 = n3;
      f18 = n4;
      f19 = new NodeToken("}");
      f20 = new NodeToken("}");
   }

   public void accept(visitor.Visitor v) {
      v.visit(this);
   }
   public <R,A> R accept(visitor.GJVisitor<R,A> v, A argu) {
      return v.visit(this,argu);
   }
   public <R> R accept(visitor.GJNoArguVisitor<R> v) {
      return v.visit(this);
   }
   public <A> void accept(visitor.GJVoidVisitor<A> v, A argu) {
      v.visit(this,argu);
   }
}
