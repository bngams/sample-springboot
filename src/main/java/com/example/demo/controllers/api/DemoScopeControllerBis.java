package com.example.demo.controllers.api;

import com.example.demo.services.IService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@Slf4j
@RequestMapping("/api/v1/scope-bis")
public class DemoScopeControllerBis {
    @Autowired
    private IService demoService;

    @PostConstruct
    public void init() {
        log.info("DemoScopeControllerBis number value " + this.demoService.getNumber());
    }

    @GetMapping("/number")
    public ResponseEntity<Integer> displayNumber() {
        return new ResponseEntity<Integer>(this.demoService.getNumber(), HttpStatus.OK);
    }
}
