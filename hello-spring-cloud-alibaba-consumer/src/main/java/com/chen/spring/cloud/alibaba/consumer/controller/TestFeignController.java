package com.chen.spring.cloud.alibaba.consumer.controller;


import com.chen.spring.cloud.alibaba.consumer.service.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestFeignController {

    @Autowired
    private EchoService echoService;

    @GetMapping("feign/echo/{string}")
    public String echo(@PathVariable("string") String string){
        return echoService.echo(string);
    }

    @GetMapping("feign/hello/{string}")
    public String hello(@PathVariable("string") String string){
        return echoService.hello(string);
    }

    /**
     * 测试负载均衡，注意配置idea可启动多个相同实例
     * @return
     */
    @GetMapping("feign/port")
    public String port(){
        return echoService.port();
    }

    /**
     * 测试nacos动态配置
     */
    @Autowired
    @Value("${user.name}")
    private String username;
    @GetMapping(value = "/config")
    public String config() {
        return echoService.echo(username);
    }
}
