package com.linkedlist.problem;

import org.junit.Test;

/**
 * Split a Circular Linked List into two halves
 * Original Linked List  
 * 12 ->56 -> 2 -> 11 -> 12
 * 
 * Expected Result:
 * 12 ->56 -> 12  
 * 2->11->2
 * @author sabiya
 *
 */
public class SplitCircularLinkedList {

	@Test
	public void splitCircularList() {
		SplitIntoTwoHalves list = new SplitIntoTwoHalves();
		int inputs[] = {10,20,30,40};
		for (int i=0; i<inputs.length; i++) {
			list.insert(inputs[i]);
		}
		System.out.println("Circular List:");
		list.print();
		CircularLinkedList list2 = list.split();
		System.out.print("\nCircular List 1:");
		list.print();
		System.out.print("\nCircular List 2:");
		list2.print();
	}
	
	 class SplitIntoTwoHalves extends CircularLinkedList{
	
		 public CircularLinkedList split() {
			 
			 Node slow, fast;
			 slow = start;
			 fast = slow.next;
			 while(fast != start) {
				 fast = fast.next;
				 if(fast != start) {
					 slow = slow.next;
					 fast = fast.next;
				 }
			 }
			 Node mid = slow;
			 
			 while (slow.next != start) {
				 slow = slow.next;
			 }
			 Node end = slow;
			 end.next = mid.next;
			 
			 mid.next = start;
			 Node start2 = end.next;
			 
			 CircularLinkedList list =new CircularLinkedList();
			 list.start =end.next;
			  return list;
			 
			 
		 }
	}
}
