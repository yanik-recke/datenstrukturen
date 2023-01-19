package array;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ArrayBinarySearchTest {

	@Test
	public void test_binarySearch_longList() {
		ArrayBinarySearch bs = new ArrayBinarySearch(new int[] {2, 4, 6, 8, 10, 12, 14, 16, 18, 20});
		
		assertEquals(1, bs.indexOf(4));
		assertEquals(0, bs.indexOf(2));
		assertEquals(9, bs.indexOf(20));
		
		assertEquals(-2, bs.indexOf(3));
		assertEquals(-4, bs.indexOf(7));
		assertEquals(-11, bs.indexOf(21));
		
		assertEquals(-1, bs.indexOf(-1));
	}
}
