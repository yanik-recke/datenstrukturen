package trees.bst_indexed;


import nodes.TreeNodeRank;
import trees.IndexedTree;

/**
 * Implementierung bei der Rang = Anzahl linker Knoten
 * und Indizierung beginnend bei Null.
 * 
 * @author Yanik Recke
 */
public class BinarySearchTreeIndexed0_v2<E extends Comparable<E>> implements IndexedTree<TreeNodeRank<E>, E>{
	/** Wurzel des Baums */
	private TreeNodeRank<E> root;
	
	
	/**
	 * Erstellt einen neuen leeren Baum.
	 */
	public BinarySearchTreeIndexed0_v2() {
		this.root = null;
	}
	
	/**
	 * Erstellt einen neuen Baum und
	 * fügt das übergebene Element ein.
	 * 
	 * @param element
	 */
	public BinarySearchTreeIndexed0_v2(E element) {
		this.root = new TreeNodeRank<E>(element, 0);
	}
	
	
	@Override
	public E select(int index) {
		assert (index >= 0);
		
		TreeNodeRank<E> result = select(this.root, index);
		
		return result == null ? null : result.getKey();
	}
	
	
	/**
	 * Hilfsmethode, die berechnet
	 * welcher Knoten sich am übergebenen Index
	 * befindet.
	 * 
	 * @param t - Wurzel des aktuellen Baums
	 * @param idx - der Index
	 * @return - Knoten des aktuellen Baums
	 */
	private TreeNodeRank<E> select(TreeNodeRank<E> t, int idx) {
		if (t == null) {
			return null;
		}
		
		if (0 <= idx && idx <= (t.getRank() - 1)) {
			return select(t.getLeft(), idx);
		} else if (idx == t.getRank()) {
			return t;
		} else {
			idx = idx - (t.getRank() + 1);
			return select(t.getRight(), idx);
		}
	}

	
	@Override
	public TreeNodeRank<E> insert(int index, E element) {
		assert (index >= 0);
		
		this.root = insert(this.root, index, element);
		
		return this.root;
	}
	
	
	/**
	 * Hilfsmethode, die ein Element an
	 * einen übergebenen Index einfügt.
	 * 
	 * @param t - aktueller Knoten
	 * @param idx - Index
	 * @param element - einzufügendes Element
	 * @return - neu einzufügender Knoten, letztendlich Wurzel
	 */
	private TreeNodeRank<E> insert(TreeNodeRank<E> t, int idx, E element) {
		if (t == null) {
			return new TreeNodeRank<E>(element, 0);
		}
		
		if (0 <= idx && idx <= t.getRank()) {
			t.increaseRank();
			t.setLeft(insert(t.getLeft(), idx, element));
		} else {
			idx = idx - (t.getRank() + 1);
			t.setRight(insert(t.getRight(), idx, element));
		}
		
		return t;
	}

	@Override
	public TreeNodeRank<E> remove(int index) {
		this.root = remove(this.root, index);
		
		return this.root;
	}
	
	
	/**
	 * Hilfsmethode zum Entfernen eines Knotens
	 * an einem übergebenen Index.
	 * 
	 * @param t - Knoten des aktuellen Baums
	 * @param idx - Index
	 * @return - Letztendlich die Wurzel des Baums ohne entfernten Knoten
	 */
	private TreeNodeRank<E> remove(TreeNodeRank<E> t, int idx) {
		if (t == null) {
			return null;
		}
		
		if (0 <= idx && idx <= (t.getRank() - 1)) {
			t.decreaseRank();
			t.setLeft(remove(t.getLeft(), idx));
		} else if (idx == t.getRank()){
			if (t.getLeft() == null) {
				return t.getRight();
			} 
			
			if (t.getRight() == null) {
				return t.getLeft();
			}
			
			TreeNodeRank<E> smallest = minimum(t.getRight());
			t.setKey(smallest.getKey());
			t.setRight(remove(smallest, 0));
		} else {
			idx = idx - t.getRank();
			t.setRight(remove(t.getRight(), idx));
		}
		
		return t;
	}
	
	
	/**
	 * Hilfsmethode, die den Knoten
	 * mit dem kleinsten Index berechnet.
	 * 
	 * @param t - Wurzelknoten des aktuellen Baums
	 * @return - der Knoten mit dem kleinsten Index
	 */
	private TreeNodeRank<E> minimum(TreeNodeRank<E> t) {
		if (t.getLeft() != null) {
			return minimum(t.getLeft());
		} else {
			return t;
		}
	}

	@Override
	public int indexOf(E element) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toGraphViz() {
		if (this.root == null) {
			return "";
		}
		
		return this.root.toGraphViz();
	}

}
