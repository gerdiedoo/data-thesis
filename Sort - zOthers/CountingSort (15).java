/**
 * Algorithms-In-Java
 * CountingSort.java
 */
package com.deepak.algorithms.Sorting;

/**
 * Counting Sort Implementation
 * 
 * @author Deepak
 */
public class CountingSort {

	/**
	 * Main method to start the flow of program
	 * @param args
	 */
	public static void main(String[] args) {
		int[] valuesToBeSorted = {7, 10, 47, 40, 83, 84, 65, 61, 32, 55, 49, 46, 25, 20, 93, 63, 54, 10};
		System.out.println("******************* COUNTING - SORT *******************");
		performCountingSort(valuesToBeSorted);
	}

	/**
	 * Counting sort is a sorting technique based on keys between a specific range.
	 * It works by counting the number of objects having distinct key values (kind of hashing).
	 * Then doing some arithmetic to calculate the position of each object in the output sequence.
	 * 
	 * <p>Notes:
	 * 1. Counting sort is efficient if the range of input data is not significantly greater than the number of objects to be sorted.
	 * 		- Consider the situation where the input sequence is between range 1 to 10K and the data is 10, 5, 10K, 5K.
	 * 2. It is not a comparison based sorting. It running time complexity is O(n) with space proportional to the range of data.
	 * 3. It is often used as a sub-routine to another sorting algorithm like radix sort.
	 * 4. Counting sort uses a partial hashing to count the occurrence of the data object in O(1).
	 * 5. Counting sort can be extended to work for negative inputs also.
	 * 6. This type of integer sorting algorithms are usually designed to work in either the pointer machine or random access machine models of computing
	 * </p>
	 */
	private static void performCountingSort(int[] values) {
		/* Find the length of the collection */
		int n = values.length;
		/* Output character array which will hold the sorted array */
		int output[] = new int[n];
		/* Create a count array of 256 size, and store the count of each character in it */
		int count[] = new int[256];
		for (int i = 0; i < n; ++i) {
			++count[values[i]];
		}
		/* Change count[i] so that count[i] now contains actual position of the character */
		for (int i = 1; i <= 255; ++i) {
			count[i] += count[i-1];
		}
		/* Build the output character array */	

		// Build the output character array
		for (int i = 0; i<n; ++i) {
			output[count[values[i]] - 1] = values[i];
			--count[values[i]];
		}
		System.out.print("Sorted  array is : ");
		for (int i = 0; i < output.length; ++i) {
			System.out.print(output[i]+", ");
		}
	}

}
