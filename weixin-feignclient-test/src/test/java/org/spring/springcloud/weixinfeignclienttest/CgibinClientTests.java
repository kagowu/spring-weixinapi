package org.spring.springcloud.weixinfeignclienttest;

import com.alibaba.fastjson.JSON;
import com.qq.weixin.api.cgibin.CgibinClient;
import com.qq.weixin.api.cgibin.request.*;
import com.qq.weixin.api.cgibin.response.*;
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

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WeixinFeignclientTestApplication.class)
public class CgibinClientTests {
    @Autowired
    StringRedisTemplate redisTemplate;

    ValueOperations<String, String> stringRedis;

    @PostConstruct
    public void init() {
        stringRedis = redisTemplate.opsForValue();
    }


    @Autowired
    private CgibinClient cgibinClient;

    private static String accessToken = "";
    private static String componentToken = "";
    private static String preAuthCode = "";
    private static String authorizerAccessToken = "";
    private static String authorizerRefreshToken = "";
    private static String componentAccessToken = "";
    private static final String componentAppid = "wxe3987587f06091cf";
    private static final String componentSecret = "10c1bde9468906b5a981302136cacf37";
    private static String componentVerifyTicket = "";


    private Object response;
    private Object req;

    @Before
    public void before() {
        accessToken = stringRedis.get("org.spring.springcloud.weixinfeignclienttest.CgibinClientTests#accessToken");
        componentToken = stringRedis.get("org.spring.springcloud.weixinfeignclienttest.CgibinClientTests#componentToken");
        preAuthCode = stringRedis.get("org.spring.springcloud.weixinfeignclienttest.CgibinClientTests#preAuthCode");
        componentVerifyTicket = stringRedis.get("org.spring.springcloud.weixinfeignclienttest.CgibinClientTests#componentVerifyTicket");
        authorizerAccessToken = stringRedis.get("org.spring.springcloud.weixinfeignclienttest.CgibinClientTests#authorizerAccessToken");
        authorizerRefreshToken = stringRedis.get("org.spring.springcloud.weixinfeignclienttest.CgibinClientTests#authorizerRefreshToken");
        componentAccessToken = stringRedis.get("org.spring.springcloud.weixinfeignclienttest.CgibinClientTests#componentAccessToken");

    }

    @After
    public void after() {
        System.out.println(JSON.toJSONString(req, true));
        System.err.println(JSON.toJSONString(response, true));
    }


    @Test
    public void componentApi_create_preauthcode() {
        val request = new ComponentApiCreatePreauthcodeRequest();
        request.setComponentAppid(componentAppid);
        ComponentApiCreatePreauthcodeResponse response = cgibinClient.componentApiCreatePreauthcode(componentToken, request);
        stringRedis.set("org.spring.springcloud.weixinfeignclienttest.CgibinClientTests#preAuthCode", response.getPreAuthCode());
        req = request;
    }

    @Test
    public void componentApi_get_authorizer_info() {
        val request = new ComponentApiGetAuthorizerInfoRequest();
        request.setAuthorizerAppid("wx01fa97816dcd707c");
        request.setComponentAppid(componentAppid);
        response = cgibinClient.componentApiGetAuthorizerInfo(componentToken, request);

        req = request;
    }


    @Test
    public void componentApi_query_auth() {
        ComponentApiQueryAuthRequest componentApi_query_authRequest = new ComponentApiQueryAuthRequest();
        componentApi_query_authRequest.setComponentAppid("wxb5520b267480440f");
        componentApi_query_authRequest.setAuthorizationCode("");
        ComponentApiQueryAuthResponse response = cgibinClient.componentApiQueryAuth(componentToken, componentApi_query_authRequest);
        stringRedis.set("org.spring.springcloud.weixinfeignclienttest.CgibinClientTests#authorizerAccessToken", response.getAuthorizationInfo().getAuthorizerAccessToken());
        stringRedis.set("org.spring.springcloud.weixinfeignclienttest.CgibinClientTests#authorizerRefreshToken", response.getAuthorizationInfo().getAuthorizerRefreshToken());

        req = componentApi_query_authRequest;

    }


    @Test
    public void componentApiComponentToken() {
        val componentTokenRequest = new ComponentTokenRequest();
        componentTokenRequest.setComponentAppid(componentAppid);
        componentTokenRequest.setComponentAppsecret(componentSecret);
        componentTokenRequest.setComponentVerifyTicket(componentVerifyTicket);
        ComponentTokenResponse response = cgibinClient.componentApiComponentToken(componentTokenRequest);
        stringRedis.set("org.spring.springcloud.weixinfeignclienttest.CgibinClientTests#componentAccessToken", response.getComponentAccessToken());

        req = componentTokenRequest;
    }

    @Test
    public void componentFastregisterweappSearch() {
        response = cgibinClient.componentFastregisterweappSearch(componentToken,
                null);
    }


    @Test
    public void token() {
        TokenResponse response = cgibinClient.token("wxe57e8b54cbe75bd0", "22642be432f7849be45956de461333c8");
        stringRedis.set("org.spring.springcloud.weixinfeignclienttest.CgibinClientTests#accessToken", response.getAccessToken());

    }

    @Test
    public void menuCreate() {
        val request = new MenuCreateRequest();
        MenuCreateRequest.ViewButton viewButton = new MenuCreateRequest.ViewButton();
        viewButton.setUrl("http://www.baidu.com");
        viewButton.setName("test");
        MenuCreateRequest.ClickButton viewButton1 = new MenuCreateRequest.ClickButton();
        viewButton1.setUrl("http://www.baidu.com");
        viewButton1.setName("test1");
        viewButton1.setKey("key1");
        MenuCreateRequest.ClickButton viewButton2 = new MenuCreateRequest.ClickButton();
        viewButton2.setUrl("http://www.baidu.com");
        viewButton2.setName("test2");
        viewButton2.setKey("key2");
        viewButton.setSubButtons(new MenuCreateRequest.Button[]{viewButton1, viewButton2});
        request.setButton(new MenuCreateRequest.Button[]{viewButton});
        System.err.println(JSON.toJSONString(request, true));
        response = cgibinClient.menuCreate(accessToken, request);
        System.err.println(JSON.toJSONString(request, true));

    }

    @Test
    public void menuGet() {
        response = cgibinClient.menuGet(accessToken);
    }

    @Test
    public void qrcodeCreate() {
        val qrcodeCreateRequest = new QrcodeCreateRequest();
        cgibinClient.qrcodeCreateTemp(accessToken, 864000, 123);
        req = qrcodeCreateRequest;
    }


    @Test
    public void componentApi_set_authorizer_option() {
    }

    @Test
    public void componentApi_get_authorizer_option() {
    }

    @Test
    public void componentClear_quota() {
    }

    @Test
    public void componentFastregisterweappCreate() {
    }


    @Test
    public void expressBusinessDeliveryGetall() {
    }

    @Test
    public void expressBusinessOrderAdd() {
    }

    @Test
    public void expressBusinessOrderCancel() {
    }

    @Test
    public void expressBusinessOrderGet() {
    }

    @Test
    public void expressBusinessPathGetall() {
    }

    @Test
    public void expressBusinessQuotaGet() {
    }

    @Test
    public void expressDeliveryContactGet() {
    }

    @Test
    public void expressDeliveryPathUpdate() {
    }

    @Test
    public void expressDeliveryserviceBusinessUpdate() {
    }

    @Test
    public void expressDeliveryTemplatePreview() {
    }

    @Test
    public void mediaGet() {
    }

    @Test
    public void mediaUpload() {
    }

    @Test
    public void menuAddconditional() {
    }


    @Test
    public void menuDelete() {
    }


    @Test
    public void messageCustomSend() {
    }

    @Test
    public void messageCustomTyping() {
    }

    @Test
    public void messageWxopenActivityidCreate() {
    }

    @Test
    public void messageWxopenTemplateSend() {
    }

    @Test
    public void messageWxopenTemplateUniform_send() {
    }

    @Test
    public void messageWxopenUpdatablesgSend() {
    }

    @Test
    public void openBind() {
    }

    @Test
    public void openCreate() {
    }

    @Test
    public void openGet() {
    }

    @Test
    public void openUnbind() {
    }


    @Test
    public void templateApi_set_industry() {
    }

    @Test
    public void ticketGetticket() {
        response = cgibinClient.ticketGetticket(accessToken);
    }


    @Test
    public void wxaappCreatewxaqrcode() {
    }

    @Test
    public void wxopenAddcategory() {
    }

    @Test
    public void wxopenDeletecategory() {
    }

    @Test
    public void wxopenGetallcategories() {
    }

    @Test
    public void wxopenGetcategory() {
    }

    @Test
    public void wxopenGetweappsupportversion() {
    }

    @Test
    public void wxopenModifycategory() {
    }

    @Test
    public void wxopenQrcodejumpadd() {
    }

    @Test
    public void wxopenQrcodejumpdelete() {
    }

    @Test
    public void wxopenQrcodejumpdownload() {
    }

    @Test
    public void wxopenQrcodejumpget() {
    }

    @Test
    public void wxopenQrcodejumppublish() {
    }

    @Test
    public void wxopenSetweappsupportversion() {
    }

    @Test
    public void wxopenTemplateDel() {
    }

    @Test
    public void wxopenTemplateLibararyAdd() {
    }

    @Test
    public void wxopenTemplateLibararyGet() {
    }

    @Test
    public void wxopenTemplateLibararyList() {
    }

    @Test
    public void wxopenTemplateList() {
    }

    @Test
    public void wxopenWxamplink() {
    }

    @Test
    public void wxopenWxamplinkget() {
    }

    @Test
    public void wxopenWxampunlink() {
    }

    @Test
    public void wxverifyCheckwxverifynickname() {
    }


    @Test
    public void accountComponentrebindadmin() {
    }

    @Test
    public void accountFastregister() {
    }

    @Test
    public void accountGetaccountbasicinfo() {
    }

    @Test
    public void accountModifyheadimage() {
    }

    @Test
    public void accountModifysignature() {
    }

    @Test
    public void clear_quota() {
    }

    @Test
    public void componentApi_authorizer_token() {
    }
}

