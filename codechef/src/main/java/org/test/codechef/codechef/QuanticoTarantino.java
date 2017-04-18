package org.test.codechef.codechef;

/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* 
This class solves Quentin Tarantino problem
 */
public class QuanticoTarantino
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scanner = new Scanner(new FileInputStream(new File("Input.txt")));
		int testCases = scanner.nextInt();
		for (int t=1; t<= testCases; t++) {
		    int noOfChapters = scanner.nextInt();
		    int chapters [] = new int [noOfChapters];
		    for (int  i = 0; i< noOfChapters ; i++) {
		        chapters[i] = scanner.nextInt();
		    }
		    checkIfDirectedByTarantino(chapters, noOfChapters);
		}
	}
	/**
	 * Method which checks if given movie is directed by Tarantino 
	 */
	 
	 public static void checkIfDirectedByTarantino(int [] chapters, int noOfChapters) {
		 Set<Integer> set = new LinkedHashSet<Integer>(noOfChapters);
	     boolean checkIfDirectedByTarantino =false;
	     boolean isStillSorted = true;
	     int summation =chapters[0];
	     for (int i=1; i<noOfChapters; i++) {
	    	 if(set.contains(chapters[i])) {
	    		 break;
	    	 }
	    	 set.add(chapters[i]);
	    	 summation += chapters[i];
	    	 if ( chapters[i] != (chapters[i-1] +1)) {
	    		 isStillSorted = false;
	    	 } 

	     }
	     int expectedSum = (noOfChapters * (noOfChapters+1) /2);
	     checkIfDirectedByTarantino = ((expectedSum == summation) && !isStillSorted)? true : false;
	     if(checkIfDirectedByTarantino == true) {
	         System.out.print("\nyes");
	     } else {
	    	 System.out.print("\nno");
	     }
	 }
}
