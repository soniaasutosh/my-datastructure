package com.aasutosh.tree;

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

		BinaryTree binaryTree = new BinaryTree();

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

				Employee emp = new Employee(empId, empName, salary, gender, empMotherName, dateOfJoin);

				binaryTree.insert(emp);
				index++;

				// if(index == 5) break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Loaded file in " + (System.currentTimeMillis() - startTime) / 1000 + " seconds");
		System.out.println("Total Employees:  " + binaryTree.getSize());

		print(10, binaryTree);

		startTime = System.currentTimeMillis();

	}

	public static void print(int numberOfRecord, BinaryTree binaryTree) {
		System.out.println("******************************************");

	}

}
