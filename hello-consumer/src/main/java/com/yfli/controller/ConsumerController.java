package com.yfli.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yfli.service.ConsumerService;

@RestController
public class ConsumerController {

    //这里注入的restTemplate就是在com.sam.ConsumerApp中通过@Bean配置的实例
    @Autowired
    //RestTemplate restTemplate;
    
    ConsumerService service;

    @RequestMapping("/hello-consumer")
    public String helloConsumer() {
        //调用hello-service服务，注意这里用的是服务名，而不是具体的ip+port
        //restTemplate.getForObject("http://hello-service/hello", String.class);
        return service.consumer();
    }
}