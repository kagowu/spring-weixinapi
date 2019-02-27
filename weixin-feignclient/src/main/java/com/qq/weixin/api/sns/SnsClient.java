package com.qq.weixin.api.sns;


import com.qq.weixin.api.BaseResponse;
import com.qq.weixin.api.sns.response.SnsTokenResponse;
import com.qq.weixin.api.sns.response.UserResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@FeignClient(name = "sns", url = "https://api.weixin.qq.com/sns/")
public interface SnsClient {
    /**
     * 通过code换取网页授权access_token
     *
     * @param appid
     * @param secret
     * @return
     * @link {https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140842}
     */
    @RequestMapping(value = "/oauth2/access_token?grant_type=authorization_code", method = RequestMethod.GET)
    SnsTokenResponse oauth2Access_token(@RequestParam("appid") String appid, @RequestParam("secret") String secret, @RequestParam("code") String code);

    /**
     * 第三方平台-通过code换取网页授权access_token
     *
     * @param appid
     * @param secret
     * @return
     * @link {https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140842}
     */
    @RequestMapping(value = "/oauth2/component/access_token?grant_type=authorization_code", method = RequestMethod.GET)
    SnsTokenResponse oauth2ComponetAccess_token(@RequestParam("appid") String appid, @RequestParam("secret") String secret, @RequestParam("code") String code,
                                                @RequestParam("component_appid") String component_appid, @RequestParam("component_access_token") String component_access_token);


    /**
     * 刷新access_token（如果需要）
     *
     * @param appid
     * @param refreshToken
     * @return
     * @link {https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140842}
     */
    @RequestMapping(value = "/oauth2/refresh_token?grant_type=refresh_token", method = RequestMethod.GET)
    SnsTokenResponse oauth2Refresh_token(@RequestParam("appid") String appid, @RequestParam("refresh_token") String refreshToken);

    /**
     * 第三方平台-刷新access_token（如果需要）
     *
     * @param appid
     * @param refreshToken
     * @return
     * @link {https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140842}
     */
    @RequestMapping(value = "/oauth2/component/refresh_token?grant_type=refresh_token", method = RequestMethod.GET)
    SnsTokenResponse oauth2ComponentRefresh_token(@RequestParam("appid") String appid,
                                                  @RequestParam("component_appid") String component_appid, @RequestParam("component_access_token") String component_access_token,
                                                  @RequestParam("refresh_token") String refreshToken);

    /**
     * 检验授权凭证（access_token）是否有效
     *
     * @param openid
     * @param access_token
     * @return
     * @link {https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140842}
     */
    @RequestMapping(value = "/oauth2/check_token?grant_type=refresh_token", method = RequestMethod.GET)
    BaseResponse oauth2Check_token(@RequestParam("openid") String openid, @RequestParam("access_token") String access_token);


    /**
     * 拉取用户信息(需scope为 snsapi_userinfo)
     *
     * @param openid
     * @param accessToken
     * @return
     * @link {https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140842}
     */
    @RequestMapping(value = "/userinfo?lang=zh_CN", method = RequestMethod.GET)
    UserResponse userInfo(@RequestParam("openid") String openid, @RequestParam("access_token") String accessToken);

    /**
     * code2Session
     *
     * @param appid
     * @param secret
     * @return
     */
    @RequestMapping(value = "/jscode2session?grant_type=authorization_code", method = RequestMethod.GET)
    BaseResponse jscode2session(@RequestParam("appid") String appid, @RequestParam("secret") String secret, @RequestParam("js_code") String js_code);

    /**
     * component-code2Session
     *
     * @param appid
     * @param js_code
     * @return
     */
    @RequestMapping(value = "component/jscode2session??grant_type=authorization_code", method = RequestMethod.GET)
    BaseResponse componetJscode2session(@RequestParam("appid") String appid, @RequestParam("js_code") String js_code, @RequestParam("component_appid") String component_appid,
                                        @RequestParam("component_access_token") String component_access_token);

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
    default String getComponentAuthorizeUrl(String appid, String redirect_uri, String scope, String state, String component_appid) throws UnsupportedEncodingException {
        return String.format("https://open.weixin.qq.com/connect/oauth2/authorize?" +
                        "appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=%s&component_appid=%s#wechat_redirect",
                appid, URLEncoder.encode(redirect_uri, "UTF-8"), scope, state, component_appid);
    }

    /**
     * 获取authorizeUrl
     *
     * @param appid
     * @param redirect_uri
     * @param scope
     * @param state
     * @return
     * @throws UnsupportedEncodingException
     */
    default String getAuthorizeUrl(String appid, String redirect_uri, String scope, String state) throws UnsupportedEncodingException {
        return String.format("https://open.weixin.qq.com/connect/oauth2/authorize?" +
                        "appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=%s#wechat_redirect",
                appid, URLEncoder.encode(redirect_uri, "UTF-8"), scope, state);
    }

}
