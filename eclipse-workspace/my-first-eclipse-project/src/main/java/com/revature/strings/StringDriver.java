package com.revature.strings;

public class StringDriver {

	public static void main(String[] args) {
		String s = "Hello"; //literal string
		String s1 = "Hello";
		String s2 = new String("Hello"); //points to a different place in memory
		
		System.out.println("Is s==s1? " + (s==s1)); //true
		System.out.println("Is s==s2? " + (s==s2)); //false
		System.out.println("Is s.equals(s2)? " + s.equals(s2)); //compares the value of string and not memory address like new String, true
		
		//s2.intern(); returns the memory address of "Hello" in the string pool, still points to the memory heap
		s2 = s2.intern(); //reassign the memory address in the string pool of "Hello" using s2 =
		System.out.println("Is s==s2? after intern? " + (s ==s2)); //true
		
		System.out.println();
		/*
		 * Comparing objects in JAva
		 * == vs .equals()
		 * == compares the value in the Stack, used for primitives
		 * reference value/memory address
		 * .equals() (if implemented correctly) compares the value of objects as defined in the class
		 * needs to be overridden based on the class' fields
		 */
		
		Object a = new Object();
		Object b = new Object();
		System.out.println("is a == b? " + (a == b)); //false, different memory addresses
		System.out.println("is a.equals(b)? " + a.equals(b)); //false, default implementation in object class is just "==", which is why we need to override it in our classes
		
		/*
		 * String methods to look into:
		 * Substring()
		 * replace()
		 * charAt()
		 * toLower/UpperCase()
		 * valueOf(return a string to whatever other numerical type you want)
		 */
		
		StringBuilder sb = new StringBuilder("Hello World!");
		sb.reverse();
		
		sb.append("abc"); //added abc to the end because abc came after the reverse method
		System.out.println(sb);
		
		String formerSb = sb.toString(); //converts sb to string and declares it to formerSb variable
		
		StringBuffer sbuff = new StringBuffer(); //same idea
		//Strings are thread safe because they are immutable, can't change so it doesn't matter how many threads read it
	}

}
