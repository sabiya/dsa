package com.stack.evaluation;

import org.junit.Test;

import com.stack.evaluation.StackUsingQueue.StackwithQueue;

/**
 * Design a stack with operations on middle element How to implement a stack
 * which will support following operations in O(1) time complexity? 
 * 1) push() which adds an element to the top of stack. 
 * 2) pop() which removes an element from top of stack.
 * 3) findMiddle() which will return middle element of the
 * stack.
 * 4) deleteMiddle() which will delete the middle element.
 * Push and pop are standard stack operations.
 * 
 * @author sabiya
 *
 */
public class StackWithMiddle {

	@Test
	public void testStack(){
		int [] inputs ={10,20,30,40,50,60,70};
		int runcount = 7;
		StackWithMiddle stack = new StackWithMiddle();
		for(int i:inputs) {
			
		 stack.push(i);
		}
		
		System.out.println("\nStack");
		stack.traverse();
		System.out.println("\nMiddle: " + stack.getMiddle());
		for(int i=1; i<=runcount; i++) {
			System.out.println("\nStack After deleting Middle :" + stack.getMiddle());
			stack.deleteMiddle();
			stack.traverse();
			System.out.print("\nMiddle: " + stack.getMiddle());
		}
		
		}
	public StackWithMiddle(){
		
	}
	Node start = null;
	Node mid = null;
	int count = 0;
	class Node {
		int data;
		Node next;
		Node prev;
		Node (int n) {
			this.data = n;
			next = null;
			prev = null;
		}
		public Node(int n, Node next, Node prev) {
			this.data = n;
			this.next = next;
			this.prev = prev;
		}
	}
		public void push(int no) {
			Node node = new Node(no);
			if (start == null) {
				start = node;
				mid = node;
				count++;
				return;
			}
			node.next = start;
			start.prev = node;
			start = node;
			count++;
			mid = ((count&1) != 0)? mid.prev : mid;
		}

		public int pop() {
			if (start == null) {
				return -1;
			}
			Node p = start;
			start = start.next;
			start.prev = null;
			count--;
			mid = ((count&1) == 0)? mid.next : mid;
			return p.data;
		}
		public int getMiddle() {
			if(mid !=null)
				return mid.data;
			else
				return -1;
		}

		public void traverse() {
			Node ptr= start;
			while(ptr != null) {
				System.out.print(" " + ptr.data);
				ptr = ptr.next;
			}
		}
		/**
		 * @return
		 */
		public int deleteMiddle() {
			if (start == null) {
				return -1;
			}
			int p = mid.data;
			if (mid == start) {
				start = mid =null;
				return p;
			}
			Node midprev = mid.prev;
			Node midnext = mid.next;
			if(midprev != null) {
				midprev.next = midnext;
			}
			if(midnext != null){
				midnext.prev = midprev;
			}
			count--;
			mid = ((count&1) != 0)? midprev : midnext;
			return p;
		}
	}
	
	
