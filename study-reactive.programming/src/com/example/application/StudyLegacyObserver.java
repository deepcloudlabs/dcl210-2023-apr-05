package com.example.application;

import java.util.List;

import com.example.event.TradeEvent;

public class StudyLegacyObserver {

	public static void main(String[] args) {
		var events = List.of(
				new TradeEvent("orcl",100,200),
				new TradeEvent("ibm",90,300),
				new TradeEvent("gogle",120,400),
				new TradeEvent("orcl",101,500)
	   );

	}

}
