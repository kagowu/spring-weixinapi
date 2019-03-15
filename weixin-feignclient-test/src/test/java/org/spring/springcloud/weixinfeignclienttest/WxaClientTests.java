package org.spring.springcloud.weixinfeignclienttest;

import com.alibaba.fastjson.JSON;
import com.qq.weixin.api.BaseRequest;
import com.qq.weixin.api.cgibin.CgibinClient;
import com.qq.weixin.api.cgibin.request.*;
import com.qq.weixin.api.cgibin.response.ComponentApiCreatePreauthcodeResponse;
import com.qq.weixin.api.cgibin.response.ComponentApiQueryAuthResponse;
import com.qq.weixin.api.cgibin.response.ComponentTokenResponse;
import com.qq.weixin.api.cgibin.response.TokenResponse;
import com.qq.weixin.api.wxa.WxaClient;
import com.qq.weixin.api.wxa.request.GetwxacodeRequest;
import com.qq.weixin.api.wxa.request.ModifyDomainRequest;
import com.qq.weixin.api.wxa.request.WebviewdomainRequest;
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
import java.io.IOException;
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

    private static final String appidMiniProgram = "wx7b4870cde75f4e5d";
    private static final String appsecretMiniProgram = "6f2369d687e62076c8f201da680548f3";
    private static String componentToken = "";


    @Before
    public void before() {
        accessTokenMiniProgram ="19_NAC5fc51WwJWkLR9F1AFQ21lCwSLEbhe6iWv02Zr1Wp3vz7bqhhN3Esxp43CVlS-Ahtl2Lt7Hx11NlMmFdswQV6ARC3RiOlVFMhq7QfdiYFJ4u2R1KkcxSufHeTva5a9R5oSKMginHJXgZRKAKMbAEDUEG";
        componentToken = stringRedis.get("marketing_microshop:wx_component_access_token");
        if (componentToken != null) {
            componentToken = componentToken.replace("\"", "");
        }
    }




    @Test
    public void getwxacode() throws IOException {
        GetwxacodeRequest getwxacodeRequest = new GetwxacodeRequest();
        getwxacodeRequest.setPath("/");
        wxaClient.getwxacodeWrapper(accessTokenMiniProgram, getwxacodeRequest);
    }

    @Test
    public void setwebviewdomain() {
        WebviewdomainRequest webviewdomainRequest = new WebviewdomainRequest();
        webviewdomainRequest.setWebviewdomain(Arrays.asList("http://marketingwmd.dev.qiaofangyun.com"));
        wxaClient.setwebviewdomain(accessTokenMiniProgram, webviewdomainRequest);
    }


    @Test
    public void gettemplatedraftlist(){
        wxaClient.gettemplatedraftlist(componentToken);
    }

    @Test
    public void gettemplatelist(){
        wxaClient.gettemplatelist(componentToken);
    }

    @Test
    public void release(){
        wxaClient.release(accessTokenMiniProgram,new BaseRequest());
    }
}

