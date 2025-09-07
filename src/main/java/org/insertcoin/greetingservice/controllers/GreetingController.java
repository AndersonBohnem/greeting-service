package org.insertcoin.greetingservice.controllers;

import org.insertcoin.greetingservice.configs.GreetingConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("greeting")
public class GreetingController {

//    @Value("${greeting-service.greeting}")
//    private String greeting;
//
//    @Value("${greeting-service.default-name}")
//    private String defaultName;

    public GreetingController(GreetingConfig config) {
        this.config = config;
    }

    private final GreetingConfig config;

    @GetMapping
    public ResponseEntity<String> greeting(
            @RequestParam(required = false) String name
    ) {
        String greetingReturn = config.getGreeting();
        String nameReturn = name != null ? name : config.getDefaultName();
        String textReturn = String.format("%s, %s!!!", greetingReturn, nameReturn);

        return ResponseEntity.ok(textReturn);
    }
}
