package com.aasutosh.treesimple;

public class Node {
	private Integer data;
	private Node left;
	private Node right;

	public Node(Integer data) {
		this.data = data;
	}

	public Integer getData() {
		return data;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return data + "";
	}
}
