package com.linkedlist.problem;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author sabiya
 *
 */
public class FindElementInLoop {

	@Test
	public void test() {
		CircularLinkedList list = new CircularLinkedList();
		list.insert(10);
		list.insert(11);
		list.insert(12);
		list.insert(13);
		list.insert(14);
		list.insert(15);
		list.insert(16);
		list.insert(17);
		Node findNode = list.findNode(12);
		list.insertNode(findNode);
		Node findElementInLoop = list.findElementInLoop();
		System.out.print("Node in a cycle: " + findElementInLoop.data);
	}

   class CircularLinkedList extends LinkedList {
	   
	   public Node findElementInLoop() {
		   Node node = null;
		   Node p = start;
		   Node q = start.next.next; 
		   int count = 0;
		   while(p != q) {
			   p = p.next;
			   q = q.next.next;
			   count ++;
		   }
//		 while(count>=1) {
//			   q = q.next.next;   
//			   count --;
//		   } 
		 
		 
		 p = start;
		 System.out.println(q.data);
		 while (p.data != q.data) {
			 p = p.next;
			 q = q.next;
		 }
		   node = q;
		   return node;
	   } 
		
	}
	
}
