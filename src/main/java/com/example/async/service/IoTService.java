package com.example.async.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class IoTService {

    @Async
    public CompletableFuture<Double> fetchTemperatureFromDevice(String deviceId, long delayInSec) {
        // Simulate fetching temperature from IoT device
        double temperature = Math.random() * 100;
        long milliseconds = delayInSec * 1000;

        // Simulate network latency
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        log.info("Device {}, Temperature:{}", deviceId, temperature);
        return CompletableFuture.completedFuture(temperature);
    }

}
