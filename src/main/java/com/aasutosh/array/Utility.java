package com.aasutosh.array;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.aasutosh.model.Employee;

public class Utility {
	public static void print(int numberOfRecord, Employee[] emp) {
		System.out.println("******************************************");
		for (int i = 0; i < numberOfRecord; i++) {
			Employee employee = emp[i];
			System.out.println(employee);
		}
	}
	
	
	public static String getFixedDateString(String value, String delimiter) {
		String[] tokens = value.split(delimiter);
		
		Integer values[]=new Integer[3];
		
		for (int i = 0; i < values.length; i++) {
			values[i] = Integer.parseInt(tokens[i]);
			
		}
		
		return String.format("%02d"+delimiter+"%02d"+delimiter+"%02d", values[0],values[1],values[2]);
	}
	
	public static LocalDate getDate(String value) {
		if (value == null || value.trim().isEmpty()) {
			return null;
		}
		try {
			if (value.contains("-")) {
				return LocalDate.parse(getFixedDateString(value,"-"), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			} 
				
			return LocalDate.parse(getFixedDateString(value,"/"), DateTimeFormatter.ofPattern("MM/dd/yyyy"));

		} catch (Exception e) {
			System.err.println(value + " :: " + e.getMessage());
			throw e;
		}
		
	}
}
