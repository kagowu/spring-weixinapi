package com.qq.weixin.api.wxa;

import com.qq.weixin.api.BaseResponse;
import com.qq.weixin.api.wxa.request.ModifyDomainRequest;
import com.qq.weixin.api.wxa.request.WebviewdomainRequest;
import com.qq.weixin.api.wxa.response.ModifyDomainResopnse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author gong.hua
 */
@FeignClient(name = "wxa", url = "https://api.weixin.qq.com/wxa/")
public interface WxaClient {
    /**
     * 设置小程序服务器域名
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/modify_domain", method = RequestMethod.POST)
    ModifyDomainResopnse modifyDomain(@RequestParam("access_token") String accessToken, @RequestBody ModifyDomainRequest modifyDomainRequest);

    /**
     * 设置小程序业务域名（仅供第三方代小程序调用）
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/setwebviewdomain", method = RequestMethod.POST)
    BaseResponse setwebviewdomain(@RequestParam("access_token") String accessToken, @RequestBody WebviewdomainRequest webviewdomainRequest);


    /**
     * 小程序名称设置及改名
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/setnickname", method = RequestMethod.POST)
    BaseResponse setnickname(@RequestParam("access_token") String accessToken, @RequestBody Map map);

    /**
     * 小程序改名审核状态查询
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/api_wxa_querynickname", method = RequestMethod.POST)
    BaseResponse api_wxa_querynickname(@RequestParam("access_token") String accessToken, @RequestBody Map map);


    /**
     * 设置小程序隐私设置（是否可被搜索）
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/changewxasearchstatus", method = RequestMethod.POST)
    BaseResponse changewxasearchstatus(@RequestParam("access_token") String accessToken, @RequestBody Map map);

    /**
     * 查询小程序当前隐私设置（是否可被搜索）
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/getwxasearchstatus", method = RequestMethod.POST)
    BaseResponse getwxasearchstatus(@RequestParam("access_token") String accessToken, @RequestBody Map map);

    /**
     * 获取展示的公众号信息
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/getshowwxaitem", method = RequestMethod.POST)
    BaseResponse getshowwxaitem(@RequestParam("access_token") String accessToken);


    /**
     * 获取展示的公众号信息
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/updateshowwxaitem", method = RequestMethod.POST)
    BaseResponse updateshowwxaitem(@RequestParam("access_token") String accessToken, @RequestBody Map map);


    /**
     * 获取可以用来设置的公众号列表
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/getwxamplinkforshow", method = RequestMethod.POST)
    BaseResponse getwxamplinkforshow(@RequestParam("access_token") String accessToken, @RequestBody Map map);

    /**
     * 绑定微信用户为小程序体验者
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/bind_tester", method = RequestMethod.POST)
    BaseResponse bind_tester(@RequestParam("access_token") String accessToken, @RequestBody Map map);

    /**
     * 解除绑定小程序的体验者
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/unbind_tester", method = RequestMethod.POST)
    BaseResponse unbind_tester(@RequestParam("access_token") String accessToken, @RequestBody Map map);

    /**
     * 获取体验者列表
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/memberauth", method = RequestMethod.POST)
    BaseResponse memberauth(@RequestParam("access_token") String accessToken, @RequestBody Map map);


    /**
     * 为授权的小程序帐号上传小程序代码
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/commit", method = RequestMethod.POST)
    BaseResponse commit(@RequestParam("access_token") String accessToken, @RequestBody Map map);

    /**
     * 获取体验小程序的体验二维码
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/get_qrcode", method = RequestMethod.GET)
    BaseResponse get_qrcode(@RequestParam("access_token") String accessToken, @RequestParam("path") String path);

    /**
     * 获取授权小程序帐号已设置的类目
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/get_category", method = RequestMethod.GET)
    BaseResponse get_category(@RequestParam("access_token") String accessToken);

    /**
     * 获取小程序的第三方提交代码的页面配置（仅供第三方开发者代小程序调用）
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/get_page", method = RequestMethod.GET)
    BaseResponse get_page(@RequestParam("access_token") String accessToken);

    /**
     * 将第三方提交的代码包提交审核（仅供第三方开发者代小程序调用）
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/submit_audit", method = RequestMethod.GET)
    BaseResponse submit_audit(@RequestParam("access_token") String accessToken);

    /**
     * 查询某个指定版本的审核状态（仅供第三方代小程序调用）
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/get_auditstatus", method = RequestMethod.POST)
    BaseResponse get_auditstatus(@RequestParam("access_token") String accessToken, @RequestBody Map map);

    /**
     * 查询最新一次提交的审核状态（仅供第三方代小程序调用）
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/get_latest_auditstatus", method = RequestMethod.GET)
    BaseResponse get_latest_auditstatus(@RequestParam("access_token") String accessToken);


    /**
     * 发布已通过审核的小程序（仅供第三方代小程序调用）
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/release", method = RequestMethod.POST)
    BaseResponse release(@RequestParam("access_token") String accessToken, @RequestBody Map map);

    /**
     * 修改小程序线上代码的可见状态（仅供第三方代小程序调用）
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/change_visitstatus", method = RequestMethod.POST)
    BaseResponse change_visitstatus(@RequestParam("access_token") String accessToken, @RequestBody Map map);

    /**
     * 小程序版本回退（仅供第三方代小程序调用）
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/revertcoderelease", method = RequestMethod.GET)
    BaseResponse revertcoderelease(@RequestParam("access_token") String accessToken);


    /**
     * 小程序审核撤回
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/undocodeaudit", method = RequestMethod.GET)
    BaseResponse undocodeaudit(@RequestParam("access_token") String accessToken);

    /**
     * 分阶段发布接口
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/grayrelease", method = RequestMethod.POST)
    BaseResponse grayrelease(@RequestParam("access_token") String accessToken, @RequestBody Map map);

    /**
     * 分阶段发布接口
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/revertgrayrelease", method = RequestMethod.GET)
    BaseResponse revertgrayrelease(@RequestParam("access_token") String accessToken);

    /**
     * 查询当前分阶段发布详情
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/getgrayreleaseplan", method = RequestMethod.GET)
    BaseResponse getgrayreleaseplan(@RequestParam("access_token") String accessToken);

    /**
     * 获取草稿箱内的所有临时代码草稿
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/gettemplatedraftlist", method = RequestMethod.GET)
    BaseResponse gettemplatedraftlist(@RequestParam("access_token") String accessToken);

    /**
     * 获取代码模版库中的所有小程序代码模版
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/gettemplatelist", method = RequestMethod.GET)
    BaseResponse gettemplatelist(@RequestParam("access_token") String accessToken);

    /**
     * 将草稿箱的草稿选为小程序代码模版
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/addtotemplate", method = RequestMethod.POST)
    BaseResponse addtotemplate(@RequestParam("access_token") String accessToken, @RequestBody Map map);

    /**
     * 删除指定小程序代码模版
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/deletetemplate", method = RequestMethod.POST)
    BaseResponse deletetemplate(@RequestParam("access_token") String accessToken, @RequestBody Map map);

    /**
     * 支付后获取用户Unionid接口-商户订单号
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/getpaidunionid", method = RequestMethod.POST)
    BaseResponse getpaidunionid4WX(@RequestParam("access_token") String accessToken, @RequestParam("openid") String openid,
                                   @RequestParam("transaction_id") String transaction_id);

    /**
     * 支付后获取用户Unionid接口-微信订单号
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/getpaidunionid", method = RequestMethod.POST)
    BaseResponse getpaidunionid4Mch(@RequestParam("access_token") String accessToken, @RequestParam("openid") String openid,
                                    @RequestParam("mch_id") String mch_id,
                                    @RequestParam("out_trade_no") String out_trade_no);

    /**
     * 申请使用插件接口
     * 查询已添加的插件
     * 删除已添加的插件
     * 快速更新插件版本
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/plugin", method = RequestMethod.POST)
    BaseResponse plugin(@RequestParam("access_token") String accessToken, @RequestBody Map map);
}
