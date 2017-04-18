package com.linkedlist.problem;

import org.junit.Test;

/**
 * Given a singly linked list, rotate the linked list counter-clockwise by k
 * nodes. Where k is a given positive integer. For example, if the given linked
 * list is 10->20->30->40->50->60 and k is 4, the list should be modified to
 * 50->60->10->20->30->40. Assume that k is smaller than the count of nodes in
 * linked list.
 * 
 * @author sabiya
 *
 */
public class RotateLinkedList {

	@Test
	public void testRotation() {
		RotateALinkedList list = new RotateALinkedList();
		int[] inputs = { 10, 20, 30, 40, 50, 60 };
		for (int i = 0; i < inputs.length; i++) {
			list.insert(inputs[i]);
		}
		int k = 6;
		System.out.print("\nOriginal List:");
		list.print();
		list.rotate(k);
		System.out.print("\nRotated List:");
		list.print();
	}

	/**
	 * @author sabiya
	 *
	 */
	class RotateALinkedList extends LinkedList {

		public void rotate(int k) {
			// empty list | 1 node | k<=s0
			if (k <= 0 || start == null || start.next == null)
				return;
			Node ptr = start, prev = null;

			// ptr points to 50, if k is 4
			// prev points to 40
			while (ptr != null && k > 0) {
				prev = ptr;
				ptr = ptr.next;
				k--;
			}
			if (ptr == null) {
				return;
			}
			// Move ptr to current end node, ptr points to 60
			while (ptr.next != null)
				ptr = ptr.next;

			// connect end to start
			//60 will connect to 10
			//10 20 30 40 50 60 10
			ptr.next = start;
			// Make prev. next | old ptr as start
			// Make 50 as start node
			start = prev.next;
			// 50 60 10 20 30 40 -> 50 , break the cycle
			//40. next = null
			prev.next = null;

		}
	}

}
