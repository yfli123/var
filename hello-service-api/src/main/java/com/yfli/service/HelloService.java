package com.yfli.service;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yfli.entity.User;

/**
 * 为了同前面那个hello 接口区分开了，我们加了refactor前缀
 *
 */
//@RequestMapping("/hello-service")
public interface HelloService {

    @RequestMapping("/hello2")
    public String hello2();
    
    @RequestMapping("/hello3")
    public User printUser(@RequestBody User user);
}