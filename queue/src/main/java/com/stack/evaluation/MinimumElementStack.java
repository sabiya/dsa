package com.stack.evaluation;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Find Minimum Element in a Stack
 * 
 * @author sabiya
 *
 */
public class MinimumElementStack {

	@Test
	public void test() {
		int [] inputs = {2,3,4,5,6,7,8,9,1};
		MinimumelementInStack stack = new MinimumelementInStack();
		for (int i=0; i <inputs.length; i++) {
			stack.push(inputs[i]);
		}
		System.out.println("Minimum :" + stack.minimum());
		stack.pop();
		System.out.println("Minimum :" + stack.minimum());
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
