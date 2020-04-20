package com.chen.spring.cloud.alibaba.consumer.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("service-provider")
public interface EchoService {

    @GetMapping("/echo/{string}")
    String echo(@PathVariable("string") String string);

    @GetMapping("/hello/{string}")
    String hello(@PathVariable("string") String string);

    @GetMapping("/port")
    String port();
}
