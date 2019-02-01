package org.spring.springcloud.weixinfeignclienttest;

import com.alibaba.fastjson.JSON;
import com.qq.weixin.api.cgibin.*;
import com.qq.weixin.api.cgibin.request.ApiComponentTokenRequest;
import com.qq.weixin.api.cgibin.request.MenuButtonsRequest;
import com.qq.weixin.api.cgibin.request.QrcodeCreateRequest;
import com.qq.weixin.api.cgibin.response.GlobalTokenResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WeixinFeignclientTestApplication.class)
public class WeixinFeignclientTestApplicationTests {

    @Test
    public void contextLoads() {
    }


    @Autowired
    private TokenClient tokenClient;
    @Autowired
    private MenuClient menuClient;
    @Autowired
    private QrcodeClient qrcodeClient;
    @Autowired
    private JSSDKClient jssdkClient;

    @Autowired
    private ComponentClient componentClient;

    private GlobalTokenResponse token;

    @Before
    public void getToken() {
        token = tokenClient.token("wx553d4b09800ee9e9", "f7b889c5fad3599a6d88ad06d70fbd36");
        System.err.println(JSON.toJSONString(token, true));

    }

    @Test
    public void createMuenu() {
        MenuButtonsRequest menuButtons = new MenuButtonsRequest();
        MenuButtonsRequest.ViewButton viewButton = new MenuButtonsRequest.ViewButton();
        viewButton.setUrl("http://www.baidu.com");
        viewButton.setName("test");
        menuButtons.setButton(new MenuButtonsRequest.Button[]{viewButton, viewButton, viewButton});
        System.err.println(JSON.toJSONString(menuButtons, true));
        menuClient.create(token.getAccess_token(), menuButtons);
    }


    @Test
    public void getMenu() {
        System.err.println(JSON.toJSONString(menuClient.get(token.getAccess_token())));
    }

    @Test
    public void getJsapiTicket() {
        System.err.println(JSON.toJSONString(jssdkClient.getJsapiTicket(token.getAccess_token()), true));
    }

    @Test
    public void createQrcode() {
        QrcodeCreateRequest qrcodeCreateRequest = new QrcodeCreateRequest();
        QrcodeCreateRequest.ActionInfo actionInfo = new QrcodeCreateRequest.ActionInfo();
        QrcodeCreateRequest.Scene scene = new QrcodeCreateRequest.Scene();
        scene.setScene_id("123");
        actionInfo.setScene(scene);
        qrcodeCreateRequest.setAction_info(actionInfo);
        qrcodeCreateRequest.setAction_name("QR_SCENE");
        qrcodeCreateRequest.setExpire_seconds(864000);
        System.err.println(JSON.toJSONString(qrcodeClient.create(token.getAccess_token(), qrcodeCreateRequest), true));
    }

    @Test
    public void componentToken() {
        ApiComponentTokenRequest apiComponentTokenRequest = new ApiComponentTokenRequest();
        apiComponentTokenRequest.setComponent_appid("");
        apiComponentTokenRequest.setComponent_appsecret("");
        apiComponentTokenRequest.setComponent_verify_ticket("");
        System.err.println(JSON.toJSONString(componentClient.apiComponentToken(apiComponentTokenRequest)));
    }

}

