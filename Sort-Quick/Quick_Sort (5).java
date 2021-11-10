package part2;

public class Quick_Sort {
	
	public static Comparable[] quickSort(Comparable[] a, int first, int last) {
		if(first<last) {
			int pivot = choosePivot(a, first, last);
			quickSort(a, first, pivot-1);
			quickSort(a, pivot+1, last);
		}
		return a;
	}
	
	private static int choosePivot(Comparable[] a, int first, int last) {
		Comparable pivot = a[last];
		int i = (first-1);
		for(int j=first; j< last; j++) {
			if(less(a[j],pivot)) { 
				i++;
				swap(a, i, j);
			}
		}
		swap(a,i+1,last);
		return i+1;
	}
	
	private static boolean less(Comparable a, Comparable b) {
		if(a.compareTo(b) < 0 || a.compareTo(b) == 0) {
			return true;
		}
		return false;
	}
	
	private static void swap(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	
	
}
