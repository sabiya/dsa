package com.linkedlist.problem;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Write code to remove duplicates from an unsorted linked list.
   FOLLOW UP
   How would you solve this problem if a temporary buffer is not allowed?
 * @author sabiya
 *
 */
public class RemoveDuplicates {

	@Test
	public void test() {
	
		LinkedListRemoveDuplicates list = new LinkedListRemoveDuplicates();
		list.insert(10);
		list.insert(40);
		list.insert(60);
		list.insert(10);
		list.insert(40);
		list.insert(60);
		list.insert(10);
		list.insert(70);
		
		list.print();
		list.removeDuplicates();
		list.print();
	}
	
	

/**
 * @author sabiya
 *
 */
class LinkedListRemoveDuplicates extends LinkedList{

	private int count;

	public LinkedListRemoveDuplicates() {
		super();
		count = 0;
	}
	
	/**
	 * 
	 */
	public void removeDuplicates() {
		Node nodep = start;
		Node prevNodeQ = null;
		Node nodeq = null ; 
		if (start == null || start.getNext() == null){
			return;
		}

		while(nodep != null && nodep.getNext() != null) {
			prevNodeQ = nodep;
			nodeq = nodep.getNext();
			while (nodeq != null && (++count !=0)) {
				if (nodeq.data == nodep.data){
					deleteNode(prevNodeQ, nodeq);
				}
				prevNodeQ = nodeq;
				nodeq = nodeq.getNext();
//				count++;
			}
			
			nodep = nodep.getNext();
			print();
		}
		System.out.print("\nNo of passes : " + count);
	}
	
	public  void removeDuplicatesBook() {
		count = 0;
		if (start == null) return;
		Node previous = start;
		Node current = previous.next;
		while (current != null) {
			// Look backwards for dups, and remove any that you see.
			Node runner = start;
			while (runner != current) { 
				count++;
				if (runner.data == current.data) {
					Node tmp = current.next;
					previous.next = tmp;
					current = tmp;
					/* We know we can’t have more than one dup preceding
					 * our element since it would have been removed 
					 * earlier. */
					break;
				}
				runner = runner.next;
			}

			/* If runner == current, then we didn’t find any duplicate 
			 * elements in the previous for loop.  We then need to 
			 * increment current.  
			 * If runner != current, then we must have hit the ‘break’ 
			 * condition, in which case we found a dup and current has
			 * already been incremented.*/
			if (runner == current) {
				previous = current;
				current = current.next;
			}
		}
		System.out.print("\nNo of passes By book : " + count);
}
}
}
