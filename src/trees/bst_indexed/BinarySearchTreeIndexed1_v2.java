package trees.bst_indexed;

import nodes.TreeNodeRank;
import trees.IndexedTree;


/**
 * Implementierung bei der Rang = Anzahl linker Kindsknoten
 * und Indizierung beginnend bei Eins.
 * 
 * @author Yanik Recke
 */
public class BinarySearchTreeIndexed1_v2<E extends Comparable<E>> implements IndexedTree<TreeNodeRank<E>, E>{
	/** Wurzel des Baums */
	private TreeNodeRank<E> root;
	
	
	/**
	 * Erstellt einen leeren Baum.
	 */
	public BinarySearchTreeIndexed1_v2() {
		this.root =  null;
	}
	
	/**
	 * Erstellt einen Baum mit einem Element.
	 * 
	 * @param element - das Element
	 */
	public BinarySearchTreeIndexed1_v2(E element) {
		this.root = insert(1, element);
	}
	
	@Override
	public E select(int index) {
		assert (index >= 1);
		
		if (this.root == null) {
			return null;
		}
		
		TreeNodeRank<E> result = select(this.root, index);
		
		return result == null ? null : result.getKey();
	}
	
	/**
	 * Hilfsmethode zum Suchen eines Knotens
	 * mit einem bestimmten Index.
	 * 
	 * @param t - aktueller Knoten
	 * @param idx - Index
	 * @return - gefundener Knoten oder null
	 */
	private TreeNodeRank<E> select(TreeNodeRank<E> t, int idx) {
		if (t == null) {
			return null;
		}
		
		if (0 <= (idx - 1) && (idx - 1) <= (t.getRank() - 1)) {
			return select(t.getLeft(), idx);
		} else if ((idx - 1) == t.getRank()) {
			return t;
		} else {
			idx = idx - (t.getRank() + 1);
			return select(t.getRight(), idx);
		}
	}
	
	@Override
	public TreeNodeRank<E> insert(int index, E element) {
		this.root = insert(this.root, index, element);
		
		return this.root;
	}
	
	
	/**
	 * Hilfsmethode zum Einfügen eines
	 * Elements an einem entsprechenden
	 * Index.
	 * 
	 * @param t - aktuell betrachteter Knoten
	 * @param idx - Index
	 * @param element - einzufügendes Element
	 * @return - letztendlich (neue) Wurzel
	 */
	private TreeNodeRank<E> insert(TreeNodeRank<E> t, int idx, E element) {
		if (t == null) {
			return new TreeNodeRank<E>(element, 0);
		}
		
		if (0 <= (idx -1) && (idx - 1) <= (t.getRank())) {
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
	 * Hilfsmethode zum Entfernen eines Knotens mit 
	 * einem entsprechenden Index.
	 * 
	 * @param t - aktueller Knoten
	 * @param idx - Index
	 * @return - letztendlich (neue) Wurzel
	 */
	private TreeNodeRank<E> remove(TreeNodeRank<E> t, int idx) {
		if (t == null) {
			return null;
		}
		
		if (0 <= (idx - 1) && (idx -1) <= t.getRank() - 1) {
			t.decreaseRank();
			t.setLeft(remove(t.getLeft(), idx));
		} else if ((idx - 1) == t.getRank()) {
			if (t.getLeft() == null) {
				return t.getRight();
			}
			
			if (t.getRight() == null) {
				return t.getLeft();
			}
			
			TreeNodeRank<E> min = minimum(t.getRight());
			t.setKey(min.getKey());
			t.setRight(remove(t.getRight(), 1));
		} else {
			idx = idx - (t.getRank() + 1);
			t.setRight(remove(t.getRight(), idx));
		}
		
		return t;
	}
	
	
	/**
	 * Hilfsmethode zur Berechnung des
	 * Elements mit dem kleinsten Index in
	 * einem Baum.
	 * 
	 * @param t - aktueller Knoten
	 * @return - das kleinste Element
	 */
	private TreeNodeRank<E> minimum(TreeNodeRank<E> t) {
		if (t.getLeft() != null) {
			return minimum(t.getLeft());
		}
		
		return t;
	}

	@Override
	public int indexOf(E element) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toGraphViz() {
		return this.root.toGraphViz();
	}

}
