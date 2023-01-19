package heaps;


/**
 * Implementation eines MinHeaps.
 * Indizierung bei 0 beginnend.
 * 
 * @author Yanik Recke
 */
public class MinHeap implements Heap {
	int[] heap = new int[1];
	int heap_size = 0;
	
	public MinHeap(int[] arr) {
		this.heap = arr.clone();
		this.heap_size = arr.length;
		
		for (int i = (this.heap_size / 2) - 1; i >= 0; i--) {
			this.heapify(i);
		}
	}
	
	@Override
	public int parent(int i) {
		return (i - 1) / 2;
	}

	@Override
	public int left_child(int i) {
		return 2 * i + 1;
	}

	@Override
	public int right_child(int i) {
		return 2 * i + 2;
	}

	@Override
	public void heapify(int i) {
		int smallest = i;
		int left = left_child(i);
		int right = right_child(i);

		if (left >= 0 && left < this.heap_size && this.heap[left] < this.heap[smallest]) {
			smallest = left;
		}

		if (right >= 0 && right < this.heap_size && this.heap[right] < this.heap[smallest]) {
			smallest = right;
		}

		if (smallest != i) {
			int temp = this.heap[i];
			this.heap[i] = this.heap[smallest];
			this.heap[smallest] = temp;
			this.heapify(smallest);
		}
	}

	@Override
	public void decrease(int i, int newVal) {
		this.heap[i] = newVal;
		
		int parent = parent(i);
		
		while (parent >= 0 && this.heap[parent] > this.heap[i]) {

			int temp = this.heap[parent];
			this.heap[parent] = this.heap[i];
			this.heap[i] = temp;

			i = parent;
			parent = parent(i);
		}
	}

}
