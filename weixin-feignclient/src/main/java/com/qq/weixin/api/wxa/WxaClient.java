package com.qq.weixin.api.wxa;

import com.qq.weixin.api.BaseResponse;
import com.qq.weixin.api.cgibin.request.ComponentFastregisterweappRequest;
import com.qq.weixin.api.wxa.request.ModifyDomainRequest;
import com.qq.weixin.api.wxa.request.WebviewdomainRequest;
import com.qq.weixin.api.wxa.response.ModifyDomainResopnse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author gong.hua
 */
@FeignClient(name = "domain", url = "https://api.weixin.qq.com/wxa/")
public interface WxaClient {
    /**
     * 设置小程序服务器域名
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/modify_domain", method = RequestMethod.GET)
    ModifyDomainResopnse modifyDomain(@RequestParam("access_token") String accessToken, @RequestBody ModifyDomainRequest modifyDomainRequest);
    /**
     * 设置小程序业务域名（仅供第三方代小程序调用）
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/setwebviewdomain", method = RequestMethod.GET)
    BaseResponse setwebviewdomain(@RequestParam("access_token") String accessToken, @RequestBody WebviewdomainRequest webviewdomainRequest);

}
