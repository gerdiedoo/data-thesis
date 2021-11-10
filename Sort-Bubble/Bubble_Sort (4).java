package part2;

public class Bubble_Sort{
	
	public static Comparable[] Bubble_Sort(Comparable[]a) {

		int last = a.length-1;
		boolean sorted = false;
		for(int i=0; i<last && !sorted; i++) {
			sorted = true;
			for(int j=last; j>i; j--) {
				if( less(a[j],a[j-1])) {
					swap(a,j,j-1);
					sorted = false;
				}
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

	private static void swap(Comparable[] a, int j, int i) {
		Comparable temp = a[j-1];
		a[j-1] = a[j];
		a[j]=temp;
	}
}
