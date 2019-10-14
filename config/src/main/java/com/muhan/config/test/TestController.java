package com.muhan.config.test;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class TestController {
//mvn install:install-file -Dfile=C:\theme\spire.pdf-2.7.8.jar -DgroupId=e-iceblue -DartifactId=spire.pdf -Dversion=2.7.8 -Dpackaging=jar
    @Value("${test.name}")
    private String name;
    @Value("${test.age}")
    private int age;

    @RequestMapping("/test")
    @SentinelResource(blockHandler = "handleException", blockHandlerClass = ExceptionUtil.class)
    public String test(){
        return name;
    }
}