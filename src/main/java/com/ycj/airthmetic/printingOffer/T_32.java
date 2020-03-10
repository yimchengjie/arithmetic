package com.ycj.airthmetic.printingOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.ycj.airthmetic.utils.MethodExecuteTimeUtils;
import com.ycj.airthmetic.utils.TreeNode;

/**
 * T_32 从上到下打印二叉树
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 */
public class T_32 {
    
    public static int[] levelOrder(TreeNode root) {
        if(root==null) return new int[0];
        Queue<TreeNode> queue=new LinkedList<>();
        List<Integer> list=new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode=queue.poll();
            list.add(treeNode.val);
            if (treeNode.left!=null) {
                queue.offer(treeNode.left);
            }
            if (treeNode.right!=null) {
                queue.offer(treeNode.right);
            }
        }
        int[] res=new int[list.size()];
        int i=0;
        for (Integer integer : list) {
            res[i]=integer;
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode1=new TreeNode(5);
        treeNode1.left=new TreeNode(4);
        treeNode1.right=new TreeNode(6);
        MethodExecuteTimeUtils.printRunTime(()->{
            int[] res=levelOrder(treeNode1);
            for (int r : res) {
                System.out.print(r+" ");
            }
        });
    }
}