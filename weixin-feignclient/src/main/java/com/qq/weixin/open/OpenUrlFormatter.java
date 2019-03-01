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
