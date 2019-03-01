package com.qq.weixin.open;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author gong.hua
 */
public class OpenUrlFormatter {
    /**
     * 获取第三方平台的authorizeUrl
     *
     * @param appid
     * @param redirect_uri
     * @param scope
     * @param state
     * @param component_appid
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String getConnectOauth2AuthorizeUrl4Component(String appid, String redirect_uri, String scope, String state, String component_appid) throws UnsupportedEncodingException {
        return getConnectOauth2AuthorizeUrl(appid, redirect_uri, scope, state).replace("#wechat_redirect", "&component_appid=" + component_appid + "#wechat_redirect");
    }

    /**
     * * <pre>
     *  1、引导用户进入授权页面同意授权，获取code
     *   @see #getConnectOauth2AuthorizeUrl
     *  2、通过code换取网页授权access_token（与基础支持中的access_token不同）
     *   @see com.qq.weixin.api.sns.SnsClient#oauth2Access_token(String, String, String)
     *  3、如果需要，开发者可以刷新网页授权access_token，避免过期
     *   @see com.qq.weixin.api.sns.SnsClient#oauth2Refresh_token(String, String)
     *  4、通过网页授权access_token和openid获取用户基本信息（支持UnionID机制）
     *   @see   com.qq.weixin.api.sns.SnsClient#userInfo(String, String)
     *  </pre>
     * 获取authorizeUrl
     *
     * @param appid
     * @param redirect_uri
     * @param scope        snsapi_base，snsapi_userinfo
     * @param state
     * @return
     * @throws UnsupportedEncodingException
     * @link {https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140842}
     */
    public static String getConnectOauth2AuthorizeUrl(String appid, String redirect_uri, String scope, String state) throws UnsupportedEncodingException {
        return String.format("https://open.weixin.qq.com/connect/oauth2/authorize?" +
                        "appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=%s#wechat_redirect",
                appid, URLEncoder.encode(redirect_uri, "UTF-8"), scope, state);
    }


}
