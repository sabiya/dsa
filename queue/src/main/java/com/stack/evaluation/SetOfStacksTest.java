package com.stack.evaluation;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Imagine a (literal) stack of plates. If the stack gets too high, it might
 * topple. Therefore, in real life, we would likely start a new stack when the
 * previous stack exceeds some threshold. Implement a data structure SetOfStacks
 * that mimics this. SetOfStacks should be composed of several stacks, and
 * should create a new stack once the previous one exceeds capacity.
 * SetOfStacks.push() and SetOfStacks.pop() should behave identically to a
 * single stack (that is, pop() should return the same values as it would if
 * there were just a single stack). FOLLOW UP Implement a function popAt(int
 * index) which performs a pop operation on a specific sub-stack
 * 
 * @author sabiya
 *
 */
public class SetOfStacksTest {

	@Test
	public void test() {
		SetOfStacks setOfStacks = new SetOfStacks(5);
		for (int i = 1; i <= 13; i++) {
//			System.out.println("Pushing :" + i);
			setOfStacks.push(i);
		}
		for (int i = 1; i <= 13; i++) {
			Node n = setOfStacks.pop();
			int pop = n == null? -1:n.getNo();
			System.out.print("\n\nPopped :" + pop);
		}
	}

	class Node {
		int no;
		Node above;
		Node below;
		public Node(int no) {
			super();
			this.no = no;
			this.above = null;
			this.below = null;
		}
		public Node(int no, Node above, Node below) {
			super();
			this.no = no;
			this.above = above;
			this.below = below;
		}
		public int getNo() {
			return no;
		}
		public void setNo(int no) {
			this.no = no;
		}
		public Node getAbove() {
			return above;
		}
		public void setAbove(Node above) {
			this.above = above;
		}
		public Node getBelow() {
			return below;
		}
		public void setBelow(Node below) {
			this.below = below;
		}
		
	}
	
	/**
	 * @author sabiya
	 *
	 */
	class Stack {
		Node top = null;
		Node bottom =null;
		int capacity;
		int size = 0;
		public Stack() {
			super();
			this.capacity = 5;
		}
		public Stack(int capacity) {
			super();
			this.capacity = capacity;
		}
		public Stack(Node top, Node bottom, int capacity) {
			super();
			this.top = top;
			this.bottom = bottom;
			this.capacity = capacity;
		}
		
		/**
		 * @param no
		 * @return 
		 */
		public boolean push(int no) {
			Node node = new Node(no);
			if (size >= capacity)
				return false;
			if (top == null) {
				bottom = top = node;
				top.above= null;
				top.below = null;
			} else {
				node.below = top;
				top.above = node;
				top = node;
			}
			size++;
			return true;
		}
		
		public Node pop () {
			if (size <=0)
				return null;
			Node node = top;
			
			if (top == bottom) {
				bottom = null;
				top = null;
				return node;
				
			}
			top.below.above = null;
			top = top.below;
			return node;
			
		}
		
	}
	
	public class SetOfStacks {

		Stack stack[];
		
		int THRESHOLD;
		int stackPointer ;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
		int top = -1;

		public SetOfStacks(int THRESHOLD) {
			stack = new Stack[10];
			stackPointer = -1;
			this.THRESHOLD = THRESHOLD;
		}

		public void push(int n) {
			top = top + 1; 
			if(stackPointer < top/ THRESHOLD) {
				stackPointer++;
				stack[stackPointer] = new Stack();
				stack[top / THRESHOLD].push(n);
				// Overflow, join stacks
				if(stackPointer > 0)
				joinStack(stack[stackPointer-1].top, stack[stackPointer].top);
			} else {
				stack[top / THRESHOLD].push(n);
			}
			
			
		}

		private void joinStack(Node belowStacktop, Node aboveStackTop) {
			if ( belowStacktop != null  && aboveStackTop !=null) {
				belowStacktop.above = aboveStackTop;
				aboveStackTop.below = belowStacktop;
			}
		}

		public Node pop() {
			if (top < 0) {
				return null;
			}
			Node pop = stack[top/THRESHOLD].pop();
			if ( pop != null) {
				top--;
			}
			return pop;
		}

		public int popAt(int stackIndex) {
			return stack[stackIndex].pop().getNo();
		}
	}
}
