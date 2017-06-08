package dynamic.programming.problems;

import java.util.Scanner;

public class FindLongestIncreasingSequence {
	
private static int max_length;



public static void main (String[] args) {
	
		Scanner scanner = new Scanner(FindLongestIncreasingSequence.class.getResourceAsStream("FindLIS.txt") );
		int tcases = scanner.nextInt();
		for(int t=1;t<=tcases;t++){
		    
		    int n = scanner.nextInt();
		    int a[] = new int[n];
		    
		    for(int i=0; i<n; i++) {
		        a[i] = scanner.nextInt();
		    }
		    int len1 = findLongestSequenceSimple(a,n);
		    System.out.println("My :" + len1);
		}
	}
	
private static int findLongestSequence(int a[], int j, int i, int n){

	
	if(j>= n-1|| i>=n-1)
		return 0;
	if(j<0)
		return 1+findLongestSequence(a,i, i+1,n);
	 if(a[j] <a[i])
	{
		return 1+findLongestSequence(a, i, i+1, n);
	}
	else {
		return Math.max(findLongestSequence(a,j,i+1,n), findLongestSequence(a, -1, i, n));
	}

}


private static int findLongestSequenceSimple(int a[], int n){
	
	if(n==1)
		return 1;
	
	int lis[] = new int [n];
	for (int ai=0;ai<n;ai++){
		lis[ai] =1;
	}
	int j=0;
	int i=1;
	findLis(j,i,a,n,lis);
	int max= lis[0];
	for(i=1;i<n;i++) {
		if(max <lis[i]) {
			max = lis[i];
		}
	}
	return max;

}


private static void findLis(int j, int i, int[] a,int n, int[] lis) {

	if(i>n-1 || j>=n-1)
		return;
	int seq = 1;
	int seqi = i;
	for (; j<n-1 && i<n;) {
		if (a[j] < a[i]){
			seq = seq+1;
			j = i;
		} else {
			findLis(i,i+1, a, n, lis);
		}
		i++;
	}
	lis[seqi] = seq;

}

private static int findLongestSequence1(int a[],  int n){

	if(n==1) {
		return 1;
	}
	int current_list_len = 1;
	for (int i=0; i< n-1;i++) {
	  int subarray_len =   findLongestSequence1(a,i+1);
	  if(a[i] < a[n-1] && current_list_len < (1 + subarray_len)) {
		  current_list_len = 1 + subarray_len;
	  }
		 if (max_length < current_list_len)
			 max_length = current_list_len;
		
	}
	return current_list_len;

}

}


//private static int findLongestSequence(int a[], int j, int i,int count, int n){
//     
//    if(j> n-1|| i>n-1)
//     return 0;
//    if(j<0)
//    	return  count +findLongestSequence(a,i, i+1,++count, n);
//    	 
//    if(a[j] <a[i])
//    {
//        return count+ findLongestSequence(a, i, i+1, ++count, n);
//    }  else {
//     	count = Math.max(findLongestSequence(a, j, i+1,count, n),  findLongestSequence(a, -1, i, 0, n));
//    }
//    return count;
//}

