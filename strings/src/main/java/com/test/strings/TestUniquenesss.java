package com.test.strings;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import org.junit.Test;

/**
 * <br> Implement an algorithm to determine if a string has all unique characters. 
 * <br> What if you can not use additional data structures?
 * <br> This class solves given problem
 * @author sabiya
 *
 */
public class TestUniquenesss {


	
	/**
	 * @param s
	 */
	/**
	 * In Java, Each character is represented as Unicode point
	 * One character means one unicode point.
	 * Each Unicode point is represented by one or more code units.
	 * 
	 * One Code unit means no of bits encoding uses
	 * E.g UTF-8 use 8 bits & UTF-16 uses 16 bits units 
	 * 16 bits means 2^16 = 65536 unique characters can be presented using 16 bits
	 * <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/dd374069(v=vs.85).aspx">https://msdn.microsoft.com/en-us/library/windows/desktop/dd374069(v=vs.85).aspx</a>
	 * 
	 *  Supplementary characters which are apart from BMP(Basic Multilingual Plane) are represented
	 *  by 2 surrogate characters
	 * @throws UnsupportedEncodingException 
	 * */
	@Test
	public void testCharacterSetBehaviour() throws UnsupportedEncodingException {
		
		String a ="☺☺♣𠜎";
		/**
		 * "𠜎" is example of supplementary character (Its above range of BMP (U+0000 = U+FFFF))
		 * It is represented by 2 characters so size is 4 bytes
		 */
		
		/**
		 * ☺ character can be represented using UTF-8 needs 3 bytes
		 */
	
		String s=a;
		char[] chars = s.toCharArray();

		byte[] bytes = s.getBytes("UTF-16");
		System.out.println("UTF-16 Byte length of string ☺☺♣𠜎 is:" +bytes.length + " dsdS:" + "☺☺♣𠜎".getBytes("UTF-16").length);
		bytes = s.getBytes("UTF-8");
		System.out.println("UTF-8 Byte length of string ☺☺♣𠜎 is:" +"☺☺♣𠜎".getBytes().length);
		System.out.println("☺".getBytes("UTF-16").length);
		System.out.println("Returns Byte length 3 for ♣ as per UTF-8 decoding:" + "♣".getBytes("UTF-8").length);
		System.out.println("Returns Byte length 4 for ♣ as per UTF-16 decoding" + "♣".getBytes("UTF-16").length);
		System.out.println("Returns Byte length 4 for 𠜎 as per UTF-8 decoding:" + "𠜎".getBytes("UTF-8").length);
		System.out.println("Returns Byte length 4 for 𠜎 as per UTF-16 decoding:" + "𠜎".getBytes("UTF-16").length);
		
	}
	
	
	/**
	 * This Method tests solution for given a problem statement
	 */
	@Test
	public void testCharacterUniqueness() {
		
		String s="☺♣𠜎";
		boolean containsUniqueCharacters = containsUniqueCharacters(s);
		System.out.println("Result for :" + s + " is :" + containsUniqueCharacters);
		
		s="cdc";
		containsUniqueCharacters = containsUniqueCharactersByBook(s);
		System.out.println("Result for :" + s + " using book method is :" + containsUniqueCharacters);
		
	}


	/**
	 * Returns true if given string contains all unique characters
	 * @param s
	 * @return
	 */
	private boolean containsUniqueCharacters(String s) {
		if(s == null || s.isEmpty()) {
			throw new IllegalArgumentException("String cannot be null or empty");
		}
		char[] charArray = s.toCharArray();
		boolean charrange[] = new boolean[65536];
		for(char c: charArray){
			if(charrange[c] == true) {
				return false;
			} else {
				charrange[c] = true;
			}
		}
		return true;
	}
	
	/**
	 * Returns true if given string contains all unique characters
	 * @param s
	 * @return
	 */
	private boolean containsUniqueCharacters1(String s) {
		if(s == null || s.isEmpty()) {
			throw new IllegalArgumentException("String cannot be null or empty");
		}

		for(int i=0, j=i+1;i<s.length();i++) {
			char c = s.charAt(i);
			
		}

		return true;
	}
	

	/**
	 * Returns true if given string contains all unique characters
	 * @param s
	 * @return
	 */
	/**
	 * This algorithm works on index, shifting value of 0001 by fixed index gives unique value.
	 * <br>In every shift, nth bit is set for index n.
	 * <br>E.X, For character b(1) 1st bit will be set => 10
	 * <br>ORing all the values will give you indices of characters encountered uptil now.
	 * 
	 * <br>Bit is set if and only if index is encountered already.
	 * <br> Take string cdc 
	 * <br>index(c): implies shifting 000001 with 2 => 0100
	 * <br>index(d): shifting 000001 with 3 => 1000
	 * <br>Now, OR these values => 1100 
	 * <br>index(c): implies shifting 000001 with 2 => 100 
	 * <br>ANDing with 1100 & 100 => 1100 its val > 1
	 * <br>That means character with same index is encountered already so return
	 * false.
	 */
	private boolean containsUniqueCharactersByBook(String s) {
		if(s == null || s.isEmpty()) {
			throw new IllegalArgumentException("String cannot be null or empty");

		}

		int mask =0;
		for(int i=0;i<s.length();i++) {
			int index = (s.charAt(i) - 'a');
			int result = mask & (1 << index);
			if(result >0) {
				return false;
			} else {
				mask = mask | (1 << index);
			}
		}

		return true;
	}
}
