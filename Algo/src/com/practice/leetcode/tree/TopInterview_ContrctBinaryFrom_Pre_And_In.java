package com.practice.leetcode.tree;

public class TopInterview_ContrctBinaryFrom_Pre_And_In {
	public TreeNode buildTree(int[] preorder, int[] inorder) {

		if (preorder == null || inorder == null)
			return null;

		// important thing to remember is root node will be first node in preorder.
		// Also, in inorder, position of rootnode's left would be left tree anf right
		// would be right tree.

		return build(preorder, inorder, 0, 0, preorder.length);

	}

	public TreeNode build(int[] preorder, int[] inorder, int offset1, int offset2, int len) {
		if (len == 0)
			return null;

		TreeNode node = new TreeNode(preorder[offset1]);
		int left = 0;
		while (inorder[offset2 + left] != preorder[offset1]) {
			left++;
		}
		node.left = build(preorder, inorder, offset1 + 1, offset2, left);
		node.right = build(preorder, inorder, offset1 + left + 1, offset2 + left + 1, len - (left + 1));
		return node;

	}

}
