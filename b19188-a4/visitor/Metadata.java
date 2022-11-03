package visitor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import in.ac.iitmandi.compl.datastructures.CFGNode;

public class Metadata {
    public static Map<String, StatementData> statementsData;

    // Method wise, final idfa data
    public static Map<CFGNode, Map<String, StatementData>> liveAnalysis;

    public Metadata() {
        statementsData = new TreeMap<String, StatementData>();
        liveAnalysis = new HashMap<CFGNode, Map<String, StatementData>>();
    }

    public static void addStatementData(
        String stmt,
        Set<String> inSet,
        Set<String> outSet
    ) {
        // System.out.println("Adding to " + stmt + inSet + outSet);
        StatementData statementData = new StatementData(inSet, outSet);
        // System.out.println("StatementData" + statementData);
        Metadata.statementsData.put(stmt, statementData);
    }

    public static void printData() {
        System.out.println("Statements data: \n" + Metadata.statementsData);
        System.out.println("\n liveAnalysis: \n" + liveAnalysis);
    }
}
