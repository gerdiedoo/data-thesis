package part2;

public class Insertion_Sort {
	
	public static Comparable[] Insertion_Sort(Comparable[]a) {
		for(int i=1; i<a.length; i++) {
			for(int j=i; j>0 && a[j].compareTo(a[j-1]) < 0; j--) {
				swap(a,j,j-1);
			}
		}
		return a;
	}
	
	
	private static boolean less(Comparable a, Comparable b) {
		if(a.compareTo(b) < 0) {
			return true;
		}
		return false;
	}

	public static void swap(Comparable[] a, int j, int b) {
		Comparable temp = a[j-1];
		a[j-1] = a[j];
		a[j]=temp;
	}
}

