package org.spring.springcloud.weixinfeignclienttest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients(value = {"com.qq.weixin.api"})
@SpringBootApplication
public class WeixinFeignclientTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeixinFeignclientTestApplication.class, args);
    }

}

