package com.test.strings;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column is set to 0.
 * @author sabiya
 *
 */
public class SetElementsToZero {

	static int count = 0;
	@Test
	public void testRotate() {
		rotate();
	}
	
	public void rotate() {
		int n = 3;
		int [][] a = {{10, 15, 5}, 
				{67, 9, 0 },
				{20, 16, 7}
				};
			
		System.out.print("Original Array");
		 
	    for (int i=0; i<n; i++){
	    	System.out.print("\n");
	    	for(int j = 0; j<n; j++) {
	    		System.out.print(a[i][j] + "\t");
	    	}
	    }
	    System.out.println("\n\nArray Elements");
	    setToZero(a, 3);	
	    
	    for (int i=0; i<n; i++){
	    	System.out.print("\n");
	    	for(int j = 0; j<n; j++) {
	    		System.out.print(a[i][j] + "\t");
	    	}
	    }
	}
	
	/**
	 * Shift all Elements
	 * @param i row index
	 * @param j column index
	 * @param a array
	 * @param n dimension
	 */
	void setToZero(int [][] a, int n) {
		int row [] = new int [a.length];
		int columns [] = new int [a[0].length];
		for (int i=0; i<n; i++){
	    	for(int j = 0; j<n; j++) {
	    		if (a[i][j] == 0) {
	    			row[i] = 1;
	    			columns[j] = 1;
	    		}
	    	}
	    }
		
		for (int i=0; i<n; i++){
	    	for(int j = 0; j<n; j++) {
	    		if (row[i] == 1 || columns[j] ==1) {
	    			a[i][j] = 0;
	    			}
	    		}
	}
	}
}
