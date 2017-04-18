package com.test.strings;

import org.junit.Test;

/**
 * Write a method to decide if two strings are anagrams or not.
 * This class provides a solution for given problems.
 * @author sabiya
 *
 */
public class TestAnagrams {

	
	@Test
	public void testAnagarams() {
		String s1 = "TOPS" ;
		String s2 = "POTS" ;
		boolean checkIfAnagrams = checkIfAnagrams(s1, s2);
		System.out.println("Are these strings anagrams: " + checkIfAnagrams);
		checkIfAnagrams = checkIfAnagrams("master", "stream");
		System.out.println("Are these strings anagrams: " + checkIfAnagrams);
	}
	/**
	 * This method verifies if given strings are anagrams of each other
	 * @param s1 
	 * @param s2
	 * @return true/false
	 */
	public boolean checkIfAnagrams (String s1, String s2) {
		boolean isAnagram = false;
		if (s1 == null || s1.isEmpty()) {
			throw new IllegalArgumentException("Input String cannot be null or empty");
		}
		if (s2 == null || s2.isEmpty()) {
			throw new IllegalArgumentException("Input String cannot be null or empty");
		}
		
        char [] s1Array = s1.toCharArray();
        char [] s2Array = s2.toCharArray();
        if(s1Array.length != s2Array.length) {
        	return false;
        }
        
        int mask1 = 0, mask2=0;
        int a[] = new int [256];
        for(int i=0; i<s1Array.length; i++) {
        	int charindex = s1Array[i] - 'A' ;
        	int charindex2 = s2Array[i] - 'A' ;
        	a[charindex]++;
        	a[charindex2]--;
        }
        
        for(int i=0;i <26; i++ ) {
         if(a[i] !=0) {
        	 return false; 
         }	
        }
		return true;
	}
}
