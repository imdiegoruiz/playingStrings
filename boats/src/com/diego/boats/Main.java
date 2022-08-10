package com.diego.boats;

import java.util.List;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] people = new int[4];
		int[] people = { 1, 2, 4, 5, 5 };
		int limit = 5;
		System.out.println(numRescueBoats(people, limit));

	}

	public static int numRescueBoats(int[] people, int limit) {
		/*
		 * The problem is find out the number of rescueBoats
		 * 
		 */

		// first step is to sort the input array
		Arrays.sort(people);
		int boats = 0;
	
        int i = 0, j = people.length - 1;

        while (i <= j) {
            boats++;
            if (people[i] + people[j] <= limit)
                i++;
            j--;
        }


		return boats;
	}

}
