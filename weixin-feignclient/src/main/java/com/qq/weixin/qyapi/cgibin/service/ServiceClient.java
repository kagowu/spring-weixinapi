package com.qq.weixin.qyapi.cgibin.service;

import com.qq.weixin.api.FeignConfiguration;
import com.qq.weixin.qyapi.cgibin.service.request.*;
import com.qq.weixin.qyapi.cgibin.service.response.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ServiceClient", url = "https://qyapi.weixin.qq.com/cgi-bin/service/", configuration = FeignConfiguration.class)
public interface ServiceClient {


    /**
     * 获取第三方应用凭证
     * 该API用于获取第三方应用凭证（suite_access_token）。
     * @link {https://work.weixin.qq.com/api/doc/10975#%E8%8E%B7%E5%8F%96%E7%AC%AC%E4%B8%89%E6%96%B9%E5%BA%94%E7%94%A8%E5%87%AD%E8%AF%81}
     * @param getSuiteTokenRequest
     * @return
     */
    @RequestMapping(value = "get_suite_token", method = RequestMethod.POST)
    GetSuiteTokenResponse getSuiteToken(@RequestBody GetSuiteTokenRequest getSuiteTokenRequest);

    /**
     * 获取访问用户身份
     * @link {https://work.weixin.qq.com/api/doc/90001/90143/91121}
     * @param suiteAccessToken 第三方应用的suite_access_token，参见“获取第三方应用凭证”
     * @param code 通过成员授权获取到的code，最大为512字节。每次成员授权带上的code将不一样，code只能使用一次，5分钟未被使用自动过期。
     * @return 用户身份
     */
    @RequestMapping(value = "getuserinfo3rd", method = RequestMethod.GET)
    GetUserInfo3rdResponse getUserInfo3rd(@RequestParam("suite_access_token") String suiteAccessToken, @RequestParam("code") String code);


    /**
     * 获取访问用户敏感信息
     * @link {https://work.weixin.qq.com/api/doc/90001/90143/91122}
     * @param suiteAccessToken 第三方应用的suite_access_token，参见“获取第三方应用凭证”
     * @param request 成员票据
     * @return 用户身份
     */
    @RequestMapping(value = "getuserinfo3rd", method = RequestMethod.POST)
    GetUserDetail3rdGResponse getUserDetail3rd(@RequestParam("suite_access_token") String suiteAccessToken, @RequestBody GetUserDetail3rdRequest request);


    /**
     * code2Session
     * 临时登录凭证校验接口是一个服务端HTTPS 接口，开发者服务器使用临时登录凭证code获取 session_key、用户userid以及用户所在企业的corpid等信息。
     * @link {https://work.weixin.qq.com/api/doc/90001/90144/92423}
     * @param suiteAccessToken 第三方应用凭证
     * @param jsCode 登录时获取的 code
     * @return
     */
    @RequestMapping(value = "miniprogram/jscode2session?grant_type=authorization_code", method = RequestMethod.GET)
    JsCode2SessionResponse jsCode2Session(@RequestParam("suite_access_token") String suiteAccessToken, @RequestParam("js_code") String jsCode);

}
