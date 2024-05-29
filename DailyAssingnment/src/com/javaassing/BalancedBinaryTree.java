package com.javaassing;
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int val){
		this.val = val;
		this.left = null;
		this.right = null;
	}
}

public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		
		return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right); 
	}
	
	private int height(TreeNode node) {
		if (node == null)
			return 0;
		
		int leftHeight = height(node.left);
		int rightHeight = height(node.right);
		return Math.max(leftHeight, rightHeight) + 1;
	}
	
	public static void main(String[] args) {
		BalancedBinaryTree tree = new BalancedBinaryTree();
		
		//usage 
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		
		boolean isBalanced = tree.isBalanced(root);
		System.out.println("is the tree balanced?" + isBalanced);
		
		
	}

}
