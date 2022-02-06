package com.theforest.eurekaclient.controller;

import com.netflix.discovery.EurekaClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;

@Slf4j
@RestController
@RequiredArgsConstructor
public class GreetingController {
    @Lazy
    private final EurekaClient eurekaClient;

    @Value("${spring.application.name}")
    private String appName;

    @Value("${server.port}")
    private String portServer;

    @GetMapping("/greeting")
    public String greeting() {
        log.info("I'm working");
        return MessageFormat.format("Hello from {0} with port number: {1}", eurekaClient.getApplication(appName).getName(), portServer);
    }
}
