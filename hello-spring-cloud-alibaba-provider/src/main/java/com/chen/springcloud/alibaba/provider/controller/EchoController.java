package com.chen.springcloud.alibaba.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/echo/{string}")
    public String echo(@PathVariable String string) {
        return "Echo Nacos Provider " + string;
    }

    @GetMapping(value = "/hello/{string}")
    public String hello(@PathVariable String string) {
        return "Hello Nacos Provider " + string;
    }

    @GetMapping("/port")
    public String port() {
        return "Nacos Provider Server port:" + port;
    }
}
