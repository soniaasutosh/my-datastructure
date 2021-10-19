package com.aasutosh.linklist;

import com.aasutosh.model.Employee;

public class MyLinkList {

	private Node root;
	private Node last;
	private int size = 0;

	public void add(Employee data) {
		if (root == null) {
			root = new Node(data);
			last = root;
		} else {
			Node node = new Node(data);
			last.setNext(node);
			last = node;
		}

		size++;

	}

	public int getSize() {
		return size;
	}

	public Itrator getItrator() {
		return new Itrator(root);
	}
}
