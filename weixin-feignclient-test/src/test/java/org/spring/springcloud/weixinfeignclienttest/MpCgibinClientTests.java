package org.spring.springcloud.weixinfeignclienttest;

import com.alibaba.fastjson.JSON;
import com.qq.weixin.api.BaseResponse;
import com.qq.weixin.api.cgibin.CgibinClient;
import com.qq.weixin.api.cgibin.request.*;
import com.qq.weixin.api.cgibin.response.*;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.PostConstruct;
import java.io.*;
import java.net.URLEncoder;
import java.util.Arrays;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WeixinFeignclientTestApplication.class)
public class MpCgibinClientTests {
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
    private static final String appidMp = "wxe57e8b54cbe75bd0";
    private static final String appsecretMp = "22642be432f7849be45956de461333c8";


    @Before
    public void before() {
        accessToken = stringRedis.get("org.spring.springcloud.weixinfeignclienttest.MpCgibinClientTests#accessToken");
        preAuthCode = stringRedis.get("org.spring.springcloud.weixinfeignclienttest.MpCgibinClientTests#preAuthCode");
        componentToken = stringRedis.get("marketing_microshop:wx_component_access_token");
        if (componentToken != null) {
            componentToken = componentToken.replace("\"", "");
        }
        authorizerAccessToken = stringRedis.get("org.spring.springcloud.weixinfeignclienttest.MpCgibinClientTests#authorizerAccessToken");
        authorizerRefreshToken = stringRedis.get("org.spring.springcloud.weixinfeignclienttest.MpCgibinClientTests#authorizerRefreshToken");

    }






    @Test
    public void token() {
        TokenResponse response = cgibinClient.token(appidMp, appsecretMp);
        stringRedis.set("org.spring.springcloud.weixinfeignclienttest.MpCgibinClientTests#accessToken", response.getAccessToken());

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
        viewButton.setSubButtons(Arrays.asList(new MenuCreateRequest.Button[]{viewButton1, viewButton2}));
        request.setButton(Arrays.asList(new MenuCreateRequest.Button[]{viewButton}));
        System.err.println(JSON.toJSONString(request, true));
        cgibinClient.menuCreate(accessToken, request);
        System.err.println(JSON.toJSONString(request, true));

    }

    @Test
    public void menuGet() {
        cgibinClient.menuGet(accessToken);
    }

    @Test
    public void qrcodeCreate() {
        cgibinClient.qrcodeCreateTemp(accessToken, 864000, 123);
    }

    @Test
    public void qrcodeCreateForever() {
        cgibinClient.qrcodeCreateForever(accessToken, "forever");
    }



    @Test
    public void messageCustomSendText() {
        MessageCustomSendBaseRequest.TextMessage textMessage = new MessageCustomSendBaseRequest.TextMessage();
        textMessage.setText(new MessageCustomSendBaseRequest.Text("hello"));
        textMessage.setTouser("o1i3qs2kVNHty34G2reV1CRs5mds");

        cgibinClient.messageCustomSend(accessToken, textMessage);

    }

    @Test
    public void messageCustomTyping() {

        cgibinClient.messageCustomTyping(accessToken, "o1i3qs2kVNHty34G2reV1CRs5mds","Typing");

    }

    @Test
    public void messageCustomSendImage() {
        MessageCustomSendBaseRequest.ImageMessage imageMessage = new MessageCustomSendBaseRequest.ImageMessage();
        imageMessage.setImage(new MessageCustomSendBaseRequest.Image("2Rb8kLek2RbW8-dBWSAPnL1zHoq5B7zWYeyb1FSo_U4n_-TxPcAzSlQgqWeJ8ULP"));
        imageMessage.setTouser("o1i3qs2kVNHty34G2reV1CRs5mds");
        cgibinClient.messageCustomSend(accessToken, imageMessage);
    }

    @Test
    public void messageCustomSendNews() {
        MessageCustomSendBaseRequest.NewsMessage newsMessage = new MessageCustomSendBaseRequest.NewsMessage();
        newsMessage.setNews(
                new MessageCustomSendBaseRequest.News(Arrays.asList(
                        new MessageCustomSendBaseRequest.Article("你好","你真的很好","https://developers.weixin.qq.com/sandbox?tab=miniprogram&hl=zh",
                                "https://developers.weixin.qq.com/sandbox?tab=miniprogram&hl=zh"))));
        newsMessage.setTouser("o1i3qs2kVNHty34G2reV1CRs5mds");
        cgibinClient.messageCustomSend(accessToken, newsMessage);
    }




    @Test
    public void mediaUpload() throws IOException {

        val val = cgibinClient.mediaUpload(accessToken, "image", new File("D:\\sources\\spring-weixinapi\\weixin-feignclient-test\\src\\main\\java\\org\\spring\\springcloud\\weixinfeignclienttest\\0.jpg"));

        System.out.println(JSON.toJSONString(val));

    }

    @Test
    public void userInfo() {
        cgibinClient.userInfo(accessToken, "o1i3qs2kVNHty34G2reV1CRs5mds");
    }

    @Test
    public void ticketGetticket(){
        cgibinClient.ticketGetticket(accessToken);
    }

    @Test
    public void shortUrl() {
        ShortUrlRequest request = new ShortUrlRequest();
        request.setAction("long2short");
        request.setLongUrl("https://atool.dev.qiaofangyun.com/atool2c4h5/qrcode?scene=7fff480e18bb4a2db3a6b25c1609fe49");


        ShortUrlResponse response = cgibinClient.shortUrl(accessToken, request);

        log.info("shortUrl: {}",response);
    }

}

