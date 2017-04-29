package com.stack.evaluation;

import org.junit.Test;

/**
 * implement two stacks in an array Create a data structure twoStacks that
 * represents two stacks. Implementation of twoStacks should use only one array,
 * i.e., both stacks should use the same array for storing elements. Following
 * functions must be supported by twoStacks.
 * 
 * push1(int x) –> pushes x to first stack push2(int x) –> pushes x to second
 * stack
 * 
 * pop1() –> pops an element from first stack and return the popped element
 * pop2() –> pops an element from second stack and return the popped element
 * 
 * Implementation of twoStack should be space efficient.
 * 
 * @author sabiya
 *
 */
public class TwoStackInArrayProblem {

	@Test
	public void testTwoStacks(){
		int [] inputs ={10,20,30,40,50,60,70};
		int runcount = 6;
		TwoStacks stack = new TwoStacks(6);
		for(int i=0; i<inputs.length; i++) {
			if((i&1) == 0){
				stack.push1(inputs[i]);
			}else{
				stack.push2(inputs[i]);
			}
		}
		System.out.println("\nStack 1 -->");
		while(!stack.isEmpty1()){
			System.out.print(stack.pop1() + " " );
		}
		
		System.out.println("\nStack 2 -->");
		while(!stack.isEmpty2()){
			System.out.print(stack.pop2() + " " );
		}
	}
	class TwoStacks {
		private int [] stack;
		int top1;
		int top2;
		private int size;
		public TwoStacks(int size) {
			this.size = size;
			stack = new int [size];
			top1 = -1;
			top2 = size;
		}
		
		public void push1(int n){
			if((top1 +1) == top2) {
				System.out.println("\nStack 1 full, No space for " + n);
				return;
			}
			stack [++top1] = n;
		}
		
		public void push2(int n){
			if((top2 - 1) == top1) {
				System.out.println("\nStack 2 full, No space for " + n);
				return;
			}
			stack [--top2] = n;
		}
		
		public int pop1() {
			if(top1 <0)
				return -1;
			int m = stack[top1];
			top1--;
			return m;
		}
		public int pop2(){
			if(top2 >= size)
				return -1;
			int m = stack[top2];
			top2++;
			return m;
		}
		public boolean isEmpty1() {
			if (top1<0)
				return true;
			else
				return false;
		}
		public boolean isEmpty2() {
			if (top2 >= size)
				return true;
			else
				return false;
		}
	}
	
}
