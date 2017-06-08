package trees;

import java.util.Stack;

/**
 * @author sabiya
 *
 */
public class Tree {
	/**
	 * Root of Tree
	 */
	Node root;

	public void insert(int n) {
		Node node = new Node(n);
		if (root == null) {
 			root = node;
			return;
		}
		insertParent(node);

	}

	private void insertParent(Node n) {
		Node parent = root;
		do {
			if (parent.data <= n.data) {
				if (parent.right == null) {
					parent.right = n;
					return;
				}
				parent = parent.right;
			} else {
				if (parent.left == null) {
					parent.left = n;
					return;
				}
				parent = parent.left;
			}
		} while (true);
	}

	/**
	 * 
	 */
	public void inorder() {
		Node ptr = root;
		Stack<Node> stack = new Stack<Node>();
		while (ptr != null || !stack.isEmpty()) {
			while(ptr != null) {
				stack.push(ptr);
				ptr = ptr.left;
				
			}
			if (!stack.isEmpty()) {
				Node n = stack.pop();
				System.out.print(n.data + " ");
				ptr = n.right;
			}
			
		}

	}
	
	public int getHeight(Node ptr) {
		int height = 0;
		int lheight =0;
		int rheight =0;
		if (ptr == null) {
			return 0;
		}
		lheight =getHeight(ptr.left);
		rheight = getHeight(ptr.right);
		height = Math.max(lheight,rheight )+1;
		return height;
	}
	public int getHeight() {
		 return getHeight(root);
	}
}
