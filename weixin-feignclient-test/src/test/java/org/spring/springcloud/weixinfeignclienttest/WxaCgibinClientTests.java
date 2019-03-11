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
import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WeixinFeignclientTestApplication.class)
public class WxaCgibinClientTests {
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
    private static final String componentAppid = "wxb5520b267480440f";
    private static final String componentSecret = "10c1bde9468906b5a981302136cacf37";
    private static String componentVerifyTicket = "";
    private static final String appidMiniProgram = "wx7b4870cde75f4e5d";
    private static final String appsecretMiniProgram = "6f2369d687e62076c8f201da680548f3";


    @Before
    public void before() {
        accessToken = stringRedis.get("org.spring.springcloud.weixinfeignclienttest.WxaCgibinClientTests#accessToken");
        preAuthCode = stringRedis.get("org.spring.springcloud.weixinfeignclienttest.WxaCgibinClientTests#preAuthCode");
        componentToken = stringRedis.get("marketing_microshop:wx_component_access_token");
        if (componentToken != null) {
            componentToken = componentToken.replace("\"", "");
        }
        authorizerAccessToken = stringRedis.get("org.spring.springcloud.weixinfeignclienttest.WxaCgibinClientTests#authorizerAccessToken");
        authorizerRefreshToken = stringRedis.get("org.spring.springcloud.weixinfeignclienttest.WxaCgibinClientTests#authorizerRefreshToken");

    }

    @Test
    public void componentApiComponentToken() {
        val componentTokenRequest = new ComponentTokenRequest();
        componentTokenRequest.setComponentAppid(componentAppid);
        componentTokenRequest.setComponentAppsecret(componentSecret);
        componentTokenRequest.setComponentVerifyTicket(componentVerifyTicket);
        ComponentTokenResponse response = cgibinClient.componentApiComponentToken(componentTokenRequest);
        stringRedis.set("org.spring.springcloud.weixinfeignclienttest.WxaCgibinClientTests#componentAccessToken", response.getComponentAccessToken());

    }

    @Test
    public void componentApiCreatePreauthcode() {
        val request = new ComponentApiCreatePreauthcodeRequest();
        request.setComponentAppid(componentAppid);
        ComponentApiCreatePreauthcodeResponse response = cgibinClient.componentApiCreatePreauthcode(componentToken, request);
        stringRedis.set("org.spring.springcloud.weixinfeignclienttest.WxaCgibinClientTests#preAuthCode", response.getPreAuthCode());
    }

    @Test
    public void componentApiGetAuthorizerInfo() {
        val request = new ComponentApiGetAuthorizerInfoRequest();
        request.setAuthorizerAppid("wx01fa97816dcd707c");
        request.setComponentAppid(componentAppid);
        cgibinClient.componentApiGetAuthorizerInfo(componentToken, request);


    }


    @Test
    public void componentApiQueryAuth() {
        ComponentApiQueryAuthRequest componentApi_query_authRequest = new ComponentApiQueryAuthRequest();
        componentApi_query_authRequest.setComponentAppid(componentAppid);
        componentApi_query_authRequest.setAuthorizationCode("");
        ComponentApiQueryAuthResponse response = cgibinClient.componentApiQueryAuth(componentToken, componentApi_query_authRequest);
        stringRedis.set("org.spring.springcloud.weixinfeignclienttest.WxaCgibinClientTests#authorizerAccessToken", response.getAuthorizationInfo().getAuthorizerAccessToken());
        stringRedis.set("org.spring.springcloud.weixinfeignclienttest.WxaCgibinClientTests#authorizerRefreshToken", response.getAuthorizationInfo().getAuthorizerRefreshToken());

    }

    @Test
    public void componentApiAuthorizerToken() {
        ComponentApiAuthorizerTokenRequest componentApiAuthorizerTokenRequest = new ComponentApiAuthorizerTokenRequest();
        componentApiAuthorizerTokenRequest.setAuthorizerAppid(appidMiniProgram);
        componentApiAuthorizerTokenRequest.setAuthorizerRefreshToken(stringRedis.get("org.spring.springcloud.weixinfeignclienttest.WxaCgibinClientTests#authorizerRefreshToken"));
        componentApiAuthorizerTokenRequest.setComponentAppid(componentAppid);
        cgibinClient.componentApiAuthorizerToken(componentToken, componentApiAuthorizerTokenRequest);

    }


    @Test
    public void token() {
        TokenResponse response = cgibinClient.token(appidMiniProgram, appsecretMiniProgram);
        stringRedis.set("org.spring.springcloud.weixinfeignclienttest.WxaCgibinClientTests#accessToken", response.getAccessToken());

    }


    @Test
    public void messageCustomSendMiniprogrampage() {
        MessageCustomSendBaseRequest.MiniprogrampageMessage miniprogrampageMessage = new MessageCustomSendBaseRequest.MiniprogrampageMessage();
        miniprogrampageMessage.setMiniprogrampage(new MessageCustomSendBaseRequest.Miniprogrampage("hello","/page/","https://developers.weixin.qq.com/sandbox?tab=miniprogram&hl=zh","2Rb8kLek2RbW8-dBWSAPnL1zHoq5B7zWYeyb1FSo_U4n_-TxPcAzSlQgqWeJ8ULP"));
        miniprogrampageMessage.setTouser("o1i3qs2kVNHty34G2reV1CRs5mds");
        cgibinClient.messageCustomSend(accessToken, miniprogrampageMessage);
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
    public void componentFastregisterweappSearch() {
        ComponentFastregisterweappSearchRequest request =new ComponentFastregisterweappSearchRequest();
        request.setLegalPersonaName("陈志雄");
        request.setLegalPersonaWechat("zxpole");
        request.setName("上海巧房信息科技有限公司");
        cgibinClient.componentFastregisterweappSearch("19_1zJlyOCShI7uvslE9EuOvrbTK44TGviCmgEBvfMPhwEEaWu0YY1bEiV82DcE0rFuB1133ko9hjxipJlW08hIrEvf-5x1jSFkV8USWXIQ6vDS9rwKW-_3ynNNf_lPfdeElcVQzXaDJ9jPGPMwNBQgAJAZNC",request);

    }

    @Test
    public void componentFastregisterweappCreate() {
        ComponentFastregisterweappCreateRequest componentFastregisterweappSearchRequest = new ComponentFastregisterweappCreateRequest();
        componentFastregisterweappSearchRequest.setName("上海巧房信息科技有限公司");
        componentFastregisterweappSearchRequest.setCode("91310115076402567D");
        componentFastregisterweappSearchRequest.setCodeType("1");
        componentFastregisterweappSearchRequest.setLegalPersonaName("陈志雄");
        componentFastregisterweappSearchRequest.setLegalPersonaWechat("zxpole");
        componentFastregisterweappSearchRequest.setComponentPhone("15216884283");
        cgibinClient.componentFastregisterweappCreate("19_1zJlyOCShI7uvslE9EuOvrbTK44TGviCmgEBvfMPhwEEaWu0YY1bEiV82DcE0rFuB1133ko9hjxipJlW08hIrEvf-5x1jSFkV8USWXIQ6vDS9rwKW-_3ynNNf_lPfdeElcVQzXaDJ9jPGPMwNBQgAJAZNC",
                componentFastregisterweappSearchRequest);
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
        cgibinClient.ticketGetticket(accessToken);
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
        cgibinClient.accountGetaccountbasicinfo(accessToken);
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

