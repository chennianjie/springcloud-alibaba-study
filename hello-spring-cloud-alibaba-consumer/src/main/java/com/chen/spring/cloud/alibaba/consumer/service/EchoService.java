package com.chen.spring.cloud.alibaba.consumer.service;


import com.chen.spring.cloud.alibaba.consumer.service.impl.EchoServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//指定服务和指定熔断类
@FeignClient(value = "service-provider", fallback = EchoServiceFallback.class)
public interface EchoService {

    @GetMapping("/echo/{string}")
    String echo(@PathVariable("string") String string);

    @GetMapping("/hello/{string}")
    String hello(@PathVariable("string") String string);

    @GetMapping("/port")
    String port();
}
