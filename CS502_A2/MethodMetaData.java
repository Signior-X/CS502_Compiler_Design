import java.util.*;

/**
 * Method Metadata stores information about a function
 * returnType -> return Type of the function
 * parameters -> The parameters "types" as a list
 */
public class MethodMetaData {
    public String returnType;
    public ArrayList<String> parameters;
    public Map<String, String> varType;

    public MethodMetaData() {
       returnType = null;
       parameters = new ArrayList<String>();
       varType = new HashMap<String, String>();
    }
}