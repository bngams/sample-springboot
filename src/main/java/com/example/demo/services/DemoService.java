package com.example.demo.services;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
// @Scope("singleton")
public class DemoService implements IService{
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
