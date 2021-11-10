package ie.gmit.dip;
import java.util.Random;
import java.util.*; 

public class BubbleSort {

    public static void main(String[] args) {
        
        // TODO code application logic here
        Random g = new Random();
        
       int [] number = new int [10000]; //alternated and run 10 times manually

        System.out.print("Random Numbers:");
        for (int d = 0 ; d<number.length ; d++){
            int RandomG = g.nextInt(1000)+1;
            number[d] = RandomG;
            System.out.print(" " +RandomG);
            }

    
       System.out.print("\nSorted Numbers:"+(Arrays.toString(BubbleSortMethod(number))));
       
      

    }

    public static int [] BubbleSortMethod(int[] number){
        int temp;
        long startTime= System.nanoTime();
        
        for(int i = 0 ; i < number.length-1 ; i++){
            for ( int j = 1 ; j < number.length-i-1 ; j++){
                if ( number[j-1] > number[j]){
                    temp = number[j-1];
                    number[j-1] = number[j];
                    number[j] = temp;
                }
            }
        }
        long endTime= System.nanoTime();
        long elapsed = endTime-startTime;
        double timeMillis= elapsed/1000000.0;
        System.out.print("\nSorted In: "+ timeMillis );
        
        return number;  
       
          
    
    }
    
}

    

