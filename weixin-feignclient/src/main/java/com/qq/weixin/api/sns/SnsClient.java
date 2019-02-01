package com.qq.weixin.api.sns;


import com.qq.weixin.api.BaseResponse;
import com.qq.weixin.api.sns.response.SnsTokenResponse;
import com.qq.weixin.api.sns.response.UserResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "jssdk", url = "https://api.weixin.qq.com/sns/")
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
    SnsTokenResponse getSnsToken(@RequestParam("appid") String appid, @RequestParam("secret") String secret, @RequestParam("code") String code);


    /**
     * 刷新access_token（如果需要）
     *
     * @param appid
     * @param refreshToken
     * @return
     * @link {https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140842}
     */
    @RequestMapping(value = "/oauth2/refresh_token?grant_type=refresh_token", method = RequestMethod.GET)
    SnsTokenResponse refreshSnsToken(@RequestParam("appid") String appid, @RequestParam("refresh_token") String refreshToken);



    /**
     * 检验授权凭证（access_token）是否有效
     *
     * @param openid
     * @param access_token
     * @return
     * @link {https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140842}
     */
    @RequestMapping(value = "/oauth2/refresh_token?grant_type=refresh_token", method = RequestMethod.GET)
    BaseResponse checkSnsToken(@RequestParam("openid") String openid, @RequestParam("access_token") String access_token);


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

}
