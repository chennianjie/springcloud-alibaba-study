package com.chen.spring.cloud.alibaba.consumer.service.impl;

import com.chen.spring.cloud.alibaba.consumer.service.EchoService;
import org.springframework.stereotype.Component;

@Component
public class EchoServiceFallback implements EchoService {

    @Override
    public String echo(String string) {
        return "echo fallback";
    }

    @Override
    public String hello(String string) {
        return "hello fallback";
    }

    @Override
    public String port() {
        return "请联系管理员";
    }
}
