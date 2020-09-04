package datastructure;

public class BTApp {
	static int d1 = -1;
	static int d2 = -1;
	static int dist = 0;

	static class Node {
		Node left, right;
		int data;

		// constructor
		Node(int key) {
			this.data = key;
			left = null;
			right = null;
		}

		@Override
		public String toString() {
			return String.valueOf(data);
		}

	}

	public static void main(String[] args) {

		System.out.println("03/25/2020 06:09:10 AM".length());
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.right = new Node(8);

		System.out.println("Dist(4, 5) = " + findDistance(root, 4, 5));
		/*
		 * System.out.println("Dist(4, 6) = " + findDistance(root, 4, 6));
		 * System.out.println("Dist(3, 4) = " + findDistance(root, 3, 4));
		 * System.out.println("Dist(2, 4) = " + findDistance(root, 2, 4));
		 * System.out.println("Dist(8, 5) = " + findDistance(root, 8, 5));
		 */

	}

	static int findDistance(Node root, int n1, int n2) {
		d1 = -1;
		d2 = -1;
		dist = 0;
		Node lca = findDistUtil(root, n1, n2, 1);
		System.out.println("findDistance:" + d1 + " " + d2);
		// If both n1 and n2 were present in Binary Tree, return dist
		if (d1 != -1 && d2 != -1)
			return dist;

		// If n1 is ancestor of n2, consider n1 as root and find level
		// of n2 in subtree rooted with n1
		if (d1 != -1) {
			dist = findLevel(lca, n2, 0);
			return dist;
		}

		// If n2 is ancestor of n1, consider n2 as root and find level
		// of n1 in subtree rooted with n2
		if (d2 != -1) {
			dist = findLevel(lca, n1, 0);
			return dist;
		}

		return -1;
	}

	static int findLevel(Node root, int k, int level) {
		// Base Case
		if (root == null)
			return -1;

		// If key is present at root, or in left subtree or right subtree,
		// return true;
		if (root.data == k)
			return level;

		int l = findLevel(root.left, k, level + 1);
		return (l != -1) ? l : findLevel(root.right, k, level + 1);
	}

	static Node findDistUtil(Node root, int n1, int n2, int lvl) {
		// System.out.println("findDistUtil-->node.value:" + root + ",n1:" + n1 + ",n2:"
		// + n2 + ",lvl:" + lvl);
		// Base case
		if (root == null)
			return null;

		// If either n1 or n2 matches with root's key, report
		// the presence by returning root (Note that if a key is
		// ancestor of other, then the ancestor key becomes LCA
		if (root.data == n1) {
			d1 = lvl;
			return root;
		}
		if (root.data == n2) {
			d2 = lvl;
			return root;
		}

		// Look for n1 and n2 in left and right subtrees
		// System.out.println("lvl val before calling left_lca=" + lvl);
		Node left_lca = findDistUtil(root.left, n1, n2, lvl + 1);
		// System.out.println("lvl val before calling right_lca=" + lvl);
		Node right_lca = findDistUtil(root.right, n1, n2, lvl + 1);

		// If both of the above calls return Non-NULL, then one key
		// is present in once subtree and other is present in other,
		// So this node is the LCA
		if (left_lca != null && right_lca != null) {
			// System.out.println(d1);
			// System.out.println(d2);
			// System.out.println(lvl);
			dist = (d1 + d2) - 2 * lvl;
			// System.out.println("Distance:" + dist);
			return root;
		}

		// Otherwise check if left subtree or right subtree is LCA
		return (left_lca != null) ? left_lca : right_lca;
	}

}
