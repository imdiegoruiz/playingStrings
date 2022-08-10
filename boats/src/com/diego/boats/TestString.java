package com.diego.boats;

import java.util.*;

import java.lang.*;
import java.io.*;

/*
       There is a string "sdfgabcwetrrytruyrtuabcpotre!@#abcprtort".
       The task is to implement the following method:

       private HashMap<string, string> processString(string inputStr, string separator);

       The result needs to contain the following keys:
       Count : count all substrings (itemstrings)  infront of which there is a separator string (if xxx is the string and A is the separator here: xxxAxxxAxxxAxxx, you need to return 3);
       prefix : if any string exists before the first separator, please provide the text
       sortedItems : a string with all itemstrings concatinated in alphabetical order
       evenChars : a string with concatinated all even indexed chars (2,4,6,8,10th)
	
	notes: 
		1. if there is no separator found in input string then the whole inputString is counted as 1 itemString 
		2. zero length strings should not be includded in count
		3. prefix should not be includded in itemstrings 
		4. prefix schould not be includded in count
		5. itemstrings schould be displayed with space (" ") between each of them in the output
	
	Implement all results display inside Main method in following format:
	
	Count: some number
	Prefix: some string
	sortedItems: some string
	evenChars: some string
	
	
	Example output when executed with inputString = "abcdefSEPgabcwetSEPsdsSEPdsfgSEPfro", separator = "SEP"
	
	Count: 4
	Prefix: abcdef
	sortedItems: dsfg fro gabcwet sds
	evenChars: aceSPaceSPdSPsgEfo
	
   */

class TestString {
	public static void main(String[] args) throws TestStringException {

		// String inputString = "sdfgabcwetrrytruyrtuabcpotre!@#abcprtort";

		// Uncomment the code to test with the input SEP and the inputString
		// abcdefSEPgabcwetSEPsdsSEPdsfgSEPfro
		String inputString = "abcdefSEPgabcwetSEPsdsSEPdsfgSEPfro";

		ArrayList<HashMap<String, String>> resultList = new ArrayList<HashMap<String, String>>();

		// Uncomment the code to test with the input SEP and the inputString
		// abcdefSEPgabcwetSEPsdsSEPdsfgSEPfro
		resultList.add(processString(inputString, "SEP"));

		// resultList.add(processString(inputString, "abc"));
		// resultList.add(processString(inputString, "s"));
		// resultList.add(processString(inputString, "r"));
		// resultList.add(processString(inputString, "zi"));

		printResult(resultList);
	}

	private static HashMap<String, String> processString(String inputStr, String separator) throws TestStringException {

		HashMap<String, String> result = new HashMap<String, String>();

		// Add the implementation here

		if (inputStr == null || inputStr.isBlank() || inputStr.isEmpty() || separator == null || separator.isBlank()
				|| separator.isEmpty()) {
			throw new TestStringException("You can not send null or empty parameters");
		}

		// Defining variables count, itemsString, indexPrefix to remove the prefix,
		// sizeInputStr
		int count = 0;
		String[] itemsString = {};
		String newInputStr = null;
		int indexPrefix = inputStr.indexOf(separator);
		int sizeInputStr = inputStr.length();
		String evenChars = "";

		// If I have prefix before my separator I remove it, and put the prefix to the
		// HashMap,
		// split the inputStr in an array of String
		if (indexPrefix != -1) {
			newInputStr = inputStr.substring(indexPrefix, sizeInputStr);
			result.put("Prefix", inputStr.substring(0, indexPrefix));
			itemsString = newInputStr.split(separator);
		} else {
			// Can be the case where before the separator there is not prefix
			itemsString = inputStr.split(separator);
			result.put("Prefix", "");
		}

		// Removing the null or "" form the itemsString in a lambda expression.
		itemsString = Arrays.stream(itemsString).filter(s -> (s != null && s.length() > 0)).toArray(String[]::new);

		// Getting the evens chars front the input string.
		evenChars = evenChars(inputStr);

		count = itemsString.length;
		result.put("Count", "" + count);
		result.put("Sorted", sortArray(itemsString));
		result.put("EvenChars", evenChars);

		return result;
	}

	private static void printResult(ArrayList<HashMap<String, String>> resultList) {
		/*
		 * Below is an example output when executed with inputString =
		 * "abcdefSEPgabcwetSEPsdsSEPdsfgSEPfro", separator = "SEP"
		 * 
		 * Count: 4 Prefix: abcdef sortedItems: dsfg fro gabcwet sds evenChars:
		 * aceSPaceSPdSPsgEfo
		 */

		// Add the implementation here

		for (HashMap<String, String> result : resultList) {
			for (String key : result.keySet()) {
				System.out.print(key + ":" + result.get(key) + " ");
			}
			System.out.println();
		}

	}

	private static String sortArray(String[] myArray) {
		int size = myArray.length;

		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < myArray.length; j++) {
				if (myArray[i].compareTo(myArray[j]) > 0) {
					String temp = myArray[i];
					myArray[i] = myArray[j];
					myArray[j] = temp;
				}
			}
		}
		return Arrays.toString(myArray);
	}

	public static String evenChars(String inputStr) {
		String evenChars = "";
		for (int j = 0; j < inputStr.length(); j++) {
			if (j % 2 == 0) {
				evenChars += inputStr.charAt(j);
			}
		}
		return evenChars;
	}

	public static class TestStringException extends Exception {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public TestStringException(String message) {
			super(message);
		}

	}

}
