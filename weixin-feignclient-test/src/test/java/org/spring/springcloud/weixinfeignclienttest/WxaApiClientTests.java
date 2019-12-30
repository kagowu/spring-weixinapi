package org.spring.springcloud.weixinfeignclienttest;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.qq.weixin.api.BaseRequest;
import com.qq.weixin.api.BaseResponse;
import com.qq.weixin.api.cgibin.CgibinClient;
import com.qq.weixin.api.cgibin.request.MessageSubscribeSendRequest;
import com.qq.weixin.api.wxa.WxaClient;
import com.qq.weixin.api.wxa.request.GetAuditstatusRequest;
import com.qq.weixin.api.wxa.request.GetwxacodeRequest;
import com.qq.weixin.api.wxa.request.WebviewdomainRequest;
import com.qq.weixin.api.wxa.response.GetAuditstatusResopnse;
import com.qq.weixin.api.wxaapi.WxaApiClient;
import com.qq.weixin.api.wxaapi.request.NewtmplAddtemplateRequest;
import com.qq.weixin.api.wxaapi.request.NewtmplDeltemplateRequest;
import com.qq.weixin.api.wxaapi.response.NewtmplAddtemplateResponse;
import com.qq.weixin.api.wxaapi.response.NewtmplDeltemplateResponse;
import com.qq.weixin.api.wxaapi.response.NewtmplGettemplateResponse;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WeixinFeignclientTestApplication.class)
public class WxaApiClientTests {
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
    private WxaApiClient wxaApiClient;

    private static String accessTokenMiniProgram = "";

    @Value("${test:~}")
    private String value;


    @Before
    public void before() {
        accessTokenMiniProgram = "28_eyBYJW_utH0HahhXhdWSXRVJV0O7UBQn3BjK7djoL-fUxnYU5HTwbGDBVqzyXRcUhkCkcjKiqS7iChgOF05iBgjN6LOmUhc9uVqp8hulMtQxwtx3SPdR07zilQf7rFAXM4Q4qqI8k7JWTc_DTUVfAHDZAB";
    }


    @Test
    public void newtmplAddtemplate() {
        NewtmplAddtemplateRequest request = new NewtmplAddtemplateRequest();
        request.setTid("4016");
        request.setKidList(Arrays.asList(3, 2, 1));
        request.setSceneDesc("私信接收通知");
        NewtmplAddtemplateResponse response = wxaApiClient.newtmplAddtemplate(accessTokenMiniProgram, request);
        log.info("newtmplAddtemplate:{}", response);
        Assert.notNull(response);
    }


    @Test
    public void newtmplGettemplate() {

        NewtmplGettemplateResponse newtmplGettemplateResponse = wxaApiClient.newtmplGettemplate(accessTokenMiniProgram);
        log.info("newtmplGettemplate:{}", newtmplGettemplateResponse);
        Assert.notNull(newtmplGettemplateResponse);
    }


    @Test
    public void newtmplDeltemplate() {
        NewtmplDeltemplateRequest request = new NewtmplDeltemplateRequest();
        request.setPriTmplId("n7fpYsCDFHYjMwWR47t4erxoPimfnHOt2D4JtvU0klk");
        NewtmplDeltemplateResponse response = wxaApiClient.newtmplDeltemplate(accessTokenMiniProgram, request);
        log.info("newtmplDeltemplate:{}", response);
        Assert.notNull(response);
    }


    @Test
    public void messageSubscribeSend() {

        MessageSubscribeSendRequest request = new MessageSubscribeSendRequest();
        request.setToUser("odFs75MNbLI7CXmWvg9QrJN8UGlo");
        request.setTemplateId("n7fpYsCDFHYjMwWR47t4ekpHypPknRl3Lm-PdPfI9EA");
        request.setPage("pages/index");
        request.setEmphasisKeyword(null);
        request.setData(ImmutableMap.<String, MessageSubscribeSendRequest.KeywordBean>builder()
                .put("name1", new MessageSubscribeSendRequest.KeywordBean("陈先生"))
                .put("date2", new MessageSubscribeSendRequest.KeywordBean("2019/12/20"))
                .put("thing3", new MessageSubscribeSendRequest.KeywordBean("你有一个未读消息"))
                .build());

        BaseResponse response = cgibinClient.messageSubscribeSend(accessTokenMiniProgram, request);

        log.info("messageSubscribeSend:{}", response);
        Assert.notNull(response);
    }
}

