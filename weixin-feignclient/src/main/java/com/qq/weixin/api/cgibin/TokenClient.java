package com.qq.weixin.api.cgibin;


import com.qq.weixin.api.cgibin.response.GlobalTokenResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "token", url = "https://api.weixin.qq.com/cgi-bin/")
public interface TokenClient {
    /**
     * 获取全局AccessToken接口
     *
     * @param appid
     * @param secret
     * @return
     * @link {https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140183}
     */
    @RequestMapping(value = "/token?grant_type=client_credential", method = RequestMethod.GET)
    GlobalTokenResponse token(@RequestParam("appid") String appid, @RequestParam("secret") String secret);

}
