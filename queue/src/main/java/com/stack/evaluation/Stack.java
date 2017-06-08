package com.stack.evaluation;

/**
 * @author sabiya
 *
 */
public class Stack {
	int[] data;
	int top = -1;

	public Stack() {
		data = new int[10];
	}
	/**
	 * @return
	 */
	public int pop() {
		if (top < 0) {
			return -1;
		} else {
			return data[top--];
		}
	}

	/**
	 * @param n
	 */
	public void push(int n) {
		data[++top] = n;
	}
	public int top () {
		if (top < 0) {
			return -1;
		} else {
			return data[top];
		}
	}
	public boolean isEmpty() {
		if (top < 0) 
			return true;
		else
			return false;
	}
}
