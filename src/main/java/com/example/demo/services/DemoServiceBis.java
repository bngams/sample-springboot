package com.example.demo.services;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class DemoServiceBis implements  IService{
    private Integer number;

    @PostConstruct
    private void init() {
        this.number = (int) (Math.random() * 100);
    }

    @Override
    public Integer getNumber() {
        return this.number;
    }
}
