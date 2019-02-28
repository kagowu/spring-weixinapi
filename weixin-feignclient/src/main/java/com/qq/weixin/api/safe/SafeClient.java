package com.qq.weixin.api.safe;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author gong.hua
 */
public interface SafeClient {
    /**
     * 第三方平台-引导公众号和小程序管理员进入授权页-微信端实际访问的授权链接
     *
     * @param component_appid
     * @param pre_auth_code
     * @param redirect_uri
     * @param auth_type
     * @param biz_appid
     * @return
     * @throws UnsupportedEncodingException
     */
    default String getBindcomponent(String component_appid, String pre_auth_code, String redirect_uri, String auth_type, String biz_appid) throws UnsupportedEncodingException {
        return String.format("https://mp.weixin.qq.com/safe/bindcomponent?action=bindcomponent&no_scan=1&component_appid=%s&pre_auth_code=%s&redirect_uri=%S&auth_type=%s&biz_appid=%s#wechat_redirect",
                component_appid, pre_auth_code, auth_type, URLEncoder.encode(redirect_uri, "UTF-8"), biz_appid);
    }}
