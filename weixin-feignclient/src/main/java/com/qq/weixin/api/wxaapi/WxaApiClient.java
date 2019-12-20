package com.qq.weixin.api.wxaapi;

import com.qq.weixin.api.BaseRequest;
import com.qq.weixin.api.BaseResponse;
import com.qq.weixin.api.FeignConfiguration;
import com.qq.weixin.api.wxaapi.request.*;
import com.qq.weixin.api.wxaapi.response.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author gong.hua
 */
@FeignClient(name = "wxa", url = "https://api.weixin.qq.com/wxaapi/", configuration = FeignConfiguration.class)
public interface WxaApiClient {

    /**
     * 订阅消息 - 组合模板并添加到个人模板库
     * 本接口用于组合模板并添加至帐号下的个人模板库，得到用于发消息的模板
     * @link {https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/Mini_Programs/subscribe_template/list_template.html}
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "newtmpl/addtemplate", method = RequestMethod.POST)
    NewtmplAddtemplateResponse newtmplAddtemplate(@RequestParam("access_token") String accessToken, @RequestBody NewtmplAddtemplateRequest baseRequest);

    /**
     * 订阅消息 - 获取帐号下的模板列表
     * 本接口用于获取小程序帐号下的个人模板库中已经存在的模板列表
     * @link {https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/Mini_Programs/subscribe_template/list_template.html}
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "newtmpl/gettemplate", method = RequestMethod.GET)
    NewtmplGettemplateResponse newtmplGettemplate(@RequestParam("access_token") String accessToken);

    /**
     * 订阅消息 - 删除帐号下的某个模板
     * 本接口用于删除帐号下的个人模板
     *
     * @link {hhttps://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/Mini_Programs/subscribe_template/del_template.html}
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "newtmpl/deltemplate", method = RequestMethod.POST)
    NewtmplDeltemplateResponse newtmplDeltemplate(@RequestParam("access_token") String accessToken, @RequestBody NewtmplDeltemplateRequest baseRequest);

}
