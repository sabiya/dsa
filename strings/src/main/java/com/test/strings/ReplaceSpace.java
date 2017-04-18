package com.test.strings;

import org.junit.Test;

/**
 * Write a method to replace all spaces in a string with ‘%20’.
 * @author sabiya
 *
 */
public class ReplaceSpace {

	@Test
	public void testSpaceReplace() {
		String s = "My Woder City!";
		System.out.println(replaceSpace(s));
	}
	public String replaceSpace(String s) {
		char[] charArray = s.toCharArray();
		int spaceCount = 0;
		for(int i=0;i<charArray.length;i++){
			if(charArray[i] == ' ') {
				spaceCount++;
			}
		}
		
		char [] c = new char[charArray.length + 2 * spaceCount];
		int j=0;
		for(int i=0;i<charArray.length;i++){
			if(charArray[i] == ' ') {
				c[j++] ='%';
				c[j++] = '2';
				c[j++] = '0';
			
			} else {
				c[j++] = charArray[i];
			}
		}
		return new String (c);
	}
}
