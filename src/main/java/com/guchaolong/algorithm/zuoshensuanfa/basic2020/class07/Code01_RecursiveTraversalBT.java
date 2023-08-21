package com.guchaolong.algorithm.zuoshensuanfa.basic2020.class07;

/**
 * 递归遍历二叉树
 */
public class Code01_RecursiveTraversalBT {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int v) {
			value = v;
		}
	}

	public static void f(Node head) {
		if (head == null) {
			return;
		}
		// 1 打印放这一行就是前序
		f(head.left);
		// 2 打印放这一行就是中序
		f(head.right);
		// 3 打印放这一行就是后序
	}

	public static void f2(Node node){
		//第1次，来到node节点
		if(node == null){
			return;
		}
		f(node.left);
		//第2次，调完了left,回到了node节点
		f(node.right);
		//第3次，调完了right,回到了node节点
	}

	// 先序打印所有节点
	public static void pre(Node head) {
		if (head == null) {
			return;
		}
		System.out.println(head.value);
		pre(head.left);
		pre(head.right);
	}

	// 中序打印所有节点
	public static void in(Node head) {
		if (head == null) {
			return;
		}
		in(head.left);
		System.out.println(head.value);
		in(head.right);
	}

	// 后序打印所有节点
	public static void pos(Node head) {
		if (head == null) {
			return;
		}
		pos(head.left);
		pos(head.right);
		System.out.println(head.value);
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		head.right.right = new Node(7);

		pre(head);
		System.out.println("========");
		in(head);
		System.out.println("========");
		pos(head);
		System.out.println("========");

	}

}
