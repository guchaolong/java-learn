package com.guchaolong.algorithm.zuoshensuanfa.basic2020.class07;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author GUCHAOLONG
 * @date 2020/12/7 19:41
 */


public class Test {
;


    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node.left = node2;
        node.right = node3;

        int[][] ints = threeOrders(node);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.println(i);
            }
        }
    }

    public static int[][] threeOrders (TreeNode root) {
        // write code here
        ArrayList<Integer> pre = new ArrayList<>();
        preOrder(root, pre);
        ArrayList<Integer> mid = new ArrayList<>();
        midOrder(root, mid);
        ArrayList<Integer> after = new ArrayList<>();
        afterOrder(root, after);
        Integer integer = pre.get(0);

        int [][] res = new int[3][pre.size()];
        for(int i = 0; i < pre.size(); i++){
            res[0][i] = pre.get(i);
        }

        for(int i = 0; i < mid.size(); i++){
            res[1][i] = mid.get(i);
        }

        for(int i = 0; i < after.size(); i++){
            res[2][i] = after.get(i);
        }
        return res;
    }

    public static void preOrder(TreeNode head, List list){
        if(head == null){
            return;
        }
        list.add(head.val);
        preOrder(head.left, list);
        preOrder(head.right, list);
    }

    public static void midOrder(TreeNode head, List list){
        if(head == null){
            return;
        }
        midOrder(head.left, list);
        list.add(head.val);
        midOrder(head.right, list);
    }

    public static void afterOrder(TreeNode head, List list){
        if(head == null){
            return;
        }
        afterOrder(head.left, list);
        afterOrder(head.right, list);
        list.add(head.val);
    }
}
