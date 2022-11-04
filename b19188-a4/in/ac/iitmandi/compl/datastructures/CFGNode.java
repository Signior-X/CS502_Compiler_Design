/**
 * 
 */
package in.ac.iitmandi.compl.datastructures;

import java.util.ArrayList;
import java.util.List;

import syntaxtree.Node;
import visitor.DotPrintVisitor;

/**
 * @author arjun
 *
 */
public class CFGNode {

	private Node node;
	private NODETYPE type;
	private List<CFGNode> predecessorNodes;
	private List<CFGNode> successorNodes;
	private int LineNumber;
	private String stmt;
	
	/**
	 * 
	 */
	public CFGNode(NODETYPE type, int LineNumber) {
		this.type=type;
		this.LineNumber = LineNumber;
		stmt = "";
	}

	/**
	 * @param statement constructor
	 */
	public CFGNode(Node node, int LineNumber) {
		this.node = node;
		this.type = NODETYPE.INTERMEDIATENODE;
		this.LineNumber = LineNumber;
		stmt = node.accept(new DotPrintVisitor()).toString();

		// System.out.println("PRIYAM add edge stmt" + stmt);
	}
	
	/**
	 * @param node
	 * @param type
	 */
	public CFGNode(Node node, NODETYPE type, int LineNumber) {
		this.node = node;
		this.type = type;
		this.LineNumber = LineNumber;
		stmt = node.accept(new DotPrintVisitor()).toString();
	}

	/**
	 * @return the stmt
	 */
	public String getStmt() {
		return stmt;
	}

	public String getStmtWithLine() {
		return LineNumber + ": " + stmt;
	}

	/**
	 * @return the node
	 */
	public Node getNode() {
		return node;
	}

	/**
	 * @param node the node to set
	 */
	public void setNode(Node node) {
		this.node = node;
	}

	/**
	 * @return the predecessorNodes
	 */
	public List<CFGNode> getPredecessorNodes() {
		return predecessorNodes;
	}
//	/**
//	 * @param predecessorNodes the predecessorNodes to set
//	 */
//	private void setPredecessorNodes(List<CFGNode> predecessorNodes) {
//		this.predecessorNodes = predecessorNodes;
//	}
	/**
	 * @return the successorNodes
	 */
	public List<CFGNode> getSuccessorNodes() {
		return successorNodes;
	}
//	/**
//	 * @param successorNodes the successorNodes to set
//	 */
//	private void setSuccessorNodes(List<CFGNode> successorNodes) {
//		this.successorNodes = successorNodes;
//	}
	
	
	
	public void addSuccessorNode(CFGNode cfgNode) {
		if(null!=cfgNode) {
			if(null==this.getSuccessorNodes()) {
				this.successorNodes = new ArrayList<>();
			}
			this.successorNodes.add(cfgNode);
		}
	}
	
	/**
	 * @return the type
	 */
	public NODETYPE getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(NODETYPE type) {
		this.type = type;
	}

	public void addPredecessorNode(CFGNode cfgNode) {
		if(null!=cfgNode) {
			if(null==this.getPredecessorNodes()) {
				this.predecessorNodes = new ArrayList<>();
			}
			this.predecessorNodes.add(cfgNode);
		}
	}
}
