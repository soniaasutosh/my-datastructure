package com.aasutosh.tree;

import com.aasutosh.model.Employee;

public class Node {
	private Employee data;
	private Node left;
	private Node right;
	
	public Node(Employee data) {
		this.data = data;
	}
	
	public Employee getData() {
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
		return data.getSalary() + "";
	}
}
