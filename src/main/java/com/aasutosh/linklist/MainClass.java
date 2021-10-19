package com.aasutosh.linklist;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;

import com.aasutosh.model.Employee;
import com.aasutosh.util.Utility;

public class MainClass {

	public static void main(String[] args) {
		System.out.println("******************  LinkList  ********************");
		String fileName = "C:\\Users\\DELL\\Desktop\\Sample Data\\100 Records.csv";
		
		long startTime = System.currentTimeMillis();
		
		MyLinkList myLinkList = new MyLinkList();

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
				
				myLinkList.add(emp);
				index++;
				
				//if(index == 5) break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Loaded file in " + (System.currentTimeMillis() - startTime) / 1000 + " seconds");
		System.out.println("Total Employees:  " + myLinkList.getSize());

		print(10, myLinkList);
		
		startTime = System.currentTimeMillis();
		
		System.out.println(myLinkList.getByEmpName("Belkis"));
		
		System.out.println("find in " + (System.currentTimeMillis() - startTime) / 1000 + " seconds");
		
		System.out.println("******************  data at 3 position  ********************");
		System.out.println(myLinkList.get(3));
	}
	
	public static void print(int numberOfRecord, MyLinkList myLinkList) {
		System.out.println("******************************************");
		
		Itrator ite = myLinkList.getItrator();
		
		int counter=0;
		/*
		
		Employee employee=ite.next();
		while (employee !=null && counter < numberOfRecord) {
			System.out.println(employee);
			employee=ite.next();
			counter++;
		}
		*/
		
		Employee employee=null;
		while ((employee=ite.next()) !=null && counter < numberOfRecord) {
			System.out.println(employee);
			counter++;
		}
	 
	}

 

 

}
