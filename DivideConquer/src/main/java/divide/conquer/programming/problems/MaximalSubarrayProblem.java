package divide.conquer.programming.problems;

import org.junit.Test;

/**
 * \ou are given a one dimensional array that may contain both positive and
 * negative integers, find the sum of contiguous subarray of numbers which has
 * the largest sum.
 * 
 * For example, if the given array is {-2, -5, 6, -2, -3, 1, 5, -6}, then the
 * maximum subarray sum is 7 (see highlighted elements).
 * 
 * @author sabiya
 *
 */
public class MaximalSubarrayProblem {

	
	@Test
	public void testMaximalsum(){
		int input[] = {12,-13,-5,25,-20,30,10};
		System.out.println("Max Sum:" + getMaximalSum(input, 0, input.length-1));
				
	}
	
	public int getMaximalSum(int a[], int l, int u) {
		if(l>u){
			return 0;
		}
		if(l==u) {
			return a[l];
		}		
		if(l-u+1==2){
			return Math.max(a[l], a[u]); 
		}
		int m = l+(u-l)/2;
		int sum = getMaximalSum(a, l, m-1);
		int sum1 = getMaximalSum(a, m+1, u);
		return Math.max(Math.max(sum, sum1), maxCrossingSum(a,l,m,u));
	
		
		
	}

	private int maxCrossingSum(int[] a, int l, int m, int u) {
		// TODO Auto-generated method stub
		int left_sum = Integer.MIN_VALUE;
		int sum =0;
		for(int i=m;i>=l;i--){
             sum = sum + a[i];
             if(left_sum<sum) {
            	 left_sum = sum;
             }
		}
		
		int right_sum = Integer.MIN_VALUE;
		 sum =0;
		for(int j=m+1;j<=u;j++){
             sum = sum + a[j];
             if(right_sum<sum) {
            	 right_sum = sum;
             }
		}
		
		return left_sum + right_sum;
			
	}
	
}
