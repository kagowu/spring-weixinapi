package com.qq.weixin.api.cgibin;

import com.qq.weixin.api.BaseResponse;
import com.qq.weixin.api.cgibin.request.ApiComponentTokenRequest;
import com.qq.weixin.api.cgibin.request.ComponentFastregisterweappRequest;
import com.qq.weixin.api.cgibin.response.ApiComponentTokenResponse;
import com.qq.weixin.api.cgibin.response.JsapiTicketResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author gong.hua
 */
@FeignClient(name = "component", url = "https://api.weixin.qq.com/cgi-bin/")
public interface ComponentClient {

    @RequestMapping(value = "/component/api_component_token", method = RequestMethod.GET)
    ApiComponentTokenResponse apiComponentToken(@RequestBody ApiComponentTokenRequest apiComponentTokenRequest);

    /**
     * 创建小程序接口
     *
     * @param componentFastregisterweappRequest
     * @return
     */
    @RequestMapping(value = "/component/fastregisterweapp?action=create", method = RequestMethod.GET)
    BaseResponse fastregisterweappCreate(@RequestParam("component_access_token") String componentAccessToken, @RequestBody ComponentFastregisterweappRequest componentFastregisterweappRequest);

    /**
     * 查询创建任务状态
     *
     * @param componentFastregisterweappRequest
     * @return
     */
    @RequestMapping(value = "/component/fastregisterweapp?action=search", method = RequestMethod.GET)
    BaseResponse fastregisterweappSearch(@RequestParam("component_access_token") String componentAccessToken, @RequestBody ComponentFastregisterweappRequest componentFastregisterweappRequest);
}
