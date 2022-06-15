package com.revature.scopes;

public class MyClass {
	
	public static int myStaticVariable = 1;
	
	public String myString;
	public boolean myBool; //default value is false
	
	public MyClass() {
		
	}
	
	public MyClass(String myString) {
		this.myString = myString; //"this" keyword provides variable shadowing
	}

		//[access modifier] [non-access modifiers] [return type] [name] ([params if any]){}
		//reverse a string, take in a string and return a reversed string
		public String reverseString(String stringToBeReversed) {
			// boa => aob
			String reversed = "";
			char[] letters = stringToBeReversed.toCharArray();
			
			for(int i = letters.length-1; i >= 0; i--) {
				reversed = reversed + letters[i];
			}
			
			return reversed;
		}
		
		public static void myStaticMethod() {
			
		}

	}
