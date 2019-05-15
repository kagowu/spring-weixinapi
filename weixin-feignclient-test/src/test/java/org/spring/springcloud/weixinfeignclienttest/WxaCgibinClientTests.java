package org.spring.springcloud.weixinfeignclienttest;

import com.qq.weixin.api.BaseRequest;
import com.qq.weixin.api.cgibin.CgibinClient;
import com.qq.weixin.api.cgibin.request.*;
import com.qq.weixin.api.cgibin.response.*;
import com.qq.weixin.api.wxa.WxaClient;
import lombok.val;
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

    private static final String componentAppid = "wxe3987587f06091cf";
    private static final String componentSecret = "10c1bde9468906b5a981302136cacf37";
    private static String componentVerifyTicket = "";
    private static final String appidMiniProgram = "wx7b4870cde75f4e5d";
    private static final String appsecretMiniProgram = "6f2369d687e62076c8f201da680548f3";


    @Before
    public void before() {
//        accessToken = stringRedis.get("org.spring.springcloud.weixinfeignclienttest.WxaCgibinClientTests#accessToken");
        accessToken = "19_Tvqf5ABboqObWYDv0wLGv0P52XgYT4-LD88KHLYhuy6n59bY5yjGkHVraKoxxwXR-Hio-R7G-fkVoUtRJT0C8bMnQ_iVsTCibv8sQf1OLxnC3tjwUmOqlhC6_0pq89piK0MMQjk8Y6UMXMMLGHQeADDABK";
        accessToken = "19_NAC5fc51WwJWkLR9F1AFQ21lCwSLEbhe6iWv02Zr1Wp3vz7bqhhN3Esxp43CVlS-Ahtl2Lt7Hx11NlMmFdswQV6ARC3RiOlVFMhq7QfdiYFJ4u2R1KkcxSufHeTva5a9R5oSKMginHJXgZRKAKMbAEDUEG";
        preAuthCode = stringRedis.get("org.spring.springcloud.weixinfeignclienttest.WxaCgibinClientTests#preAuthCode");
        componentToken = stringRedis.get("marketing_microshop:wx_component_access_token");
        if (componentToken != null) {
            componentToken = componentToken.replace("\"", "");
        }


    }

    @Test
    public void componentApiComponentToken() {
        val componentTokenRequest = new ComponentTokenRequest();
        componentTokenRequest.setComponentAppid("wxe3987587f06091cf");
        componentTokenRequest.setComponentAppsecret("10c1bde9468906b5a981302136cacf37");
        componentTokenRequest.setComponentVerifyTicket("ticket@@@I6OER8I_JH99MsblkGDtfryEH59AmB4J_n8RKxM2IT1Bj5VrUqK3WS4BK5Os7dsfLT2SLAEQzl9Kp_H23w9Vaw");
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
        request.setAuthorizerAppid("wxea1e46a5ed94489a");
        request.setComponentAppid(componentAppid);
        cgibinClient.componentApiGetAuthorizerInfo(componentToken, request);


    }

    @Test
    public void apiGetAuthorizerList() {
        val request = new ApiGetAuthorizerListRequest();
        request.setComponentAppid(componentAppid);
        ApiGetAuthorizerListResponse response = cgibinClient.apiGetAuthorizerList(componentToken, request);
        System.out.println(response);

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
        miniprogrampageMessage.setMiniprogrampage(new MessageCustomSendBaseRequest.Miniprogrampage("hello", "/page/", "https://developers.weixin.qq.com/sandbox?tab=miniprogram&hl=zh", "2Rb8kLek2RbW8-dBWSAPnL1zHoq5B7zWYeyb1FSo_U4n_-TxPcAzSlQgqWeJ8ULP"));
        miniprogrampageMessage.setTouser("o1i3qs2kVNHty34G2reV1CRs5mds");
        cgibinClient.messageCustomSend(accessToken, miniprogrampageMessage);
    }

    @Test
    public void componentApi_set_authorizer_option() {
        ComponentApiSetAuthorizerOptionRequest componentApiSetAuthorizerOptionRequest = new ComponentApiSetAuthorizerOptionRequest();
        cgibinClient.componentApiSetAuthorizerOption(componentToken,componentApiSetAuthorizerOptionRequest);
    }

    @Test
    public void componentApi_get_authorizer_option() {
    }

    @Test
    public void componentClear_quota() {
    }

    @Test
    public void componentFastregisterweappSearch() {
        ComponentFastregisterweappSearchRequest request = new ComponentFastregisterweappSearchRequest();
        request.setLegalPersonaName("陈志雄");
        request.setLegalPersonaWechat("zxpole");
        request.setName("上海巧房信息科技有限公司");
        cgibinClient.componentFastregisterweappSearch("19_1zJlyOCShI7uvslE9EuOvrbTK44TGviCmgEBvfMPhwEEaWu0YY1bEiV82DcE0rFuB1133ko9hjxipJlW08hIrEvf-5x1jSFkV8USWXIQ6vDS9rwKW-_3ynNNf_lPfdeElcVQzXaDJ9jPGPMwNBQgAJAZNC", request);

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
    public void accountGetaccountbasicinfo() {
        cgibinClient.accountGetaccountbasicinfo(accessToken);
    }

    @Test
    public void wxopenGetallcategories(){
        cgibinClient.wxopenGetallcategories(accessToken);
    }

    @Test
    public void wxverifyCheckwxverifynickname(){
        cgibinClient.wxverifyCheckwxverifynickname(accessToken,new WxverifyCheckwxverifynicknameRequest("123"));
    }

    @Test
    public void wxopenGetweappsupportversion(){
        cgibinClient.wxopenGetweappsupportversion(accessToken,new BaseRequest());
    }

    @Test
    public void wxopenSetweappsupportversion(){
        cgibinClient.wxopenSetweappsupportversion(accessToken,new WxopenSetweappsupportversionRequest("1.0.0"));
    }

    @Test
    public void wxopenQrcodejumpget(){
        cgibinClient.wxopenQrcodejumpget(accessToken,new BaseRequest());
    }

    @Test
    public void wxopenTemplateLibararyList(){
        BaseRequest baseRequest = new BaseRequest();
        baseRequest.put("offset",0);
        baseRequest.put("count",20);
        cgibinClient.wxopenTemplateLibararyList(accessToken,baseRequest);
    }

    @Test
    public void wxopenTemplateList(){
        BaseRequest baseRequest = new BaseRequest();
        baseRequest.put("offset",0);
        baseRequest.put("count",20);
        cgibinClient.wxopenTemplateList(accessToken,baseRequest);
    }

    @Test
    public void openUnbind(){
        BaseRequest baseRequest = new BaseRequest();
        baseRequest.put("appid","wx01fa97816dcd707c");
        baseRequest.put("open_appid","wxe3987587f06091cf");
        cgibinClient.openUnbind(accessToken,baseRequest);
    }



}

