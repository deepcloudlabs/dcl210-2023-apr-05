package com.example.exercises;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;

public class Exercise03 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// 1. Process
		// 2. Thread
		// i. Platform Thread -> Kernel Thread
		// ii. Virtual Thread
		var vt1 = Thread.ofVirtual(); // IO-Bound -> Reactive System
		vt1.start(new ATask());
		var pt1 = Thread.ofPlatform(); // CPU-Bound -> Parallel
		pt1.start(new ATask());
		var pt2 = new Thread(new ATask());
		pt2.start();
		ATask taskA = new ATask();
		Thread t1 = new Thread(taskA);
		t1.start();
		t1.join();
		System.out.println(taskA.getResult());
		BTask taskB = new BTask();
		FutureTask<Integer> future1 = new FutureTask<Integer>(taskB);
		FutureTask<Integer> future2 = new FutureTask<Integer>(taskB);
		FutureTask<Integer> future3 = new FutureTask<Integer>(taskB);
		Thread t2 = new Thread(future1);
		Thread t3 = new Thread(future2);
		Thread t4 = new Thread(future3);
		t2.start();
		t3.start();
		t4.start();
		future1.get();
		future2.get();
		future3.get();
		System.out.println(taskB.getCounter());
	}
}

class ATask implements Runnable {
	private int result;

	@Override
	public void run() {
		result = 42;
	}

	public int getResult() {
		return result;
	}

}

class BTask implements Callable<Integer> {
	private AtomicInteger counter= new AtomicInteger();

	@Override
	public Integer call() throws Exception {
		for (var i=0;i<100_000;++i)
			//synchronized (this) {
				counter.incrementAndGet();				
			//}
		return counter.get();
	}

	public int getCounter() {
		return counter.get();
	}

}