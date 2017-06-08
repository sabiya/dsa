package trees;

import java.util.Stack;

import org.junit.Test;

public class FindSiblingNode {

	@Test
	public void testFindSibling() {
		SiblingTree tree = new SiblingTree();
		int inputs [] = {30, 25, 47 ,23, 26,35, 52, 17,24};
		for (int i=0;i<inputs.length; i++) {
			tree.insert(inputs[i]);	
		}
		System.out.println("inserted data");
		System.out.println("\n\n Inorder : \n");
		tree.inorder();
		
		System.out.println("Sibling Tree : ");
		tree.findSibling();
		tree.traverseSiblings();
	}
	
	class SiblingTree extends Tree {
		public void findSibling() {

			Node ptr = root, sib = null;
			if(ptr == null)
				return;
			Stack<Node> s = new Stack<Node>();
			Stack<Node> s2 = new Stack<Node>();
			s.push(ptr);
			while(!s.isEmpty()) {
				ptr = s.pop();
				if(ptr.left != null && ptr.right != null)
				{
					ptr.left.sib = ptr.right;
				}
				s.push(ptr.right);

			}

		}
		
		public void traverseSiblings() {
			Node ptr = root;
			Node q = null;
			while (ptr != null) {
				System.out.print("\n" + ptr.data);
				q = ptr.sib;
				while (q != null) {
					System.out.print("  " + q.data);
					q = q.sib;
				}
			ptr = ptr.left;
			}
			
		}

	}
	
	

}
