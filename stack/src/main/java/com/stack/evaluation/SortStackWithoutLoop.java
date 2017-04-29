package com.stack.evaluation;

import org.junit.Test;

/**
 * Given a stack, sort it using recursion. Use of any loop constructs like
 * while, for..etc is not allowed. We can only use the following ADT functions
 * on Stack S:
 * 
 * Input:  -3  <--- Top
        14 
        18 
        -5 
        30 

Output: 30  <--- Top
        18 
        14 
        -3 
        -5 
 * @author sabiya
 *
 */
public class SortStackWithoutLoop {

	@Test
	public void testSortStack() {
		int inputs [] = {-3,14,18,-5,30};
		Stack s = new Stack();
		for(int i: inputs){
			s.push(i);
		}
		sort(s);
		System.out.print("Stack After Sort:");
		while(!s.isEmpty()) {
			System.out.println(s.pop());
		}
		
	}
	/**
	 * @param s
	 */
	public void sort(Stack s) {
		if (s.isEmpty()) 
			return;
		int n = s.pop();
		sort(s);
		insertSorted(s,n);
	}

	/**
	 * @param s
	 * @param n
	 */
	private void insertSorted(Stack s,int n) {
		if (s.isEmpty()) {
			s.push(n);
			return;
		}
		// if top < element, 5 <30 then insert directly
		if(n> s.top()) {
			s.push(n);
		} else {
			int top = s.pop();
			insertSorted(s, n);
			s.push(top);

		}

	}
}
