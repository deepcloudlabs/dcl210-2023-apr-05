package com.example.lottery.application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.ServiceLoader;

import com.example.lottery.service.business.StandardLotteryService;
import com.example.random.service.Quality;
import com.example.random.service.QualityLevel;
import com.example.random.service.RandomNumberService;

public class LotteryApplication {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		var lotteryService = new StandardLotteryService();
		var randomNumberServices = ServiceLoader.load(RandomNumberService.class);
		var props = new Properties();
		props.load(new FileInputStream(new File("src","application.properties")));
		var qualityLevel = QualityLevel.valueOf(props.getProperty("random.service"));
		RandomNumberService randomNumberService = null;
		for (var randomNumberServiceImpl : randomNumberServices) {
			Class<?> clazz = randomNumberServiceImpl.getClass();
			if (clazz.isAnnotationPresent(Quality.class)) {
				var quality = clazz.getAnnotation(Quality.class);
				if (quality.value().equals(qualityLevel)) {
					randomNumberService = randomNumberServiceImpl;
					break;
				}
			}
		}
		lotteryService.setRandomNumberService(randomNumberService);
		lotteryService.draw(60, 6, 10)
		              .forEach(System.out::println);
	}

}
