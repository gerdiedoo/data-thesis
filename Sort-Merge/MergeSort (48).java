import java.util.Arrays;

/**
 * An implementation of the video: https://www.youtube.com/watch?v=KF2j-9iSf4Q
 */

public class MergeSort {

	public void mergeSort(int[] A) {
		mergeSort(A, new int[A.length], 0, A.length - 1);
	}

	private void mergeSort(int[] A, int[] tmp, int leftStart, int rightEnd) {
		if (leftStart >= rightEnd) {
			return;
		}
		int middle = (leftStart + rightEnd) / 2;
		mergeSort(A, tmp, leftStart, middle);
		mergeSort(A, tmp, middle + 1, rightEnd);
		merge(A, tmp, leftStart, rightEnd);
	}

	private void merge(int[] A, int[] tmp, int leftStart, int rightEnd) {
		int leftEnd = (leftStart + rightEnd) / 2;
		int rightStart = leftEnd + 1;
		int size = rightEnd - leftStart + 1;

		int left = leftStart;
		int right = rightStart;
		int tmpIdx = leftStart;

		while (left <= leftEnd && right <= rightEnd) {
			if (A[left] <= A[right]) {
				tmp[tmpIdx] = A[left];
				left ++;
			} else {
				tmp[tmpIdx] = A[right];
				right ++;
			}
			tmpIdx ++;
		}

		System.arraycopy(A, left, tmp, tmpIdx, leftEnd - left + 1);
		System.arraycopy(A, right, tmp, tmpIdx, rightEnd - right + 1);
		System.arraycopy(tmp, leftStart, A, leftStart, size);
	}

	public static void main(String[] args) {
		int[] A = {4, 5, 9, 2, 0, 1, 6, 8, 3, 7};
		MergeSort ms = new MergeSort();
		System.out.println("unsorted: " + Arrays.toString(A));
		ms.mergeSort(A);
		System.out.println("sorted: " + Arrays.toString(A));
	}

}