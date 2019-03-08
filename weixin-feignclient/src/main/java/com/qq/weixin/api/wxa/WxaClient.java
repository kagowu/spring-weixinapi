package com.qq.weixin.api.wxa;

import com.alibaba.fastjson.JSON;
import com.google.common.io.BaseEncoding;
import com.qq.weixin.api.BaseRequest;
import com.qq.weixin.api.BaseResponse;
import com.qq.weixin.api.FeignConfiguration;
import com.qq.weixin.api.wxa.request.GetwxacodeRequest;
import com.qq.weixin.api.wxa.request.ModifyDomainRequest;
import com.qq.weixin.api.wxa.request.WebviewdomainRequest;
import com.qq.weixin.api.wxa.response.GetwxacodeResopnse;
import com.qq.weixin.api.wxa.response.ModifyDomainResopnse;
import com.qq.weixin.api.wxa.response.PluginResponse;
import feign.Response;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Collection;

/**
 * @author gong.hua
 */
@FeignClient(name = "wxa", url = "https://api.weixin.qq.com/wxa/", configuration = FeignConfiguration.class)
public interface WxaClient {
    /**
     * <pre>
     *     <h1>修改服务器地址</h1>
     * @link {https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1489138143_WPbOO&token=95d7ef0e1ad4b63a3421a661ae1309b35e502195&lang=}
     *1、设置小程序服务器域名
     * 授权给第三方的小程序，其服务器域名只可以为第三方的服务器，当小程序通过第三方发布代码上线后，小程序原先自己配置的服务器域名将被删除，只保留第三方平台的域名，所以第三方平台在代替小程序发布代码之前，需要调用接口为小程序添加第三方自身的域名。
     * 提示：需要先将域名登记到第三方平台的小程序服务器域名中，才可以调用接口进行配置。
     * @see #modifyDomain
     *
     * 2、设置小程序业务域名（仅供第三方代小程序调用）
     * 授权给第三方的小程序，其业务域名只可以为第三方的服务器，当小程序通过第三方发布代码上线后，小程序原先自己配置的业务域名将被删除，只保留第三方平台的域名，所以第三方平台在代替小程序发布代码之前，需要调用接口为小程序添加业务域名。
     *
     * 提示：
     * 1、需要先将域名登记到第三方平台的小程序业务域名中，才可以调用接口进行配置。
     * 2、为授权的小程序配置域名时支持配置子域名，例如第三方登记的业务域名如为qq.com，则可以直接将qq.com及其子域名（如xxx.qq.com）也配置到授权的小程序中。
     * @see #setwebviewdomain
     * </pre>
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
    BaseResponse setnickname(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 小程序改名审核状态查询
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/api_wxa_querynickname", method = RequestMethod.POST)
    BaseResponse apiWxaQuerynickname(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);


    /**
     * <pre>
     *     <h1>代小程序实现业务-基础信息设置</h1>
     * 1. 设置小程序隐私设置（是否可被搜索）
     *  @see #changewxasearchstatus
     * 2. 查询小程序当前隐私设置（是否可被搜索）
     *  @see #getwxasearchstatus
     * 3 小程序扫码公众号关注组件
     *   用户扫码使用小程序时，即可展示当前公众号，用户可直接关注公众号。
     *   3.1. 获取展示的公众号信息
     *   @see #getshowwxaitem
     *   3.2 设置展示的公众号
     *   @see #updateshowwxaitem
     *   3.3 获取可以用来设置的公众号列表
     *   @see #getwxamplinkforshow
     * </pre>
     * 设置小程序隐私设置（是否可被搜索）
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/changewxasearchstatus", method = RequestMethod.POST)
    BaseResponse changewxasearchstatus(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 查询小程序当前隐私设置（是否可被搜索）
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/getwxasearchstatus", method = RequestMethod.POST)
    BaseResponse getwxasearchstatus(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

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
    BaseResponse updateshowwxaitem(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);


    /**
     * 获取可以用来设置的公众号列表
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/getwxamplinkforshow", method = RequestMethod.POST)
    BaseResponse getwxamplinkforshow(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * <pre>
     *     <h1>代小程序实现业务-成员管理</h1>
     * @link {https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1489140588_nVUgx&token=&lang=zh_CN}
     * 1、绑定微信用户为小程序体验者
     *  @see #bindTester
     * 2、解除绑定小程序的体验者
     *  @see #unbindTester
     * 3. 获取体验者列表
     *  @see #memberauth
     * </pre>
     * 绑定微信用户为小程序体验者
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/bind_tester", method = RequestMethod.POST)
    BaseResponse bindTester(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 解除绑定小程序的体验者
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/unbind_tester", method = RequestMethod.POST)
    BaseResponse unbindTester(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 获取体验者列表
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/memberauth", method = RequestMethod.POST)
    BaseResponse memberauth(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);


    /**
     * <pre>
     * <h1>代小程序实现业务-代码管理</h1>
     * @link {https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1489140610_Uavc4&token=&lang=zh_CN}
     * 1、为授权的小程序帐号上传小程序代码
     * @see #commit
     * 2、获取体验小程序的体验二维码
     * @see #getQrcode
     * 3、获取授权小程序帐号已设置的类目
     * @see #getCategory
     * 4、获取小程序的第三方提交代码的页面配置（仅供第三方开发者代小程序调用）
     * @see #getPage
     * 5、将第三方提交的代码包提交审核（仅供第三方开发者代小程序调用）
     * @see #submitAudit
     * 6、获取审核结果
     *   当小程序有审核结果后，第三方平台将可以通过开放平台上填写的回调地址，获得审核结果通知。
     *   除了消息通知之外，第三方平台也可通过接口查询审核状态。
     * 7、查询某个指定版本的审核状态（仅供第三方代小程序调用）
     * @see #getAuditstatus
     * 8、查询最新一次提交的审核状态（仅供第三方代小程序调用）
     * @see #getLatestAuditstatus
     * 9、发布已通过审核的小程序（仅供第三方代小程序调用）
     * @see #release
     * 10、修改小程序线上代码的可见状态（仅供第三方代小程序调用）
     * @see #changeVisitstatus
     * 11. 小程序版本回退（仅供第三方代小程序调用）
     * @see #revertcoderelease
     * 12. 查询当前设置的最低基础库版本及各版本用户占比（仅供第三方代小程序调用）
     * @see com.qq.weixin.api.cgibin.CgibinClient#wxopenGetweappsupportversion
     * 13. 设置最低基础库版本（仅供第三方代小程序调用）
     * @see com.qq.weixin.api.cgibin.CgibinClient#wxopenSetweappsupportversion
     * 14. 设置小程序“扫普通链接二维码打开小程序”能力
     * @link {https://developers.weixin.qq.com/miniprogram/introduction/qrcode.html}
     * (1)增加或修改二维码规则
     * @see com.qq.weixin.api.cgibin.CgibinClient#wxopenQrcodejumpadd
     * (2)获取已设置的二维码规则
     * @see com.qq.weixin.api.cgibin.CgibinClient#wxopenQrcodejumpget
     * (3)获取校验文件名称及内容
     * @see com.qq.weixin.api.cgibin.CgibinClient#wxopenQrcodejumpdownload
     * (4)删除已设置的二维码规则
     * @see com.qq.weixin.api.cgibin.CgibinClient#wxopenQrcodejumpdelete
     * (5)发布已设置的二维码规则
     * @see com.qq.weixin.api.cgibin.CgibinClient#wxopenQrcodejumppublish
     * 15. 小程序审核撤回
     * 单个帐号每天审核撤回次数最多不超过1次，一个月不超过10次。
     * @see #undocodeaudit
     * 16.小程序分阶段发布
     * （1）分阶段发布接口
     * @see #grayrelease
     * （2）取消分阶段发布
     * @see #revertgrayrelease
     * （3）查询当前分阶段发布详情
     * @see #getgrayreleaseplan
     * </pre>
     * 为授权的小程序帐号上传小程序代码
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/commit", method = RequestMethod.POST)
    BaseResponse commit(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 获取体验小程序的体验二维码
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/get_qrcode", method = RequestMethod.GET)
    BaseResponse getQrcode(@RequestParam("access_token") String accessToken, @RequestParam("path") String path);

    /**
     * 获取授权小程序帐号已设置的类目
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/get_category", method = RequestMethod.GET)
    BaseResponse getCategory(@RequestParam("access_token") String accessToken);

    /**
     * 获取小程序的第三方提交代码的页面配置（仅供第三方开发者代小程序调用）
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/get_page", method = RequestMethod.GET)
    BaseResponse getPage(@RequestParam("access_token") String accessToken);

    /**
     * 将第三方提交的代码包提交审核（仅供第三方开发者代小程序调用）
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/submit_audit", method = RequestMethod.GET)
    BaseResponse submitAudit(@RequestParam("access_token") String accessToken);

    /**
     * 查询某个指定版本的审核状态（仅供第三方代小程序调用）
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/get_auditstatus", method = RequestMethod.POST)
    BaseResponse getAuditstatus(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 查询最新一次提交的审核状态（仅供第三方代小程序调用）
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/get_latest_auditstatus", method = RequestMethod.GET)
    BaseResponse getLatestAuditstatus(@RequestParam("access_token") String accessToken);


    /**
     * 发布已通过审核的小程序（仅供第三方代小程序调用）
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/release", method = RequestMethod.POST)
    BaseResponse release(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 修改小程序线上代码的可见状态（仅供第三方代小程序调用）
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/change_visitstatus", method = RequestMethod.POST)
    BaseResponse changeVisitstatus(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

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
    BaseResponse grayrelease(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

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
     * <pre>
     * <h1>代小程序实现业务-小程序代码模版库管理</h1>
     * @link {https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1506504150_nMMh6&token=&lang=zh_CN}
     * 1、获取草稿箱内的所有临时代码草稿
     *  @see #gettemplatedraftlist
     * 2、获取代码模版库中的所有小程序代码模版
     *  @see #gettemplatelist
     * 3、将草稿箱的草稿选为小程序代码模版
     *  @see #addtotemplate
     * 4、删除指定小程序代码模版
     *  @see #deletetemplate
     * </pre>
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
    BaseResponse addtotemplate(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 删除指定小程序代码模版
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/deletetemplate", method = RequestMethod.POST)
    BaseResponse deletetemplate(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 支付后获取用户Unionid接口-商户订单号
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/getpaidunionid", method = RequestMethod.POST)
    BaseResponse getpaidunionid4WX(@RequestParam("access_token") String accessToken, @RequestParam("openid") String openid,
                                   @RequestParam("transaction_id") String transactionId);

    /**
     * 支付后获取用户Unionid接口-微信订单号
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/getpaidunionid", method = RequestMethod.POST)
    BaseResponse getpaidunionid4Mch(@RequestParam("access_token") String accessToken, @RequestParam("openid") String openid,
                                    @RequestParam("mch_id") String mchId,
                                    @RequestParam("out_trade_no") String outTradeNo);

    /**
     * <pre>
     * <h1>代小程序实现业务-小程序插件管理权限集</h1>
     * @link {https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=21521637082Sqi4M&token=&lang=zh_CN}
     * 1.申请使用插件
     * @see #pluginApply
     * 2.查询已添加的插件
     * @see #pluginList
     * 3.删除已添加的插件
     * @see #pluginUnbind
     * 4.快速更新插件版本号
     * @see #pluginUpdate
     * </pre>
     * 申请使用插件接口
     *
     * @param accessToken
     * @return
     * @link {https://developers.weixin.qq.com/miniprogram/dev/api/applyPlugin.html}
     */
    @RequestMapping(value = "/plugin", method = RequestMethod.POST)
    PluginResponse plugin(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 申请使用插件接口
     *
     * @param accessToken
     * @param pluginAppid
     * @return
     */
    default BaseResponse pluginApply(String accessToken, String pluginAppid) {
        BaseRequest baseRequest = new BaseRequest();
        baseRequest.put("action", "apply");
        baseRequest.put("plugin_appid", pluginAppid);
        return plugin(accessToken, baseRequest);
    }

    /**
     * 查询已添加的插件
     *
     * @param accessToken
     * @return
     */
    default PluginResponse pluginList(String accessToken) {
        BaseRequest baseRequest = new BaseRequest();
        baseRequest.put("action", "list");
        return plugin(accessToken, baseRequest);
    }

    /**
     * 删除已添加的插件
     *
     * @param accessToken
     * @param pluginAppid
     * @return
     */
    default BaseResponse pluginUnbind(String accessToken, String pluginAppid) {
        BaseRequest baseRequest = new BaseRequest();
        baseRequest.put("action", "unbind");
        baseRequest.put("plugin_appid", pluginAppid);
        return plugin(accessToken, baseRequest);
    }


    /**
     * 快速更新插件版本号
     *
     * @param accessToken
     * @param pluginAppid
     * @param userVersion
     * @return
     */
    default BaseResponse pluginUpdate(String accessToken, String pluginAppid, String userVersion) {
        BaseRequest baseRequest = new BaseRequest();
        baseRequest.put("action", "update");
        baseRequest.put("user_version", userVersion);
        baseRequest.put("plugin_appid", pluginAppid);
        return plugin(accessToken, baseRequest);
    }

    /**
     * 获取当前所有插件使用方（供插件开发者调用）
     *
     * @param accessToken
     * @return
     * @link {https://developers.weixin.qq.com/miniprogram/dev/api/getPluginDevApplyList.html}
     */
    @RequestMapping(value = "/devplugin", method = RequestMethod.POST)
    BaseResponse devplugin(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);


    /**
     * 附近的小程序--添加地点
     *
     * @param accessToken
     * @return
     * @link {https://developers.weixin.qq.com/miniprogram/dev/api/addNearbyPoi.html}
     */
    @RequestMapping(value = "/addnearbypoi", method = RequestMethod.POST)
    BaseResponse addnearbypoi(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 附近的小程序--删除地点
     *
     * @param accessToken
     * @return
     * @link {https://developers.weixin.qq.com/miniprogram/dev/api/deleteNearbyPoi.html}
     */
    @RequestMapping(value = "/delnearbypoi", method = RequestMethod.POST)
    BaseResponse delnearbypoi(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 展示/取消展示附近小程序
     *
     * @param accessToken
     * @return
     * @link {https://developers.weixin.qq.com/miniprogram/dev/api/setNearbyPoiShowStatus.html}
     */
    @RequestMapping(value = "/setnearbypoishowstatus", method = RequestMethod.POST)
    BaseResponse setnearbypoishowstatus(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 获取小程序码，适用于需要的码数量较少的业务场景。
     * 通过该接口生成的小程序码，永久有效，有数量限制
     * <pre>
     * @see #getwxacodeunlimit
     * @see com.qq.weixin.api.cgibin.CgibinClient#wxaappCreatewxaqrcode
     * </pre>
     *
     * @param accessToken
     * @return
     * @link {https://developers.weixin.qq.com/miniprogram/dev/api/getWXACode.html}
     */
    @RequestMapping(value = "/getwxacode", method = RequestMethod.POST)
    Response getwxacode(@RequestParam("access_token") String accessToken, @RequestBody GetwxacodeRequest getwxacodeRequest);

    /**
     * 获取小程序码，适用于需要的码数量较少的业务场景。
     * @see #getwxacode
     * @param accessToken
     * @param getwxacodeRequest
     * @return
     * @throws IOException
     */
    default GetwxacodeResopnse getwxacodeWrapper(String accessToken, GetwxacodeRequest getwxacodeRequest) throws IOException {
        Response response = getwxacode(accessToken, getwxacodeRequest);
        return getGetwxacodeResopnse(response);
    }

    default GetwxacodeResopnse getGetwxacodeResopnse(Response response) throws IOException {
        Collection<String> contentTypes = response.headers().get("Content-Type");
        String contentType = contentTypes.stream().findFirst().orElse("");

        if (contentType.contains("json")) {
            return JSON.parseObject(feign.Util.toString(response.body().asReader()), GetwxacodeResopnse.class);
        }

        byte[] bytes = feign.Util.toByteArray(response.body().asInputStream());
        GetwxacodeResopnse codeResponse = new GetwxacodeResopnse();
        codeResponse.setDataUrl(String.format("data:%s;base64,%s", contentType, BaseEncoding.base64().encode(bytes)));
        return codeResponse;
    }

    /**
     * 获取小程序码，适用于需要的码数量极多的业务场景。
     * 通过该接口生成的小程序码，永久有效，数量暂无限制
     *
     * @param accessToken
     * @return
     * @link {https://developers.weixin.qq.com/miniprogram/dev/api/getWXACodeUnlimit.html}
     */
    @RequestMapping(value = "/getwxacodeunlimit", method = RequestMethod.POST)
    Response getwxacodeunlimit(@RequestParam("access_token") String accessToken, @RequestBody GetwxacodeRequest getwxacodeRequest);


    /**
     * 获取小程序码，适用于需要的码数量极多的业务场景。
     * @see #getwxacodeunlimit
     * @param accessToken
     * @param getwxacodeRequest
     * @return
     * @throws IOException
     */
    default GetwxacodeResopnse getwxacodeunlimitWrapper(String accessToken, GetwxacodeRequest getwxacodeRequest) throws IOException {
        Response response = getwxacodeunlimit(accessToken, getwxacodeRequest);
        return getGetwxacodeResopnse(response);
    }
    /**
     * 校验一张图片是否含有违法违规内容。
     * FIXME
     *
     * @param accessToken
     * @return
     * @link {https://developers.weixin.qq.com/miniprogram/dev/api/imgSecCheck.html}
     */
    @RequestMapping(value = "/img_sec_check", method = RequestMethod.POST)
    BaseResponse imgSecCheck(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 检查一段文本是否含有违法违规内容。
     *
     * @param accessToken
     * @return
     * @link {https://developers.weixin.qq.com/miniprogram/dev/api/msgSecCheck.html}
     */
    @RequestMapping(value = "/msg_sec_check", method = RequestMethod.POST)
    BaseResponse msgSecCheck(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);
}
