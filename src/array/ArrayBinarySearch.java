package array;


/**
 * Klasse zur Implementierung der
 * binären Suche in einem sortierten Array.
 * 
 * @author Yanik Recke
 */
public class ArrayBinarySearch {
	/** Sortierter Array, auf welchen die binäre Suche ausgeführt wird */
	int[] sortedArr;
	
	/**
	 * Konstruktor.
	 * Es ist wichtig, dass der übergebene
	 * Array bereits sortiert ist!
	 * 
	 * @param arr - int-Array
	 */
	public ArrayBinarySearch(int[] arr) {
		this.sortedArr = arr;
	}
	
	
	/**
	 * Gibt an, ob ein Element in einem
	 * Array enthalten ist oder nicht.
	 * 
	 * @param num - zu suchendes Element
	 * @return - true, wenn es enthalten ist, false, wenn nicht
	 */
	public boolean contains(int num) {
		return indexOf(num) >= 0;
	}
	
	
	/**
	 * Berechnet den Index eines übergebenen Elements
	 * in einem sortierten Array. 
	 * Ist das Element nicht enthalten wird der Index, an
	 * dem es eingefügt werden soll folgendermaßen zurückgegeben:
	 * -(einfügeindex - 1)
	 * 
	 * Somit ist die 0 nicht "doppelt"
	 * 
	 * @param num - zu suchendes Element
	 * @return - (Einfüge-)Index
	 */
	public int indexOf(int num) {
		int low = 0, high = this.sortedArr.length - 1, mid;
		
		while (low <= high) {
			mid = low + (high - low) / 2;
			
			if (this.sortedArr[mid] == num) {
				return mid;
			} else if (this.sortedArr[mid] < num) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		
		return -(low + 1);
	}
	
}
