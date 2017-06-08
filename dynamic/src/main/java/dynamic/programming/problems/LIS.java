package dynamic.programming.problems;

//Java program to find length of longest increasing subsequence
//in O(n Log n) time
import java.io.*;
import java.util.Arrays;
import java.util.*;
import java.lang.Math;

class LIS
{
	// Binary search (note boundaries in the caller)
	// A[] is ceilIndex in the caller
	static int CeilIndex(int A[], int l, int r, int key)
	{
		while (r - l > 1)
		{
			int m = l + (r - l)/2;
			if (A[m]>=key)
				r = m;
			else
				l = m;
		}

		return r;
	}

	static int LongestIncreasingSubsequenceLength(int A[], int size)
	{
		// Add boundary case, when array size is one

		int[] tailTable = new int[size];
		int len; // always points empty slot

		tailTable[0] = A[0];
		len = 1;
		for (int i = 1; i < size; i++)
		{
			if (A[i] < tailTable[0])
				// new smallest value
				tailTable[0] = A[i];

			else if (A[i] > tailTable[len-1])
				// A[i] wants to extend largest subsequence
				tailTable[len++] = A[i];

			else
				// A[i] wants to be current end candidate of an existing
				// subsequence. It will replace ceil value in tailTable
				tailTable[CeilIndex(tailTable, -1, len-1, A[i])] = A[i];
			print(tailTable);
			
		}

		return len;
	}

	private static void print(int[] tailTable) {

		System.out.println();
		for(int i=0;i<tailTable.length; i++){
//			if(tailTable[i] != 0) {
			 System.out.print(tailTable[i] + ",");
//			}
		}
	}

	// Driver program to test above function
	public static void main(String[] args)
	{
		int A[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};// { 3, 10, 7, 8, 9, 15, 12, 18 };
		int n = A.length;
		System.out.println("Length of Longest Increasing Subsequence is "+
							LongestIncreasingSubsequenceLength(A, n));
		int A1[] = { 3, 15, 17, 5, 4, 18 };
		System.out.println("Length of Longest Increasing Subsequence is "+
				LongestIncreasingSubsequenceLength(A1, A1.length));
	}
}
/* This code is contributed by Devesh Agrawal*/
