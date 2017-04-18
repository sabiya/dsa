package com.linkedlist.problem;

import static org.junit.Assert.*;

import org.junit.Test;

class LinkedList {
	Node start;

	public LinkedList() {
		super();
	}

	public void insert(int n){
		Node newNode = new Node(n);
		if (start == null) {
			start = newNode;
			return;
		} 
		Node p = start;
		while(p.getNext() != null) {
			p = p.getNext();
		}
		p.setNext(newNode);
	}
	public void insertNode(Node newNode){
		if (start == null) {
			start = newNode;
			return;
		} 
		Node p = start;
		while(p.getNext() != null) {
			p = p.getNext();
		}
		p.setNext(newNode);
	}
	public void deleteNode(Node prevNode, Node node){
		if (start != null && node == start) {
			start = null;
		} else {
			prevNode.setNext(node.getNext());
		}
		
	}
	/**
	 * @param n
	 * @return
	 */
	public Node findNode(int n) {
		Node p = start;
		while ( p != null && p.data != n) {
			p = p.next;
		}
		return p;
		
	}
	public void print() {
		Node p = start;
		System.out.print("\n");
		while(p != null) {
			System.out.print(p.getData() + "->");
			p = p.getNext();
		}
	}

}
