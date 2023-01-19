package nodes;


/**
 * Abstrakte Klasse einer Node (Knoten)
 * einer Baumstruktur.
 * 
 * @author Yanik Recke
 */
public abstract class Node<T extends Node<T, E>, E> {
	/** Linker Kindsknoten */
	T left;
	/** Rechter Kindsknoten */
	T right;
	/** Schlüssel / Element */
	E key;
	
	
	/**
	 * Getter für Schlüssel.
	 * 
	 * @return - den Schlüssel.
	 */
	public E getKey() {
		return key;
	}
	
	/**
	 * Setter für Schlüssel.
	 * 
	 * @param key - neuer Schlüssel
	 */
	public void setKey(E key) {
		this.key = key;
	}
	
	/**
	 * Getter für linken Kindsknoten.
	 * 
	 * @return - linker Kindsknoten
	 */
	public T getLeft() {
		return left;
	}
	 
	/**
	 * Setter für linken Kindsknoten.
	 * 
	 * @param left - neuer linker Kindsknoten
	 */
	public void setLeft(T left) {
		this.left = left;
	}
	
	/**
	 * Getter für rechten Kindsknoten.
	 * 
	 * @return - rechter Kindsknoten
	 */
	public T getRight() {
		return right;
	}
	
	/**
	 * Setter für rechten Kindsknoten.
	 * 
	 * @param right - neuer rechter Kindsknoten
	 */
	public void setRight(T right) {
		this.right = right;
	}
	
	
	/**
	 * Methode, die die Baumstruktur in 
	 * GraphViz Syntax generiert.
	 * (nicht schön, aber funktioniert)
	 * 
	 * @return - String, den man bei GraphViz reinkopieren kann
	 */
	public String toGraphViz() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("digraph T {\n");
		this.toGraphViz(builder, "_");
		builder.append("}\n");
		
		return builder.toString();
	}
	
	
	/**
	 * Hilfsmethode zur Generierung der
	 * GraphViz-Darstellung.
	 * 
	 * @param builder - StringBuilder
	 * @param pre - Prefix
	 */
	public void toGraphViz(StringBuilder builder, String pre) {
		builder.append("\"" + pre + "\"" + "[label=\"" + this.key + "\"]" + "\n");
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
