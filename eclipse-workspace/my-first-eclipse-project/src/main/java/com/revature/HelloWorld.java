package com.revature;

import java.util.Arrays;
import java.util.Iterator;

public class HelloWorld {
	
	public static void main(String[] args) {
		
		System.out.println("Hello from Eclipse!");
		
		boolean bool = true; //1 bit
		byte myByte = 127; //8 bits -128 to 127
//		myByte = 128;
		short myShort = 128; //16 bits or 2 bytes
		char myChar = 'a'; //16 bits of memory
		int standardDataTypeForWholeNumber = 12345; //32 bits
		float lessPreciseDouble = 92.3f; // 32 bits
		
		double standardDecimal = 20.45; // 64 bits
		long bigNumber = 165654654L; //64 bits
		
		/*Casting
		 * convert data types of a variable to another
		 */
		//implicit/automatic 
		byte a = 2;
		int b = a;
		
		//explicit
		double d = 35.5;
		float f = (float)d;
		
		//s and s2 are a reference type that references the string in the heap
		String s = "Hello";
		String s2 = new String("World");
		
		//Wrapper classes:
		//Integer intWrap = new Integer(standardDataTypeForWholeNumber);
		Integer intWrap = standardDataTypeForWholeNumber;
		
		System.out.println("Max value for int: " + Integer.MAX_VALUE + ", min value for int: " + Integer.MIN_VALUE);
		
		//declaring an array
		int[] numbers;
		
		//create an array of size 5 and assign it to the variable numbers
		numbers = new int[5];
		
		numbers[0] = 2;
		numbers[3] = 4;
		//System.out.println(numbers[0]);
		
		for(int j = 0; j < numbers.length; j++) {
			System.out.println(numbers[j]);
		}
		//enhanced for loop, however, no access to index
		for(int in : numbers) {
			System.out.println(in);
		}
		
		String k = "kevin";
		char[] chars = k.toCharArray();
		
		//manipulate char c to the chars array to print out all elements
		for(char c : chars) {
			System.out.println(c);
		}
		
		Arrays.sort(numbers);
	}

}
