package com.algo.tree;

public class MaxProd {

	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		
		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(5);
		
		node.right.left = new TreeNode(6);
		System.out.println(new MaxProd().maxProduct(node));
	}
	private int totalSum = 0;
	private int maxProduct = 1;
	private int sum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return root.val + sum(root.left) + sum(root.right);
	}

	private void preOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		process(root);
		preOrder(root.left);
		preOrder(root.right);        
	}

	private void process(TreeNode root) {
		int subTreeSum  = sum(root);
		int product = (totalSum-subTreeSum)*subTreeSum;
		if (product<maxProduct) {
			this.maxProduct = product;
		}
	}

	public int maxProduct(TreeNode root) {
		this.totalSum = sum(root);
		System.out.println(totalSum);
		preOrder(root);
		return maxProduct;
	}
}
