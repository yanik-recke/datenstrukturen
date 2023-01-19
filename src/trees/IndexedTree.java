package trees;


/**
 * Interface für Bäume als Listen, also
 * mit indiziertem Zugriff.
 * 
 * @author Yanik Recke
 */
public interface IndexedTree<T, E> {

	/**
	 * Findet das Element am übergebenen Index,
	 * sofern ein gültiger Index angegeben ist.
	 * 
	 * @param index - der Index des wiederzugebenen Elements
	 * @return - das Element
	 */
	E select(int index);
	
	
	/**
	 * Fügt ein Element am übergebenen Index ein.
	 * Index muss größer gleich Null sein. 
	 * 
	 * @param index - Index
	 * @param element - einzufügendes Element
	 * @return - (neue) Wurzel der Baumstruktur
	 */
	T insert(int index, E element);
	
	
	/**
	 * Entfernt ein Element am übergebenen Index
	 * sofern dieser gültig ist.
	 * Index muss größer gleich Null sein.
	 * Ist der Index zu groß, wird nichts
	 * entfernt.
	 * 
	 * @param index
	 * @param element
	 * @return
	 */
	T remove(int index);
	
	
	/**
	 * Berechnet den Index des ersten Vorkommens
	 * eines übergebenen Elements.
	 * 
	 * @param element - das zu suchende Element
	 * @return - der Index des ersten Vorkommens des Elements
	 */
	int indexOf(E element);
	
	/**
	 * Generiert die Darstellung des Baums in 
	 * GraphViz Schreibweise.
	 * 
	 * @return - String für GraphViz
	 */
	String toGraphViz();
	
}
