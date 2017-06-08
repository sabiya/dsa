package trees;

import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

import org.junit.Test;

public class ZigZagPrintTree extends Tree {

	@Test
	public void test() {
		ZigZagPrintTree tree = new ZigZagPrintTree();
//		int inputs [] = {10, 16, 34, 18 , 20, 22};
		int inputs [] = {30, 25, 47 ,23, 26,35, 52, 17,24};
		for (int i=0;i<inputs.length; i++) {
			tree.insert(inputs[i]);	
		}
		System.out.println("inserted data");
//		System.out.println("\n\n Inorder : \n");
		tree.inorder();
		System.out.print("\nZigzag:");
		tree.traverseZigZag();
	}
	
	public void traverseZigZag() {
		Stack<Node> stack = new Stack<Node>();
		Queue<Node> queue = new LinkedBlockingQueue<Node>();
		Node ptr= root;
		queue.add(ptr);
		int level =0;
		MyQueue q1 = new MyQueue();
		MyQueue q2 = new MyQueue();
		
		q1.add(ptr);
		
		while (!q1.isEmpty() || !q2.isEmpty()) {
			while (!q1.isEmpty()) {
				Node n = q1.pop();
				System.out.print(n.data + " ");
				if (n.left !=null) {
					q2.add(n.left);
				}
				if (n.right !=null) {
					q2.add(n.right);
				}
			}
			
			while (!q2.isEmpty()) {
				Node n = q2.pop();
				System.out.print(n.data + " ");
				if (n.right !=null) {
					q1.add(n.right);
				}
				if (n.left !=null) {
					q1.add(n.left);
				}
				
			}
		}
		
	}
	
}
