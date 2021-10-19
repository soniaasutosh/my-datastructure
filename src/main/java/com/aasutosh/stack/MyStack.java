package com.aasutosh.stack;

import com.aasutosh.model.Employee;

public class MyStack {
	private final Employee[] data;
	private int top=-1;
	
	
	public MyStack(int size) {
		 data=new Employee[size];
	}
	
	public void push(Employee emp)  {
		if(top == data.length -1) {
			throw new RuntimeException("Overflow");
		}
		
		top++;
		data[top]=emp;

	}
	
	public Employee pop() {
		if(top == -1) {
			throw new RuntimeException("underflow");
		}
		return data[top--];
		 
	}
	
	public int getSize() {
		return data.length;
	}
	
	
}
