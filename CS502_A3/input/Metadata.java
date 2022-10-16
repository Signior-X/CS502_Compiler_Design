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
     * Adds an object to the method body
     * @param name - object name
     * @param type - objec type
     */
    public static void addObject(String className, String methodName, String name, String type) {
        String key = getMethodKey(className, methodName);
        methods.get(key).objects.put(name, type);
    }

    public static String getObjectType(String className, String methodName, String name) {
        String key = getMethodKey(className, methodName);
        String ans = methods.get(key).objects.get(name);

        // If not defined statically inside the function block
        // check the parameters of the method parameters
        if (ans == null) {
            ArrayList<Variable> paramsList = methods.get(key).parameters;
            for (Variable v : paramsList) {
                if (v.name == name) {
                    return v.type;
                }
            }
        }

        return ans;
    }

    /**
     * Adds a field into the classes
     * @param var - Field Name
     * @param type - File type
     */
    public static void addField(String className, String var, String type) {
        classes.get(className).fields.add(new Variable(var, type));
    }

    public static void addAllField(String className, String var, String type) {
        classes.get(className).allFields.add(new Variable(var, type));
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
     * @return If the variable name is redefined in the local scope
     */
    public static boolean isLocal(String className, String methodName, String varName) {
        String key = getMethodKey(className, methodName);

        if (!methods.containsKey(key)) {
            return false;
        }

        for (String var : methods.get(key).objects.keySet()) {
            if (var == varName) {
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
        if (className == "" || methodName == "" || className == null || methodName == null) {
            return -3;
        }

        if (isLocal(className, methodName, varName)) {
            return -2;
        }

        if (isParam(className, methodName, varName)) {
            return -1;
        }

        // i = 0 for "this" (NOT SURE)
        // TODO should reverse loop as more close filed needs to be find
        ArrayList<Variable> allFieldsList = classes.get(className).allFields;

        int i = allFieldsList.size() - 1;
        while(i >= 0) {
            if (allFieldsList.get(i).name == varName) {
                // System.out.println("ClassName: " + className + " , " + "MethodName: " + methodName + " , " + "VAR: " + varName);

                return (i + 1) * 4;
            }
            i--;
        }

        return -1;
    }

    /**
     * Finds the the value store of the class field
     * ifexists in the function vTable
     * @param baseType - Class Type of the function base
     * @param fName - Function Name
     * @return position of the function (i * 4)
     */
    public static int getMethodPoint(String baseType, String fName) {
        // now using the baseType, find which method is
        // suitable to call based on fName
        // String functionKey = Metadata.classes.get(baseType).methodsMapping.get(fName);
        ArrayList<String> allMethodsList = Metadata.classes.get(baseType).allMethods;

        // System.out.println("Function Key: " + fName);
        // System.out.println("ALLMethods: " + allMethodsList);

        int i = allMethodsList.size() - 1;
        while(i >= 0) {
            if (allMethodsList.get(i) == fName) {
                // System.out.println("ClassName: " + className + " , " + "MethodName: " + methodName + " , " + "VAR: " + varName);

                return i * 4;
            }
            i--;
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
    public ArrayList<Variable> allFields;

    // Stores only the method name, a reference for the method
    public ArrayList<String> methods;

    // all methods, stores the key classmethod Pair
    public ArrayList<String> allMethods;

    // The mapping of the function name with latest function name
    public Map<String, String> methodsMapping;

    public ClassMetadata() {
        fields = new ArrayList<Variable>();
        allFields = new ArrayList<Variable>();
        methods = new ArrayList<String>();
        allMethods = new ArrayList<String>();
        methodsMapping = new HashMap<String, String>();
    }

    public String toString() {
        return " Methods: " + methods.toString() + " \n Fields: " + fields.toString() +"\n"
        + "All Fields: " + allFields.toString() + "\n AllMethods: " + allMethods.toString() + "\n"
        + "MethodsMapping: " + methodsMapping.toString() + "\n\n";
    }
}

class Method {
    public String name;
    public String returnType;
    public ArrayList<Variable> parameters;
    
    // object name, type
    public Map<String, String> objects;

    public Method() {
        parameters = new ArrayList<Variable>();
        objects = new HashMap<String, String>();
    }

    public Method(String name, String returnType) {
        parameters = new ArrayList<Variable>();
        objects = new HashMap<String, String>();
        this.name = name;
        this.returnType = returnType;
    }

    public String toString() {
        return " MethodName: " + name + "->" + returnType
        + "\n Parameters=" + parameters.toString()
        + "\n Objects=" + objects.toString() + "\n";
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