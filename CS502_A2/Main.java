import syntaxtree.*;
import visitor.*;
import java.util.*;

public class Main {
   public static void main(String [] args) {
      try {
         Node root = new Tchk(System.in).Goal();
         root.accept(new MetaDataRecorder(), null); // For storing the metadata
         root.accept(new TypeCheckVisitor(), null); // Your assignment part is invoked here.
      }
      catch (ParseException e) {
         System.out.println(e.toString());
      }
   }
} 
