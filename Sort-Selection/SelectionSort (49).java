import java.util.Arrays;

public class SelectionSort {

	public void selectionSort(int[] A) {

		int len = A.length;
		int minIdx = 0;
		for (int i = 0; i < len; i ++) {
			minIdx = i;
			for (int j = i + 1; j < len; j ++) {
				if (A[j] < A[minIdx]) {
					minIdx = j;				
				}
			}
			swap(A, i, minIdx);
		}

	}

	private void swap(int[] A, int idx1, int idx2) {

		int tmp = A[idx1];
		A[idx1] = A[idx2];
		A[idx2] = tmp;

	}

	public static void main(String[] args) {
		
		SelectionSort ss = new SelectionSort();
		int[] A = {4, 5, 9, 2, 0, 1, 6, 8, 3, 7};
		System.out.println("unsorted: " + Arrays.toString(A));
		ss.selectionSort(A);
		System.out.println("sorted: " + Arrays.toString(A));

	}

}