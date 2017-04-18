package com.test.strings;

import org.junit.Test;

/**
 * <br> Write code to reverse a C-Style String. 
 * <br> (C-String means that “abcd” is represented as five characters, including the null character.)
 * @author sabiya
 *
 */
public class ReverseString {

	
	@Test
	public void testReverseString() {
		
		String s  = "aaaaaaaa" ;
		String reverseString = reverseString(s);
		System.out.println("Reverse string of : " + s + " is :" + reverseString);
	}
	/**
	 * Reverses a Given String 
	 * @param s String to be reversed
	 * @return Reversed representation of given String
	 */
	public String reverseString(String s) {
		if (s == null || s.isEmpty()) {
			throw new IllegalArgumentException("Input String cannot be null or empty");
		}
		char [] sarray = s.toCharArray();
		for(int i=0,j=sarray.length -1; i<sarray.length/2 ;i++, j--) {
			if(sarray[i] != sarray[j]) {
				char temp = sarray[i]; 
				sarray[i] = sarray[j];
				sarray[j] = temp;
			}
				 
		}
		String reversedString = new String(sarray);
		return reversedString;
	}
}
