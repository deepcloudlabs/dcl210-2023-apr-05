package com.example.se7;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SuppressWarnings("unused")
public class ProjectCoin {

	public static void main(String[] args) {
		Map<String, List<Integer>> cache = new ConcurrentHashMap<>(); // Java SE 7
		var w = 3.1415;
		var p = new ConcurrentHashMap<String, List<Integer>>(); // Java SE 10
		int x = 42;
		int y = 042;
		int z = 0x93;
		int u = 0b1001_0011; // base 2
		int money = 10_000_000; // grouping digits
		int v = 10000000;
		String weekDay = "wednesday";
		switch (weekDay) { // Since Java SE 7: String
		case "monday":
		case "tuesday":
		case "wednesday":
		case "thursday":
		case "friday":
			System.out.println("Work hard!");
			break;
		case "saturday":
		case "saunday":
			System.out.println("Rest now!");
			break;
		}
		String dayMessage = switch (weekDay) { // Since Java SE 12
		case "monday", "tuesday", "wednesday", "thursday", "friday" -> {
			yield "Work hard!";
		}
		case "saturday", "saunday" -> {
			yield "Rest now!";
		}
		default -> throw new IllegalArgumentException("Unexpected value: " + weekDay);
		};
		System.out.println(dayMessage);
		dayMessage = switch (weekDay) { // Since Java SE 12
		case "monday", "tuesday", "wednesday", "thursday", "friday" -> "Work hard!";
		case "saturday", "saunday" -> "Rest now!";
		default -> "unknown";
		};
		System.out.println(dayMessage);
	}

}
