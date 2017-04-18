package com.linkedlist.problem;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * Swap nodes in a linked list without swapping data
 * Input:  10->15->12->13->20->14,  x = 12, y = 20
   Output: 10->15->20->13->12->14
 * @author sabiya
 *
 */
public class SwapNodesWithoutDataSwap {

	@Test
	public void test() {
		SwapNodesinList list = new SwapNodesinList();
		int inputs [] = {10,15,12,13,20,14};
		for (int i=0; i<inputs.length; i++) {
			list.insert(inputs[i]);
		}
		System.out.print("\nInput:");
		list.print();
		System.out.print("\nOutput:");
		list.swapNodes(10, 10);
		list.print();
	}

	/**
	 * @author sabiya
	 *
	 */
	public class SwapNodesinList extends LinkedList {
		
		public void swapNodes(int x, int y) {
			Node xnode = start, ynode = start, prevx,prevy;
			//if list empty or  x nd y are same no need to swap
			if(start == null || x==y) {
				return;
			}
			prevx = null;
			prevy =null; 
			//Find Prev Node to X, X node
			while (xnode.data != x && xnode !=null) {
				prevx= xnode;
				xnode = xnode.next;

			}
			//Find Prev Node to Y and Y node
			while (ynode.data != y && ynode !=null) {
				prevy= ynode;
				ynode = ynode.next;

			}
			if (xnode == null || ynode==null)
				return;

			if(prevx == null ){
				start = ynode;
			} else {
				prevx.next = ynode;
			}
			if(prevy == null ){
				start = xnode;
			} else {
				prevy.next = xnode;
			}
			Node temp = ynode.next;
			ynode.next = xnode.next;
			xnode.next =temp;

		}
	}
}
