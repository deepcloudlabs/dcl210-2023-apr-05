package com.example.application;

import java.util.concurrent.TimeUnit;

import com.example.service.BusinessService;

public class AsyncBusinessApplication {

	public static void main(String[] args) {
		System.out.println("[%s] Business Application is just started.".formatted(Thread.currentThread().getName()));
		var businessService = new BusinessService();
		for (var i=0;i<10;++i)
			businessService.doAsyncBusiness()
			               .thenAcceptAsync(result -> System.out.println("[%s][%d] Result is %d".formatted(Thread.currentThread().getName(),i,result)));
		System.out.println("[%s] Business Application is just completed.".formatted(Thread.currentThread().getName()));
		try {TimeUnit.SECONDS.sleep(10);}catch (Exception e) {}
	}

}
