package com.example.async;

import com.example.async.service.IoTService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class AsyncApplication {

	@Autowired
	private IoTService ioTService;

	public static void main(String[] args) {
		SpringApplication.run(AsyncApplication.class, args);
	}

	@PostConstruct
	public void testService(){
		ioTService.fetchTemperatureFromDevice("1", 10);
		ioTService.fetchTemperatureFromDevice("2", 2);
		ioTService.fetchTemperatureFromDevice("3", 6);
		ioTService.fetchTemperatureFromDevice("4", 8);
		ioTService.fetchTemperatureFromDevice("5", 4);
	}
}
