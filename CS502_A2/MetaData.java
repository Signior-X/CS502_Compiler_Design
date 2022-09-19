import java.util.*;

/**
 * The MetaData for the file we explored in TopDownManner
 */
public class MetaData {
    // we will create static objects that can be used from anywhere
    // we will update them from MetaDataRecorder.java
    // And use them here

    // child -> parent
    public static Map<String, String> inheritanceGraph;

    // stores class and inside it functions
    // Function meta data, return type, parameters
    // class -> method -> data
    public static Map<String, Map<String, MethodMetaData>> functionMetadata;

    // Type list
    public static ArrayList<String> typeList;

    public MetaData() {
        functionMetadata = new HashMap<String, Map<String, MethodMetaData>>();
        inheritanceGraph = new HashMap<String, String>();
        typeList = new ArrayList<String>();
        typeList.add("boolean");
        typeList.add("float");
        typeList.add("int");
        typeList.add("void");
    }

    public static void addClass(String className) {
        typeList.add(className);
        functionMetadata.put(className, new HashMap<String, MethodMetaData>());
    }

    public static void addFunction(String className, String methodName) {
        functionMetadata.get(className).put(methodName, new MethodMetaData());
    }

    public static void addParameterType(String className, String methodName, String type) {
        functionMetadata.get(className).get(methodName).parameters.add(type);
    }

    public static void addVariable(String className, String methodName, String var, String type) {
        functionMetadata.get(className).get(methodName).varType.put(var, type);
    }

    public static String getVarType(String className, String methodName, String key) {
        if (key == null) {
            return null;
        }

        if (typeList.contains(key)) {
            return key;
        }

        Map<String, String> varType = functionMetadata.get(className).get(methodName).varType;
        if (varType.containsKey(key)) {
            return varType.get(key);
        }

        return null;
    }

    public static void printMetaData() {
        for (String className : functionMetadata.keySet()) {
            System.out.println("CLASS: " + className);
            for (String methodName : functionMetadata.get(className).keySet()) {
                System.out.println("  Function name : " + methodName);
                System.out.println("  Return Type : " + functionMetadata.get(className).get(methodName).returnType);
                System.out.println("  Parameters :" + functionMetadata.get(className).get(methodName).parameters);
                System.out.println("  Variables and Types :" + functionMetadata.get(className).get(methodName).varType);
            }
        }

        // System.out.println("\n\nInheritance Graph: ");
        // for (String child: inheritanceGraph.keySet()) {
        // System.out.println(" " + child + " -> " + inheritanceGraph.get(child));
        // }

        System.out.println(inheritanceGraph);

        System.out.println(typeList);
    }
}
