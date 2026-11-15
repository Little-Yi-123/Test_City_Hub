package com.hmdp;

import cn.hutool.json.JSONUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(exposeProxy = true)
@MapperScan("com.hmdp.mapper")
@SpringBootApplication
public class HmDianPingApplication {
    // 这是一条测试git提交+回溯的注释
    public static void main(String[] args) {
        SpringApplication.run(HmDianPingApplication.class, args);
    }

}
