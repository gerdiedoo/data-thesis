import java.util.Arrays;

/**
 * BinarySearch
 */
public class BinarySearchRecursion {

    public int binarySearch(int[] arr, int low, int high, int target) {
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid] < target) {
                return binarySearch(arr, mid + 1, high, target);
            } else {
                return binarySearch(arr, low, mid - 1, target);
            }
        }
        return -1;
    }

    public static void main(String args[]) 
    { 
        BinarySearchRecursion ob = new BinarySearchRecursion(); 
        int arr[] = { 10, 40, 167, 55, 32, 98, 100 }; 
        Arrays.sort(arr);
        int n = arr.length; 
        int x = 100; 
        int result = ob.binarySearch(arr, 0, n - 1, x); 
        if (result == -1) 
            System.out.println("Element not present"); 
        else
            System.out.println("Element found at Index " + result); 
    } 
}