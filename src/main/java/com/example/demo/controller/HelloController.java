package com.example.demo.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {

    private final static String UNKNOWN_ARTIST = "unknown artist";
    private final static String UNKNOWN_SONG = "unknown song";

    @PostMapping("")
    @JsonProperty("parameters")
    public String helloAge(@RequestParam(value = "artist", required = false) String artistName,
                           @RequestParam(value = "song", required = false) String songTitel,
                           HttpServletRequest request,
                           Model model) {

        System.out.println(request);
        System.out.println(songTitel);

        if (artistName == null) {
            artistName = UNKNOWN_ARTIST;
        }

        if (songTitel == null) {
            songTitel = UNKNOWN_SONG;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        model.addAttribute("time", LocalDateTime.now().format(formatter));
        model.addAttribute("artist", artistName);
        model.addAttribute("song", songTitel);

        return "index"; // index.html
    }

    @GetMapping("headers")
    public String headerList(HttpServletRequest request, Model model){

        Map<String, String> map = new HashMap<>();

        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String key = headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }

        model.addAttribute("map", map);

        return "headers";
    }



}



