package com.test.strings;

import org.junit.Test;

/**
 * <br> Design an algorithm and write code to remove the duplicate characters in a string without using any additional buffer. 
 * NOTE: One or two additional variables are fine. An extra copy of the array is not.FOLLOW UP
 * Write the test cases for this method.
 * @author sabiya
 *
 */
public class RemoveDuplicateChars {

	
	
	@Test
	public void testRemoveDuplicate() {
		String s  = "sabiyadass";
		String removeDuplicates = removeDuplicates(s);
		System.out.println("Result after removing duplicates from string : " + s + " is  :" + removeDuplicates);
		String removeDuplicatesWithoutVar = removeDuplicatesWithoutVar(s);
		System.out.println("Result after removing duplicates from string without var: " + s + " is  :" + s); 
	}
	public String removeDuplicates(String s) {
		if(s == null || s.isEmpty()) {
			throw new IllegalArgumentException("String cannot be null or empty");

		}
		int mask =0;
		int len = s.length();
		StringBuilder str = new StringBuilder(s);
		for(int i=0;i<len;i++) {
			int index = (str.charAt(i) - 'a');
			int result = mask & (1 << index);
			if(result >0) {
				str = str.deleteCharAt(i);
				len--;
				i--;
			} else {
				mask = mask | (1 << index);
			}
		}
		return 	str.toString();
	}
	
	public String removeDuplicatesWithoutVar(String s) { 
		char[] sArray = s.toCharArray();
		int mask = 0;
		int len = sArray.length;
		for (int i=0; i<len; i++) {
			char c = sArray[i];
			int charindex = c - 'a' ;
			int result = mask & (1 << charindex);
			if(result > 1) {
				deleteElement(sArray,i);
				len--;
				i--;
			} else {
				mask = mask | (1 << charindex);
			}
		}
		

		System.out.println("\n\n==============String :" + s + "\n");
		return "";
		
	}
	private void deleteElement(char[] sArray, int i) {
		// TODO Auto-generated method stub
		if(i<0 || i>sArray.length) {
			throw new IndexOutOfBoundsException("Index not valid");
		}
		if(sArray.length == 1) {
			sArray [i] = '\u0000';
		}
		int j = i+1;
		for(; j<sArray.length; j++) {
			sArray[j-1] = sArray[j];
		}
		
		sArray[j] = '\u0000';
	}

}
