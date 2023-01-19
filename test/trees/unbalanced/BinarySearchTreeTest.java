package trees.unbalanced;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import trees.unbalanced.BinarySearchTree;

public class BinarySearchTreeTest {

	
	
	// --------------- Tests für ceiling(E)
	@Test
	public void testCeiling_bigTree() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		
		tree.insertAll(Arrays.asList(50, 25, 5, 1, 7, 35, 85, 95, 101, 90, 51, 62));
		
		assertEquals(35, tree.ceiling(35));
		
		for (int i = 36; i <= 50; i++) {
			assertEquals(50, tree.ceiling(i));	
		}
		
		System.out.println(tree.toGraphViz());
		
		assertEquals(1, tree.ceiling(0));
		
		assertEquals(101, tree.ceiling(97));
	}
	
	
	@Test
	public void testCeiling_emptyTree() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		
		assertNull(tree.ceiling(0));
		assertNull(tree.ceiling(-5));
		assertNull(tree.ceiling(10));
	}
	
	
	@Test
	public void testCeiling_oneElementInTree() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		
		tree.insert(20);
		
		assertEquals(20, tree.ceiling(0));
		assertEquals(20, tree.ceiling(15));
		assertEquals(20, tree.ceiling(20));
		
		assertNull(tree.ceiling(21));
	}
	
	
	// --------------- Tests für floor(E)
	@Test
	public void testFloor_bigTree() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		
		tree.insertAll(Arrays.asList(50, 25, 5, 1, 7, 35, 85, 95, 101, 90, 51, 62));
		
		for (int i = 49; i >= 35; i--) {
			assertEquals(35, tree.floor(i));
		}
		
		assertEquals(1, tree.floor(1));
		assertNull(tree.floor(0));
		
		assertEquals(101, tree.floor(101));
		assertEquals(95, tree.floor(100));
		assertEquals(95, tree.floor(97));
		assertEquals(95, tree.floor(95));
	}
	
	
	@Test
	public void testFloor_emptyTree() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		
		assertNull(tree.floor(100));
		assertNull(tree.floor(0));
		assertNull(tree.floor(-90));
	}
	
	
	@Test
	public void testFloor_oneElementInTree() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		
		tree.insert(20);
		
		for (int i = 10000; i >= 20; i--) {
			assertEquals(20, tree.floor(i));
		}
		
		assertNull(tree.floor(19));
	}
	
	
	
	// --------------- Tests für higher(E)
	@Test
	public void testHigher_bigTree() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		
		tree.insertAll(Arrays.asList(50, 25, 5, 1, 7, 35, 85, 95, 101, 90, 51, 62));
		
		assertEquals(51, tree.higher(50));
		
		assertEquals(50, tree.higher(49));
		assertEquals(50, tree.higher(48));
		assertEquals(50, tree.higher(47));
		assertEquals(50, tree.higher(46));
		assertEquals(50, tree.higher(45));
		assertEquals(50, tree.higher(44));
		assertEquals(50, tree.higher(35));
		
		assertEquals(5, tree.higher(1));
		
		assertEquals(1, tree.higher(0));
		
		assertNull(tree.higher(101));
		
		assertEquals(101, tree.higher(100));
	}
	
	
	@Test
	public void testHigher_emptyTree() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		
		assertNull(tree.higher(0));
	}
	
	
	@Test
	public void testHigher_treeWithOneElement() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.insert(20);
		
		for (int i = -5; i < 20; i++) {
			assertEquals(20, tree.higher(i));
		}
	}
	
	
	// --------------- Tests für lower(E)
	@Test
	public void testLower_bigTree() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		
		tree.insertAll(Arrays.asList(50, 25, 5, 1, 7, 35, 85, 95, 101, 90, 51, 62));
		
		assertEquals(35, tree.lower(50));
		
		assertEquals(35, tree.lower(49));
		assertEquals(35, tree.lower(48));
		assertEquals(35, tree.lower(47));
		assertEquals(35, tree.lower(46));
		assertEquals(35, tree.lower(45));
		assertEquals(35, tree.lower(44));
		assertEquals(25, tree.lower(35));
		
		assertEquals(1, tree.lower(5));
		
		assertEquals(51, tree.lower(62));
		
		assertNull(tree.lower(1));
		
		assertEquals(95, tree.lower(101));
	}
	
	
	@Test
	public void testLower_emptyTree() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		
		assertNull(tree.lower(0));
	}
	
	
	@Test
	public void testLower_treeWithOneElement() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.insert(20);
		
		for (int i = 100000; i > 20; i--) {
			assertEquals(20, tree.lower(i));
		}
		
		assertEquals(20, tree.lower(66));
	}
}
