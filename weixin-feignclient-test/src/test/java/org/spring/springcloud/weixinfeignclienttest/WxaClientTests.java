package org.spring.springcloud.weixinfeignclienttest;

import com.alibaba.fastjson.JSON;
import com.qq.weixin.api.cgibin.CgibinClient;
import com.qq.weixin.api.cgibin.request.*;
import com.qq.weixin.api.cgibin.response.ComponentApiCreatePreauthcodeResponse;
import com.qq.weixin.api.cgibin.response.ComponentApiQueryAuthResponse;
import com.qq.weixin.api.cgibin.response.ComponentTokenResponse;
import com.qq.weixin.api.cgibin.response.TokenResponse;
import com.qq.weixin.api.wxa.WxaClient;
import com.qq.weixin.api.wxa.request.GetwxacodeRequest;
import lombok.val;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WeixinFeignclientTestApplication.class)
public class WxaClientTests {
    @Autowired
    StringRedisTemplate redisTemplate;

    ValueOperations<String, String> stringRedis;

    @PostConstruct
    public void init() {
        stringRedis = redisTemplate.opsForValue();
    }


    @Autowired
    private CgibinClient cgibinClient;
    @Autowired
    private WxaClient wxaClient;

    private static String accessTokenMiniProgram = "";

    private static final String appidMiniProgram = "wxcc52a334768b73ef";
    private static final String appsecretMiniProgram = "a536b0f381f099f7ace0904cbdd62ec7";


    @Before
    public void before() {
        accessTokenMiniProgram = stringRedis.get("org.spring.springcloud.weixinfeignclienttest.CgibinClientTests#accessTokenMiniProgram");

    }


    @Test
    public void token() {
        TokenResponse response = cgibinClient.token(appidMiniProgram, appsecretMiniProgram);
        stringRedis.set("org.spring.springcloud.weixinfeignclienttest.CgibinClientTests#accessTokenMiniProgram", response.getAccessToken());

    }

    @Test
    public void test() {
        GetwxacodeRequest getwxacodeRequest = new GetwxacodeRequest();
        getwxacodeRequest.setPath("/");
        wxaClient.getwxacode(accessTokenMiniProgram, getwxacodeRequest);
    }


}

