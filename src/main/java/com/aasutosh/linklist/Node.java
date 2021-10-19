package com.aasutosh.linklist;

import com.aasutosh.model.Employee;

public class Node {
	private Employee data;
	private Node next;
	
	public Node(Employee data) {
		this.data = data;
	}
	
	public Employee getData() {
		return data;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public Node getNext() {
		return next;
	}
}
