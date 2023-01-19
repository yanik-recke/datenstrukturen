package nodes;


/**
 * Klasse, die einen Knoten in einem
 * Baum realisiert.
 * 
 * @author Yanik Recke
 */
public class TreeNode<E> extends Node<TreeNode<E>, E>{
	
	
	/**
	 * Erstellt einen neuen Knoten.
	 * 
	 * @param key - Schlüssel / Element
	 * @param left - linker Kindsknoten
	 * @param right - rechter Kindsknoten
	 */
	public TreeNode(E key, TreeNode<E> left, TreeNode<E> right) {
		this.key = key;
		this.left = left;
		this.right = right;
	}
	
	/**
	 * Erstellt einen neuen Knoten ohne 
	 * Kindsknoten.
	 * 
	 * @param key - Schlüssel / Element
	 */
	public TreeNode(E key) {
		this(key, null, null);
	}
	
}
