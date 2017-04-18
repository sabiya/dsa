package trees;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryTreeWithMinimalHeight {

	@Test
	public void test() {
		Tree tree = new Tree();
//		int inputs [] = {10, 16, 34, 18 , 20, 22};
		int inputs [] = {8,10, 16, 18 ,20, 22, 34,36,38};
		insertWithMinHeight(tree, inputs, 0 , inputs.length-1);
//		for (int i=0;i<inputs.length; i++) {
//			tree.insert(inputs[i]);	
//		}
		System.out.println("inserted data");
//		System.out.println("\n\n Inorder : \n");
		tree.inorder();
		System.out.print("\nHeight:" + tree.getHeight());
	}

	private void insertWithMinHeight(Tree tree, int[] inputs, int left, int right) {
		if(left<0||right<0 || left>right)
			return;
		int mid = ( left+ ((right -left)/2));
		if (left <= right) {
			System.out.println("L:"+ left + " M:" +mid+ " R:"+ right );
			System.out.println(inputs[mid]);
			tree.insert(inputs[mid]);
			insertWithMinHeight(tree, inputs, left, mid-1);
			insertWithMinHeight(tree, inputs, mid+1, right);
		} else {
			return;
		}
		
		
	}

}
