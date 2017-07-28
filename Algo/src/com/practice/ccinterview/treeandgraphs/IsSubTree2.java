package com.practice.ccinterview.treeandgraphs;

public class IsSubTree2 {
	public boolean matchTree(TreeNode s, TreeNode t) {
		if(s==null && t!=null){
			return false;
		}
		if(s!=null && t==null){
			return false;
		}
	
		if(s==null && t==null){
			return true;
		}
	
		if (s.val != t.val) {
			return false;
		}

		matchTree(s.left, t.left);
		matchTree(s.right, t.right);

		return true;
	}

	public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
         return true;
        }
		else if (s.val == t.val && matchTree(s, t)) {

			return true;
		}
		return isSubtree(s.left, t) || isSubtree(s.right, t);

	}
}

