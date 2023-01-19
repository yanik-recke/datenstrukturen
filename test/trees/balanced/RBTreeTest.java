package trees.balanced;

import org.junit.jupiter.api.Test;

import trees.balanced.RBTree;

public class RBTreeTest {

	@Test
	public void testInsert_bigTree() {
		RBTree<Integer> tree = new RBTree<Integer>();
		
		tree.insert(13);
		tree.insert(8);
		tree.insert(17);
		tree.insert(1);
		tree.insert(11);
		tree.insert(6);
		tree.insert(15);
		tree.insert(25);
		tree.insert(22);
		tree.insert(27);
		
		System.out.println(tree.toGraphViz());
	}
	
	
	@Test
	public void testInsert_bigTree_2() {
		RBTree<Integer> tree = new RBTree<Integer>();
		
		// Baum aus Nachbereitung 6, Lösung Seite 17
		tree.insert(56);
		tree.insert(75);
		tree.insert(64);
		tree.insert(70);
		tree.insert(50);
		tree.insert(60);
		tree.insert(46);
		
		// Seite 18
		//tree.insert(58);
		
		// Seite 19
		//tree.insert(62);
		
		// Seite 21
		//tree.insert(52);
		
		// Seite 24
		//tree.insert(44);
		
		// Seite 28
		tree.insert(48);
		
		System.out.println(tree.toGraphViz());
	}
}
