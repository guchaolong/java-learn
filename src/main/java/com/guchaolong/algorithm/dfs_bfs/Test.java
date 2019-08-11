/**
 * <p>
 * For more information about , welcome to http://www.guchaolong.com
 * <p>
 * project: java-learn
 * <p>
 * Revision History:
 * Date          Version       Name            Description
 * 2019/8/11 1.0          guchaolong          Creation File
 */
package com.guchaolong.algorithm.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 */
public class Test {

    public static void BFSWithQueue(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.add(root);
        }
        while (!queue.isEmpty()){
            TreeNode currentNode = queue.poll();
            System.out.println("current node:" + currentNode.value);
            if (currentNode.left != null)
                ((LinkedList<TreeNode>) queue).add(currentNode.left);
            if(currentNode.right != null)
                ((LinkedList<TreeNode>) queue).add(currentNode.right);
        }

    }


    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n1.setLeft(n2);
        n1.setRight(n3);
        n2.setLeft(n4);
        n2.setRight(n5);
        n3.setLeft(n6);
        n3.setRight(n7);

        BFSWithQueue(n1);

    }
}