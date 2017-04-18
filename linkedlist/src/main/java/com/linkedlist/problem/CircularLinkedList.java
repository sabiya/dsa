package com.linkedlist.problem;

/**
 * @author sabiya
 *
 */
public class CircularLinkedList{

	Node start;
	CircularLinkedList() {
		start=null;
	}
	/**Insert into linked list
	 * @param n
	 */
	public void insert(int n){ 
		Node node = new Node(n);
		if (start == null) {
			start = node;
			start.next= start;
			return;
		}
		
		Node ptr = start;
		while (ptr.next != start) {
			ptr = ptr.next;
		}
		node.next = ptr.next;
		ptr.next = node;
	}
	public void print() {
		if (start == null)
			return;
		Node p = start;
		System.out.print("\n");
		do {
			System.out.print(p.getData() + "->");
			p = p.getNext();
		}while(p != start);
	}
}
