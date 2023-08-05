package com.example.async.controller;

import com.example.async.service.IoTService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
@RestController
public class IoTController {

    @Autowired
    private IoTService ioTService;

    @GetMapping("/fetch-temperatures")
    public ResponseEntity<String> fetchTemperatures(@RequestParam(required = true) String deviceId,
                                                    @RequestParam(required = true) long delayInSec)
            throws InterruptedException, ExecutionException {
        String deviceName = "Device " + deviceId;
        CompletableFuture<Double> deviceTemperature = ioTService.fetchTemperatureFromDevice(deviceName, delayInSec);
        double temperature = deviceTemperature.get();
        String msg = deviceName +" Temperature:" + temperature + "°C";
        System.out.println(msg);
        return ResponseEntity.ok(msg);
    }

}

