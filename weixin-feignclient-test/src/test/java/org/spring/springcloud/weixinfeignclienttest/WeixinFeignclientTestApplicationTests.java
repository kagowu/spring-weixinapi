package org.spring.springcloud.weixinfeignclienttest;

import com.alibaba.fastjson.JSON;
import com.qq.weixin.api.BaseRequest;
import com.qq.weixin.api.cgibin.CgibinClient;
import com.qq.weixin.api.cgibin.request.*;
import com.qq.weixin.api.cgibin.response.ComponentApi_get_authorizer_infoResponse;
import com.qq.weixin.api.cgibin.response.ComponentTokenResponse;
import com.qq.weixin.mp.MpUrlFormatter;
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
    private String componentToken = "19_VHEwZ6q1TtcR9zJqBU7h0YsF5ovIuyOVRJOoSUG2RO9ca9pH86m1LJ-1CFXmIqow2NCxp1910KLdrNl9sYJKM6X8ZNOUh8I3T6DjZ3v-A1PnH9veXyYd_eebCRmIRGI0l_qS575caGemcFdeQVOhAHADIB";

    private String pre_auth_code = "preauthcode@@@eymeq_YOZcqZWlRtriL0gLnLDgsz4yRoOFtXZg1PTFI3vPtU-bARS_NJah77pPNH";

    @Test
    public void getToken() {
        val token = cgibinClient.token("wxe57e8b54cbe75bd0", "22642be432f7849be45956de461333c8");
        System.err.println(JSON.toJSONString(token, true));

    }


    @Test
    public void componentFastregisterweappSearch() {
        val val = cgibinClient.componentFastregisterweappSearch(componentToken,
                null);
        System.err.println(JSON.toJSONString(val, true));

    }

    @Test
    public void componentApi_create_preauthcode() {
        val baseRequest = new ComponentApi_create_preauthcodeRequest();
        baseRequest.setComponent_appid("wxe3987587f06091cf");
        val val = cgibinClient.componentApi_create_preauthcode(componentToken, baseRequest);
        System.err.println(JSON.toJSONString(val, true));

    }


    @Test
    public void getComonentloginpage() throws UnsupportedEncodingException {
        val val = MpUrlFormatter.getComonentloginpage("wxe3987587f06091cf", pre_auth_code, "http://wmd.dev.zhongjieyun.cn/wxopen/api/auth/jump");
        System.err.println(JSON.toJSONString(val, true));

    }

    @Test
    public void createMuenu() {
        val menuButtons = new MenuCreateRequest();
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
        val qrcodeCreateRequest = new QrcodeCreateRequest();
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
        val componentTokenRequest = new ComponentTokenRequest();
        componentTokenRequest.setComponent_appid("");
        componentTokenRequest.setComponent_appsecret("");
        componentTokenRequest.setComponent_verify_ticket("");
        System.err.println(JSON.toJSONString(cgibinClient.componentApiComponentToken(componentTokenRequest)));
    }

    @Test
    public void getToken2() {
        val componentTokenRequest = new ComponentTokenRequest();
        componentTokenRequest.setComponent_appid("wxe3987587f06091cf");
        componentTokenRequest.setComponent_appsecret("10c1bde9468906b5a981302136cacf37");
        componentTokenRequest.setComponent_verify_ticket("ticket@@@nBM6F2ykguKB41H40NOFLlrljtJRFiV-5dD2iOyI7iGGTBVwR6phGduA8-C-TJL21ZmCZas1ii88doVVHfUKdg");
        ComponentTokenResponse token = cgibinClient.componentApiComponentToken(componentTokenRequest);
        System.err.println(JSON.toJSONString(token, true));

    }

    @Test
    public void componentApi_get_authorizer_info() {
        val request = new ComponentApi_get_authorizer_infoRequest();
        request.setAuthorizer_appid("wx01fa97816dcd707c");
        request.setComponent_appid("wxe3987587f06091cf");
        ComponentApi_get_authorizer_infoResponse response = cgibinClient.componentApi_get_authorizer_info(componentToken, request);
        System.err.println(JSON.toJSONString(response, true));

    }

}

