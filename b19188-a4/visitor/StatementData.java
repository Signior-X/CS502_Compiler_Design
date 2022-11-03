package visitor;

import java.util.Set;
import java.util.TreeSet;

public class StatementData {
    Set<String> inSet;
    Set<String> outSet;

    public StatementData() {
        inSet = new TreeSet<String>();
        outSet = new TreeSet<String>();
    }

    public StatementData(Set<String> inSet, Set<String> outSet) {
        this.inSet = new TreeSet<String>(inSet);
        this.outSet = new TreeSet<String>(outSet);
    }

    public void setInSet(Set<String> inSet) {
        this.inSet = new TreeSet<String>(inSet);
    }

    public void setOutSet(Set<String> outSet) {
        this.outSet = new TreeSet<String>(outSet);
    }

    public void addToInSet(String var) {
        inSet.add(var);
    }

    public void addToOutSet(String var) {
        outSet.add(var);
    }

    public String toString() {
        return "{ inSet: " + inSet.toString() + " AND outSet: " + outSet.toString() + " }\n";
    }
}
