import syntaxtree.*;
import visitor.*;

public class Main {
   public static void main(String [] args) {
      try {
         Node root = new TempoJavaParser(System.in).Goal();
         // System.out.println("Program parsed successfully");

         root.accept(new MetadataRecorder());

         Metadata.printMetaData();

         root.accept(new FinalCode());
      }
      catch (ParseException e) {
         System.out.println(e.toString());
      }
   }
} 
