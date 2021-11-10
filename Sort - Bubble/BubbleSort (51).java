import java.util.Arrays;

public class BubbleSort{

	private boolean optimized = false;

	public BubbleSort(){}

	public BubbleSort(boolean optimized){
		this.optimized = optimized;
	}

	public void bubbleSort(int[] A) {
		if (optimized) {
			optimizedBubbleSort(A);
		} else {
			basicBubbleSort(A);
		}
	}

	private void basicBubbleSort(int[] A) {

		int len = A.length;
		for (int i = 0; i < len - 1; i ++) {
			for (int j = 0; j < len - 1; j ++) {
				if (A[j] > A[j + 1]) {
					swap(A, j, j + 1);
				}
			}
		}

	}

	private void optimizedBubbleSort(int[] A) {

		int len = A.length;
		int unsortedBorder = len - 1, lastExchange = 0;
		for (int i = 0; i < len - 1; i ++) {
			int flag = 0;
			for (int j = 0; j < unsortedBorder; j ++) {
				if (A[j] > A[j + 1]) {
					swap(A, j, j + 1);
					flag = 1;
					lastExchange = j;
				}
			}
			unsortedBorder = lastExchange;
			if (0 == flag) {
				return;
			}
		}
	}

	private void swap(int[] A, int idx1, int idx2) {

		int tmp = A[idx1];
		A[idx1] = A[idx2];
		A[idx2] = tmp;

	}

	public static void main(String[] args) {
		int[] A1 = {4, 5, 9, 2, 0, 1, 6, 8, 3, 7};
		int[] A2 = {4, 5, 9, 2, 0, 1, 6, 8, 3, 7};
		BubbleSort bs1 = new BubbleSort();
		BubbleSort bs2 = new BubbleSort(true);

		System.out.println("A1 unsorted: " + Arrays.toString(A1));
		System.out.println("A2 unsorted: " + Arrays.toString(A2));

		long basicStartTime = System.currentTimeMillis();
		bs1.bubbleSort(A1);
		long basicEndTime = System.currentTimeMillis();

		long optimizedStartTime = System.currentTimeMillis();
		bs2.bubbleSort(A2);
		long optimizedEndTime = System.currentTimeMillis();

		System.out.println("A1 sorted via basic: " + Arrays.toString(A1) 
						+ ", time eclipsed: " + (basicEndTime - basicStartTime) + "ms");
		System.out.println("A2 sorted via optimized: " + Arrays.toString(A2)
						+ ", time eclipsed: " + (optimizedEndTime - optimizedStartTime) + "ms");
	}

}