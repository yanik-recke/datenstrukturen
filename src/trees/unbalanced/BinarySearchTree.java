package trees.unbalanced;

import java.util.Collection;

import nodes.TreeNode;
import trees.Tree;


/**
 * Implementierung eines binären
 * Suchbaums.
 * 
 * @author Yanik Recke
 */
public class BinarySearchTree<E extends Comparable<E>> implements Tree<TreeNode<E>, E> {
	/** Wurzel des binären Suchbaums */
	public TreeNode<E> root;
	
	
	/** 
	 * Konstruktor zur Erstellung eines neuen
	 * binären Suchbaums. Das übergebene Element
	 * entspricht der Wurzel.
	 * 
	 * @param element - die Wurzel des binären Suchbaums
	 */
	public BinarySearchTree(E element) {
		this.root = new TreeNode<E>(element);
	}
	
	
	/**
	 * Konstruktor zur Erstellung eines neuen,
	 * leeren binären Suchbaums.
	 */
	public BinarySearchTree() {
		this.root = null;
	}


	@Override
	public TreeNode<E> insert(E element) {
		this.root = this.insert(root, element);
		
		return this.root;
	}


	/**
	 * Hilfsmethode zum Einfügen in
	 * einen Baum.
	 * 
	 * @param t - Wurzel des aktuell betrachteten Baums
	 * @param element - das einzufügende Element
	 * @return - die Wurzel der Baumstruktur
	 */
	private TreeNode<E> insert(TreeNode<E> t, E element) {
		assert (element != null);
		
		if (t == null) {
			return new TreeNode<E>(element);
		}
		
		int cmp = element.compareTo(t.getKey());
		
		if (cmp == 0) {
			return t;
		} else if (cmp < 0) {
			t.setLeft(insert(t.getLeft(), element));
		} else {
			t.setRight(insert(t.getRight(), element));
		}
		
		return t;
	}
	
	
	@Override
	public TreeNode<E> insertAll(Collection<E> elements) {
		for (E element : elements) {
			this.root = this.insert(element);
		}
		
		return this.root;
	}
	

	@Override
	public TreeNode<E> insert(int idx, E element) {
		throw new IllegalAccessError("not implemented");
	}


	@Override
	public TreeNode<E> remove(E element) {
		if (this.root == null) {
			return null;
		}
		
		this.root = this.remove(this.root, element);
		
		return this.root;
	}
	
	
	/**
	 * Hilfsmethode zum Entfernen aus einem binären
	 * Suchbaum.
	 * 
	 * @param t - Wurzel des aktuellen Baums
	 * @param element - das zu entfernende Element
	 * @return - die neue Wurzel
	 */
	private TreeNode<E> remove(TreeNode<E> t, E element) {
		if (t == null) {
			return null;
		}
		
		int cmp = element.compareTo(t.getKey());
		
		if (cmp < 0) {
			t.setLeft(remove(t.getLeft(), element));
		} else if (cmp > 0) {
			t.setRight(remove(t.getRight(), element));
		} else {
			if (t.getLeft() == null) {
				return t.getRight();
			} 
			
			if (t.getRight() == null) {
				return t.getLeft();
			}
			
			t.setKey(minimum(t.getRight()).getKey());
			t.setRight(remove(t.getRight(), t.getKey()));
		}
		
		return t;
	}


	@Override
	public TreeNode<E> minimum() {
		if (this.root == null) {
			return null;
		}
		
		return this.minimum(this.root);
	}
	
	
	/**
	 * Hilfsmethode zur Berechnung des Minimums
	 * des binären Suchbaums.
	 * 
	 * @param t - Wurzel des aktuellen Baums
	 * @return - der kleinste Knoten
	 */
	private TreeNode<E> minimum(TreeNode<E> t) {
		if (t.getLeft() != null) {
			return minimum(t.getLeft());
		} else {
			return t;
		}
	}


	@Override
	public TreeNode<E> maximum() {
		if (this.root == null) {
			return null;
		}
		
		return this.maximum(this.root);
	}
	
	
	/**
	 * Hilfsmethode zur Berechnung des Knotens
	 * mit dem größten Element in dem 
	 * binären Suchbaum.
	 * 
	 * @param t - Wurzel des aktuellen Knotens
	 * @return - Knoten mit dem größten Element
	 */
	private TreeNode<E>	maximum(TreeNode<E> t) {
		if (t.getRight() != null) {
			return maximum(t.getRight());
		} else {
			return t;
		}
	}


	@Override
	public boolean contains(E element) {
		if (this.root == null) {
			return false;
		}
		
		return contains(this.root, element) == null ? false : true;
	}
	
	
	/**
	 * Methode, die prüft ob ein Element
	 * in einem Knoten des Baums vorhanden ist
	 * und gibt den entsprechenden Knoten zurück.
	 * 
	 * @param element - das zu suchende Element
	 * @return - der Knoten mit dem Element oder null
	 */
	public TreeNode<E> containsElem(E element) {
		if (this.root == null) {
			return null;
		}
		
		return contains(this.root, element);
	}
	
	
	/**
	 * Hilfsmethode zur Berechnung, ob ein
	 * Element im binären Suchbaum vorhanden ist.
	 * 
	 * @param t - Wurzelknoten des aktuellen Baums
	 * @param element - das zu suchende Element
	 * @return - der Knoten mit dem Element oder null
	 */
	private TreeNode<E> contains(TreeNode<E> t, E element) {
		if (t == null) {
			return null;
		}
		
		int cmp = element.compareTo(t.getKey());
		if (cmp < 0) {
			return contains(t.getLeft(), element);
		} else if (cmp > 0) {
			return contains(t.getRight(), element);
		} else {
			return t;
		}
	}


	@Override
	public E ceiling(E element) {
		TreeNode<E> result = ceiling(this.root, element);
		
		return result == null ? null : result.getKey();
	}


	/**
	 * Hilfsmethode zur Berechnung des kleinsten Elements
	 * größer oder gleich dem übergebenen Element.
	 * 
	 * @param t - Wurzelknoten des akutellen Baums
	 * @param element - das übergebene Element
	 * @return - der Knoten mit dem Element oder null, bei nicht Vorhandensein
	 */
	private TreeNode<E> ceiling(TreeNode<E> t, E element) {
		if (t == null) {
			return null;
		}
		
		int cmp = element.compareTo(t.getKey());
		if (cmp == 0) {
			return t;
		} else if (cmp < 0) {
			TreeNode<E> l = ceiling(t.getLeft(), element);
			if (l != null) {
				return l;
			} else {
				return t;
			}
		} else {
			return ceiling(t.getRight(), element);
		}
	}

	@Override
	public E floor(E element) {
		TreeNode<E> result = floor(this.root, element);
		
		return result == null ? null : result.getKey();
	}

	
	/**
	 * Hilfsmethode zur Berechnung des größten Elements kleiner
	 * oder gleich dem übergebenen Element.
	 * 
	 * @param t - Wurzelknoten des aktuellen Baums
	 * @param element - das übergebene Element
	 * @return - der Knoten mit dem Element oder null, bei nicht Vorhandensein
	 */
	private TreeNode<E> floor(TreeNode<E> t, E element) {
		if (t == null) {
			return null;
		}
		
		int cmp = element.compareTo(t.getKey());
		if (cmp == 0) {
			return t;
		} else if (cmp < 0) {
			return floor(t.getLeft(), element);
		} else {
			TreeNode<E> r = floor(t.getRight(), element);
			if (r == null) {
				return t;
			} else {
				return r;
			}
		}
	}
	

	@Override
	public E higher(E element) {
		TreeNode<E> result = higher(this.root, element);
		
		return result == null ? null : result.getKey();
	}
	
	
	/**
	 * Hilfsmethode zur Berechnung des nächst-
	 * höheren Elements.
	 * 
	 * @param t - Wurzel des aktuellen Knotens
	 * @param element - das übergebene Element, dessen "Nachfolger" zu berechnen ist
	 * @return - das Nachfolger Element oder null
	 */
	private TreeNode<E> higher(TreeNode<E> t, E element) {
		if (t == null) {
			return null;
		}
		
		int cmp = element.compareTo(t.getKey());
		if (cmp < 0) {
			TreeNode<E> l = higher(t.getLeft(), element);
			if (l == null) {
				return t;
			} else {
				return l;
			}
		} else {
			TreeNode<E> r = higher(t.getRight(), element);
			return r;
		}
	}


	@Override
	public E lower(E element) {
		TreeNode<E> result = lower(this.root, element);
		
		return result == null ? null : result.getKey();
	}
	
	
	/**
	 * Hilfsmethode zur Berechnung des nächst-
	 * kleineren Elements.
	 * 
	 * @param t - Wurzel des aktuellen Knotens
	 * @param element - das übergebene Element, dessen "Vorgänger" zu berechnen ist
	 * @return - das Vorgänger Element oder null
	 */
	private TreeNode<E> lower(TreeNode<E> t, E element) {
		if (t == null) {
			return null;
		}
		
		int cmp = element.compareTo(t.getKey());
		if (cmp <= 0) {
			return lower(t.getLeft(), element);
		} else {
			TreeNode<E> r = lower(t.getRight(), element);
			if (r == null) {
				return t;
			} else {
				return r;
			}
		}
	}


	@Override
	public String toGraphViz() {
		return this.root.toGraphViz();
	}
	

}
