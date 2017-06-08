package com.stack.evaluation;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * Next Greater Element
 * Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element for an element x is the first greater element on the right side of x in array. Elements for which no greater element exist, consider next greater element as -1.

Examples:
a) For any array, rightmost element always has next greater element as -1.
b) For an array which is sorted in decreasing order, all elements have next greater element as -1.
c) For the input array [4, 5, 2, 25}, the next greater elements for each element are as follows.

Element       NGE
   4      -->   5
   5      -->   25
   2      -->   25
   25     -->   -1
 * @author sabiya
 *
 */
public class PrintNextGreaterElementInArray {

	@Test
	public void test() {
//	 int inputs [] = {4,5,2,25};
	 int inputs [] = {13,7,6,12};
	 int [] out= findNextGreaterElement(inputs);
		for(int i=0;i<inputs.length; i++) {
			System.out.println(inputs[i] +  "  " + out[i]);
		}
	 
	 
	}
	/**
	 * @param inputs
	 * @return
	 */
	public int [] findNextGreaterElement(int [] inputs) {
		if( inputs.length == 0) {
			return inputs;
		}
		if( inputs.length == 1) {
			int [] n ={-1};
			return n;
		}
		Stack stack = new Stack();
		int [] n = new int [inputs.length];

		stack.push(0);
		int index= 1;
		for(index=1 ; index< inputs.length; index++) {
			int no = inputs[index];
			while (!stack.isEmpty()) {
				int jindex = stack.pop();
				if (inputs[jindex]<no){
					n[jindex] = no;
				} else {
					stack.push(jindex);
					break;
				}
			}
			stack.push(index);
		}

		while (!stack.isEmpty()) {
			int jindex = stack.pop();
			n[jindex] = -1;
		}
		return n;

	}

}
