package com.aasutosh.tree;

import com.aasutosh.model.Employee;

public class BinaryTree {

	private Node root;
	private int size = 0;

	public void insert(Employee emp) {
		size++;

		if (root == null) {
			root = new Node(emp);
			return;
		}
		
		Node parent=root;
		
		while(parent!=null) {
			if(emp.getSalary() < parent.getData().getSalary() ) {
				
				if(parent.getLeft()==null) {
					parent.setLeft(new Node(emp));
					break;
				}
				
				parent = parent.getLeft();
				
			}else {
				if(parent.getRight()==null) {
					parent.setRight(new Node(emp));
					break;
				}
				parent = parent.getRight();
			}
		}
		

	}
	
	public int getSize() {
		return size;
	}

}
