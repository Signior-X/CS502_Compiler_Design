//
// Generated by JTB 1.3.2
//

package syntaxtree;

/**
 * Grammar production:
 * f0 -> Identifier()
 * f1 -> "("
 * f2 -> ( ArgList() )?
 * f3 -> ")"
 * f4 -> ";"
 */
public class FunctionCallStatement implements Node {
   public Identifier f0;
   public NodeToken f1;
   public NodeOptional f2;
   public NodeToken f3;
   public NodeToken f4;

   public FunctionCallStatement(Identifier n0, NodeToken n1, NodeOptional n2, NodeToken n3, NodeToken n4) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
      f3 = n3;
      f4 = n4;
   }

   public FunctionCallStatement(Identifier n0, NodeOptional n1) {
      f0 = n0;
      f1 = new NodeToken("(");
      f2 = n1;
      f3 = new NodeToken(")");
      f4 = new NodeToken(";");
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

