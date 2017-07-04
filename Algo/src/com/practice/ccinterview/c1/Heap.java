package com.practice.ccinterview.c1;
class TreeNode<V> {
	V value;

	TreeNode<V> left;
	TreeNode<V> right;

	public TreeNode(V value) {
		this.value = value;
	}
}
public class Heap<V> {

	TreeNode<V> root=null;
	
	
	public V getMax(){
		V data=null;
		if(root==null){
			
		}
		else{
			data=root.value	;
		
			
		}
		return data;
		
	}
	
	
	public void insert(V element){
		TreeNode<V> node= new TreeNode<V>(element);
		TreeNode temp=root;
		while(temp!=null){
			
		
			
			temp=temp.left;
		}
		
	
	}
	
	
	
}
