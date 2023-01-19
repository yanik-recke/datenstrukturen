package trees;

import nodes.Node;


/**
 * Interface für Rot-Schwarz-Bäume.
 * 
 * @author Yanik Recke
 */
public interface RedBlackTree<T extends Node<T,E>, E> extends Tree<T, E>{
	/**
	 * Linksrotation.
	 *  
	 * @param t - Ausgangsknoten
	 * @return - neuer Knoten
	 */
	T rotateLeft(T t);
	
	
	/**
	 * Rechtsrotation.
	 * 
	 * @param t - Ausgangsknoten
	 * @return - neuer Knoten
	 */
	T rotateRight(T t);
	
	
	/**
	 * Tauscht die Farben zweier (drei) Knoten.
	 * (In Vorlesung flip())
	 * 
	 * @param t - Ausgangsknoten
	 * @return - Ausgangsknoten aber andere Farbe
	 */
	T changeColor(T t);
	
	
	/**
	 * Färbt den übergebenen Knoten schwarz.
	 * Wird verwendet, um die Wurzel schwarz zu färben.
	 * 
	 * @param t - zu färbender Knoten 
	 * @return - der Knoten
	 */
	T colorRootBlack(T t);
	
}
