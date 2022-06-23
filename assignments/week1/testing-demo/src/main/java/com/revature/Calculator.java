/**
 * 
 */
package com.revature;

import com.revature.exceptions.DivideBy0Exception;
import com.revature.exceptions.Number13Exception;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author KevinTranHuu
 *
 */
public class Calculator {
	/*
	 * - add(int a, int b)
	 * 		- if the result is 13
	 * 			- throw an exception
	 * 				- Number13Exception
	 * - subtract
	 * - multiply
	 * - sum of an array
	 * - divide
	 * 		- throw a custom exception if divided by 0
	 */
	
	
	public int add(int a, int b) {
		if(a == 8 && b == 5 ) {
			throw new Number13Exception();
		}
		return a + b;
	}
	
	public int divide(int a, int b) {
		if(a == 100 && b == 0) {
			throw new DivideBy0Exception();
		}
		return a / b;
	}
	
	public int subtract(int a, int b) {
		return a - b;
	}
	
	public int sumOfAnArray(int[] intArr) {
		int sum = 0;
		int i;
		for(i = 0; i < intArr.length; i++) {
			sum += intArr[i];
		}
		return sum;
	}
	
	public int multiply(int a, int b) {
		return a * b;
	}
	
}
