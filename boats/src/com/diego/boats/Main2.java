package com.diego.boats;

import java.util.Iterator;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int array[] = { 5, 20, 32, 12, 2, 10 };

		int len = array.length;
		int largest = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			largest = Math.max(largest, array[i]);
		}
		System.out.println(largest);

		int secondLargest = Integer.MIN_VALUE;
		int pos = -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != largest) {
				secondLargest = Math.max(secondLargest, array[i]);
				pos = i;
			}

		}

		System.out.println(secondLargest);
		System.out.println(pos);

	}

}
