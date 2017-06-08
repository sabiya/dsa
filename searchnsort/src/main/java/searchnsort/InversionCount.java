package searchnsort;

import org.junit.Test;

public class InversionCount {

	
	public static void main(String [] args){
//		int input[] = {2,4,1,3,5};
//		int input [] = {1, 20, 6, 4, 5,9,8};
		int input [] = {1, 10, 16, 3, 4, 5};
		int invcount = mergeSort(input, 0, input.length-1);
		System.out.println();
		for(int no:input){
		System.out.print( "  "+ no);
		}
		System.out.println("\n No of inversions count :" + invcount);
		
	}

	private static int  mergeSort(int[] a, int l, int u) {
		int count =0;
		if(l<u){
			int m = l + (u-l)/2;
			count = mergeSort(a, l, m);
			count = count + mergeSort(a, m+1, u);
			count = count + merge(a, l, m, u);
		}
		return count;
	}

	private static int merge(int a[], int l, int m, int u) {
		// TODO Auto-generate\d method stub\
		int n1 = m - l + 1, n2 = u - m;
		int[] a1 = new int[n1], a2 = new int[n2];
		int i = 0;
		int j = 0, k = 0;
		int count =0;
		for (i = l; i <= m; i++)
			a1[k++] = a[i];
		
		for (j = m+1, k=0; j <= u; j++)
			a2[k++] = a[j];
		
//		int c[] = new int[n1 + n2];
		k=l;
		i=0;j=0;
	
		while (i < n1 && j < n2) {
			if (a1[i] < a2[j]) {
				a[k++] = a1[i];
				i++;
			} else {
				a[k++] = a2[j];
				j++;
				count = count+ (n1-i);

			}

		} 
		
		if(i<n1) {
			while (i < n1) {
				a[k++] = a1[i];
				i++;
			}

		}
		while (j < n2) {
			a[k++] = a2[j];
			j++;
		}

		return count;
	}
}
