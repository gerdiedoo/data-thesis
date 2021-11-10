class BinarySearchIterative {
    public int binarySearch(int[] arr, int target) {
        int index = -1;
        int low = 0;
        int high = arr.length - 1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            if( arr[mid] == target ){
                index = mid;
            } else if( arr[mid] < target ) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return index;
    }
    public static void main(String args[]) 
    {  
        BinarySearchIterative object = new BinarySearchIterative();
        int arr[] = { 2, 3, 4, 10, 40 }; 
        int target = 3; 
        int index = object.binarySearch(arr, target);
        if (index == -1) 
            System.out.println("Element not present"); 
        else
            System.out.println("Element found at index " + index); 
    } 
}
// Java implementation of iterative Binary Search 
