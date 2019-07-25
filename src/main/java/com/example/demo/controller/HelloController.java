package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class HelloController {

    private final static String UNKNOWN_ARTIST = "unknown artist";
    private final static String UNKNOWN_SONG = "unknown song";

    @GetMapping("")
    public String helloAge(@RequestParam(value = "artist", required = false) String artistName,
                           @RequestParam(value = "titel", required = false) String songTitel,
                           Model model) {

        if (artistName == null) {
            artistName = UNKNOWN_ARTIST;
        }

        if (songTitel == null) {
            songTitel = UNKNOWN_SONG;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        model.addAttribute("time", LocalDateTime.now().format(formatter));
        model.addAttribute("artist", artistName);
        model.addAttribute("titel", songTitel);

        return "index"; // index.html
    }

}



