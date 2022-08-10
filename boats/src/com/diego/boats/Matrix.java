package com.diego.boats;

import java.util.Scanner;

public class Matrix {

	static int[][] matrix = {};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int size = 0;
		
		
		System.out.println("==========Looping menu==============");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Input the size of the Matrix: ");
		size = in.nextInt();
		matrix= new int[size][size];
		fillOutMatrix(size);
		
		
		while (true) {
			System.out.println();
			System.out.println("1. traverse in Vertical");
			System.out.println("2. traverse in N");
			System.out.println("3. traverse in O");
			System.out.println("4. traverse in Horizontal");
			System.out.println("5. Exit");
	        System.out.println("\nEnter Your Menu Choice: ");

			int key = in.nextInt();

			switch (key) {
			case 1:
				recorrido(size, 1);
				break;
			case 2:
				recorrido(size, 2);
				break;
			case 3:
				recorrido(size, 3);
				break;
			case 4:
				recorrido(size, 4);
				break;
			default:
				System.err.println("Bye");
				break;
			}
		}

	}

	public static void recorrido(int size, int type) {

		System.out.println("=========The input Matrix===========");
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				System.out.print("|" + matrix[row][col] + "|");
			}
			System.out.println();
		}
		System.out.println("==========Recorrido seleccionado==========");

		switch (type) {
		case 1:
			// Looping from top to buttom
			int col = 0;
			for (int i = 1; i <= size; i++) {
				if (i % 2 != 0) {
					for (int row = 0; row < size; row++) {
						System.out.print(matrix[row][col]);
					}
				} else {
					for (int row = size - 1; row > -1; row--) {
						System.out.print(matrix[row][col]);
					}
				}
				col++;

			}
			break;
		case 2:
			// Looping from bottom to top and diagonal
			int col2 = 0;
			for (int row = size - 1; row > -1; row--) {
				System.out.print(matrix[row][col2]);
			}
			col2++;
			for (int row = 1; row < size; row++) {
				System.out.print(matrix[row][col2]);
				col2++;
			}
			col2=size-1;
			for (int row = size - 2; row > -1; row--) {
				System.out.print(matrix[row][col2]);
			}

			break;

		default:
			break;
		}

	}
	
	public static void fillOutMatrix(int size) {
		Scanner in = new Scanner(System.in);

		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				System.out.println("Input the number in row " + row + " column " + col + " : ");
				matrix[row][col] = in.nextInt();
			}
		}
	}

}
