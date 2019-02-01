package com.qq.weixin.api.cgibin;


import com.qq.weixin.api.cgibin.response.JsapiTicketResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "jssdk", url = "https://api.weixin.qq.com/cgi-bin/")
public interface JSSDKClient {
    /**
     * JS-SDK使用权限签名算法
     *
     * @param accessToken
     * @return
     * @link {https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421141115}
     */
    @RequestMapping(value = "/ticket/getticket?type=jsapi", method = RequestMethod.GET)
    JsapiTicketResponse getJsapiTicket(@RequestParam("access_token") String accessToken);

}
