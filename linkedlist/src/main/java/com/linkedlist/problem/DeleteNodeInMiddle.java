package com.linkedlist.problem;

import static org.junit.Assert.*;

import org.junit.Test;

import com.linkedlist.problem.FindNthtoLastElement.LinkedListFindElement;

/**
 * Implement an algorithm to delete a node in the middle of a single linked
 * list, given only access to that node. 
 * 
 * EXAMPLE Input: the node ‘c’ from the
 * linked list a->b->c->d->e
 *  Result: nothing is returned, but the new linked
 * list looks like a->b->d->e
 * 
 * @author sabiya
 *
 */
public class DeleteNodeInMiddle {

	@Test
	public void test() {
		LinkedListDeleteNode list = new LinkedListDeleteNode();
		list.insert(11);
		list.insert(55);
		list.insert(88);
		list.insert(54);
		list.insert(77);
		list.insert(66);
		list.insert(22);
		System.out.print("\nList");
		list.print();
		list.deleteNode(list.start.next.next.next);
		System.out.print("\nAfter deleting 54:");
		list.print();
	}
	class LinkedListDeleteNode extends LinkedList {
		/**
		 * Delete any node in the middle of list, except last node.
		 * @param n
		 */
		public void deleteNode(Node n) {
			//if its last node, this algorithm does not work
			if ( n == null || n.next == null){
				return;
			}
			if (start ==n) {
				start = null;
				return;
			}
			// Delete next Node to  n
			//Copy 'd'at place of c
			n.data = n.next.data;
			// Delete node d
			n.next = n.next.next;
			return;
		}
	}

}
