package com.aasutosh.linklist;

import com.aasutosh.model.Employee;

public class Itrator {
	Node data;

	public Itrator(Node data) {
		this.data = data;
	}

	public Employee next() {
		if(data == null) {
			return null;
		}
		
		Employee emp = data.getData();
		data= data.getNext();
		return emp;
	}
}
