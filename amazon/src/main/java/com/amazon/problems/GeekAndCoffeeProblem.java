package com.amazon.problems;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * http://practice.geeksforgeeks.org/problems/geek-and-coffee-shop/0 
 * 
 * @author sabiya
 *
 */
public class GeekAndCoffeeProblem {

	public  static void main(String args[]) throws FileNotFoundException {
		//Scanner scanner = new Scanner(new FileInputStream(new File("InputGeek.txt")));
		Scanner scanner = new Scanner(System.in);
		int tcases = scanner.nextInt();
		for(int i=1;i<= tcases; i++) {
			int N = scanner.nextInt();
			int M = scanner.nextInt();
			int units  = getUnitsOfRefill(N,M);
			System.out.print("\n" + units);
			
		}
		
	}

	private static int getUnitsOfRefill(int n, int m) {
		int i;
		for(m=m-1,i=n; i>=0&&m>=1;  m--) {
			i=i/2;		
		}
		return i;
	}
	
}
