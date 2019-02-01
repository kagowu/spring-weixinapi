package com.qq.weixin.api.cgibin;


import com.qq.weixin.api.cgibin.request.MenuButtonsRequest;
import com.qq.weixin.api.BaseResponse;
import com.qq.weixin.api.cgibin.response.MenuResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "menu", url = "https://api.weixin.qq.com/cgi-bin/")
public interface MenuClient {


    /**
     * 自定义菜单创建接口
     *
     * @param accessToken
     * @param menuButtons
     * @return
     */
    @RequestMapping(value = "/menu/create", method = RequestMethod.POST)
    BaseResponse create(@RequestParam("access_token") String accessToken, @RequestBody MenuButtonsRequest menuButtons);

    /**
     * 自定义菜单删除接口
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/menu/delete", method = RequestMethod.GET)
    BaseResponse delete(@RequestParam("access_token") String accessToken);

    /**
     * 自定义菜单查询接口
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/menu/get", method = RequestMethod.GET)
    MenuResponse get(@RequestParam("access_token") String accessToken);


    /**
     * 个性化菜单接口
     *
     * @param accessToken
     * @param menu
     * @return
     */
    @RequestMapping(value = "/menu/addconditional", method = RequestMethod.POST)
    BaseResponse addconditional(@RequestParam("access_token") String accessToken, @RequestBody MenuResponse menu);
}
