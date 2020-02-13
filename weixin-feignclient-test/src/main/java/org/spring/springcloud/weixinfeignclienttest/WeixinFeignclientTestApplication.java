package org.spring.springcloud.weixinfeignclienttest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableFeignClients(value = {"com.qq.weixin"})
@SpringBootApplication
@ComponentScan(value = {"org.spring.springcloud.weixinfeignclienttest"})
public class WeixinFeignclientTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeixinFeignclientTestApplication.class, args);
    }

}

