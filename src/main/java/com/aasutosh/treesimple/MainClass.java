package com.aasutosh.treesimple;

public class MainClass {

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();
//		try (Scanner in = new Scanner(System.in)) {
//			int input = 0;
//
//			while (input != -1) {
//				if (input != 0) {
//					tree.insert(input);
//				}
//				System.out.print("Enter : ");
//				input = in.nextInt();
//			}
//		}
		
		int[] arr= {4,6,8,4,2,4,6,4,5,4,8,5,4,6,4,8,12,6,100,58,65,10,85,35};
		
		for (int i : arr) {
			tree.insert(i);
		}
		
		
		tree.printInorder();
		

	}
	
	

	public static void print(int numberOfRecord, BinaryTree binaryTree) {
		System.out.println("******************************************");

	}

}
