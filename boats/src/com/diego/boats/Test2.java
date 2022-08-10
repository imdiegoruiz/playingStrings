package com.diego.boats;

public class Test2 {
	
	public static void main(String[] args) {
		String str = "ju77juhelloslkhellodjladfjhellomnbg";
		String findStr = "ju";
		System.out.println(str.indexOf(findStr));
		System.out.println(str.split(findStr, -1).length-1);
		String[] arr =str.split(findStr);
		for (int i = 0; i < arr.length; i++) {
			System.err.println("For");
			System.out.println(arr[i]);
		}
		String newSrt = str.substring(6, str.length());
		System.out.println(newSrt);
	}

}
