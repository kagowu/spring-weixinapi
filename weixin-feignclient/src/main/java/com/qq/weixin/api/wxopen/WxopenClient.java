package com.qq.weixin.api.wxopen;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author gong.hua
 */
public interface WxopenClient {
    /**
     * 换绑小程序管理员接口-从第三方平台跳转至微信公众平台授权注册页面
     * 流程
     * 步骤一：从第三方平台页面发起，并跳转至微信公众平台指定换绑页面。
     * 步骤二：小程序原管理员扫码，并填写原管理员身份证信息确认。
     * 步骤三：填写新管理员信息(姓名、身份证、手机号)，使用新管理员的微信确认。
     * 步骤四：点击提交后跳转至第三方平台页面，第三方平台回调对应 api 完成换绑流程。
     *
     * @param component_appid 第三方平台的appid
     * @param appid           公众号的 appid
     * @param redirect_uri    新管理员信息填写完成点击提交后，将跳转到该地址(注：1.链接需 urlencode 2.Host需和第三方平台在微信开放平台上面填写的登录授权的发起页域名一致)
     * @return
     * @throws UnsupportedEncodingException
     */
    default String getComponentrebindadminUrl(String component_appid, String appid, String redirect_uri) throws UnsupportedEncodingException {
        return String.format("https://mp.weixin.qq.com/wxopen/componentrebindadmin?appid=%s&component_appid=%s&redirect_uri=%s",
                appid, component_appid, URLEncoder.encode(redirect_uri, "UTF-8"));
    }
}
