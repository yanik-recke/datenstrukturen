package trees;

import java.util.Collection;


/**
 * Interface für Baumstrukturen.
 * 
 * @author Yanik Recke
 */
public interface Tree<T, E> {
	
	
	/**
	 * Fügt ein übergebenes Element in
	 * die Baumstruktur entsprechend seiner Ordnung
	 * ein.
	 * 
	 * @param element - das einzufügende Element
	 * @return - die Wurzel der Baumstruktur
	 */
	T insert(E element);
	
	
	/**
	 * Fügt alle Element der übergebenen
	 * Collection in die Baumstruktur
	 * entsprechend ihrer Ordnung ein.
	 * 
	 * @param elements - Collection an einzufügenden Elementen
	 * @return - die (neue) Wurzel der Baumstruktur
	 */
	T insertAll(Collection<E> elements);
	
	
	/**
	 * Fügt ein Element in die Baumstruktur
	 * am entsprechenden Index ein.
	 * 
	 * @param idx - der übergebene Index, an den eingefügt werden soll
	 * @param element - das einzufügende Element
	 * @return - die (neue) Wurzel des Baums
	 */
	T insert(int idx, E element);
	
	
	/**
	 * Entfernt das übergebene Element aus
	 * dem Baum, sofern es existiert.
	 * 
	 * @param element
	 * @return - die (neue) Wurzel des Baums
	 */
	T remove(E element);
	
	
	/**
	 * Liefert das kleinste Element des
	 * Baums.
	 * 
	 * @return
	 */
	T minimum();
	
	
	/**
	 * Liefert das größte Element des
	 * Baums.
	 * 
	 * @return - das größte Element
	 */
	T maximum();
	
	
	/**
	 * Gibt an, ob ein Element in dem
	 * Baum existiert oder nicht.
	 * 
	 * @param element - das zu suchende Element
	 * @return - true, wenn es existiert, false, wenn nicht
	 */
	boolean contains(E element);
	
	/**
	 * Liefert das kleinste Element größer oder
	 * gleich dem übergebenen Element.
	 * 
	 * @param element - das übergebene Element
	 * @return - das kleinste Element größer oder gleich dem 
	 * 			 übergebenen Element, oder null, wenn es kein
	 * 			 solches gibt
	 */
	E ceiling(E element);
	
	
	/**
	 * Liefert das größte Element kleiner oder
	 * gleich dem übergebenen Element.
	 * 
	 * @param element - das übergebene Element
	 * @return - das größte Element kleiner oder gleich
	 * 			 dem übergebenen Element, oder null, wenn
	 * 			 kein solches gibt
	 */
	E floor(E element);
	
	
	/**
	 * Liefert das nächsthöhere Element ausgehend
	 * des übergebenen Elements.
	 *  
	 * @param element - das übergebene Element
	 * @return - das nächstgrößere Element als das übergebene
	 * 			 oder null, wenn es kein solches gibt
	 */
	E higher(E element);
	
	
	/**
	 * Liefert das nächstkleinere Element ausgehend
	 * des übergebenen Elements.
	 * 
	 * @param element - das übergebene Element
	 * @return - das nächstkleinere Element als das übergebene
	 * 			 oder null, wenn es kein solches gibt
	 */
	E lower(E element);
	
	
	
	/**
	 * Generiert die Darstellung des Baums in 
	 * GraphViz Schreibweise.
	 * 
	 * @return - String für GraphViz
	 */
	String toGraphViz();
	
}
