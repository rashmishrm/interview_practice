package com.practice.ccinterview.treeandgraphs;

//Tl and T2 are two very large binary trees, with Tl much bigger than T2. Create an
//algorithm to determine if T2 is a subtree of Tl.
//A tree T2 is a subtree ofTi if there exists a node n in Ti such that the subtree of n is identical to T2.
//That is, if you cut off the tree at node n, the two trees would be identical.
public class IsSubTree1 {

	String value = "";

	public void getTraversalVersion(TreeNode s, StringBuilder sb) {
		if (s == null) {
			sb = sb.append("null,");
			return;
		}

		sb = sb.append(s.val + ",");

		getTraversalVersion(s.left, sb);
		getTraversalVersion(s.right, sb);

	}

	public boolean isSubtree(TreeNode s, TreeNode t) {
		
		StringBuilder s1= new StringBuilder();
		s1.append(",");

		StringBuilder s2= new StringBuilder();
		s2.append(",");
		

		getTraversalVersion(s, s1);
		getTraversalVersion(t,  s2);
		System.out.println(s1);
		System.out.println(s2);
		
		if (s1.indexOf(s2.toString())!=-1) {
			return true;
		}

		return false;

	}

	public static void main(String[] args) {
		TreeNode node = new TreeNode(4);

	}

}
