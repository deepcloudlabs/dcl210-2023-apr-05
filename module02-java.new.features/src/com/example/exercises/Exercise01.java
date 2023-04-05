package com.example.exercises;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Exercise01 {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException,
			NoSuchFieldException, SecurityException, NoSuchMethodException, InvocationTargetException {
		System.out.println("Fields:");
		for (var field : A.class.getFields()) {
			System.out.println(field.getName());
		}
		System.out.println("Methods:");
		for (var method : A.class.getMethods()) {
			System.out.println(method.getName());
		}
		System.out.println("Declared Fields:");
		for (var field : A.class.getDeclaredFields()) {
			System.out.println(field.getName());
		}
		System.out.println("Declared Methods:");
		for (var method : A.class.getDeclaredMethods()) {
			System.out.println(method.getName());
		}
		A a = new A();
		System.out.println(a);
		// a.x = 41;
		var clazz = a.getClass();
		Field field = clazz.getDeclaredField("x");
		field.setAccessible(true);
		field.set(a, 41);
		field.setAccessible(false);
		System.out.println(a);
		Method fun = clazz.getDeclaredMethod("fun");
		fun.setAccessible(true);
		fun.invoke(a);
		fun.setAccessible(false);
	}

}

@SuppressWarnings("unused")
class A {
	private int x = 42;
	private int y = 100;
	public final int z = 200;

	private void fun() {
		System.out.println("have fun!");
	}

	protected void gun() {
	}

	private void sun() {
	}

	@Override
	public String toString() {
		return "A [x=" + x + ", y=" + y + ", z=" + z + "]";
	}

}