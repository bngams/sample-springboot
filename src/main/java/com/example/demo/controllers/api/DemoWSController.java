package com.example.demo.controllers.api;

import com.example.demo.models.Quote;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("/api/v1/ws")
public class DemoWSController {

    @GetMapping("/quotes")
    public void fetchQuotes() {
        RestTemplate restTemplate = new RestTemplate();
        Quote q = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        log.info(q.toString());
    }
}
