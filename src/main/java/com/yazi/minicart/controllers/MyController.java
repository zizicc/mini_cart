package com.yazi.minicart.controllers;

//import lombok.Value;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@PropertySource(value = "classpath:application.properties")
//@Configuration
//@Component
//@RestController("/my")

@RestController
@RequestMapping("/my")
public class MyController {

    @Value("${my.website.name}")
    private String myWebsiteName;

    @GetMapping ("/welcome")
    public String welcome() {
        return "Welcome to " + myWebsiteName;
    }
}
