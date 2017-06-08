package trees;

/**
 * @author sabiya
 *
 */
public class Node {

	int data;
	Node left;
	Node right;
	Node sib;

	public Node(int data) {
		this.data = data;
		this.left = null;
		this.sib = null;
		this.right = null;
	}

}
