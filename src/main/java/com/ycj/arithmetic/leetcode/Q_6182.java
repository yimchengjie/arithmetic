package com.ycj.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Q_6182
 *
 * @author yanchengjie
 * @version : Q_6182.java, v 0.1 2022/9/18 10:49 yanchengjie Exp$
 */
public class Q_6182 {

	public static class TreeNode {

		int val;

		TreeNode left;

		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public TreeNode reverseOddLevels(TreeNode root) {
		LinkedList<TreeNode> nodes = new LinkedList<>();
		nodes.add(root);
		boolean hasMore = true;
		int level = 0;
		while (hasMore) {
			level++;
			int len = nodes.size();
			for (int i = 0; i < len; i++) {
				TreeNode node = nodes.poll();
				if (node.left==null) {
					hasMore = false;
					break;
				}
				nodes.add(node.left);
				nodes.add(node.right);
			}
			if (!hasMore) {
				break;
			}
			if (level%2!=0){
				reverse(nodes);
			}

		}
		return root;

	}

	private void reverse(List<TreeNode> nodes) {
		for (int i = 0; i < nodes.size() / 2; i++) {
			TreeNode right = nodes.get(nodes.size() - 1 - i);
			TreeNode left = nodes.get(i);
			int temp = right.val;
			right.val = left.val;
			left.val = temp;
		}
	}

	public static void main(String[] args) {
		int[] root = {7, 13, 11};
		TreeNode treeNode = new TreeNode(2,new TreeNode(3, new TreeNode(8), new TreeNode(13)), new TreeNode(5,new TreeNode(21), new TreeNode(34)));
		TreeNode node = new Q_6182().reverseOddLevels(treeNode);
		System.out.println(node.val);
		System.out.println(node.left.val);
		System.out.println(node.right.val);
		System.out.println(node.left.left.val);

		System.out.println(node.left.right.val);
		System.out.println(node.right.left.val);
		System.out.println(node.right.right.val);

	}

}
