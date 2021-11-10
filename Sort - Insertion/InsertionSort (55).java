import java.util.Arrays;

public class InsertionSort{

	public void insertionSort(int[] A) {

		int len = A.length;
		for (int i = 1; i < len; i ++) {
			for (int j = i; j > 0 && A[j] < A[j - 1]; j --) {
				swap(A, j, j - 1);
			}
		}

	}

	private void swap(int[] A, int idx1, int idx2) {

		int tmp = A[idx1];
		A[idx1] = A[idx2];
		A[idx2] = tmp;

	}

	public static void main(String[] args) {
		InsertionSort is = new InsertionSort();
		int[] A = {4, 5, 9, 2, 0, 1, 6, 8, 3, 7};
		System.out.println("unsorted: " + Arrays.toString(A));
		is.insertionSort(A);
		System.out.println("sorted: " + Arrays.toString(A));
	}

}