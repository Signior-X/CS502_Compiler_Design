import syntaxtree.*;
import visitor.*;

public class Main {
   public static void main(String [] args) {
      try {
         Node root = new FriendTJMem(System.in).Goal();
         Validator v = new Validator();
         root.accept(v);
         System.out.println("Spills: " + v.totalSpills);
      }
      catch (ParseException e) {
         System.out.println(e.toString());
      }
   }
}
