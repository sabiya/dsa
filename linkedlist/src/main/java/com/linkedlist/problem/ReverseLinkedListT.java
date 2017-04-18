package com.linkedlist.problem;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Write a function to reverse a linked list Given pointer to the head node of a
 * linked list, the task is to reverse the linked list. Input : Head of
 * following linked list 1->2->3->4->NULL Output : Linked list should be changed
 * to, 4->3->2->1->NULL
 * 
 * @author sabiya
 *
 */
public class ReverseLinkedListT {

	@Test
	public void test() {
		ReverseTheLinkedList list = new ReverseTheLinkedList();
		int inputs[] = { 10, 15, 12, 13, 20, 14 };
		for (int i = 0; i < inputs.length; i++) {
			list.insert(inputs[i]);
		}
		System.out.print("\nInput:");
		list.print();
		System.out.print("\nOutput:");
		list.reverseList();
		list.print();
	}

	/**
	 * @author sabiya
	 *
	 */
	public class ReverseTheLinkedList extends LinkedList {

		public void reverseList() {
			// List is empty or contains only 1 node then nothing to swap.
			if (start == null || start.next == null) {
				return;
			}
			Node p = start;
			Node q = start.next;
			Node temp;
			p.next = null;
			while (q != null) {
				temp = q.next;
				q.next = p;
				p = q;
				q = temp;
			}
			start = p;

		}
	}
}
