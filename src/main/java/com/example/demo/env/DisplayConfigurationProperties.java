package com.example.demo.env;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component()
@Slf4j
public class DisplayConfigurationProperties {

    // SpeL Spring Expression Language
    // @Value("${app.token}")
    private String appToken;

    // interface Environmment
    // @Autowired
    private Environment env;

    // @Autowired
    private MapConfigurationProperties envMap;

    // @Autowired
    public DisplayConfigurationProperties(@Value("${app.token}") String appToken, Environment env, MapConfigurationProperties envMap) {
        this.appToken = appToken;
        this.env = env;
        this.envMap = envMap;
    }

    @PostConstruct
    public void init() {
        log.info("testing app.token with Value+SpeL" + this.appToken);
        log.info("testing app.token with env" + this.env.getProperty("app.token"));
        log.info("testing app.token with env map " + this.envMap.getToken());
    }
}
