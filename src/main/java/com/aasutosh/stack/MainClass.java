package com.aasutosh.stack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;

import com.aasutosh.model.Employee;
import com.aasutosh.util.Utility;

public class MainClass {

	public static void main(String[] args) {
		String fileName = "C:\\Users\\DELL\\Desktop\\Sample Data\\100 Records.csv";
		
		long startTime = System.currentTimeMillis();
		
		MyStack myStack = new MyStack(10);

		int bufferSize = 10240; // 10k
		
		try (BufferedReader br = new BufferedReader(new FileReader(fileName), bufferSize)) {

			String line = br.readLine(); // Skiping first line (Extra read)

			int index = 0;
			while ((line = br.readLine()) != null) {
				String[] valueArr = line.split(",");

				Integer empId = Integer.parseInt(valueArr[0]);
				String empName = valueArr[1] + " " + valueArr[2] + " " + valueArr[3] + " " + valueArr[4];
				Long salary = Long.parseLong(valueArr[25]);
				String gender = valueArr[5];
				String empMotherName = valueArr[8];
				LocalDate dateOfJoin = Utility.getDate(valueArr[14]);

				Employee emp  = new Employee(empId, empName, salary, gender, empMotherName, dateOfJoin);
				
				myStack.push(emp);
				index++;
				
				if(index == 10) break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Loaded file in " + (System.currentTimeMillis() - startTime) / 1000 + " seconds");
		System.out.println("Total Employees:  " + myStack.getSize());

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		
		print(5, myStack);
//		print(5, myStack);
	//	print(5, myStack);
		startTime = System.currentTimeMillis();
		
		 
	}
	
	public static void print(int numberOfRecord, MyStack myStack) {
		System.out.println("******************************************");
		Employee employee=null;
		int counter=0;
		while (counter < numberOfRecord) {
			employee= myStack.pop();
			System.out.println(employee);
			counter++;
		}
	 
	}

 

 

}
