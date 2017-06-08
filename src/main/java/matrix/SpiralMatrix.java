package matrix;

import java.io.InputStream;
import java.util.Scanner;

public class SpiralMatrix {

	public static void main(String args[]){
		
		InputStream stream = SpiralMatrix.class.getClassLoader().getResourceAsStream("spiral.txt");
		Scanner scanner = new Scanner(stream);
		int N= scanner.nextInt();
		int a[][] = new int[N][N];
		
		for(int i=0;i<N; i++) {
			
			for(int j=0; j<N; j++) {
				a[i][j] = scanner.nextInt();
			}
		}
		print(printSpiralMatrix(a, N), N, N);
		
		
	}
	
	/**
	 * @param a
	 * @param N
	 * @return
	 */
	public static int[][] printSpiralMatrix(int a[][], int N) {
		
		int layers = N/2;
		int lx = 0;
		int ly = 0;
		int ux = N-1, uy = N-1;
		int i,j, count , p=1;
		int b[][] = new int[N][N], c1=-1,c2=-1;
	  for(int layer =1; layer<=layers; layer++) {
		  i = lx;
		  j = ly;
		  count = 1;
		  while (count <=2) {
			  while(i>=lx && i<=ux && ( c1<N-1 || c2 < N-1)) {
				  c1=  ((c2 = (c2 + 1) %N) ==0) ? c1 +1: c1;
				  b[c1][c2] = a[i][j];
				  i = i+p;
			  }
			  i = (i>ux) ? ux : ((i<lx) ? lx : i);
			  j = j+p;
			  while(j>ly && j<=uy && ( c1<N-1 || c2 < N-1)) {
				  c1=  ((c2 = (c2 + 1) %N) ==0) ? c1 +1: c1;
				  b[c1][c2] = a[i][j];
				  j = j+p;
			  }
			  
			  j = (j>uy) ? uy : ((j<ly) ? ly : ly);
			  p = -p;
			  i = i+p;
			  count++;
		  }
		  lx = lx +1;
		  ly = ly +1;
		  ux = ux -1;
		  uy = uy -1;
		  
	  }
	   if(N%2==1) {
		   c1=  ((c2 = (c2 + 1) %N) ==0) ? c1 +1: c1;
		   b[c1][c2] = a[N/2][N/2];
	   }
	   return b;
		
	}
	
	public static void print(int a[][], int m, int n){
		System.out.print("\n");
		for(int i=0;i <m; i++) {
			for(int j=0;j<n; j++){
				System.out.print(a[i][j] + " ");
			}
		}
	}
}
