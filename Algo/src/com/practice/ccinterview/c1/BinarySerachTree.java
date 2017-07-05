package com.practice.ccinterview.c1;

class BTreeNode {
	int val;
	BTreeNode left;
	BTreeNode right;
	BTreeNode parent = null;

	BTreeNode(int x) {
		val = x;
	}
}

public class BinarySerachTree {

	BTreeNode root = null;

	public BTreeNode find(int value) {
		BTreeNode node = null;

		if (root == null) {
			return root;
		}

		node = find(value, root);

		return node;
	}

	private BTreeNode find(int value, BTreeNode node) {
		BTreeNode found = null;
		found = node;

		if (node.val > value) {
			if (node != null && node.left != null) {
				found = find(value, node.left);
			}
		} else if (node.val < value) {
			if (node != null && node.right != null) {
				found = find(value, node.right);
			}
		}

		return found;
	}

	public BTreeNode leftDescendant(BTreeNode node) {
		BTreeNode n = null;
		if (node.left == null) {
			n = node;
		} else {
			n = leftDescendant(node.left);
		}
		return n;
	}

	public BTreeNode rightAscendant(BTreeNode node) {

		if (node == null || node.parent == null) {
			return null;
		}
		if (node.val < node.parent.val) {
			return node.parent;
		} else {
			return rightAscendant(node.parent);
		}

	}

	public BTreeNode next(BTreeNode node) {
		BTreeNode n = null;

		if (node.right != null) {
			n = leftDescendant(node.right);
		} else {
			n = rightAscendant(node);
		}

		return n;
	}

	public void add(int value) {
		BTreeNode bt = new BTreeNode(value);

		if (root == null) {
			root = bt;
		} else {
			BTreeNode node = find(value, root);
			bt.parent = node;
			if (node.val > value) {
				node.left = bt;

			} else {
				node.right = bt;
			}
		}
	}

	public void delete(BTreeNode node) {
		if (node.right == null) {
			node.left.parent = node.parent;
			if (node.parent.val > node.val) {
				node.parent.left = node.left;
			} else {
				node.parent.right = node.left;

			}
		}

		else {
			BTreeNode nx = next(node);
			BTreeNode nxRight = nx.right;
			BTreeNode nxParent = nx.parent;
			// replace
			nx.parent = node.parent;
			if (node.parent.val > node.val) {
				node.parent.left = nx;
			} else {
				node.parent.right = nx;
			}

			nx.right = node.right;
			// promote
			nxRight.parent = nxParent;
			nxParent.left = nxRight;

		}
	}

	public static void main(String[] args) {
		BinarySerachTree bst = new BinarySerachTree();

		bst.add(2);
		bst.add(1);
		bst.add(5);
		System.out.println(bst.find(2).val);
		bst.delete(bst.root.left);
		System.out.println(bst.find(1).val);


	}

}
