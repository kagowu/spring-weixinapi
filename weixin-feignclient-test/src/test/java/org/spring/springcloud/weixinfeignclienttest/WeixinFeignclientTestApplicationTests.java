package org.spring.springcloud.weixinfeignclienttest;

import com.alibaba.fastjson.JSON;
import com.qq.weixin.api.BaseRequest;
import com.qq.weixin.api.cgibin.*;
import com.qq.weixin.api.cgibin.request.ComponentTokenRequest;
import com.qq.weixin.api.cgibin.request.ComponentFastregisterweappRequest;
import com.qq.weixin.api.cgibin.request.MenuCreateRequest;
import com.qq.weixin.api.cgibin.request.QrcodeCreateRequest;
import com.qq.weixin.api.cgibin.response.ComponentTokenResponse;
import com.qq.weixin.api.cgibin.response.TokenResponse;
import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WeixinFeignclientTestApplication.class)
public class WeixinFeignclientTestApplicationTests {

    @Test
    public void contextLoads() {
    }


    @Autowired
    private CgibinClient cgibinClient;

    private String token = "19_g62tFf2xqOG1gDR1MZZhguyMxtXNYp1iUe8hNq-lKT6pcvAFiPTp6oDYZunRaG2ke45pNiuxHv26b3OjkR62MF8hqELSL7TkRIcvZZb3MKJ4ygbuSUnxDaKdoMIZVAgAIASOT";
    private String componentToken = "19_IwSfev_TWhbQj6mlkrfZgkVjgqwZsEaB3xD741d7R7oU6htm7RZqRdB8cPcv3kMUM3j1W9omWnfiar_lgoDajAKkLqfvpEtI_M7kTLponx8CSBNKbz66FurC1afO1I2gRrklGHKYnmnAqisHBIPdACASZG";
    private String pre_auth_code = "preauthcode@@@eymeq_YOZcqZWlRtriL0gLnLDgsz4yRoOFtXZg1PTFI3vPtU-bARS_NJah77pPNH";

    @Test
    public void getToken() {
        TokenResponse token = cgibinClient.token("wxe57e8b54cbe75bd0", "22642be432f7849be45956de461333c8");
        System.err.println(JSON.toJSONString(token, true));

    }

    @Test
    public void getToken2() {
        ComponentTokenRequest componentTokenRequest = new ComponentTokenRequest();
        componentTokenRequest.setComponent_appid("wxe3987587f06091cf");
        componentTokenRequest.setComponent_appsecret("10c1bde9468906b5a981302136cacf37");
        componentTokenRequest.setComponent_verify_ticket("ticket@@@9-kjd9KQumTVIg4oSmXQcyZO85IEl8HoWEs_eThLUkWBMsabMq8-GucGUAmiwi6ljNjyccczyURYHWqcflIefg");
        ComponentTokenResponse token = cgibinClient.componentApiComponentToken(componentTokenRequest);
        System.err.println(JSON.toJSONString(token, true));

    }

    @Test
    public void componentFastregisterweappSearch() {
        val val = cgibinClient.componentFastregisterweappSearch(componentToken,
                ComponentFastregisterweappRequest.builder().code("123").component_phone("123").build());
        System.err.println(JSON.toJSONString(val, true));

    }

    @Test
    public void componentApi_create_preauthcode() {
        val baseRequest = new BaseRequest();
        baseRequest.put("component_appid","wxe3987587f06091cf");
        val val = cgibinClient.componentApi_create_preauthcode(componentToken, baseRequest);
        System.err.println(JSON.toJSONString(val, true));

    }


    @Test
    public void getComonentloginpage() throws UnsupportedEncodingException {
        val val = cgibinClient.getComonentloginpage("wxe3987587f06091cf", pre_auth_code,"http://wmd.dev.zhongjieyun.cn/wxopen/api/auth/jump");
        System.err.println(JSON.toJSONString(val, true));

    }

    @Test
    public void createMuenu() {
        MenuCreateRequest menuButtons = new MenuCreateRequest();
        MenuCreateRequest.ViewButton viewButton = new MenuCreateRequest.ViewButton();
        viewButton.setUrl("http://www.baidu.com");
        viewButton.setName("test");
        menuButtons.setButton(new MenuCreateRequest.Button[]{viewButton, viewButton, viewButton});
        System.err.println(JSON.toJSONString(menuButtons, true));
        cgibinClient.menuCreate(token, menuButtons);
    }


    @Test
    public void getMenu() {
        System.err.println(JSON.toJSONString(cgibinClient.menuGet(token)));
    }

    @Test
    public void getJsapiTicket() {
        System.err.println(JSON.toJSONString(cgibinClient.ticketGetticket(token), true));
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
        System.err.println(JSON.toJSONString(cgibinClient.qrcodeCreate(token, qrcodeCreateRequest), true));
    }

    @Test
    public void componentToken() {
        ComponentTokenRequest componentTokenRequest = new ComponentTokenRequest();
        componentTokenRequest.setComponent_appid("");
        componentTokenRequest.setComponent_appsecret("");
        componentTokenRequest.setComponent_verify_ticket("");
        System.err.println(JSON.toJSONString(cgibinClient.componentApiComponentToken(componentTokenRequest)));
    }

    @Test
    public void getAuthorizeUrl() {

    }

}

