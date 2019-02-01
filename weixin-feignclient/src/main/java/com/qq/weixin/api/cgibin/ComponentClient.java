package com.qq.weixin.api.cgibin;

import com.qq.weixin.api.cgibin.request.ApiComponentTokenRequest;
import com.qq.weixin.api.cgibin.response.JsapiTicketResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author gong.hua
 */
@FeignClient(name = "component", url = "https://api.weixin.qq.com/cgi-bin/")
public interface ComponentClient {

    @RequestMapping(value = "/component/api_component_token", method = RequestMethod.GET)
    JsapiTicketResponse apiComponentToken(@RequestBody ApiComponentTokenRequest apiComponentTokenRequest);
}
