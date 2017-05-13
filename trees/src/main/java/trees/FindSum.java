package trees;

import java.util.Scanner;

import org.junit.Test;

public class FindSum {

	@Test
	public void testSum() {
		int inputs [] = {1,4,3,9,5,6,7};
		BinaryTree tree = new BinaryTree();
		for(int i:inputs){
			tree.insert(i);
		}
		tree.inorder();
		System.out.print( "\nResult:" + tree.findSum(14));
		System.out.print( "\nResult:" + tree.findSum(12));
	}
	class BinaryTree extends Tree {
		Scanner scanner  = new Scanner(System.in);
	 public void insert(int n) {
		 Node node = new Node(n);
		 if (root ==null){
			 root = node;
			 return;
		 }
		 Node ptr = root;
		 Node parent =root;
		 int ch = 0;
		 System.out.println("Inserting " + n);
		 while(ptr !=null ) {
			 System.out.println("Enter choice (Left = 1) | right =2 ) of: " + ptr.data);
			 ch = scanner.nextInt();
			 parent = ptr;
			 ptr= (ch ==1) ?  ptr.left: ptr.right;
		 }
		 if (parent != null) {
		Node ignore=  (ch ==1) ?  (parent.left = node): (parent.right = node);
		 }
	 }	
	 public boolean findSum(int sum) {
		 return findSum(root, sum);
	 }  
		
	 public boolean findSum(Node root, int sum) {
		 //base case
		 if(root == null)
			 return false;
		 if(sum < root.data) {
			 return false;
		 }
		 if(sum == root.data) {
			 return true;
		 }
		 return ( findSum(root.left, sum-root.data) || findSum(root.right, sum-root.data));
	 }
	
	}
	}
