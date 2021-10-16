package com.aasutosh.array;

import java.io.BufferedReader;
import java.io.FileReader;

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
				// System.out.println(Arrays.toString(valueArr));
//				System.out.print(valueArr[0]);
//				System.out.print("\t");
//				System.out.print(valueArr[1]+" "+valueArr[2]+" "+valueArr[3]+" "+valueArr[4]);
//				System.out.print("\t");
//				System.out.println(valueArr[25]);

				Integer empId = Integer.parseInt(valueArr[0]);
				String empName = valueArr[1] + " " + valueArr[2] + " " + valueArr[3] + " " + valueArr[4];
				Long salary = Long.parseLong(valueArr[25]);
				emp[index++] = new Employee(empId, empName, salary);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		Employee[] top10SalaryEmps = getTop10SalaryEmps(emp);

		System.out.println("Total Employees:  " + emp.length);
		System.out.println("Top Ten Employees:  " + top10SalaryEmps.length);
		printEmployee(10, top10SalaryEmps);
	}

	private static void printEmployee(int n, Employee[] emp) {
		System.out.println("******************************************");
		for (int i = 0; i < n; i++) {
			Employee employee = emp[i];
			System.out.println(employee);
		}
	}

	private static Employee[] getTop10SalaryEmps(Employee[] emp) {
//		printEmployee(5, emp);
		sortRecords(emp);
//		printEmployee(5, emp);
		Employee[] newEmpArr = new Employee[10];
		for (int i = 0; i < 10; i++) {
			newEmpArr[i] = emp[i];

		}
		return newEmpArr;
	}

	private static void sortRecords(Employee[] emp) {
		for (int i = 0; i < emp.length; ++i) {
			for (int j = i + 1; j < emp.length; ++j) {
				// if (emp[i].getSalary() > emp[j].getSalary()) { Ascending

				if (emp[i].getSalary() < emp[j].getSalary()) { // Descending
					Employee temp = emp[i];
					emp[i] = emp[j];
					emp[j] = temp;
				}
			}

		}

	}

}
