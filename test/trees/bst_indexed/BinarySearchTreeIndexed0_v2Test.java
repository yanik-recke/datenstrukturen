package trees.bst_indexed;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;


public class BinarySearchTreeIndexed0_v2Test {

	
	@Test
	public void testInsert_bigTree() {
		BinarySearchTreeIndexed0_v2<Integer> tree = new BinarySearchTreeIndexed0_v2<>();
		
		tree.insert(0, 2);
		tree.insert(0,3);
		tree.insert(0, 4);
		tree.insert(2, 99);
		tree.insert(4, 6);
		
		assertEquals(4, tree.select(0));
		assertEquals(3, tree.select(1));
		assertEquals(99, tree.select(2));
		assertEquals(2, tree.select(3));
		assertEquals(6, tree.select(4));
		
		System.out.println(tree.toGraphViz());
	}
	
	
	@Test
	public void testRemove_bigTree() {
		BinarySearchTreeIndexed0_v2<Integer> tree = new BinarySearchTreeIndexed0_v2<>();
		
		tree.insert(0, 2);
		tree.insert(0,3);
		tree.insert(0, 4);
		tree.insert(2, 99);
		tree.insert(4, 6);
		
		//System.out.println("before:\n" + tree.toGraphViz());
		// should remove 4
		//tree.remove(0);
		//System.out.println("after:\n" + tree.toGraphViz());
	}
	
	
	@Test
	public void testInsert_2_bigTree() {
		BinarySearchTreeIndexed0_v2<Integer> tree = new BinarySearchTreeIndexed0_v2<>();
		
		tree.insert(0, 2);
		tree.insert(0, 3);
		tree.insert(0, 4);
		tree.insert(2,  99);
		tree.insert(4,  6);
		
		assertEquals(4, tree.select(0));
		assertEquals(3, tree.select(1));
		assertEquals(99, tree.select(2));
		assertEquals(2, tree.select(3));
		assertEquals(6, tree.select(4));
		
		//System.out.println(tree.toGraphViz());
	}
	
	
	@Test
	public void testRemove_3_bigTree() {
		BinarySearchTreeIndexed0_v2<Integer> tree = new BinarySearchTreeIndexed0_v2<>();
		
		tree.insert(0, 2);
		tree.insert(0, 3);
		tree.insert(0, 4);
		tree.insert(2,  99);
		tree.insert(4,  6);
		
		assertEquals(4, tree.select(0));
		assertEquals(3, tree.select(1));
		assertEquals(99, tree.select(2));
		assertEquals(2, tree.select(3));
		assertEquals(6, tree.select(4));
		
		tree.remove(2);
		
		assertEquals(6, tree.select(3));
		assertEquals(4, tree.select(0));
		assertEquals(3, tree.select(1));
		assertEquals(2, tree.select(2));
		
		assertNull(tree.select(5));
		
		//System.out.println(tree.toGraphViz());
	}
	
	@Test
	public void testRemove_2_bigTree() {
		BinarySearchTreeIndexed0_v2<Integer> tree = new BinarySearchTreeIndexed0_v2<>();
		
		tree.insert(0, 2);
		tree.insert(0, 3);
		tree.insert(0, 4);
		tree.insert(2,  99);
		tree.insert(4,  6);
		
		assertEquals(4, tree.select(0));
		assertEquals(3, tree.select(1));
		assertEquals(99, tree.select(2));
		assertEquals(2, tree.select(3));
		assertEquals(6, tree.select(4));
		
		tree.remove(0);
		
		assertEquals(3, tree.select(0));
		assertEquals(99, tree.select(1));
		assertEquals(2, tree.select(2));
		assertEquals(6, tree.select(3));
		
		//System.out.println(tree.toGraphViz());
	}
	
	
	@Test
	public void testRemove_wholeTree_bigTree() {
		BinarySearchTreeIndexed0_v2<Integer> tree = new BinarySearchTreeIndexed0_v2<>();
		
		tree.insert(0, 2);
		tree.insert(0, 3);
		tree.insert(0, 4);
		tree.insert(2,  99);
		tree.insert(4,  6);
		
		assertEquals(4, tree.select(0));
		assertEquals(3, tree.select(1));
		assertEquals(99, tree.select(2));
		assertEquals(2, tree.select(3));
		assertEquals(6, tree.select(4));
		
		tree.remove(3);
		tree.remove(3);
		tree.remove(0);
		
		assertEquals(3, tree.select(0));
		assertEquals(99, tree.select(1));
		
		tree.remove(0);
		tree.remove(0);
		
		assertNull(tree.select(0));
		
		//System.out.println(tree.toGraphViz());
	}
}
