package com.test.strings;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees. Can you do this in place?
 * @author sabiya
 *
 */
public class RotatateImage {

	static int count = 0;
	@Test
	public void testRotate() {
		rotate();
	}
	
	public void rotate() {
		int n = 3;
		char [][] a = {{'a', 'b', 'c'}, 
				{'d', 'e', 'f'},
				{'g', 'h', 'i'}
				};
			
		System.out.print("Original Array");
		 
	    for (int i=0; i<n; i++){
	    	System.out.print("\n");
	    	for(int j = 0; j<n; j++) {
	    		System.out.print(a[i][j] + "\t");
	    	}
	    }
	    System.out.println("\n\nArray Rotated");
	    for(int j=0;j<n-1; j++) {
	    	shiftElement(0,j, a, 3);	
	    }
	    
	    for (int i=0; i<n; i++){
	    	System.out.print("\n");
	    	for(int j = 0; j<n; j++) {
	    		System.out.print(a[i][j] + "\t");
	    	}
	    }
	    System.out.println("\nCount :" + count);
	}
	
	/**
	 * Shift all Elements
	 * @param i row index
	 * @param j column index
	 * @param a array
	 * @param n dimension
	 */
	void shiftElement(int i, int j , char [][] a, int n) {
		// Save initial character
		char startChar = a[i][j];
		/* a b c
		 * d e f
		 * g h i
		 * We will start with g, will copy g to a
		 * then copy i to g
		 * copy  c  to i
		 * At last copy a to c 
		 * 
		 * */
		// Row, Column  to start with 
		int row = n - j -1;
		int col = i;
		 do{
			 // Copy i,j to j, n-i-1
		     a[col][n-row-1] = a[row][col];
		     //Update row & column to 
		     // i = n- j -1
		     // j = i
		     count ++;
		     int temp = row;
		     row = n- col -1;
		     col = temp;
		     //end when start element is received
		}while (!(row == i && col == j));
		 // Copy saved char at , j n-i-1
		 a[j][n-i-1] = startChar;
	}

}
