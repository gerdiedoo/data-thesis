package ie.gmit.dip;
import java.util.Random;
import java.util.*; 

public class InsertionSort {
    
    
      public static void main(String[] args) {
        
        // TODO code application logic here
        Random g = new Random();
        
       int [] number = new int [10]; //alternated and run 10 times manually

        System.out.print("Random Numbers:");
        for (int d = 0 ; d<number.length ; d++){
            int RandomG = g.nextInt(number.length)+1;
            number[d] = RandomG;
            System.out.print(" " +RandomG);
            }

    
       System.out.print("\nSorted Numbers:"+(Arrays.toString(InsertSort(number))));
       

    }

    public static int [] InsertSort(int[] number){
    
    long startTime= System.nanoTime();
    
    for(int i = 1; i < number.length; i++){
    int value = number[i];
    int j = i - 1;
    while(j >= 0 && number[j] > value){
      number[j + 1] = number[j];
      j = j - 1;
    }
    number[j + 1] = value;
  }
  
        long endTime= System.nanoTime();
        long elapsed = endTime-startTime;
        double timeMillis= elapsed/1000000.0;
        System.out.print("\nSorted In: "+ timeMillis );
        
        return number;  
}
}
