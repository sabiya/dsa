package com.stack.evaluation;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Describe how you could use a single array to implement three stacks.
 * 
 * @author sabiya
 *
 */
public class MinimumElementStack {

	@Test
	public void test() {
		MinimumelementInStack stack = new MinimumelementInStack();
		stack.push(5);
		System.out.println("Minimum :" + stack.minimum());
		stack.push(3);
		System.out.println("Minimum :" + stack.minimum());
		stack.push(4);
		System.out.println("Minimum :" + stack.minimum());
		stack.push(2);
		System.out.println("Minimum :" + stack.minimum());
		stack.pop();
		stack.pop();
		stack.pop();
		System.out.println("Minimum :" + stack.minimum());
	}

	class NodeWithMin {
		int data;
		int indexNextMin;
		public NodeWithMin(int data, int indexNextMin) {
			this.data = data;
			this.indexNextMin = indexNextMin;
		}
	}
	class MinimumelementInStack {

		NodeWithMin [] stackNode = new NodeWithMin[50];
		int minimum = -1;
		int top=-1;

		public MinimumelementInStack() {
			super();
		}

		public void push(int n) {
			NodeWithMin nodeWithMin = new NodeWithMin(n,minimum);
			stackNode[++top] = nodeWithMin;
			if (minimum < 0 || n < stackNode[minimum].data) {
				minimum = top;
			}
		}
		public int  pop() {
			if (top < 0) {
				return -1;
			} else {
				NodeWithMin nodePoped = stackNode[top];
				if (top == minimum) {
					 minimum = nodePoped.indexNextMin;
				}
				top--;
				return nodePoped.data;
			}
		}

		public int minimum() {
			if (minimum >= 0) {
				return stackNode[minimum].data;
			} else {
				return -1;
			}
		}
	}
}
