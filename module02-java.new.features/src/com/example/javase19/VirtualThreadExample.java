package com.example.javase19;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class VirtualThreadExample {

	public static void main(String[] args) throws Exception {
		ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
		IntStream.range(0, 100_000).forEach(i -> executor.execute(() -> {
			System.out.println("Virtual Thread " + i + " running...");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Virtual Thread " + i + " completed.");
		}));
		executor.awaitTermination(5, TimeUnit.SECONDS);
		executor.shutdownNow();
	}

}