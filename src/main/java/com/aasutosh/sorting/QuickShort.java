package com.aasutosh.sorting;

import com.aasutosh.model.Employee;

public class QuickShort {

	public static void sort(Employee[] arr, int low, int high) {

		if (low < high) {
			int pi = partition(arr, low, high);
			sort(arr, low, pi - 1);
			sort(arr, pi + 1, high);
		}

	}

	private static int partition(Employee[] arr, int low, int high) {
		Long pivot = arr[high].getSalary();
		int i = (low - 1);
		for (int j = low; j <= high - 1; j++) {

			Utility.counter++;
			
			if (arr[j].getSalary() > pivot) {
				i++;
				Utility.swap(arr, i, j);
			}
		}
		Utility.swap(arr, i+1, high);
		return (i + 1);
	}
}
