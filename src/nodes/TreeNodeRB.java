package nodes;


/**
 * Implementierung eines Rot-Schwarz-Knotens.
 * 
 * @author Yanik Recke
 */
public class TreeNodeRB<E> extends Node<TreeNodeRB<E>, E>{
	/** Ob der Knoten rot ist */
	private boolean red;
	
	
	/**
	 * Erstellt einen neuen, roten Knoten mit einem
	 * übergeben Element.
	 * 
	 * @param element - Element / Schlüssel
	 */
	public TreeNodeRB(E element) {
		this.key = element;
		this.left = null;
		this.right = null;
		red = true;
	}
	
	/**
	 * Getter für die Farbeigenschaft des
	 * Knotens.
	 * 
	 * @return - true, wenn der Knoten rot ist, false, wenn nicht
	 */
	public boolean getIsRed() {
		return this.red;
	}
	
	/**
	 * Färbt den Knoten schwarz.
	 */
	public void setColorBlack() {
		this.red = false;
	}
	
	/**
	 * Färbt den Knoten rot.
	 */
	public void setColorRed() {
		this.red = true;
	}
	
	@Override
	public void toGraphViz(StringBuilder builder, String pre) {
		if (this.getIsRed()) {
			builder.append("\"" + pre + "\"" + "[label=\"" + this.key + "\" color=\"red\"]" + "\n");
		} else {
			builder.append("\"" + pre + "\"" + "[label=\"" + this.key + "\"]" + "\n");
		}
		
		boolean hasLeft = false, hasRight = false;
		
		if (this.left != null) {
			builder.append("\"" + pre + "\"").append("->").append("\"" + pre  + "l_\" [label=\"\"]\n");
			hasLeft = true;
		} else {
			builder.append("\"" + pre + "\"").append("->").append("\"null" + pre + "l_\" [label=\"\"]\n");
			builder.append("\"null" + pre + "l_\"[label=\"null\"]\n");
		}
		
		if (this.right != null) {
			builder.append("\"" + pre + "\"").append("->").append("\"" + pre + "r_\" [label=\"\"]\n");
			hasRight = true;
		}  else {
			builder.append("\"" + pre + "\"").append("->").append("\"null" + pre + "r_\" [label=\"\"]\n");
			builder.append("\"null" + pre + "r_\"[label=\"null\"]\n");
		}
		
		if (hasLeft) {
			this.left.toGraphViz(builder, pre  +  "l_");
		}
		
		if (hasRight) {
			this.right.toGraphViz(builder, pre  + "r_");
		}
	}

}
