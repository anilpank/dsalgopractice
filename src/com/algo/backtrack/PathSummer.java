package com.algo.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PathSummer {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(21);
		root.left.right = new TreeNode(27);

		root.right.left = new TreeNode(31);
		root.right.right = new TreeNode(37);

		Stack<Integer> stack = new Stack<>();
		System.out.println(new PathSummer().pathSum(root, 24));
	}
	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		List<List<Integer>> paths = new ArrayList<>();		
		Stack<Integer> stack = new Stack<>();
		inOrder(root, stack, paths);
		List<List<Integer>> resultPaths = new ArrayList<>();
		for (List<Integer> list : paths) {
			int sum = 0;
			for (Integer val : list) {
				sum = sum + val;
			}
			if (sum == targetSum) {
				resultPaths.add(list);
			}
		}
		return resultPaths;
	}

	public void inOrder(TreeNode root, Stack<Integer> stack, List<List<Integer>> paths) {
		if (root == null) {
			return;
		}
		stack.push(root.val);
		inOrder(root.left, stack, paths);
		if (root.left == null && root.right == null) {
			process(root, stack, paths);			
		}		
		inOrder(root.right, stack, paths);		
		stack.pop();
	}

	private void process(TreeNode root, Stack<Integer> stack, List<List<Integer>> paths) {
		List<Integer> list = new ArrayList<>();
		for(Integer item : stack) {
			list.add(item);
		}
		paths.add(list);
		System.out.println(list);
	}

}
