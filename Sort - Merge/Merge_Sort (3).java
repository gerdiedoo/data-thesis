package part2;

public class Merge_Sort {
	public static Comparable[] Merge_Sort(Comparable[]a, int first, int last) {
		if(first < last) {
			int mid = (first+last)/2;
			Merge_Sort(a,first,mid);
			Merge_Sort(a,mid+1,last);
			Merge(a,first,mid,last);
			for(Comparable n: a) {
				System.out.print(n +" ");
			}
			System.out.println();
		}
		return a;
	} 
	private static void Merge(Comparable[]a, int first, int mid, int last) {
		Comparable[] temp = new Comparable[a.length];
		int first1 = first;
		int last1 = mid;
		int first2 = mid+1;
		int last2 = last;
		int index = first1;
		
		for(; first1<=last1 && first2<=last2; index++) {
			if(less(a[first1],a[first2])) {
				temp[index] = a[first1];
				first1++;
			}else {
				temp[index] = a[first2];
				first2++;
			}
		}
		while(first1 <= last1) {
			temp[index] = a[first1];
			index++;
			first1++;
		}
		while(first2 <= last2) {
			temp[index] = a[first2];
			index++;
			first2++;
		}
		for(int i=first; i<=last; i++) {
			a[i] = temp[i];
		}
	}

	private static boolean less(Comparable a, Comparable b) {
		if(a.compareTo(b) < 0) {
			return true;
		}
		return false;
	}
}
