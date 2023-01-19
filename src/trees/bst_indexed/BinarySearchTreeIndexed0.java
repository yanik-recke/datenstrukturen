package trees.bst_indexed;


import nodes.TreeNodeRank;
import trees.IndexedTree;


/**
 * Implementierung bei der Rang = Anzahl linker Kindsknoten + 1
 * und Indizierung beginnend bei Null.
 * 
 * @author Yanik Recke
 */
public class BinarySearchTreeIndexed0<E extends Comparable<E>> implements IndexedTree<TreeNodeRank<E>, E>{
	/** Wurzel des Baums */
	private TreeNodeRank<E> root;
	
	
	/**
	 * Erstellt einen leeren Baum.
	 */
	public BinarySearchTreeIndexed0() {
		this.root = null;
	}
	
	/**
	 * Erstellt einen Baum und fügt das
	 * übergebene Element ein.
	 * 
	 * @param element - Element / Schlüssel
	 */
	public BinarySearchTreeIndexed0(E element) {
		this.root = new TreeNodeRank<E>(element, 1);
	}

	@Override
	public E select(int index) {
		assert (index >= 0);
		
		TreeNodeRank<E> result = select(this.root, index);
		
		return result == null ? null : result.getKey();
	}
	
	
	/**
	 * Hilfsmethode, die anhand eines Indexes ein 
	 * Element sucht. Wenn das Element nicht existiert wird 
	 * null zurückgegeben.
	 * 
	 * @param t - Wurzell des aktuellen Baums
	 * @param idx - der Index
	 * @return - der Knoten mit dem Element oder null, falls keiner existiert
	 */
	private TreeNodeRank<E> select(TreeNodeRank<E> t, int idx) {
		if (t == null) {
			return null;
		}
		
		if (0 <= idx && idx <= t.getRank() - 2) {
			return select(t.getLeft(), idx);
		} else if (idx == t.getRank() - 1) {
			return t;
		} else {
			idx = idx - t.getRank();
			return select(t.getRight(), idx);
		}
	}
	
	
	@Override
	public TreeNodeRank<E> insert(int idx, E element) {
		assert(idx >= 0);
		
		this.root = insert(this.root, idx, element);
	
		return this.root;
	}
	
	
	/**
	 * Hilfsmethode zum Einfügen an einem
	 * übergebenen Index.
	 * 
	 * @param t - Wurzel des aktuellen Baums
	 * @param idx - der Index, an dem eingefügt werden soll
	 * @param element - das einzufügende Element
	 * @return - die (neue) Wurzel
	 */
	private TreeNodeRank<E> insert(TreeNodeRank<E> t, int idx, E element) {
		if (t == null) {
			return new TreeNodeRank<E>(element, 1);
		}
		
		if (0 <= idx && idx <= (t.getRank() - 1)) {
			t.increaseRank();
			t.setLeft(insert(t.getLeft(), idx, element));
		} else {
			idx = idx - t.getRank();
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
	 * Hilfsmethode zum Entfernen eines
	 * Knotens an einem übergebenen Index.
	 * 
	 * @param t - Wurzel des aktuellen Baums
	 * @param idx - der Index des zu löschenden Elements
	 * @return - (neue) Wurzel
	 */
	private TreeNodeRank<E> remove(TreeNodeRank<E> t, int idx) {
		if (t == null) {
			return null;
		}
		
		if (0 <= idx && idx <= t.getRank() - 2) {
			t.decreaseRank();
			t.setLeft(remove(t.getLeft(), idx));
		} else if (idx == t.getRank() - 1) {
			if (t.getLeft() == null) {
				return t.getRight();
			} 	
			
			if (t.getRight() == null) {
				return t.getLeft();
			}
			
			TreeNodeRank<E> smallest = smallestIndex(t.getRight());
			t.setKey(smallest.getKey());
			t.setRight(remove(t.getRight(), 0));
		} else {
			idx = idx - t.getRank();
			t.setRight(remove(t.getRight(), idx));
		}
		
		return t;
	}
	
	
	/**
	 * Hilfsmethode, die den Knoten mit 
	 * dem kleinsten Knoten ausgehend von t
	 * berechnet.
	 * 
	 * @param t - Wurzel aber der gesucht werden soll  
	 * @return - Knoten mit dem kleinsten Index
	 */
	private TreeNodeRank<E> smallestIndex(TreeNodeRank<E> t) {
		if (t.getLeft() != null) {
			return smallestIndex(t.getLeft());
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
