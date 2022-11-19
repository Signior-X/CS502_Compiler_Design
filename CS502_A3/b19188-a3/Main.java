import syntaxtree.*;
import visitor.*;
import java.util.*;

public class Main {

   private static void makeAllFields(String className, Set<String> visited) {
      if (visited.contains(className)) {
         // already computed
         return;
      }

      visited.add(className);

      if (Metadata.inheritanceGraph.containsKey(className)) {
         // it extends to some other class, first computer all the allFields for that array
         // System.out.println("Contains inheritance");
         String class2 = Metadata.inheritanceGraph.get(className);
         makeAllFields(class2, visited);

         // now make all fields is done, created
         for (Variable var : Metadata.classes.get(class2).allFields) {
            Metadata.addAllField(className, var.name, var.type);
         }
      }

      // also add myself fields
      for (Variable var : Metadata.classes.get(className).fields) {
         Metadata.addAllField(className, var.name, var.type);
      }
   }

   private static void AddIfNotExists(ArrayList<String> list, String value) {
      if (list.contains(value)) {
         return;
      }

      list.add(value);
   }

   private static void makeAllMethods(String className, Set<String> visited) {
      if (visited.contains(className)) {
         // already computed
         return;
      }

      visited.add(className);

      if (Metadata.inheritanceGraph.containsKey(className)) {
         // it extends to some other class, first computer all the allFields for that array
         // System.out.println("Contains inheritance");
         String class2 = Metadata.inheritanceGraph.get(className);
         makeAllMethods(class2, visited);

         // now make all fields is done, created
         for (String methodKey : Metadata.classes.get(class2).allMethods) {
            Method methodName = Metadata.methods.get(methodKey);
            Metadata.classes.get(className).methodsMapping.put(methodName.name, methodKey);
            AddIfNotExists(Metadata.classes.get(className).allMethods, methodKey);            
         }
      }

      // also add myself fields
      for (String methodKey : Metadata.classes.get(className).methods) {
         Method methodName = Metadata.methods.get(methodKey);
         Metadata.classes.get(className).methodsMapping.put(methodName.name, methodKey);
         AddIfNotExists(Metadata.classes.get(className).allMethods, methodKey);           
      }
   }

   public static void main(String [] args) {
      try {
         Node root = new TempoJavaParser(System.in).Goal();
         // System.out.println("Program parsed successfully");

         root.accept(new MetadataRecorder());

         // we now need to computer inheritance strucutres and maps

         Set<String> visited = new TreeSet<String>();
         for (String className : Metadata.classes.keySet()) {
            makeAllFields(className, visited);
         }

         visited.clear();
         for (String className : Metadata.classes.keySet()) {
            makeAllMethods(className, visited);
         }

         // Metadata.printMetaData();
         root.accept(new FinalCode());
      }
      catch (ParseException e) {
         System.out.println(e.toString());
      }
   }
} 
