package com.diego.boats;

public class Main3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String [] array1 = {"", "es", "", "", "secreto"};
		String [] array2 = {"este", "", "", "mensaje", ""};
		String [] array3 = {"este", "", "un", "", ""};
		String [] msg = new String[5];

		 // Initialize starting indexes for arrays
        int i = 0, j = 0, k = 0;
 
        // Iterate through three arrays while all arrays
        // have elements
        while (i < array1.length && j < array2.length
               && k < array3.length) {
            // Check if every position in array is empty or not to fill out the msg
            if (!array1[i].isEmpty()){
            	msg[i]=array1[i];
            }
            if (!array2[j].isEmpty()){
            	msg[i]=array2[j];
            }
            if (!array3[k].isEmpty()){
            	msg[i]=array3[k];
            }
            i++;
            j++;
            k++;
            
        }
        String test="";
        for (int k2 = 0; k2 < msg.length; k2++) {			
        	test+=msg[k2]+" ";
		}
        System.out.println(test.trim());

	}

}
