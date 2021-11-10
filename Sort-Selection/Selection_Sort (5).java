package part2;

public class Selection_Sort {
	
	public static Comparable[] Selection_Sort(Comparable[] a) {
		for(int i=0; i<a.length; i++) {
			int min = i;
			for(int j=i+1; j<a.length; j++) {
				if(less(a[j],a[min]))
					min = j;
			}
			swap(a, i, min);
		}
		return a;
	}
	
	private static boolean less(Comparable a, Comparable b) {
		if(a.compareTo(b) < 0) {
			return true;
		}
		return false;
	}

	private static void swap(Comparable[] a, int i, int min) {
		Comparable temp = a[i];
		a[i] = a[min];
		a[min] = temp;
	}
}
