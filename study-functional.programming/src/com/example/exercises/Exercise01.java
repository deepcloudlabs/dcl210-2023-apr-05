package com.example.exercises;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;

public class Exercise01 {

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
		// Functional Programming
		//  i. HoF (Higher-Order Function): filter, map, reduce
		// ii. Pure Function: side-effect -> lambda expression -> optimized anonymous class
		// function -> Functional Interface -> SAM
		sum = 
		numbers.stream().filter( t -> t%2 == 0 ) // 10,20,30,40
		                .map( v -> v*v*v ) // 1000,8000,9000,64000
		                .reduce(0, (s,n) -> s+n); 
		System.out.println("Sum of cube of event numbers in numbers: %d".formatted(sum));

	}

}
