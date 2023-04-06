package com.example.exercises;

public class Exercise02 {

	public static void main(String[] args) {
		C c= new C();	
		A a = new B();
		if (a instanceof A) {
			
		}
		if (a instanceof B) {
			
		}
		if (a instanceof I) {
			
		}
		if (a instanceof J) {
			
		}
		if (a instanceof K) {
			
		}
		/*
		 * Error
		 */
//		if (a instanceof C) {
//			
//		}
		
	}

}

interface I {}
interface J {}
interface K {}
class A {}
class C {}
class B extends A implements I, J {}
