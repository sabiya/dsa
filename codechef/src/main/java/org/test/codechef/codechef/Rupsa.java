package org.test.codechef.codechef;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Rupsa {

	public static void main (String args[]) throws FileNotFoundException {
		Scanner scanner = new Scanner(new FileInputStream("rupsa.txt"));
		int noOfTestCases = scanner.nextInt();
		for (int t=1; t<= noOfTestCases; t++) {
			 int N = scanner.nextInt();
			 long nos [] = new long [N+1];
			 for (int i=0; i<N+1; i++) {
				 nos[i] = scanner.nextInt();
			 }
			 gameplay(nos, N);
		}
	}

	
	private static void gameplay(long[] A, int N) {
		long score = 0;
		for (int i=1; i<=N; i++) {
			score = score + A[i] * A[i-1];
		}
		System.out.println(score);
	}
	private static long gameScore(long[] A, int i , int N) {
		
		long score = 0;
		if (i==0) {
			  return score;
			} else if(i==1) {
				
			} 
		else {
			    lo
				gameScore()
			}
				score = score + A[i] * A[i-1];
			}
		
		System.out.println(score);
		return score;
	}