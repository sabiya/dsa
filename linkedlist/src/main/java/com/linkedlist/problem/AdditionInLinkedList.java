package com.linkedlist.problem;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * You have two numbers represented by a linked list, where each node contains a
 * single digit. The digits are stored in reverse order, such that the 1’s digit
 * is at the head of the list. Write a function that adds the two numbers and
 * returns the sum as a linked list. EXAMPLE Input: (3 -> 1 -> 5) + (5 -> 9 ->
 * 2) Output: 8 -> 0 -> 8 _
 * ________________________________________________________________
 * 
 * @author sabiya
 *
 */
public class AdditionInLinkedList {

	@Test
	public void test() {
		LinkedListAddition list1 = new LinkedListAddition();
		list1.insert(3);
		list1.insert(1);
		list1.insert(7);
		LinkedListAddition list2 = new LinkedListAddition();
		list2.insert(5);
		list2.insert(9);
		list2.insert(4);
//		list2.insert(2);
		System.out.print("\nList 1");
		list1.print();
		System.out.print("\nList 2");
		list2.print();
		System.out.print("\n Sum: ");
		LinkedListAddition sum = list1.sum(list2);
		sum.print();
	}
	
	/**
	 * @author sabiya
	 *
	 */
	class LinkedListAddition extends LinkedList {
		
		public LinkedListAddition sum(LinkedListAddition list2) {
			// Both are null, return null
			if (start == null && list2 == null)
				return null;
			// this is empty list, return list2
			if (this.start == null)
				return list2;
			// List2 is empty return this list
			if (list2 == null || list2.start == null)
				return this;

			Node p = this.start;
			Node q = list2.start;
			LinkedListAddition sumList = new LinkedListAddition();
			int carry = 0;
			int m ;
			while (p != null || q != null) {
				m = carry;
				if (p != null) {
					m = m + p.data;
					p = p.next;
				}
				if (q != null) {
					m = m + q.data;
					q = q.next;
				}
				carry = m / 10;
				m = m % 10;
				sumList.insert(m);
			}
			if(carry>0)
			sumList.insert(carry);
			return sumList;
		}
		
	}

}
