package com.example.se8;

public class StudyInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

abstract interface Service1 {
	int x = 42;
 	public abstract int fun(int x,int y);
 	public int gun(int x,int y);
 	default public int run(int x,int y) { // (1) backward compatibility, since java se 8
 	   return hun(x)*hun(y);	
 	}
 	public static int pun(int x,int y) { // functional programming -> filter/map/reduce
 		return x*2 + jun(y);         // (2) reusable utility functions, since java se 8
 	}
 	private int hun(int x) { return x*x*x;} // since java se 9
 	private static int jun(int x) { return x*x*x;} // since java se 9
}

abstract interface Service2 { 
	abstract int sun(int x,int y);	
}
abstract interface Service3 extends Service1, Service2 { 
}

class A implements Service1 {

	@Override
	public int fun(int x, int y) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int gun(int x, int y) {
		// TODO Auto-generated method stub
		return 0;
	}

}

interface I {
	default int fun() {return 42;}
}

interface J {
	default int fun() {return 108;}
}

class E implements I,J {

	@Override
	public int fun() {
		return J.super.fun();
	}
	
}