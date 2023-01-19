package nodes;


/**
 * Klasse, die einen Knoten mit
 * einem Rang implementiert. Der Rang
 * muss in der jeweiligen Baumstruktur
 * definiert werden.
 * 
 * @author Yanik Recke
 */
public class TreeNodeRank<E> extends Node<TreeNodeRank<E>, E>{	
	/** Rang */
	private int rank;
	

	/**
	 * Erstellt einen neuen Knoten mit einem
	 * Rang und ohne Kindsknoten.
	 * 
	 * @param element - Schlüssel / Element
	 * @param rank - Rang
	 */
	public TreeNodeRank(E element, int rank) {
		this.key = element;
		this.rank = rank;
	}

	/**
	 * Getter für Rang.
	 * 
	 * @return - der Rang
	 */
	public int getRank() {
		return rank;
	}
	
	/**
	 * Erhöht den Rang um 1.
	 */
	public void increaseRank() {
		this.rank++;
	}
	
	/**
	 * Dekrementiert den Rang um 1.
	 */
	public void decreaseRank() {
		this.rank--;
	}

	
}
