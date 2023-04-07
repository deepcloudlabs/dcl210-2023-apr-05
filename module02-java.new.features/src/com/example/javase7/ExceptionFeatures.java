package com.example.javase7;

public class ExceptionFeatures {

	public static void fun() throws ExceptionA {
		throw new ExceptionA();
	}
	
	public static void gun() throws ExceptionB {
		throw new ExceptionB();
	}
	
	public static void sun() throws ExceptionC {
		throw new ExceptionC();
	}
	
	public static void main(String[] args) throws Exception { // Since Java SE 7
		try {
			fun();
			gun();
			sun();
		} catch (ExceptionA | ExceptionB | ExceptionC e) { // multi-catch: since java se 7
			System.err.println("Error has occured: %s.".formatted(e.getMessage()));
			throw e; // re-throw
		}

	}

}

@SuppressWarnings("serial")
class ExceptionA extends Exception {}
@SuppressWarnings("serial")
class ExceptionB extends Exception {}
@SuppressWarnings("serial")
class ExceptionC extends Exception {}