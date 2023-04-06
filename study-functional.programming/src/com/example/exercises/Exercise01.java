package com.example.exercises;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Exercise01 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		var numbers = List.of(10,20,15,30,25,5,40,35);
		var sum = 0;
		for (var number : numbers) { // external loop
			if (number%2 == 0) {
				var cubed = number * number * number;
				sum += cubed;
			}
		}
		System.out.println("Sum of cube of event numbers in numbers: %d".formatted(sum));
		int state = 42;
		// Functional Programming: Java SE 8
		//  i. HoF (Higher-Order Function): filter, map, reduce
		// ii. Pure Function: side-effect -> i) lambda expression -> optimized anonymous class
		//                                  ii) method reference : Integer::sum
		// function -> Functional Interface -> SAM
		Predicate<Integer> even = t -> t%2 == 0; 
		Function<Integer,Integer> toCube = v -> v*v*v;
		BinaryOperator<Integer> accumulate = (s,n) -> s+n;
		sum = 
		numbers.stream().parallel()
		                .filter( Number::even ) // 10,20,30,40
		                .map( Number::toCube ) // 1000,8000,9000,64000
		                .reduce(0, Integer::sum ); 
		System.out.println("Sum of cube of event numbers in numbers: %d".formatted(sum));

	}

}

interface Number {
	public static int toCube(int x) {
		return x*x*x;
	}
	public static boolean even(int x) {
		return x%2 == 0;
	}
	public static boolean odd(int x) {
		return !even(x);
	}
}
