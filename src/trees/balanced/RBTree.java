package trees.balanced;

import java.util.Collection;


import nodes.TreeNodeRB;
import trees.RedBlackTree;


/**
 * Implementierung eines Rot-Schwarz-Baums.
 * 
 * @author Yanik Recke
 */
public class RBTree<E extends Comparable<E>> implements RedBlackTree<TreeNodeRB<E>, E>{
	/** Wurzel des Baums */
	TreeNodeRB<E> root;
	
	
	/**
	 * Erstellt einen leeren Baum.
	 */
	public RBTree() {
		this.root = null;
	}
	
	
	/**
	 * Erstellt einen Baum und fügt
	 * das übergebene Element ein.
	 * 
	 * @param element
	 */
	public RBTree(E element) {
		insert(element);
	}
	
	@Override
	public TreeNodeRB<E> insert(E element) {
		this.root = insert(this.root, element);
		
		if (this.root.getIsRed()) {
			colorRootBlack(this.root);
		}
		
		return this.root;
	}
	
	
	/**
	 * Hilfsmethode zum Einfügen
	 * in den Rot-Schwarz-Baum.
	 * 
	 * @param t - aktueller Knoten
	 * @param element - einzufügendes Element
	 * @return - letztendlich (neue) Wurzel
	 */
	private TreeNodeRB<E> insert(TreeNodeRB<E> t, E element) {
		if (t == null) {
			return new TreeNodeRB<E>(element);
		} 
		
		int cmp = element.compareTo(t.getKey());
		
		if (cmp < 0) {
			t.setLeft(insert(t.getLeft(), element));
		} else if (cmp == 0) {
			return t;
		} else {
			t.setRight(insert(t.getRight(), element));
		}
		
		if (t.getRight() != null && t.getRight().getIsRed() && (t.getLeft() == null || !t.getLeft().getIsRed())) {
			t = rotateLeft(t);
		}
		
		if (t.getLeft() != null && t.getLeft().getIsRed() && t.getLeft().getLeft() != null && t.getLeft().getLeft().getIsRed()) {
			t = rotateRight(t);
		}
		
		if (t.getRight() != null && t.getRight().getIsRed() && t.getLeft() != null && t.getLeft().getIsRed()) {
			t = changeColor(t);
		}
		
		return t;
	}

	@Override
	public TreeNodeRB<E> insertAll(Collection<E> elements) {
		for (E element : elements) {
			this.root = insert(element);
		}
		
		return this.root;
	}

	@Override
	public TreeNodeRB<E> insert(int idx, E element) {
		throw new IllegalAccessError("not implemented, use insert(E)");
	}

	@Override
	public TreeNodeRB<E> remove(E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TreeNodeRB<E> minimum() {
		return minimum(this.root);
	}
	
	/**
	 * Berechnung des kleinsten
	 * Schlüssels im Baum.
	 * 
	 * @param t - aktueller Knoten
	 * @return - Knoten mit größtem Schlüssel
	 */
	private TreeNodeRB<E> minimum(TreeNodeRB<E> t) {
		if (t.getLeft() != null) {
			return minimum(t.getLeft());
		} 
		
		return t;
	}

	@Override
	public TreeNodeRB<E> maximum() {
		return maximum(this.root);
	}
	
	
	/**
	 * Berechnung des größten
	 * Schlüssels im Baum.
	 * 
	 * @param t - aktueller Knoten
	 * @return - Knoten mit größtem Schlüssel.
	 */
	private TreeNodeRB<E> maximum(TreeNodeRB<E> t) {
		if (t.getRight() != null) {
			return maximum(t.getRight());
		}
		
		return t;
	}

	@Override
	public boolean contains(E element) {
		return contains(this.root, element) != null;
	}
	
	private TreeNodeRB<E> contains(TreeNodeRB<E> t, E element) {
		if (t == null) {
			return null;
		}
		
		int cmp = element.compareTo(t.getKey());
		if (cmp < 0) {
			return contains(t.getLeft(), element);
		} else if (cmp == 0) {
			return t;
		} else {
			return contains(t.getRight(), element);
		}
	}

	@Override
	public E ceiling(E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E floor(E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E higher(E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E lower(E element) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public TreeNodeRB<E> rotateLeft(TreeNodeRB<E> t) {
		TreeNodeRB<E> r = t.getRight();
		
		if (t.getIsRed()) {
			r.setColorRed();
		} else {
			r.setColorBlack();
		}
		
		t.setColorRed();
		
		t.setRight(r.getLeft());
		r.setLeft(t);
		
		return r;
	}

	@Override
	public TreeNodeRB<E> rotateRight(TreeNodeRB<E> t) {
		TreeNodeRB<E> l = t.getLeft();
		
		if (t.getIsRed()) {
			l.setColorRed();
		} else {
			l.setColorBlack();
		}
		
		t.setColorRed();
		
		t.setLeft(l.getRight());
		l.setRight(t);
		
		return l;
	}

	@Override
	public TreeNodeRB<E> changeColor(TreeNodeRB<E> t) {
		t.getLeft().setColorBlack();
		t.getRight().setColorBlack();
		t.setColorRed();
		
		return t;
	}

	@Override
	public TreeNodeRB<E> colorRootBlack(TreeNodeRB<E> t) {
		t.setColorBlack();
		
		return t;
	}
	
	@Override
	public String toGraphViz() {
		return this.root.toGraphViz();
	}
	
}
