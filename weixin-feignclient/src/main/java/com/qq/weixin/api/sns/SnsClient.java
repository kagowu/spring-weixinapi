package com.qq.weixin.api.sns;


import com.qq.weixin.api.BaseResponse;
import com.qq.weixin.api.sns.response.Jscode2sessionResponse;
import com.qq.weixin.api.sns.response.Oauth2Access_tokenResponse;
import com.qq.weixin.api.sns.response.UserinfoResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * sns相关服务
 */
@FeignClient(name = "sns", url = "https://api.weixin.qq.com/sns/")
public interface SnsClient {
    /**
     * 通过code换取网页授权access_token
     *
     * @param appid
     * @param secret
     * @return
     * @link {https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140842}
     * @see com.qq.weixin.open.OpenUrlFormatter#getConnectOauth2AuthorizeUrl(String, String, String, String)
     */
    @RequestMapping(value = "/oauth2/access_token?grant_type=authorization_code", method = RequestMethod.GET)
    Oauth2Access_tokenResponse oauth2Access_token(@RequestParam("appid") String appid, @RequestParam("secret") String secret, @RequestParam("code") String code);

    /**
     * 第三方平台-通过code换取网页授权access_token
     *
     * @param appid
     * @param secret
     * @return
     * @link {https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140842}
     * @see com.qq.weixin.open.OpenUrlFormatter#getConnectOauth2AuthorizeUrl4Component(String, String, String, String, String)
     */
    @RequestMapping(value = "/oauth2/component/access_token?grant_type=authorization_code", method = RequestMethod.GET)
    Oauth2Access_tokenResponse oauth2ComponetAccess_token(@RequestParam("appid") String appid, @RequestParam("secret") String secret, @RequestParam("code") String code,
                                                          @RequestParam("component_appid") String component_appid, @RequestParam("component_access_token") String component_access_token);


    /**
     * 刷新access_token（如果需要）
     *
     * @param appid
     * @param refreshToken
     * @return
     * @link {https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140842}
     * @see #oauth2ComponentRefresh_token
     */
    @RequestMapping(value = "/oauth2/refresh_token?grant_type=refresh_token", method = RequestMethod.GET)
    Oauth2Access_tokenResponse oauth2Refresh_token(@RequestParam("appid") String appid, @RequestParam("refresh_token") String refreshToken);

    /**
     * 第三方平台-刷新access_token（如果需要）
     *
     * @param appid
     * @param refreshToken
     * @return
     * @link {https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1419318590&token=&lang=zh_CN}
     * @see #oauth2Refresh_token
     */
    @RequestMapping(value = "/oauth2/component/refresh_token?grant_type=refresh_token", method = RequestMethod.GET)
    Oauth2Access_tokenResponse oauth2ComponentRefresh_token(@RequestParam("appid") String appid,
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
    UserinfoResponse userInfo(@RequestParam("openid") String openid, @RequestParam("access_token") String accessToken);

    /**
     * code2Session
     * 第三方平台开发者的服务器使用登录凭证 code 以及第三方平台的component_access_token 获取 session_key 和 openid。
     * 其中 session_key 是对用户数据进行加密签名的密钥。为了自身应用安全，session_key 不应该在网络上传输
     *
     * @param appid
     * @param secret
     * @return
     * @link {https://developers.weixin.qq.com/minigame/dev/api/code2Session.html?search-key=code2session}
     * @see #componetJscode2session
     */
    @RequestMapping(value = "/jscode2session?grant_type=authorization_code", method = RequestMethod.GET)
    Jscode2sessionResponse jscode2session(@RequestParam("appid") String appid, @RequestParam("secret") String secret, @RequestParam("js_code") String js_code);

    /**
     * component-code2Session
     *
     * @param appid
     * @param js_code
     * @return
     * @link {https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1492585163_FtTNA&token=&lang=zh_CN}
     * @see #jscode2session
     */
    @RequestMapping(value = "component/jscode2session?grant_type=authorization_code", method = RequestMethod.GET)
    Jscode2sessionResponse componetJscode2session(@RequestParam("appid") String appid, @RequestParam("js_code") String js_code, @RequestParam("component_appid") String component_appid,
                                                  @RequestParam("component_access_token") String component_access_token);
}
