package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class HelloController {

    private final static String UNKNOWN_USER = "unknown";
    private final static String UNKNOWN_AGE = "unknown";

    @GetMapping("")
    public String helloAge(@RequestParam(value = "naam", required = false) String name,
                           @RequestParam(value = "leeftijd", required = false) String age,
                           Model model) {

        if (name == null) {
            name = UNKNOWN_USER;
        }

        if (age == null) {
            age = UNKNOWN_AGE;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        model.addAttribute("time", LocalDateTime.now().format(formatter));
        model.addAttribute("name", name);
        model.addAttribute("age", age);

        return "index"; // index.html
    }

}



