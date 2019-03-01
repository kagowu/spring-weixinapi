package org.spring.springcloud.weixinfeignclienttest;

import com.alibaba.fastjson.JSON;
import com.qq.weixin.api.BaseRequest;
import com.qq.weixin.api.cgibin.CgibinClient;
import com.qq.weixin.api.cgibin.request.*;
import com.qq.weixin.api.cgibin.response.ComponentApi_get_authorizer_infoResponse;
import com.qq.weixin.api.cgibin.response.ComponentTokenResponse;
import com.qq.weixin.mp.MpUrlFormatter;
import lombok.val;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WeixinFeignclientTestApplication.class)
public class CgibinClientTests {

    @Autowired
    private CgibinClient cgibinClient;

    private String token = "19_g62tFf2xqOG1gDR1MZZhguyMxtXNYp1iUe8hNq-lKT6pcvAFiPTp6oDYZunRaG2ke45pNiuxHv26b3OjkR62MF8hqELSL7TkRIcvZZb3MKJ4ygbuSUnxDaKdoMIZVAgAIASOT";
    private String componentToken = "19_VHEwZ6q1TtcR9zJqBU7h0YsF5ovIuyOVRJOoSUG2RO9ca9pH86m1LJ-1CFXmIqow2NCxp1910KLdrNl9sYJKM6X8ZNOUh8I3T6DjZ3v-A1PnH9veXyYd_eebCRmIRGI0l_qS575caGemcFdeQVOhAHADIB";


    private Object response;
    private Object req;

    @Before
    public void before() {

    }

    @After
    public void after() {
        System.out.println(JSON.toJSONString(req, true));
        System.err.println(JSON.toJSONString(response, true));
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

    @Test
    public void componentApi_create_preauthcode() {
        val request = new ComponentApi_create_preauthcodeRequest();
        request.setComponent_appid("wxe3987587f06091cf");
        response = cgibinClient.componentApi_create_preauthcode(componentToken, request);
        req = request;
    }

    @Test
    public void componentApi_get_authorizer_info() {
        val request = new ComponentApi_get_authorizer_infoRequest();
        request.setAuthorizer_appid("wx01fa97816dcd707c");
        request.setComponent_appid("wxe3987587f06091cf");
        ComponentApi_get_authorizer_infoResponse response = cgibinClient.componentApi_get_authorizer_info(componentToken, request);
        req = request;
    }

    @Test
    public void componentApi_get_authorizer_option() {
    }

    @Test
    public void componentApi_query_auth() {
    }

    @Test
    public void componentApi_set_authorizer_option() {
    }

    @Test
    public void componentApiComponentToken() {
        val componentTokenRequest = new ComponentTokenRequest();
        componentTokenRequest.setComponent_appid("wxe3987587f06091cf");
        componentTokenRequest.setComponent_appsecret("10c1bde9468906b5a981302136cacf37");
        componentTokenRequest.setComponent_verify_ticket("ticket@@@nBM6F2ykguKB41H40NOFLlrljtJRFiV-5dD2iOyI7iGGTBVwR6phGduA8-C-TJL21ZmCZas1ii88doVVHfUKdg");
        cgibinClient.componentApiComponentToken(componentTokenRequest);
        req = componentTokenRequest;
    }

    @Test
    public void componentClear_quota() {
    }

    @Test
    public void componentFastregisterweappCreate() {
    }

    @Test
    public void componentFastregisterweappSearch() {
        response = cgibinClient.componentFastregisterweappSearch(componentToken,
                null);
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
    public void menuCreate() {
        val request = new MenuCreateRequest();
        MenuCreateRequest.ViewButton viewButton = new MenuCreateRequest.ViewButton();
        viewButton.setUrl("http://www.baidu.com");
        viewButton.setName("test");
        request.setButton(new MenuCreateRequest.Button[]{viewButton, viewButton, viewButton});
        System.err.println(JSON.toJSONString(request, true));
        response = cgibinClient.menuCreate(token, request);
    }

    @Test
    public void menuDelete() {
    }

    @Test
    public void menuGet() {
        response = cgibinClient.menuGet(token);
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
    public void qrcodeCreate() {
        val qrcodeCreateRequest = new QrcodeCreateRequest();
        QrcodeCreateRequest.ActionInfo actionInfo = new QrcodeCreateRequest.ActionInfo();
        QrcodeCreateRequest.Scene scene = new QrcodeCreateRequest.Scene();
        scene.setScene_id("123");
        actionInfo.setScene(scene);
        qrcodeCreateRequest.setAction_info(actionInfo);
        qrcodeCreateRequest.setAction_name("QR_SCENE");
        qrcodeCreateRequest.setExpire_seconds(864000);
        cgibinClient.qrcodeCreate(token, qrcodeCreateRequest);
        req = qrcodeCreateRequest;
    }

    @Test
    public void templateApi_set_industry() {
    }

    @Test
    public void ticketGetticket() {
        response = cgibinClient.ticketGetticket(token);
    }

    @Test
    public void token() {
        response = cgibinClient.token("wxe57e8b54cbe75bd0", "22642be432f7849be45956de461333c8");

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


}

