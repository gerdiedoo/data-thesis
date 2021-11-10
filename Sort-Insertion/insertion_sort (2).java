public class insertion_sort 
{
    static void InsertionSort(int arr[]) {
        int j;
        for(int i=1; i<arr.length; i++) {
            j = i;
            while(j>0 && arr[j-1] > arr[j]) {
                //swap
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                
                j = j-1;
            }
        }
    }

    static void printarray(int arr[]){
        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i] + " ");
    } 

    public static void main(String args[]) { 
        int arr[] = {15, 32, 4, 6, 21, 23, 12};
        InsertionSort(arr);
        printarray(arr);
        
    }
}

