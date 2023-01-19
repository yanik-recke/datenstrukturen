package heaps;

import org.junit.Test;


public class MinHeapTest {

	@Test
	public void testHeapify_alreadyHeap() {
		MinHeap heap  = new MinHeap(new int[] {10, 32, 21, 64, 40, 48, 52, 88, 71, 95, 42, 76});
		
//		for (int i = 0; i < heap.heap_size; i++) {
//			System.out.println(heap.heap[i]);
//		}
	}
	
	@Test
	public void testHeapify_notHeap() {
		MinHeap heap  = new MinHeap(new int[] {14, 8, 7, 2, 1, 16, 4, 3, 9, 10});
		
//		for (int i = 0; i < heap.heap_size; i++) {
//			System.out.println(heap.heap[i]);
//		}
	}
	
	@Test
	public void testDecrease_1() {
		MinHeap heap  = new MinHeap(new int[] {10, 32, 21, 64, 40, 48, 52, 88, 71, 95, 42, 76});
		
		heap.decrease(11, 16);
		
		for (int i = 0; i < heap.heap_size; i++) {
			System.out.println(heap.heap[i]);
		}
	}
}
