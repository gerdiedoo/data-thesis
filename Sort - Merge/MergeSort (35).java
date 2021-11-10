package raymond.com.sorting;

/**
 * 
 * 
 * This class will carry out the merge sort algorithm on a set on numbers.
 * 
 * 
 * @version 03/02/2019
 * @author Raymond Ward
 *
 */

public class MergeSort extends Sorting 
{
	private int [] numbersArray;
	
	
	
	public MergeSort(int[] array)
	{
		numbersArray = array;
		
	}
	
	
	public int [] sort ()
	{
		return sort(numbersArray);
		
	}
	
	public int []  sort (int [] array)
	{
		
		if (array.length == 1)
		{
			return array;
		}
			
		else
		{
			int [] tempArray1 = new int[array.length / 2];
			int [] tempArray2 = new int[array.length - array.length / 2];
			
			for (int i = 0; i < array.length; i ++)
			{
				if (i < array.length / 2)
				{
					tempArray1[i] = array[i];
				}
				else
				{
					tempArray2[i - array.length / 2] = array[i];
				}
			}
			
			int [] sortedArray1 = sort(tempArray1);
			int [] sortedArray2 = sort(tempArray2);
			return mergeArrays(sortedArray1, sortedArray2);

			
		}
		
	
		
		
	}





	private int [] mergeArrays(int [] array1, int[] array2) 
	{

		
	
		int [] sortedArray = new int [array1.length + array2.length];
		int array1Index = 0;
		int array2Index = 0;
		int sortedIndex = 0;
		
		
		while (array1Index < array1.length && array2Index < array2.length)
		{
			if (array1[array1Index] <= array2[array2Index])
			{
				sortedArray[sortedIndex] = array1[array1Index];
				array1Index++;
			}
			else
			{
				sortedArray[sortedIndex] = array2[array2Index];
				array2Index++;
			}
			sortedIndex++;

			
		}
		
		while (array1Index < array1.length)
		{
			sortedArray[sortedIndex] = array1[array1Index];
			array1Index++;
			sortedIndex++;
		}
		while (array2Index < array2.length)
		{
			sortedArray[sortedIndex] = array2[array2Index];
			array2Index++;
			sortedIndex++;
		}
		
		
		return sortedArray;
	}
	
	

}
