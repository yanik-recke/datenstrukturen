package trees.bst_indexed;

import nodes.TreeNodeRank;
import trees.IndexedTree;


/**
 * Implementierung bei der Rang = Anzahl linker Kindsknoten + 1
 * und Indizierung beginnend bei Eins.
 * 
 * @author Yanik Recke
 */
public class BinarySearchTreeIndexed1<E extends Comparable<E>> implements IndexedTree<TreeNodeRank<E>, E>{
	/** Wurzel des Baums */
	TreeNodeRank<E> root;
	
	/**
	 * Erstellt einen leeren Baum.
	 */
	public BinarySearchTreeIndexed1() {
		this.root = null;
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
	 * Hilfsmethode zum Finden eines
	 * Knotens mit entsprechendem Index.
	 * 
	 * @param t - aktueller Knoten
	 * @param idx - zu suchender Index
	 * @return - letztendlich gefundener Knoten oder null
	 */
	private TreeNodeRank<E> select(TreeNodeRank<E> t, int idx) {
		if (t == null) {
			return null;
		}
		
		if (0 <= (idx - 1) && (idx - 1) <= (t.getRank() - 2)) {
			return select(t.getLeft(), idx);
		} else if ((idx - 1) == (t.getRank() - 1)) {
			return t;
		} else {
			idx = idx - t.getRank();
			return select(t.getRight(), idx);
		}
	}

	@Override
	public TreeNodeRank<E> insert(int index, E element) {
		assert (index >= 1);
		
		this.root = insert(this.root, index, element);
		
		return this.root;
	}
	
	
	/**
	 * Hilfsmethode zum Einfügen eines Knotens
	 * an einen entsprechenden Index.
	 * 
	 * @param t - aktueller Knoten
	 * @param idx - Index
	 * @param element - einzufügendes Element
	 * @return - letztendlich (neue) Wurzel
	 */
	private TreeNodeRank<E> insert(TreeNodeRank<E> t, int idx, E element) {
		if (t == null) {
			return new TreeNodeRank<E>(element, 1);
		} 
		
		if (0 <= (idx - 1) && (idx - 1) <= t.getRank() - 1) {
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
	 * Hilfsmethode zum Entfernen eines Knotens
	 * an einem bestimmten Index.
	 * 
	 * @param t - aktueller Knoten
	 * @param idx - Index
	 * @return - letztendlich (neue) Wurzel
	 */
	private TreeNodeRank<E> remove(TreeNodeRank<E> t, int idx) {
		if (t == null) {
			return null;
		}
		
		if (0 <= (idx - 1) && (idx - 1) <= (t.getRank() - 2)) {
			t.decreaseRank();
			t.setLeft(remove(t.getLeft(), idx));
		} else if ((idx - 1) == (t.getRank() - 1)) {
			if (t.getLeft() == null) {
				return t.getRight();
			}
			
			if (t.getRight() == null) {
				return t.getLeft();
			}
			
			TreeNodeRank<E> min = minimum(t.getRight());
			t.setKey(min.getKey());
			t.setRight(remove(min, 1));
		} else {
			idx = (idx - 1) - t.getRank();
			t.setRight(remove(t.getRight(), idx));
		}
		
		return t;
	}
	
	
	/**
	 * Berechnet das Minimum des 
	 * übergebenen Baums.
	 * 
	 * @param t - aktueller Knoten
	 * @return - kleinster Knoten
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
