package datastructure.binarytree;

public class BSTApp {

	public static void main(String[] args) {
		BST b = new BST();
		Node root = null;
		root = b.addNode(root, 8);
		b.addNode(root, 3);
		b.addNode(root, 6);
		b.addNode(root, 10);
		b.addNode(root, 4);
		b.addNode(root, 7);
		b.addNode(root, 1);
		b.addNode(root, 14);
		b.addNode(root, 11);
		b.addNode(root, 13);
		b.inorder(root);
		System.out.println("\nIs 10 Present?");
		if (b.bstSearch(root, 10)) {
			System.out.println("Yes");
			b.deleteNode(root, 10);
			b.inorder(root);
		} else
			System.out.println("No");
		
		
	}

}

class Node {
	int val;
	Node left;
	Node right;

	Node(int val) {
		this.val = val;
		right = null;
		left = null;
	}

	@Override
	public String toString() {
		return "Node [val=" + val + ", left=" + left + ", right=" + right + "]";
	}

}

class BST {
	public Node addNode(Node node, int val) {
		if (node == null) {
			return new Node(val);
		}
		if (val < node.val) {
			node.left = addNode(node.left, val);
		} else if (val > node.val) {
			node.right = addNode(node.right, val);
		}
		return node;
	}

	public void inorder(Node node) {
		if (node != null) {
			inorder(node.left);
			System.out.print(" "+node.val);
			inorder(node.right);
		}

	}

	public boolean bstSearch(Node node, int val) {
		if (node == null)
			return false;

		if (val == node.val)
			return true;

		return val < node.val ? bstSearch(node.left, val) : bstSearch(node.right, val);
	}

	public Node deleteNode(Node node, int val) {
		// if tree is empty
		if (node == null)
			return node;

		// recur down tree
		if (val < node.val)
			node.left = deleteNode(node.left, val);
		else if (val > node.val)
			node.right = deleteNode(node.right, val);
		else { // found matched val
				// node with only one child or no child
			if (node.left == null)
				return node.right;
			else if (node.right == null)
				return node.left;
			// node with two children : Get the in order successor of right subtree
			node.val = minVal(node.right);

			// Deletes the inorder successor
			node.right = deleteNode(node.right, val);
		}
		return null;
	}

	private int minVal(Node node) {
		int minVal = node.val;
		while (node.left != null) {
			minVal = node.left.val;
			node = node.left;
		}
		return minVal;
	}
}