package heaps;


/**
 * Interface für einen Heap.
 * 
 * @author Yanik Recke
 */
public interface Heap {
	
	/** Berechnung des Elternknotens */
	int parent(int i);
	
	/** Berechnung des linken Kindknotens */
	int left_child(int i);
	
	/** Berechnung des rechten Kindknotens */
	int right_child(int i);
	
	/**
	 * Stellt für den binären Baum mit Wurzel
	 * an Index i die Heap-Eigenschaft her.
	 * 
	 * @param i - Wurzel des Baums
	 */
	void heapify(int i);
	
	/**
	 * Verringert den Schlüssel des Knotens
	 * an Index i auf den übergebenen Wert und
	 * stellt die Heap-Eigenschaft wieder her.
	 * 
	 * @param i - Index
	 * @param newVal - neuer Wert des Knotens an Index i
	 */
	void decrease(int i, int newVal);
	
	
	// TODO to graphviz
	
}
