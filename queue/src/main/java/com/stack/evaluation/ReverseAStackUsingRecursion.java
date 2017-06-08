package com.stack.evaluation;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Reverse a stack using recursion
 * @author sabiya
 *
 */
public class ReverseAStackUsingRecursion {

	@Test
	public void test() {
		int inputs [] = {13,7,6,12};
		Stack s = new Stack();
			for(int i=0;i<inputs.length; i++) {
				s.push(inputs[i]);
			}
		reverseStack(s);
		System.out.println("\nStack After function");
		while(!s.isEmpty()) {
			System.out.println(s.pop());
		}
	}
	public void reverseStack(Stack s){
		if (!s.isEmpty()) {
			int no = s.pop();
			reverseStack(s);
			s.push(no);
		}
		return;
	}

}
