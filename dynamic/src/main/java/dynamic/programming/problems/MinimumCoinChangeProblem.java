package dynamic.programming.problems;

import org.junit.Test;

/**
 * http://algorithms.tutorialhorizon.com/dynamic-programming-minimum-coin-change
 * -problem/
 * 
 * Objec­tive: Given a amount ‘A’ and n coins, v1<v2<v3<.….……<vn . Write a
 * pro­gram to find out min­i­mum num­bers of coins required to make the change
 * for the amount ‘A’.
 * 
 * Example:
 * 
 * Amount: 5
 * 
 * Coins [] = 1, 2, 3.
 * 
 * No of ways to make the change are : { 1,1,1,1,1} , {1,1,1,2}, {2,2,1},{1,1,3}
 * and {3,2}.
 * 
 * So as we can see minimum number of coins required are 2 ( 3+2=5}.
 * 
 * @author sabiya
 *
 */
public class MinimumCoinChangeProblem {

	
	@Test
	public void testCoinChange() {
		int a[] = {1,2,3};
		int m= a.length;
		int n=5;
		System.out.print("\nCoins For a change:"+ minCoinsForChange(a,m,n));
		
		System.out.print("\n---- Tabulation method -----");
		System.out.print("\nCoins For a change using dynamic :"+ minCoinsForChangeOpt(a,m,n));
		
		System.out.print("\n---- My method -----");
		System.out.print("\nCoins For a change using dynamic more optimized :" + minCoinsForMoreOpt(a,m,n));
	}
	
	public int minCoinsForChange(int c[], int m, int n) {
		if(m==0 && n>=1)
			return Integer.MAX_VALUE;
		//if amount is 0, there are no coins to make a change
		if(n==0)
			return 0;
		
		if(n<c[m-1])
			return minCoinsForChange(c, m-1, n);
		else
			return Math.min(1 + minCoinsForChange(c, m,n-c[m-1]),  minCoinsForChange(c, m-1, n));
		
	}
	
	public int minCoinsForMoreOpt(int c[], int m, int n) {
	// sort coins, using mlogm or assume sorted
		if(n==0)
			return 0;
		
		int count = 0;
		while(n>0 && m>=1){
			if (n>=c[m-1]){
				n = n-c[m-1];
				count++;
				System.out.print("\ncoin:" +c[m-1]);
			} else {
				m = m-1;
			}

		}
		if(n>0) {
			System.out.println("\nNo such solution exists");
			return -1;
		}
		return count;
	}
	
	public int minCoinsForChangeOpt(int c[], int m, int n) {
		int sol[][]=new int[n+1][m+1];
		
		// if amount is 0, 0 coins are needed
		for(int j=0;j<m+1; j++)
			sol[0][j] = 0;
		
		//If coins are 0 and amount >=1 then cannot make it.
		for(int i=1;i<n+1; i++)
			sol[i][0] = Integer.MAX_VALUE;
		
		for(int i=1;i<n+1; i++){
			for(int j=1; j<m+1; j++){
				
				if(i<c[j-1]){
					sol[i][j] = sol[i][j-1];
				} else {
					sol[i][j] = Math.min(1+ sol[i-c[j-1]][j], sol[i][j-1]);
							
				}
			}
			
		}
		
		//printMatrix(sol,n+1,m+1);
		// print which coins are chosen
		int coins = sol[n][m];
		int j=m;
		int i = n;
		int coinused[] = new int[coins];
		for(; coins>=1; ) {
			if(i>= c[j-1]) {
			  coinused[coins -1] = c[j-1];
			   i = i- c[j-1];
			   coins--;
			  } else {
				  j = j -1;
			  } 
			
		}
		for (i=0;i<sol[n][m];i++)
			System.out.print("\nC: " + coinused[i]);
		return sol[n][m];
	}

	private void printMatrix(int[][] a, int m, int n) {
		// TODO Auto-generated method stub
		
		for(int i=0; i<m; i++) {
			System.out.println();
			for(int j=0; j<n; j++) {
				System.out.print(" " + a[i][j]);
			}
		}
		System.out.println();
	}
}
