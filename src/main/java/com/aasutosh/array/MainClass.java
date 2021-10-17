package com.aasutosh.array;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;

import com.aasutosh.model.Employee;

public class MainClass {

	public static void main(String[] args) {
		String fileName = "C:\\Users\\DELL\\Desktop\\Sample Data\\100 Records.csv";
		
		Employee[] emp = new Employee[100];

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

		System.out.println("Total Employees:  " + emp.length);

		System.out.println();
		System.out.println();
		System.out.println("Top Ten Salary wise Employees  ");
		sortRecordsBySalary(emp);
		Utility.print(10, emp);

		System.out.println();
		System.out.println();
		System.out.println("Top Ten Latest joined Employees  ");
		sortRecordByDateOfJoiningLatest(emp);
		Utility.print(10, emp);

		System.out.println();
		System.out.println();
		System.out.println("Top Ten old joined Employees  ");
		sortRecordByDateOfJoiningOld(emp);
		Utility.print(10, emp);
	}

	private static void sortRecordByDateOfJoiningOld(Employee[] emp) {
		for (int i = 0; i < emp.length; ++i) {
			for (int j = i + 1; j < emp.length; ++j) {

				if (emp[i].getDateOfJoin().isAfter(emp[j].getDateOfJoin())) { // Ascending
					Employee temp = emp[i];
					emp[i] = emp[j];
					emp[j] = temp;
				}
			}

		}
	}

	private static void sortRecordByDateOfJoiningLatest(Employee[] emp) {
		for (int i = 0; i < emp.length; ++i) {
			for (int j = i + 1; j < emp.length; ++j) {

				if (emp[i].getDateOfJoin().isBefore(emp[j].getDateOfJoin())) { // Descending
					Employee temp = emp[i];
					emp[i] = emp[j];
					emp[j] = temp;
				}
			}

		}
	}

	private static void sortRecordsBySalary(Employee[] emp) {
		for (int i = 0; i < emp.length; ++i) {
			for (int j = i + 1; j < emp.length; ++j) {
				// if (emp[i].getSalary() < emp[j].getSalary()) { Ascending

				if (emp[i].getSalary() < emp[j].getSalary()) { // Descending
					Employee temp = emp[i];
					emp[i] = emp[j];
					emp[j] = temp;
				}
			}

		}

	}

}
