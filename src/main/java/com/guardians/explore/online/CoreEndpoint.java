package com.guardians.explore.online;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@EnableAutoConfiguration
public class CoreEndpoint {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }
}
