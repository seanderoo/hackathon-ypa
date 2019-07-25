package com.example.demo.controller;

import com.example.demo.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
public class audioToText {

    @Autowired
    private SongRepository songRepository;

    @GetMapping(value = "/api/text")
    public WebhookResponse testMethode() {

        List<WebhookResponse> webhookResponseList = songRepository.findAll();

        Collections.reverse(webhookResponseList);
        System.out.println("last entry: " + webhookResponseList.get(0).getSong());

        WebhookResponse webhookResponse = webhookResponseList.get(0);

        return webhookResponse;
    }

    @PostMapping(value = "/webhook")
    public WebhookResponse testMethode2(@RequestBody Map<String, Object> result) {
        // lees artist en title uit
        Map<String, Object> queryResult = (Map) result.get("queryResult");
        Map<String, Object> parameters = (Map) queryResult.get("parameters");

        String artist = (String) parameters.get("music-artist");
        String title = (String) parameters.get("any");

        System.out.println("artist: " + artist);
        System.out.println("title: " + title);

        WebhookResponse webhookResponse = new WebhookResponse(artist, title);

        songRepository.save(webhookResponse);

        return webhookResponse;
    }

}
