package com.linkedlist.problem;

import static org.junit.Assert.*;

import org.junit.Test;

import com.linkedlist.problem.RemoveDuplicates.LinkedListRemoveDuplicates;

/**
 * Implement an algorithm to find the nth to last element of a singly linked list.
 * @author sabiya
 *
 */
public class FindNthtoLastElement {

	@Test
	public void test() {
		LinkedListFindElement list = new LinkedListFindElement();
		list.insert(10);
		list.insert(40);
		list.insert(60);
		list.insert(10);
		list.insert(40);
		list.insert(60);
		list.insert(70);
		
		list.print();
		Node nthLastElement = list.findNthLastElement(20);
		if (nthLastElement != null) {
		System.out.print("\nNode :" + nthLastElement.getData());
		}
	}
	
	
	class LinkedListFindElement extends LinkedList {
		
		/**
		 * 
		 * @param n
		 * @return
		 */
		public Node findNthLastElement(int n) {
			
			Node node  = null;
			Node p = start;
			Node q = p;
			// Move q pointer start + n
			int i;
			for (i=1; i<n && q.next != null; i++) {
				q= q.next;
			}
			if (q.next == null && i<n){
				System.out.print("\nLess elements present than " + n);
				return null;
			}
			// When q reached end , p points to expected element
			while (q.next != null) {
				q= q.next;
				p = p.next;
			}
			node = p;
			return node;
			
		} 
		
	}

}
