import java.util.*;

public class Metadata {
    // we need to store each class
    // 1. Fields, an array of object type
    // 2. Methods, with some values (MethodMetadata)

    // Inheritance graph
    public static Map<String, String> inheritanceGraph;

    // Class methods
    // className -> ClassMetadata
    public static Map<String, ClassMetadata> classes;

    // Methods appended with class Name
    public static Map<String, Method> methods;


    public Metadata() {
        inheritanceGraph = new HashMap<String, String>();
        classes = new HashMap<String, ClassMetadata>();
        methods = new HashMap<String, Method>();
    }

    /**
     * Creates a key to identify a particular method in methods
     * A link between classname and methodName
     * @return key - The unique identifier
     */
    public static String getMethodKey(String className, String methodName) {
        return className + "__" + methodName;
    }

    /**
     * Adds a class Name in the classes map
     */
    public static void addClass(String className) {
        classes.put(className, new ClassMetadata());
    }

    /**
     * Create a key in class and also add method in methods
     * @param methodType - Return type of the method
     */
    public static void addMethod(String className, String methodName, String methodType) {
        Method method = new Method(methodName, methodType);
        String key = getMethodKey(className, methodName);
        classes.get(className).methods.add(key);
        methods.put(key, method);
    }

    /**
     * Takes into account that this className and method exists, if not
     * Add it from addMethod
     * First we need to find the method to which we need to add, and then
     * @param name - name of the variable
     * @param type - type of the variable
     */
    public static void addParameter(String className, String methodName, String name, String type) {
        String key = getMethodKey(className, methodName);
        methods.get(key).parameters.add(new Variable(name, type));
    }

    /**
     * Adds a field into the classes
     * @param var - Field Name
     * @param type - File type
     */
    public static void addField(String className, String var, String type) {
        classes.get(className).fields.add(new Variable(var, type));
    }

    /**
     * @return If the variable name is in parameters list or not
     */
    public static boolean isParam(String className, String methodName, String varName) {
        String key = getMethodKey(className, methodName);

        if (!methods.containsKey(key)) {
            return false;
        }

        for (Variable param : methods.get(key).parameters) {
            if (param.name == varName) {
                return true;
            }
        }

        return false;
    }

    /**
     * Finds the the value store of the class field
     * ifexists in the fieldsTable
     * @return -2 / -1 / 4k
     */
    public static int isClassField(String className, String methodName, String varName) {
        if (className == "" || methodName == "") {
            return -2;
        }

        if (isParam(className, methodName, varName)) {
            return -1;
        }

        // i = 0 for "this" (NOT SURE)
        // TODO should reverse loop as more close filed needs to be find
        int i = 1;
        for (Variable field : classes.get(className).fields) {
            if (field.name == varName) {
                // System.out.println("ClassName: " + className + " , " + "MethodName: " + methodName + " , " + "VAR: " + varName);

                return i * 4;
            }
            i++;
        }

        return -1;
    }

    public static void printMetaData() {
        System.out.println("\nGRAPH");
        System.out.println(inheritanceGraph);

        System.out.println("\nCLASSES");
        System.out.println(classes);

        System.out.println("\nMETHODS");
        System.out.println(methods);
    }
}

class ClassMetadata {
    public ArrayList<Variable> fields;

    // Stores only the method name, a reference for the method
    public ArrayList<String> methods;

    public ClassMetadata() {
        fields = new ArrayList<Variable>();
        methods = new ArrayList<String>();
    }

    public String toString() {
        return " Methods: " + methods.toString() + " \n Fields: " + fields.toString() +"\n";
    }
}

class Method {
    public String name;
    public String returnType;
    public ArrayList<Variable> parameters;

    public Method() {
        parameters = new ArrayList<Variable>();
    }

    public Method(String name, String returnType) {
        parameters = new ArrayList<Variable>();
        this.name = name;
        this.returnType = returnType;
    }

    public String toString() {
        return " MethodName: " + name + "->" + returnType + "\n Parameters=" + parameters.toString() + "\n";
    }
}

class Variable {
    public String name;
    public String type;

    public Variable(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String toString() {
        return name + "->" + type;
    }
}