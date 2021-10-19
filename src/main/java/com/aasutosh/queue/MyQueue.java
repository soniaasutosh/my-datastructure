package com.aasutosh.queue;

import com.aasutosh.model.Employee;

public class MyQueue {
	private final Employee[] data;
	private int top=-1;
	
	
	public MyQueue(int size) {
		 data=new Employee[size];
	}
	
	public void enQueue(Employee emp)  {
		if(top == data.length -1) {
			throw new RuntimeException("Overflow");
		}
		
		top++;
		data[top]=emp;

	}
	
	public Employee deQueue() {
		if(top == -1) {
			throw new RuntimeException("underflow");
		}
		
		Employee emp=data[0];
		
		for (int i = 0; i < top; i++) {
			data[i]=data[i+1];
			
		}
		top--;
		return emp;
		 
	}
	
	public int getSize() {
		return data.length;
	}
	
	
}
