package org.spring.springcloud.weixinfeignclienttest;

import com.qq.weixin.qyapi.cgibin.service.ServiceClient;
import com.qq.weixin.qyapi.cgibin.service.request.*;
import com.qq.weixin.qyapi.cgibin.service.response.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WeixinFeignclientTestApplication.class)
public class ServiceClientTests {

    @Autowired
    private ServiceClient serviceClient;

    @Value("${suiteId:wxf55ea18c823281db}")
    private String suiteId;

    @Value("${suiteSecret:}")
    private String suiteSecret;

    @Value("${suiteTicket:yjdoZ4ZvGiTAdSeXb5qJAihTdx6hgNAxR19ZN-tg4iUIrH58pu1FAI1oO5lT5eWb}")
    private String suiteTicket;

    @Test
    public void getSuiteToken() {
        GetSuiteTokenRequest request = new GetSuiteTokenRequest();
        request.setSuiteId(suiteId);
        request.setSuiteSecret(suiteSecret);
        request.setSuiteTicket(suiteTicket);

        GetSuiteTokenResponse response = serviceClient.getSuiteToken(request);

        log.info("getSuiteToken: {}", response);
        Assert.assertNotNull(response);
    }

    @Test
    public void getUserInfo3rd() {

        String suiteAccessToken = "fM4y_XU8qeeXKZr0LqLOSV4HjlfuXF7VyaRW-ZvkgDizerGLVwYh2_0wOgUpUYIWXlPok7NX9QitYSdc2omRwcgmKNSBv_hN3gG4_0x1K_huynmwPXbQOQ-sb8aABho_";
        String code = "ssss";
        GetUserInfo3rdResponse response = serviceClient.getUserInfo3rd(suiteAccessToken, code);

        log.info("getUserInfo3rd: {}", response);
        Assert.assertNotNull(response);
    }

    @Test
    public void getUserDetail3rd() {

        String suiteAccessToken = "fM4y_XU8qeeXKZr0LqLOSV4HjlfuXF7VyaRW-ZvkgDizerGLVwYh2_0wOgUpUYIWXlPok7NX9QitYSdc2omRwcgmKNSBv_hN3gG4_0x1K_huynmwPXbQOQ-sb8aABho_";
        GetUserDetail3rdRequest request = new GetUserDetail3rdRequest();
        request.setUserTicket("sdfsdf");
        GetUserDetail3rdGResponse response = serviceClient.getUserDetail3rd(suiteAccessToken, request);

        log.info("getUserDetail3rd: {}", response);
        Assert.assertNotNull(response);
    }

    @Test
    public void jsCode2Session() {

        String suiteAccessToken = "fM4y_XU8qeeXKZr0LqLOSV4HjlfuXF7VyaRW-ZvkgDizerGLVwYh2_0wOgUpUYIWXlPok7NX9QitYSdc2omRwcgmKNSBv_hN3gG4_0x1K_huynmwPXbQOQ-sb8aABho_";
        String code = "LixZZpiIxWfGwGxpyJ4wz7E__S5vz7xs0lY_3A6nD4s";
        JsCode2SessionResponse response = serviceClient.jsCode2Session(suiteAccessToken, code);

        log.info("jsCode2Session: {}", response);
        Assert.assertNotNull(response);
    }
}
