package trees.bst_indexed;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.Test;

public class BinarySearchTreeIndexed1_v2Test {

	@Test
	public void testInsert_bigTree() {
		BinarySearchTreeIndexed1_v2<Integer> tree = new BinarySearchTreeIndexed1_v2<>();
		
		tree.insert(1, 2);
		tree.insert(1, 3);
		tree.insert(1, 4);
		tree.insert(3,  99);
		tree.insert(5,  6);
		
		assertEquals(4, tree.select(1));
		assertEquals(3, tree.select(2));
		assertEquals(99, tree.select(3));
		assertEquals(2, tree.select(4));
		assertEquals(6, tree.select(5));
		
		//System.out.println(tree.toGraphViz());
	}
	
	
	@Test
	public void testRemove_bigTree() {
		BinarySearchTreeIndexed1_v2<Integer> tree = new BinarySearchTreeIndexed1_v2<>();
		
		tree.insert(1, 2);
		tree.insert(1, 3);
		tree.insert(1, 4);
		tree.insert(3,  99);
		tree.insert(5,  6);
		
		assertEquals(4, tree.select(1));
		assertEquals(3, tree.select(2));
		assertEquals(99, tree.select(3));
		assertEquals(2, tree.select(4));
		assertEquals(6, tree.select(5));
		
		tree.remove(3);
		
		assertEquals(6, tree.select(4));
		assertEquals(4, tree.select(1));
		assertEquals(3, tree.select(2));
		assertEquals(2, tree.select(3));
		
		assertNull(tree.select(5));
		
		//System.out.println(tree.toGraphViz());
	}
	
	@Test
	public void testRemove_2_bigTree() {
		BinarySearchTreeIndexed1_v2<Integer> tree = new BinarySearchTreeIndexed1_v2<>();
		
		tree.insert(1, 2);
		tree.insert(1, 3);
		tree.insert(1, 4);
		tree.insert(3,  99);
		tree.insert(5,  6);
		
		assertEquals(4, tree.select(1));
		assertEquals(3, tree.select(2));
		assertEquals(99, tree.select(3));
		assertEquals(2, tree.select(4));
		assertEquals(6, tree.select(5));
		
		tree.remove(1);
		
		assertEquals(3, tree.select(1));
		assertEquals(99, tree.select(2));
		assertEquals(2, tree.select(3));
		assertEquals(6, tree.select(4));
		
		//System.out.println(tree.toGraphViz());
	}
	
	
	@Test
	public void testRemove_wholeTree_bigTree() {
		BinarySearchTreeIndexed1_v2<Integer> tree = new BinarySearchTreeIndexed1_v2<>();
		
		tree.insert(1, 2);
		tree.insert(1, 3);
		tree.insert(1, 4);
		tree.insert(3,  99);
		tree.insert(5,  6);
		
		assertEquals(4, tree.select(1));
		assertEquals(3, tree.select(2));
		assertEquals(99, tree.select(3));
		assertEquals(2, tree.select(4));
		assertEquals(6, tree.select(5));
		
		tree.remove(4);
		tree.remove(4);
		tree.remove(1);
		
		assertEquals(3, tree.select(1));
		assertEquals(99, tree.select(2));
		
		tree.remove(1);
		tree.remove(1);
		
		assertNull(tree.select(1));
		
		//System.out.println(tree.toGraphViz());
	}
}
