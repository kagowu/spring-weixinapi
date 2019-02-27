package com.qq.weixin.api.cgibin;


import com.qq.weixin.api.BaseResponse;
import com.qq.weixin.api.cgibin.request.ApiComponentTokenRequest;
import com.qq.weixin.api.cgibin.request.ComponentFastregisterweappRequest;
import com.qq.weixin.api.cgibin.request.MenuButtonsRequest;
import com.qq.weixin.api.cgibin.request.QrcodeCreateRequest;
import com.qq.weixin.api.cgibin.response.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "token", url = "https://api.weixin.qq.com/cgi-bin/")
public interface CgibinClient {
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

    @RequestMapping(value = "/component/api_component_token", method = RequestMethod.GET)
    ApiComponentTokenResponse componentApiComponentToken(@RequestBody ApiComponentTokenRequest apiComponentTokenRequest);

    /**
     * 创建小程序接口
     *
     * @param componentFastregisterweappRequest
     * @return
     */
    @RequestMapping(value = "/component/fastregisterweapp?action=create", method = RequestMethod.GET)
    BaseResponse componentFastregisterweappCreate(@RequestParam("component_access_token") String componentAccessToken, @RequestBody ComponentFastregisterweappRequest componentFastregisterweappRequest);

    /**
     * 查询创建任务状态
     *
     * @param componentFastregisterweappRequest
     * @return
     */
    @RequestMapping(value = "/component/fastregisterweapp?action=search", method = RequestMethod.GET)
    BaseResponse componentFastregisterweappSearch(@RequestParam("component_access_token") String componentAccessToken, @RequestBody ComponentFastregisterweappRequest componentFastregisterweappRequest);


    /**
     * 自定义菜单创建接口
     *
     * @param accessToken
     * @param menuButtons
     * @return
     */
    @RequestMapping(value = "/menu/create", method = RequestMethod.POST)
    BaseResponse menuCreate(@RequestParam("access_token") String accessToken, @RequestBody MenuButtonsRequest menuButtons);

    /**
     * 自定义菜单删除接口
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/menu/delete", method = RequestMethod.GET)
    BaseResponse menuDelete(@RequestParam("access_token") String accessToken);

    /**
     * 自定义菜单查询接口
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/menu/get", method = RequestMethod.GET)
    MenuResponse menuGet(@RequestParam("access_token") String accessToken);


    /**
     * 个性化菜单接口
     *
     * @param accessToken
     * @param menu
     * @return
     */
    @RequestMapping(value = "/menu/addconditional", method = RequestMethod.POST)
    BaseResponse menuAddconditional(@RequestParam("access_token") String accessToken, @RequestBody MenuResponse menu);

    /**
     * 生成带参数的二维码
     *
     * @param accessToken
     * @return
     * @link {https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1443433542}
     */
    @RequestMapping(value = "/qrcode/create", method = RequestMethod.GET)
    QrcodeTicketResponse qrcodeCreate(@RequestParam("access_token") String accessToken, @RequestBody QrcodeCreateRequest qrcodeCreateRequest);

    /**
     * JS-SDK使用权限签名算法
     *
     * @param accessToken
     * @return
     * @link {https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421141115}
     */
    @RequestMapping(value = "/ticket/getticket?type=jsapi", method = RequestMethod.GET)
    JsapiTicketResponse ticketGetticket(@RequestParam("access_token") String accessToken);

    /**
     * 获取帐号基本信息
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/account/getaccountbasicinfo", method = RequestMethod.GET)
    BaseResponse accountGetaccountbasicinfo(@RequestParam("access_token") String accessToken, @RequestBody Map map);

}
