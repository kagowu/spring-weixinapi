package org.spring.springcloud.weixinfeignclienttest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WechatOpenConfiguration {
    /**
     * 设置微信三方平台的appid
     */
    public static String componentAppId;

    /**
     * 设置微信三方平台的app secret
     */
    public static String componentSecret;

    /**
     * 设置微信三方平台的token
     */
    public static String componentToken;

    /**
     * 设置微信三方平台的EncodingAESKey
     */
    public static String componentAesKey;

    /**
     * 三方平台跳转
     */
    public static String jumpUrl;

    @Value("${wechat.open.componentAppId}")
    public void setComponentAppId(String componentAppId) {
        WechatOpenConfiguration.componentAppId = componentAppId;
    }

    @Value("${wechat.open.componentSecret}")
    public void setComponentSecret(String componentSecret) {
        WechatOpenConfiguration.componentSecret = componentSecret;
    }

    @Value("${wechat.open.componentToken}")
    public void setComponentToken(String componentToken) {
        WechatOpenConfiguration.componentToken = componentToken;
    }

    @Value("${wechat.open.componentAesKey}")
    public void setComponentAesKey(String componentAesKey) {
        WechatOpenConfiguration.componentAesKey = componentAesKey;
    }


    @Value("${wechat.open.jumpUrl}")
    public void setJumpUrl(String jumpUrl) {
        WechatOpenConfiguration.jumpUrl = jumpUrl;
    }
}
