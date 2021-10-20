package com.aasutosh.treesimple;

import java.util.Stack;

public class BinaryTree {

	private Node root;
	private int size = 0;

	public void insert(Integer data) {
		System.out.println("inserting : " + data);
		size++;

		if (root == null) {
			root = new Node(data);
			return;
		}

		Node parent = root;

		while (parent != null) {
			System.out.println(parent);
			if (data < parent.getData()) {

				if (parent.getLeft() == null) {
					parent.setLeft(new Node(data));
					break;
				}

				parent = parent.getLeft();

			} else {
				if (parent.getRight() == null) {
					parent.setRight(new Node(data));
					break;
				}
				parent = parent.getRight();
			}
		}

	}

	void printInorder() {
		System.out.println("**********************      print In order      *************************");
		if (root == null)
			return;

		Stack<Node> s = new Stack<Node>();
		Node curr = root;

		// traverse the tree
		while (curr != null || s.size() > 0) {

			/*
			 * Reach the left most Node of the curr Node
			 */
			while (curr != null) {
				/*
				 * place pointer to a tree node on the stack before traversing the node's left
				 * subtree
				 */
				s.push(curr);
				curr = curr.getLeft();
			}

			/* Current must be NULL at this point */
			curr = s.pop();

			System.out.print(curr.getData() + " ");

			/*
			 * we have visited the node and its left subtree. Now, it's right subtree's turn
			 */
			curr = curr.getRight();
		}
	}

	public int getSize() {
		return size;
	}

}
