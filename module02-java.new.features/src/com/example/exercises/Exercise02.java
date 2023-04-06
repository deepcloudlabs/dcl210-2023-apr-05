package com.example.exercises;

@SuppressWarnings("unused")
public class Exercise02 {

	public static void main(String[] args) {
		C c = new C();
		AA a = new B();
		if (a instanceof AA) {

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

interface I {
}

interface J {
}

interface K {
}

class AA {
}

class C {
}

class B extends AA implements I, J {
}
