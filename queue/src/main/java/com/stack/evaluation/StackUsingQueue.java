package com.stack.evaluation;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import org.junit.Test;

/**
 * Implement Stack using Queues
 * @author sabiya
 *
 */
public class StackUsingQueue {

	@Test
	public void stackUsingQ() {
		int [] inputs ={10,20,30,40,50,60,70};
		StackwithQueue stack = new StackwithQueue();
		for(int i:inputs) {
		 stack.push(i);
		}
		System.out.println("\nStack Popped: ");
		while(!stack.isEmpty()){
			System.out.print(" " + stack.pop());
		}
	}
	
	class StackwithQueue {

		
		Queue q1;
		Queue q2;

		public StackwithQueue() {
			q1 = new LinkedBlockingQueue<Integer>();
			q2 = new LinkedBlockingQueue<Integer>();
		}
		public void push(int n) {
			q1.add(n);

		}

		public boolean isEmpty() {
			return q1.isEmpty();
		}

		public int pop() {
			int a;
			if (q1.isEmpty())
				return -1;
			a = (int) q1.remove();
			while (!q1.isEmpty()) {
				q2.add(a);
				a = (int) q1.remove();
			}
			while (!q2.isEmpty()) {
				a = (int) q2.remove();
				q1.add(a);

			}
			return a;

		}
	}
	
	
	
}
