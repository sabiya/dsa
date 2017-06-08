package backtrack.programming.problems;

import org.junit.Test;

/**
 * 
 * http://www.geeksforgeeks.org/backtracking-set-1-the-knights-tour-problem/
 * @author sabiya
 *
 */
public class KnightTourProblem {

	public  static void main(String[] args){
		solve(8);
	}
	public static boolean solve(int N) {
		int sol[][] = new int[N][N];
		
		for(int i=0;i<N; i++){
			for(int j=0;j<N;j++)
				sol[i][j] = -1;
		}
		
		sol[0][0] = 0;
		int x =0;
		int y=0;
		int [] xmove = { 2 , 2,   1, -1, -2, -2, -1, 1};
		int [] ymove = { 1, -1,  -2, -2, -1,  1,  2, 2};	
//		int xmove [] = {2, 1, -1, -2, -2, -1,  1,  2};
//		int ymove [] = {1, 2,  2,  1, -1, -2, -2, -1}; 
		if ( solveKnightTour(sol, x, y, 1, xmove, ymove, N ) == true) {
			printSolution(sol, N);
			
		} else {
			System.out.println("Solution does not exist");
		}
		return false;
		
	}

	private static void printSolution(int[][] sol, int N) {
		// TODO Auto-generated method stub
		for(int i=0;i<N; i++){
			System.out.print("\n");
			for(int j=0;j<N;j++) {
				System.out.print(sol[i][j] + "\t");
			}
		}
		
	}

	/**
	 * @param sol
	 * @param x
	 * @param y
	 * @param movei
	 * @param xmove
	 * @param ymove
	 * @param N
	 * @return
	 */
	private static boolean solveKnightTour(int[][] sol, int x, int y, int movei, int[] xmove, int[] ymove, int N) {
//		System.out.println("trying (" + x +"," + y + ") move:" + movei);
		if (movei==N*N)
			return true;
		for(int k=0; k<8; k++) {
			int xnext = x+ xmove[k];
			int ynext = y+ ymove[k];
			if(isNextMove(xnext,ynext,sol, N)) {
				sol[xnext][ynext] =  movei;
				if(solveKnightTour(sol,xnext,ynext,movei+1, xmove,ymove, N)==true) {
					return true;
				}
				else {
					//backtrack
					sol[xnext][ynext] = -1;
				}

			}

		}
		return false;
	}

	private static  boolean isNextMove( int xnext, int ynext, int sol[][], int N) {
		// TODO Auto-generated method stub
		return  (xnext>=0 && xnext<N&& ynext>=0 && ynext<N && (sol[xnext][ynext]==-1));
	}
}
