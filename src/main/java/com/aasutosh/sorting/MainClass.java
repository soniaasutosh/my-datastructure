package com.aasutosh.sorting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;

import com.aasutosh.model.Employee;
import com.aasutosh.util.Utility;

public class MainClass {
	

	public static void main(String[] args) {
		// String fileName = "C:\\Users\\DELL\\Desktop\\Sample Data\\100 Records.csv";

		long startTime = System.currentTimeMillis();

		//String fileName = "C:\\Users\\DELL\\Desktop\\Sample Data\\50000 Records.csv";

		//String fileName = "C:\\Users\\DELL\\Desktop\\Sample Data\\Hr1m.csv";
		String fileName = "C:\\Users\\DELL\\Desktop\\Sample Data\\Hr5m.csv";
		
		// Employee[] emp = new Employee[100];
//		Employee[] emp = new Employee[50000];
		Employee[] emp = new Employee[5000000];
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

				emp[index++] = new Employee(empId, empName, salary, gender, empMotherName, dateOfJoin);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Loaded file in " + (System.currentTimeMillis() - startTime) / 1000 + " seconds");

		System.out.println("Total Employees:  " + emp.length);

		System.out.println();
		System.out.println();
		System.out.println("Top Ten Salary wise Employees  ");

		startTime = System.currentTimeMillis();
		
//		bubbleShort(emp);
//		selectionShort(emp);
//		insertionShort(emp);
		
		QuickShort.sort(emp, 0, emp.length -1);
		
		System.out.println("Sorted in " + (System.currentTimeMillis() - startTime) / 1000 + " seconds with itration counter :: "+Utility.counter);

		Utility.print(10, emp);

	}

	private static void bubbleShort(Employee[] emp) {
		for (int i = 0; i < emp.length - 1; ++i) {
			for (int j = i + 1; j < emp.length - i - 1; ++j) {
				Utility.counter++;
				if (emp[i].getSalary() < emp[j].getSalary()) { // Descending
					Utility.swap(emp, i, j);
				}
			}

		}

	}

	private static void selectionShort(Employee[] emp) {
		for (int i = 0; i < emp.length - 1; ++i) {
			int minIndex = i;
			for (int j = i + 1; j < emp.length - i - 1; ++j) {
				Utility.counter++;
				if (emp[minIndex].getSalary() < emp[j].getSalary()) { // Descending
					minIndex = j;
				}
			}
			Utility.swap(emp, i, minIndex);
		}

	}

	private static void insertionShort(Employee[] emp) {
		for (int i = 1; i < emp.length - 1; ++i) {
			Employee key = emp[i];
			int j = i - 1;
			while (j >= 0 && emp[j].getSalary() < key.getSalary()) {
				Utility.counter++;
				emp[j + 1] = emp[j];
				j--;
			}
			emp[j + 1] = key;
		}

	}

	

}
