package com.qq.weixin.api.cgibin;


import com.qq.weixin.api.BaseRequest;
import com.qq.weixin.api.BaseResponse;
import com.qq.weixin.api.cgibin.request.*;
import com.qq.weixin.api.cgibin.response.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@FeignClient(name = "cgi-bin", url = "https://api.weixin.qq.com/cgi-bin/")
public interface CgibinClient {
    /**
     * 获取全局AccessToken接口
     *
     * @param appid
     * @param secret
     * @return
     * @link {https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140183}
     * 小程序文档
     * @link {https://developers.weixin.qq.com/miniprogram/dev/api/getAccessToken.html}
     */
    @RequestMapping(value = "/token?grant_type=client_credential", method = RequestMethod.GET)
    TokenResponse token(@RequestParam("appid") String appid, @RequestParam("secret") String secret);

    /**
     * 调用次数清零API的权限
     *
     * @return
     */
    @RequestMapping(value = "/clear_quota", method = RequestMethod.POST)
    BaseResponse clear_quota(@RequestParam("access_token") String access_token, @RequestBody BaseRequest baseRequest);

    /**
     * 自定义菜单创建接口
     *
     * @param accessToken
     * @param menuCreateRequest
     * @return
     * @link {https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421141013}
     */
    @RequestMapping(value = "/menu/create", method = RequestMethod.POST)
    BaseResponse menuCreate(@RequestParam("access_token") String accessToken, @RequestBody MenuCreateRequest menuCreateRequest);

    /**
     * 自定义菜单删除接口
     *
     * @param accessToken
     * @return
     * @link {https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421141015}
     */
    @RequestMapping(value = "/menu/delete", method = RequestMethod.GET)
    BaseResponse menuDelete(@RequestParam("access_token") String accessToken);

    /**
     * 自定义菜单查询接口
     *
     * @param accessToken
     * @return
     * @link {https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421141014}
     */
    @RequestMapping(value = "/menu/get", method = RequestMethod.GET)
    MenuGetResponse menuGet(@RequestParam("access_token") String accessToken);


    /**
     * 个性化菜单接口
     *
     * @param accessToken
     * @param menuAddconditionalRequest
     * @return
     * @link {https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1455782296}
     */
    @RequestMapping(value = "/menu/addconditional", method = RequestMethod.POST)
    BaseResponse menuAddconditional(@RequestParam("access_token") String accessToken, @RequestBody MenuAddconditionalRequest menuAddconditionalRequest);

    /**
     * 生成带参数的二维码
     *
     * @param accessToken
     * @return
     * @link {https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1443433542}
     */
    @RequestMapping(value = "/qrcode/create", method = RequestMethod.POST)
    QrcodeCreateResponse qrcodeCreate(@RequestParam("access_token") String accessToken, @RequestBody QrcodeCreateRequest qrcodeCreateRequest);

    /**
     * JS-SDK使用权限签名算法
     *
     * @param accessToken
     * @return
     * @link {https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421141115}
     */
    @RequestMapping(value = "/ticket/getticket?type=jsapi", method = RequestMethod.GET)
    TicketGetticketResponse ticketGetticket(@RequestParam("access_token") String accessToken);


    /**
     * 下发客服当前输入状态给用户
     *
     * @param accessToken
     * @return
     * @link {https://developers.weixin.qq.com/miniprogram/dev/api/customerTyping.html}
     */
    @RequestMapping(value = "/message/custom/typing", method = RequestMethod.POST)
    BaseResponse messageCustomTyping(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 发送客服消息给用户
     *
     * @param accessToken
     * @return
     * @link {https://developers.weixin.qq.com/miniprogram/dev/api/sendCustomerMessage.html}
     */
    @RequestMapping(value = "/message/custom/send", method = RequestMethod.POST)
    BaseResponse messageCustomSend(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);


    /**
     * 发送模板消息
     *
     * @param accessToken
     * @return
     * @link {https://developers.weixin.qq.com/miniprogram/dev/api/sendTemplateMessage.html}
     */
    @RequestMapping(value = "/message/wxopen/template/send", method = RequestMethod.POST)
    BaseResponse messageWxopenTemplateSend(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 下发小程序和公众号统一的服务消息
     *
     * @param accessToken
     * @return
     * @link {https://developers.weixin.qq.com/miniprogram/dev/api/sendTemplateMessage.html}
     */
    @RequestMapping(value = "/message/wxopen/template/uniform_send", method = RequestMethod.POST)
    BaseResponse messageWxopenTemplateUniform_send(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 创建被分享动态消息的 activity_id
     *
     * @param accessToken
     * @return
     * @link {https://developers.weixin.qq.com/miniprogram/dev/api/createActivityId.html}
     */
    @RequestMapping(value = "/message/wxopen/activityid/create", method = RequestMethod.POST)
    BaseResponse messageWxopenActivityidCreate(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 修改被分享的动态消息
     *
     * @param accessToken
     * @return
     * @link {https://developers.weixin.qq.com/miniprogram/dev/api/setUpdatableMsg.html}
     */
    @RequestMapping(value = "/message/wxopen/updatablemsg/send", method = RequestMethod.POST)
    BaseResponse messageWxopenUpdatablesgSend(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);


    /**
     * 获取客服消息内的临时素材。即下载临时的多媒体文件。目前小程序仅支持下载图片文件
     *
     * @param accessToken
     * @return
     * @link {https://developers.weixin.qq.com/miniprogram/dev/api/getTempMedia.html}
     */
    @RequestMapping(value = "/media/get", method = RequestMethod.POST)
    BaseResponse mediaGet(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 把媒体文件上传到微信服务器。目前仅支持图片。用于发送客服消息或被动回复用户消息
     * FIXME formdata
     *
     * @param accessToken
     * @return
     * @link {https://developers.weixin.qq.com/miniprogram/dev/api/uploadTempMedia.html}
     */
    @RequestMapping(value = "/media/upload", method = RequestMethod.POST)
    BaseResponse mediaUpload(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 第三方平台对其所有API调用次数清零（只与第三方平台相关，与公众号无关，接口如api_component_token）
     *
     * @return
     */
    @RequestMapping(value = "component/clear_quota", method = RequestMethod.POST)
    BaseResponse componentClear_quota(@RequestParam("component_access_token") String component_access_token, @RequestBody BaseRequest baseRequest);


    /**
     * 获取第三方平台token
     *
     * @param componentTokenRequest
     * @return
     */
    @RequestMapping(value = "/component/api_component_token", method = RequestMethod.POST)
    ComponentTokenResponse componentApiComponentToken(@RequestBody ComponentTokenRequest componentTokenRequest);

    /**
     * 授权流程-获取预授权码pre_auth_code
     *
     * @param componentAccessToken
     * @return
     */
    @RequestMapping(value = "/component/api_create_preauthcode", method = RequestMethod.POST)
    ComponentApi_create_preauthcodeResponse componentApi_create_preauthcode(@RequestParam("component_access_token") String componentAccessToken, @RequestBody ComponentApi_create_preauthcodeRequest componentApi_create_preauthcodeRequest);


    /**
     * 授权流程-使用授权码换取公众号或小程序的接口调用凭据和授权信息
     *
     * @param componentAccessToken
     * @return
     */
    @RequestMapping(value = "/component/api_query_auth", method = RequestMethod.POST)
    ComponentApi_query_authResponse componentApi_query_auth(@RequestParam("component_access_token") String componentAccessToken, @RequestBody ComponentApi_query_authRequest componentApi_query_authRequest);


    /**
     * 授权流程-获取（刷新）授权公众号或小程序的接口调用凭据（令牌）
     *
     * @param componentAccessToken
     * @return
     */
    @RequestMapping(value = "/component/api_authorizer_token", method = RequestMethod.POST)
    ComponentApi_authorizer_tokenResponse componentApi_authorizer_token(@RequestParam("component_access_token") String componentAccessToken, @RequestBody ComponentApi_authorizer_tokenRequest componentApi_authorizer_tokenRequest);


    /**
     * 授权流程-获取授权方的帐号基本信息
     * -公众号获取方法
     * -小程序获取方法如下  返回结果不同
     *
     * @param componentAccessToken
     * @return
     */
    @RequestMapping(value = "/component/api_get_authorizer_info", method = RequestMethod.POST)
    ComponentApi_get_authorizer_infoResponse componentApi_get_authorizer_info(@RequestParam("component_access_token") String componentAccessToken, @RequestBody ComponentApi_get_authorizer_infoRequest componentApi_get_authorizer_infoRequest);

    /**
     * 授权流程-获取授权方的选项设置信息
     *
     * @param componentAccessToken
     * @return
     */
    @RequestMapping(value = "/component/api_get_authorizer_option", method = RequestMethod.POST)
    ComponentApi_get_authorizer_optionResponse componentApi_get_authorizer_option(@RequestParam("component_access_token") String componentAccessToken, @RequestBody ComponentApi_get_authorizer_optionRequest componentApi_get_authorizer_optionRequest);


    /**
     * 设置授权方的选项信息
     *
     * @param componentAccessToken
     * @return
     */
    @RequestMapping(value = "/component/api_set_authorizer_option", method = RequestMethod.POST)
    BaseResponse componentApi_set_authorizer_option(@RequestParam("component_access_token") String componentAccessToken, @RequestBody ComponentApi_set_authorizer_optionRequest componentApi_set_authorizer_optionRequest);


    /**
     * <pre>
     * <h1>代小程序实现业务-快速创建小程序接口文档</h1>
     * @link {https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=21538208049W8uwq&token=2dc40382b1879696f2d7c35d221d8844cae685fd&lang=}
     *
     * 1、权限集准备：第三方平台需具有以下权限集。（更新权限集后，需通过审核并全网发布后才可生效）
     * 2、第三方收集法人微信、法人姓名、企业名称、信用代码四个商户信息外加第三方客服电话，方便商家与第三方联系（建议填写第三方客服电话）；
     * 3、企业名称需与工商部门登记信息一致；法人姓名与绑定微信银行卡的姓名一致。信息收集时要确保四个信息的对应关系，否则接口无法成功调用。
     * 4、通过法人&企业主体校验，平台向法人微信下发模板消息。法人需在24小时内点击消息，进行身份证信息与人脸识别信息收集；
     *  创建小程序接口
     * @see CgibinClient#componentFastregisterweappCreate
     *  查询创建任务状态
     * @see CgibinClient#componentFastregisterweappSearch
     * 5、信息收集完毕，验证通过后，即可创建已认证的小程序。第三方平台服务器可以收到创建appid信息（通过授权登录相关-授权事件接收URL接收信息）；
     * 6、第三方获得小程序appid后，可调用代码开发相关接口，完成后续的小程序代码开发。
     *
     *
     * </pre>
     * 快速创建小程序接口-创建小程序接口
     *
     * @param componentFastregisterweappCreateRequest
     * @return
     */
    @RequestMapping(value = "/component/fastregisterweapp?action=create", method = RequestMethod.POST)
    BaseResponse componentFastregisterweappCreate(@RequestParam("component_access_token") String componentAccessToken, @RequestBody ComponentFastregisterweappCreateRequest componentFastregisterweappCreateRequest);

    /**
     * 快速创建小程序接口-查询创建任务状态
     *
     * @param componentFastregisterweappSearchRequest
     * @return
     */
    @RequestMapping(value = "/component/fastregisterweapp?action=search", method = RequestMethod.POST)
    BaseResponse componentFastregisterweappSearch(@RequestParam("component_access_token") String componentAccessToken, @RequestBody ComponentFastregisterweappSearchRequest componentFastregisterweappSearchRequest);


    /**
     * <pre>
     * <h1>小程序信息设置</h1>
     * @link {https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=21528465979XX32V&token=&lang=zh_CN}
     * 1 获取帐号基本信息
     * @see #accountGetaccountbasicinfo
     * 2 小程序名称设置及改名
     * @see com.qq.weixin.api.wxa.WxaClient#setnickname
     * 3 小程序改名审核状态查询
     * @see com.qq.weixin.api.wxa.WxaClient#api_wxa_querynickname
     * 4 微信认证名称检测
     * @see #wxverifyCheckwxverifynickname
     * 5 修改头像
     * @see #accountModifyheadimage
     * 6 修改功能介绍
     * @see #accountModifysignature
     * 7 换绑小程序管理员接口
     *  流程
     *  步骤一：从第三方平台页面发起，并跳转至微信公众平台指定换绑页面。
     *    @see com.qq.weixin.mp.MpUrlFormatter#getComponentrebindadminUrl
     *  步骤二：小程序原管理员扫码，并填写原管理员身份证信息确认。
     *    点击页面提交按钮。
     *    跳转回第三方平台，会在上述 redirect_uri 后拼接 taskid=*
     *    跳转回第三方平台举例： https://www.qq.com/auth/callback?taskid=b25519093b1e97239eff9d2bfc07e08e
     *  步骤三：填写新管理员信息(姓名、身份证、手机号)，使用新管理员的微信确认。
     *  步骤四：点击提交后跳转至第三方平台页面，第三方平台回调对应 api 完成换绑流程。
     *     @see #accountComponentrebindadmin
     * 8 类目相关接口
     *  8.1 获取账号可以设置的所有类目
     *   @see #wxopenGetallcategories
     *  8.2添加类目
     *   @see #wxopenAddcategory
     *  8.3删除类目
     *   @see #wxopenDeletecategory
     *  8.4获取账号已经设置的所有类目
     *   @see #wxopenGetcategory
     *  8.5修改类目
     *   @see #wxopenModifycategory
     * </pre>
     * 小程序信息设置-获取帐号基本信息
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/account/getaccountbasicinfo", method = RequestMethod.POST)
    BaseResponse accountGetaccountbasicinfo(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 修改头像
     * FIXME
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/account/modifyheadimage", method = RequestMethod.POST)
    BaseResponse accountModifyheadimage(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);


    /**
     * 换绑小程序管理员接口-跳转至第三方平台，第三方平台调用快速注册API完成管理员换绑。
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/account/componentrebindadmin", method = RequestMethod.POST)
    BaseResponse accountComponentrebindadmin(@RequestParam("access_token") String accessToken, @RequestBody AccountComponentrebindadminRequest accountComponentrebindadminRequest);


    /**
     * 修改功能介绍
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/account/modifysignature", method = RequestMethod.POST)
    BaseResponse accountModifysignature(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);


    /**
     * 跳转至第三方平台，第三方平台调用快速注册API完成注册
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/account/fastregister", method = RequestMethod.POST)
    BaseResponse accountFastregister(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 微信认证名称检测
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "wxverify/checkwxverifynickname", method = RequestMethod.POST)
    BaseResponse wxverifyCheckwxverifynickname(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 获取账号可以设置的所有类目
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "wxopen/getallcategories", method = RequestMethod.GET)
    BaseResponse wxopenGetallcategories(@RequestParam("access_token") String accessToken);

    /**
     * 添加类目
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "wxopen/addcategory", method = RequestMethod.POST)
    BaseResponse wxopenAddcategory(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);


    /**
     * 删除类目
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "wxopen/deletecategory", method = RequestMethod.POST)
    BaseResponse wxopenDeletecategory(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 获取账号已经设置的所有类目
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "wxopen/getcategory", method = RequestMethod.POST)
    BaseResponse wxopenGetcategory(@RequestParam("access_token") String accessToken);

    /**
     * 修改类目
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "wxopen/modifycategory", method = RequestMethod.POST)
    BaseResponse wxopenModifycategory(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 查询当前设置的最低基础库版本及各版本用户占比（仅供第三方代小程序调用）
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "wxopen/getweappsupportversion", method = RequestMethod.GET)
    BaseResponse wxopenGetweappsupportversion(@RequestParam("access_token") String accessToken);

    /**
     * 获取公众号关联的小程序
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "wxopen/wxamplinkget", method = RequestMethod.GET)
    BaseResponse wxopenWxamplinkget(@RequestParam("access_token") String accessToken);

    /**
     * 关联小程序
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "wxopen/wxamplink", method = RequestMethod.GET)
    BaseResponse wxopenWxamplink(@RequestParam("access_token") String accessToken);


    /**
     * 关联小程序
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "wxopen/wxampunlink", method = RequestMethod.GET)
    BaseResponse wxopenWxampunlink(@RequestParam("access_token") String accessToken);

    /**
     * 设置最低基础库版本（仅供第三方代小程序调用）
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "wxopen/setweappsupportversion", method = RequestMethod.GET)
    BaseResponse wxopenSetweappsupportversion(@RequestParam("access_token") String accessToken);

    /**
     * 增加或修改二维码规则
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "wxopen/qrcodejumpadd", method = RequestMethod.POST)
    BaseResponse wxopenQrcodejumpadd(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 增加或修改二维码规则
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "wxopen/qrcodejumpget", method = RequestMethod.POST)
    BaseResponse wxopenQrcodejumpget(@RequestParam("access_token") String accessToken);

    /**
     * 获取校验文件名称及内容
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "wxopen/qrcodejumpdownload", method = RequestMethod.POST)
    BaseResponse wxopenQrcodejumpdownload(@RequestParam("access_token") String accessToken);

    /**
     * 删除已设置的二维码规则
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "wxopen/qrcodejumpdelete", method = RequestMethod.POST)
    BaseResponse wxopenQrcodejumpdelete(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 发布已设置的二维码规则
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "wxopen/qrcodejumppublish", method = RequestMethod.POST)
    BaseResponse wxopenQrcodejumppublish(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * <pre>
     * <h1>代小程序实现业务-小程序模板设置</h1>
     * @link {https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1500465446_j4CgR&token=&lang=zh_CN}
     * 1.获取小程序模板库标题列表
     *  @see #wxopenTemplateLibararyList
     * 2.获取模板库某个模板标题下关键词库
     *  @see #wxopenTemplateLibararyGet
     * 3.组合模板并添加至帐号下的个人模板库
     *   @see #wxopenTemplateLibararyAdd
     * 4.获取帐号下已存在的模板列表
     *   @see #wxopenTemplateList
     * 5.删除帐号下的某个模板
     *   @see #wxopenTemplateDel
     * @link {https://developers.weixin.qq.com/miniprogram/dev/framework/open-ability/template-message.html}
     * </pre>
     * 模板消息-获取小程序模板库标题列表
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "wxopen/template/library/list", method = RequestMethod.POST)
    BaseResponse wxopenTemplateLibararyList(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 模板消息-获取模板库某个模板标题下关键词库
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "wxopen/template/library/get", method = RequestMethod.POST)
    BaseResponse wxopenTemplateLibararyGet(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 模板消息-组合模板并添加至帐号下的个人模板库
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "wxopen/template/library/add", method = RequestMethod.POST)
    BaseResponse wxopenTemplateLibararyAdd(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 模板消息-获取帐号下已存在的模板列表
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "wxopen/template/list", method = RequestMethod.POST)
    BaseResponse wxopenTemplateList(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 模板消息-删除帐号下的某个模板
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "wxopen/template/del", method = RequestMethod.POST)
    BaseResponse wxopenTemplateDel(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * <pre>
     * <h1>代小程序实现业务-微信开放平台帐号管理</h1>
     * @link {https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1498704199_1bcax&token=&lang=zh_CN}
     * 1）创建开放平台帐号并绑定公众号/小程序
     * @see #openCreate
     * 2）将公众号/小程序绑定到已有开放平台帐号下
     * @see #openBind
     * 3）将公众号/小程序从开放平台帐号下解绑
     * @see #openUnbind
     * 4）获取公众号/小程序所绑定的开放平台帐号
     *  @see #openGet
     * </pre>
     *  创建 开放平台帐号并绑定公众号/小程序
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "open/create", method = RequestMethod.POST)
    BaseResponse openCreate(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);


    /**
     * 将 公众号/小程序绑定到开放平台帐号下
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "open/bind", method = RequestMethod.POST)
    BaseResponse openBind(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 将公众号/小程序从开放平台帐号下解绑
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "open/unbind", method = RequestMethod.POST)
    BaseResponse openUnbind(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 获取公众号/小程序所绑定的开放平台帐号
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "open/get", method = RequestMethod.POST)
    BaseResponse openGet(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 模板消息-设置所属行业
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "template/api_set_industry", method = RequestMethod.POST)
    BaseResponse templateApi_set_industry(@RequestParam("access_token") String accessToken, @RequestBody TemplateApi_set_industryRequest templateApi_set_industryRequest);


    /**
     * 获取小程序二维码，适用于需要的码数量较少的业务场景
     * 通过该接口生成的小程序码，永久有效，有数量限制
     * <pre>
     * @see com.qq.weixin.api.wxa.WxaClient#getwxacode
     * @see com.qq.weixin.api.wxa.WxaClient#getwxacodeunlimit
     * </pre>
     *
     * @param accessToken
     * @return
     * @link {https://developers.weixin.qq.com/miniprogram/dev/api/createWXAQRCode.html}
     */
    @RequestMapping(value = "wxaapp/createwxaqrcode", method = RequestMethod.POST)
    BaseResponse wxaappCreatewxaqrcode(@RequestParam("access_token") String accessToken, @RequestBody TemplateApi_set_industryRequest templateApi_set_industryRequest);

    /**
     * 物流助手-生成运单
     *
     * @param accessToken
     * @return
     * @link {https://developers.weixin.qq.com/miniprogram/dev/api/addOrder.html}
     */
    @RequestMapping(value = "express/business/order/add", method = RequestMethod.POST)
    BaseResponse expressBusinessOrderAdd(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 物流助手-取消运单
     *
     * @param accessToken
     * @return
     * @link {https://developers.weixin.qq.com/miniprogram/dev/api/cancelOrder.html}
     */
    @RequestMapping(value = "express/business/order/cancel", method = RequestMethod.POST)
    BaseResponse expressBusinessOrderCancel(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 物流助手-获取支持的快递公司列表
     *
     * @param accessToken
     * @return
     * @link {https://developers.weixin.qq.com/miniprogram/dev/api/cancelOrder.html}
     */
    @RequestMapping(value = "express/business/delivery/getall", method = RequestMethod.POST)
    BaseResponse expressBusinessDeliveryGetall(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 物流助手-获取运单数据
     *
     * @param accessToken
     * @return
     * @link {https://developers.weixin.qq.com/miniprogram/dev/api/getOrder.html}
     */
    @RequestMapping(value = "express/business/order/get", method = RequestMethod.POST)
    BaseResponse expressBusinessOrderGet(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 物流助手-获取打印员
     *
     * @param accessToken
     * @return
     * @link {https://developers.weixin.qq.com/miniprogram/dev/api/getPrinter.html}
     */
    @RequestMapping(value = "express/business/path/getall", method = RequestMethod.POST)
    BaseResponse expressBusinessPathGetall(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 物流助手-获取电子面单余额。仅在使用加盟类快递公司时，才可以调用
     *
     * @param accessToken
     * @return
     * @link {https://developers.weixin.qq.com/miniprogram/dev/api/getPrinter.html}
     */
    @RequestMapping(value = "express/business/quota/get", method = RequestMethod.POST)
    BaseResponse expressBusinessQuotaGet(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);


    /**
     * 物流助手-获取面单联系人信息
     *
     * @param accessToken
     * @return
     * @link {https://developers.weixin.qq.com/miniprogram/dev/api/getPrinter.html}
     */
    @RequestMapping(value = "express/delivery/contact/get", method = RequestMethod.POST)
    BaseResponse expressDeliveryContactGet(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 物流助手-预览面单模板。用于调试面单模板使用
     *
     * @param accessToken
     * @return
     * @link {https://developers.weixin.qq.com/miniprogram/dev/api/getPrinter.html}
     */
    @RequestMapping(value = "express/delivery/template/preview", method = RequestMethod.POST)
    BaseResponse expressDeliveryTemplatePreview(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 物流助手-更新商户审核结果
     *
     * @param accessToken
     * @return
     * @link {https://developers.weixin.qq.com/miniprogram/dev/api/updateBusiness.html}
     */
    @RequestMapping(value = "express/delivery/service/business/update", method = RequestMethod.POST)
    BaseResponse expressDeliveryserviceBusinessUpdate(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 物流助手-更新运单轨迹
     *
     * @param accessToken
     * @return
     * @link {https://developers.weixin.qq.com/miniprogram/dev/api/updatePath.html}
     */
    @RequestMapping(value = "express/delivery/path/update", method = RequestMethod.POST)
    BaseResponse expressDeliveryPathUpdate(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

}
