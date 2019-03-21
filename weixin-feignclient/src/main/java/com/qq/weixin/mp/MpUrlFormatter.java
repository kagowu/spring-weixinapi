package com.qq.weixin.mp;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author gong.hua
 */
public class MpUrlFormatter {

    /**
     * 通过ticket换取二维码
     *
     * 获取二维码ticket后，开发者可用ticket换取二维码图片。请注意，本接口无须登录态即可调用。
     * @param ticket
     * @return
     */
    public static String showqrcode(String ticket) {
        return String.format("https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=%s",
                ticket);
    }
    /**
     * 从第三方平台页面发起，并跳转至微信公众平台指定换绑页面
     *
     * @param componentAppid 第三方平台的appid
     * @param appid           公众号的 appid
     * @param redirectUri    新管理员信息填写完成点击提交后，将跳转到该地址(注：1.链接需 urlencode 2.Host需和第三方平台在微信开放平台上面填写的登录授权的发起页域名一致)
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String getComponentrebindadminUrl(String componentAppid, String appid, String redirectUri) throws UnsupportedEncodingException {
        return String.format("https://mp.weixin.qq.com/wxopen/componentrebindadmin?appid=%s&component_appid=%s&redirect_uri=%s",
                appid, componentAppid, URLEncoder.encode(redirectUri, "UTF-8"));
    }


    /**
     * <pre>
     *     <h1>授权流程技术说明</h1>
     * @link {https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1453779503&token=2dc40382b1879696f2d7c35d221d8844cae685fd&lang=}
     *
     * 步骤1：第三方平台方获取预授权码（pre_auth_code）
     * *   预授权码是第三方平台方实现授权托管的必备信息。
     *    @see com.qq.weixin.api.cgibin.CgibinClient#componentApiComponentToken
     *    @see com.qq.weixin.api.cgibin.CgibinClient#componentApiCreatePreauthcode
     *
     * 步骤2：引入用户进入授权页
     * *    第三方平台方可以在自己的网站中放置“微信公众号授权”或者“小程序授权”的入口：
     *      @see #getComonentloginpage
     *     或生成授权链接放置在移动网页中:
     *      @see #getBindcomponentUrl
     *     引导公众号和小程序管理员进入授权页。
     * 步骤3：用户确认并同意登录授权给第三方平台方
     *     用户进入第三方平台授权页后，需要确认并同意将自己的公众号或小程序授权给第三方平台方，完成授权流程。
     * 步骤4：授权后回调URI，得到授权码（authorization_code）和过期时间
     *     授权流程完成后，授权页会自动跳转进入回调URI，并在URL参数中返回授权码和过期时间(redirect_url?auth_code=xxx&expires_in=600)
     * 步骤5：利用授权码调用公众号或小程序的相关API
     *     @see com.qq.weixin.api.cgibin.CgibinClient#componentApiQueryAuth
     *     @see com.qq.weixin.api.cgibin.CgibinClient#componentApiAuthorizerToken
     *     @see com.qq.weixin.api.cgibin.CgibinClient#componentApiGetAuthorizerInfo
     *     @see com.qq.weixin.api.cgibin.CgibinClient#componentApiGetAuthorizerOption
     *     @see com.qq.weixin.api.cgibin.CgibinClient#componentApiSetAuthorizerOption
     * </pre>
     * 第三方平台-引导公众号和小程序管理员进入授权页-微信端实际访问的授权链接
     *
     * @param componentAppid
     * @param preAuthCode 预授权码
     * @param redirectUri 回调URI
     * @param authType 要授权的帐号类型， 1则商户扫码后，手机端仅展示公众号、2表示仅展示小程序，3表示公众号和小程序都展示。如果为未制定，则默认小程序和公众号都展示。第三方平台开发者可以使用本字段来控制授权的帐号类型。
     * @param bizAppid 指定授权唯一的小程序或公众号
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String getBindcomponentUrl(String componentAppid, String preAuthCode, String redirectUri, String authType, String bizAppid) throws UnsupportedEncodingException {
        return String.format("https://mp.weixin.qq.com/safe/bindcomponent?action=bindcomponent&no_scan=1&component_appid=%s&pre_auth_code=%s&redirect_uri=%s&auth_type=%s&biz_appid=%s#wechat_redirect",
                componentAppid, preAuthCode, URLEncoder.encode(redirectUri, "UTF-8"),authType, bizAppid);
    }


    public static String getBindcomponentUrl(String componentAppid, String preAuthCode, String redirectUri, String authType) throws UnsupportedEncodingException {
        return String.format("https://mp.weixin.qq.com/safe/bindcomponent?action=bindcomponent&no_scan=1&component_appid=%s&pre_auth_code=%s&redirect_uri=%s&auth_type=%s#wechat_redirect",
                componentAppid, preAuthCode, URLEncoder.encode(redirectUri, "UTF-8"),authType);
    }

    public static String getBindcomponentUrl(String componentAppid, String preAuthCode, String redirectUri) throws UnsupportedEncodingException {
        return String.format("https://mp.weixin.qq.com/safe/bindcomponent?action=bindcomponent&no_scan=1&component_appid=%s&pre_auth_code=%s&redirect_uri=%s#wechat_redirect",
                componentAppid, preAuthCode, URLEncoder.encode(redirectUri, "UTF-8"));
    }

    /**
     * 第三方平台-引导公众号和小程序管理员进入授权页-引导页
     * 获取到的地址，必须在和redirect_uri的域名相同的地方才能点击进入，否则报错。
     *
     * @param componentAppid
     * @param preAuthCode
     * @param redirectUri
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String getComonentloginpage(String componentAppid, String preAuthCode, String redirectUri, String authType, String bizAppid) throws UnsupportedEncodingException {
        return String.format("https://mp.weixin.qq.com/cgi-bin/componentloginpage?component_appid=%s&pre_auth_code=%s&redirect_uri=%s&auth_type=%s&biz_appid=%s",
                componentAppid, preAuthCode, URLEncoder.encode(redirectUri, "UTF-8"), authType, bizAppid);
    }

    public static String getComonentloginpage(String componentAppid, String preAuthCode, String redirectUri, String authType) throws UnsupportedEncodingException {
        return String.format("https://mp.weixin.qq.com/cgi-bin/componentloginpage?component_appid=%s&pre_auth_code=%s&redirect_uri=%s&auth_type=%s",
                componentAppid, preAuthCode, URLEncoder.encode(redirectUri, "UTF-8"), authType);
    }
    public static String getComonentloginpage(String componentAppid, String preAuthCode, String redirectUri) throws UnsupportedEncodingException {
        return String.format("https://mp.weixin.qq.com/cgi-bin/componentloginpage?component_appid=%s&pre_auth_code=%s&redirect_uri=%s",
                componentAppid, preAuthCode, URLEncoder.encode(redirectUri, "UTF-8"));
    }

    /**
     * <pre>
     *      <h1>复用公众号主体快速注册小程序</h1>
     *      @link {https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=21521706765hLoMO&token=2dc40382b1879696f2d7c35d221d8844cae685fd&lang=}
     *   1.1 从第三方平台跳转至微信公众平台授权注册页面
     *      @see #getFastregisterauthUrl(String, String, String)
     *   1.2 公众号管理员扫码确认授权注册，并跳转回第三方平台
     *      * 公众号管理员扫码后在手机端完成授权确认。
     *      * 跳转回第三方平台，会在上述 redirect_uri后拼接 ticket=*
     *      * 跳转回第三方平台举例:
     *       @link {https://www.qq.com/auth/callback?from=mp&ticket=b25519093b1e97239eff9d2bfc07e08e}
     *   1.3 跳转至第三方平台，第三方平台调用快速注册API完成注册
     *     @see com.qq.weixin.api.cgibin.CgibinClient#accountFastregister
     *    2 小程序信息设置相关接口
     *      2.1 获取帐号基本信息
     *       @see com.qq.weixin.api.cgibin.CgibinClient#accountGetaccountbasicinfo
     *      2.2 修改头像
     *       @see com.qq.weixin.api.cgibin.CgibinClient#accountModifyheadimage
     * </pre>
     * 从第三方平台跳转至微信公众平台授权注册页面
     *
     * @param appid
     * @param componentAppid
     * @param redirectUri
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String getFastregisterauthUrl(String appid, String componentAppid, String redirectUri) throws UnsupportedEncodingException {
        return String.format("https://mp.weixin.qq.com/cgi-bin/fastregisterauth?appid=%s&component_appid=%s&copy_wx_verify=1&redirect_uri=%s",
                appid, componentAppid, URLEncoder.encode(redirectUri, "UTF-8"));
    }


}
