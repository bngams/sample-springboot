package com.example.demo.controllers.api;

import com.example.demo.services.IService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

// @Controller + @ResponseBody
@RestController
@RequestMapping("/api/v1/scope")
@Slf4j
public class DemoScopeController {

    @Autowired
    @Qualifier("demoServiceBis")
    private IService demoService;

    @PostConstruct
    public void init() {
        log.info("DemoScopeController number value " + this.demoService.getNumber());
    }

    // /api/v1/scope/number
    @ApiOperation(httpMethod = "GET", value="Display", response = Integer.class)
    @ApiResponses({
        @ApiResponse(code = 404, message="Not found")
    })
    @GetMapping("/number")
    public ResponseEntity<Integer> displayNumber() {
        return new ResponseEntity<Integer>(this.demoService.getNumber(),HttpStatus.OK);
    }
}
