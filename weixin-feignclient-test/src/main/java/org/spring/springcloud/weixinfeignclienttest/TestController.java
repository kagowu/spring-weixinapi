package org.spring.springcloud.weixinfeignclienttest;

import com.qq.weixin.api.BaseRequest;
import com.qq.weixin.api.BaseResponse;
import com.qq.weixin.api.cgibin.CgibinClient;
import com.qq.weixin.api.cgibin.request.AccountFastregisterRequest;
import com.qq.weixin.api.cgibin.request.ComponentApiCreatePreauthcodeRequest;
import com.qq.weixin.api.cgibin.request.ComponentApiQueryAuthRequest;
import com.qq.weixin.api.cgibin.request.ComponentTokenRequest;
import com.qq.weixin.api.cgibin.response.*;
import com.qq.weixin.cipher.MpBizMsgCrypt;
import com.qq.weixin.cipher.util.CipherException;
import com.qq.weixin.cipher.util.XMLParse;
import com.qq.weixin.mp.MpUrlFormatter;
import com.qq.weixin.xml.mp.BaseAcceptMsg;
import com.qq.weixin.xml.mp.accept.BasicEvent;
import com.qq.weixin.xml.open.BaseAuthorizationEvent;
import com.qq.weixin.xml.open.accept.*;
import com.qq.weixin.xml.util.JAXBUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeUnit;

/**
 * @author gong.hua
 */
@RestController
@RequestMapping("/wxopen")
@Api(tags = "wxopen", description = "wxopen")
@Slf4j
public class TestController {

    @Autowired
    private CgibinClient cgibinClient;

    @Autowired
    StringRedisTemplate redisTemplate;

    ValueOperations<String, String> stringRedis;

    @PostConstruct
    public void init() {
        stringRedis = redisTemplate.opsForValue();
    }

    @PostMapping("/receive/authorizationEvent")
    @ApiOperation(value = "authorizationEvent", notes = "授权事件接收URL")
    public String authorizationEvent(@RequestBody(required = false) String requestBody,
                                     @RequestParam("timestamp") String timestamp,
                                     @RequestParam("nonce") String nonce,
                                     @RequestParam("signature") String signature,
                                     @RequestParam(name = "encrypt_type", required = false) String encType,
                                     @RequestParam(name = "msg_signature", required = false) String msgSignature) throws CipherException {

        log.info("\nticket接收微信请求：[signature=[{}], encType=[{}], msgSignature=[{}], timestamp=[{}], nonce=[{}], requestBody=[\n{}\n] ",
                signature, encType, msgSignature, timestamp, nonce, requestBody);
        MpBizMsgCrypt crypt = new MpBizMsgCrypt(WechatOpenConfiguration.componentToken, WechatOpenConfiguration.componentAesKey, WechatOpenConfiguration.componentAppId);
        String message = crypt.decryptMsg(msgSignature, timestamp, nonce, requestBody);
        log.info("\nauthorizationEvent 消息解密后内容为：\n{} ", message);

        String[] infoType = XMLParse.extractChild(message, "InfoType");
        switch (infoType[0]) {
            case BaseAuthorizationEvent.AUTHORIZED:
                // 授权和跳转是重复的，这里可以不用实现。
                break;
            case BaseAuthorizationEvent.UPDATEAUTHORIZED:
                // 更新授权和跳转是重复的，这里可以不用实现。
                break;
            case BaseAuthorizationEvent.UNAUTHORIZED:
                UnauthorizedEvent unauthorizedEvent = JAXBUtils.convertToJavaBean(message, UnauthorizedEvent.class);
                log.info("取消授权通知:{}", unauthorizedEvent);
                // FIXME 取消授权之后做点什么
                break;
            case BaseAuthorizationEvent.COMPONENT_VERIFY_TICKET:
                // 微信推送了三遍相同的消息
                ComponentVerifyTicketAuthorizationEvent componentVerifyTicketAuthorizationEvent = JAXBUtils.convertToJavaBean(message, ComponentVerifyTicketAuthorizationEvent.class);
                stringRedis.set("CACHE_WX_COMPONENT_VERIFY_TICKET", componentVerifyTicketAuthorizationEvent.getComponentVerifyTicket());
                getComponentAccessToken();
                break;
            case BaseAuthorizationEvent.NOTIFY_THIRD_FASTEREGISTER:
                NotifyThirdFasteregisterEvent notifyThirdFasteregisterEvent = JAXBUtils.convertToJavaBean(message, NotifyThirdFasteregisterEvent.class);
                ComponentApiQueryAuthResponse componentApiQueryAuthFast = getQueryAuth(notifyThirdFasteregisterEvent.getAuthCode());
                saveAccessToken(componentApiQueryAuthFast);
            default:
                break;
        }
        return "success";
    }

    @RequestMapping(value = "/receive/message/{appId}/callback", method = RequestMethod.POST)
    @ApiOperation(value = "callback", notes = "消息与事件接收URL")
    public String callback(@RequestBody(required = false) String requestBody,
                           @PathVariable("appId") String appId,
                           @RequestParam("signature") String signature,
                           @RequestParam("timestamp") String timestamp,
                           @RequestParam("nonce") String nonce,
                           @RequestParam("openid") String openid,
                           @RequestParam("encrypt_type") String encType,
                           @RequestParam("msg_signature") String msgSignature) throws CipherException {
        log.info("\ncallback接收微信请求：[appId=[{}], openid=[{}], signature=[{}], encType=[{}], msgSignature=[{}], timestamp=[{}], nonce=[{}], requestBody=[\n{}\n] ",
                appId, openid, signature, encType, msgSignature, timestamp, nonce, requestBody);

        MpBizMsgCrypt crypt = new MpBizMsgCrypt(WechatOpenConfiguration.componentToken, WechatOpenConfiguration.componentAesKey, WechatOpenConfiguration.componentAppId);
        String message = crypt.decryptMsg(msgSignature, timestamp, nonce, requestBody);
        String[] elements = XMLParse.extractChild(message, "MsgType", "Event", "EventKey");
        switch (elements[0]) {
            case BaseAcceptMsg.EVENT_MSG_TYPE:
                switch (elements[1]) {
                    case BasicEvent.SUBSCRIBE_EVENT:
                    case BasicEvent.UNSUBSCRIBE_EVENT:
                    case BasicEvent.LOCATION_EVENT:
                    case BasicEvent.SCAN_EVENT:
                    case BasicEvent.CLICK_EVENT:
                    case BasicEvent.VIEW_EVENT:
                    case BasicEvent.WXA_NICKNAME_AUDIT_EVENT:
                    case BasicEvent.WEAPP_AUDIT_SUCCESS_EVENT:
                    case BasicEvent.WEAPP_AUDIT_FAIL_EVENT:
                    case BasicEvent.QUALIFICATION_VERIFY_SUCCESS_EVENT:
                    case BasicEvent.QUALIFICATION_VERIFY_FAIL_EVENT:
                    case BasicEvent.NAMING_VERIFY_SUCCESS_EVENT:
                    case BasicEvent.NAMING_VERIFY_FAIL_EVENT:
                    case BasicEvent.ANNUAL_RENEW_EVENT:
                        break;
                    default:
                        break;
                }
                break;
            case BaseAcceptMsg.TEXT_MSG_TYPE:
                break;
            case BaseAcceptMsg.VIDEO_MSG_TYPE:
            case BaseAcceptMsg.VOICE_MSG_TYPE:
            case BaseAcceptMsg.IMAGE_MSG_TYPE:
            case BaseAcceptMsg.LOCATION_MSG_TYPE:
            case BaseAcceptMsg.SHORT_VIDEO_MSG_TYPE:
            case BaseAcceptMsg.LINK_MSG_TYPE:
                break;
            default:
                break;
        }
        log.info("\ncallback 消息解密后内容为：\n{} ", message);
        return "success";
    }

    @ResponseBody
    @GetMapping("/auth/goto_auth_url_show")
    @ApiOperation(value = "goto_auth_url_show", notes = "引导页")
    public String gotoPreAuthUrlShow() {
        return "<form action='goto_auth_url'>\n" +
                "companyUuid:<input name='companyUuid' value='swaggerCompanyUuid' style='width: 700px;'/>\n" +
                "<input type='submit' value='start'></input>\n" +
                "</form>";
    }

    @ResponseBody
    @GetMapping("/auth/jump")
    @ApiOperation(value = "jump", notes = "回调跳转页")
    public Object jump(@RequestParam("auth_code") String authorizationCode, @RequestParam("companyUuid") String
            companyUuid) {
        log.info("auth_code :{}", authorizationCode);
        ComponentApiQueryAuthResponse componentApiQueryAuthResponse = getQueryAuth(authorizationCode);
        stringRedis.set("CACHE_WX_ACCESSTOKEN" + componentApiQueryAuthResponse.getAuthorizationInfo().getAuthorizerAppid(), componentApiQueryAuthResponse.getAuthorizationInfo().getAuthorizerAccessToken());
        return componentApiQueryAuthResponse;

    }

    @GetMapping("/auth/goto_auth_url")
    @ApiOperation(value = "goto_auth_url", notes = "引导跳转页")
    public void gotoPreAuthUrl(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ComponentApiCreatePreauthcodeRequest componentApiCreatePreauthcodeRequest = new ComponentApiCreatePreauthcodeRequest();
        componentApiCreatePreauthcodeRequest.setComponentAppid(WechatOpenConfiguration.componentAppId);
        ComponentApiCreatePreauthcodeResponse componentApiCreatePreauthcodeResponse = cgibinClient.componentApiCreatePreauthcode(getComponentAccessToken(), componentApiCreatePreauthcodeRequest);
        log.info("pre_auth_code:{}", componentApiCreatePreauthcodeResponse.getPreAuthCode());
        String url = MpUrlFormatter.getComonentloginpage(WechatOpenConfiguration.componentAppId, componentApiCreatePreauthcodeResponse.getPreAuthCode(),
                request.getHeader("referer").replace("goto_auth_url_show", "jump") + "?companyUuid=" + request.getParameter("companyUuid"));
        response.sendRedirect(url);
        log.info("sendRedirect url:{}", url);

    }

    @ResponseBody
    @GetMapping("/auth/goto_auth_url_show2")
    @ApiOperation(value = "goto_auth_url_show2", notes = "引导页")
    public String gotofastregisterPreAuthUrlShow() {
        return "<form action='goto_auth_url2'>\n" +
                "mpAppid:<input name='mpAppid' value='mpAppid' style='width: 700px;'/><br/>" +
                "mpSecret:<input name='mpSecret' value='mpSecret' style='width: 700px;'/>\n" +
                "<input type='submit' value='start'></input>\n" +
                "</form>";
    }

    @GetMapping("/auth/goto_auth_url2")
    @ApiOperation(value = "goto_auth_url2", notes = "引导跳转页")
    public void gotoPreAuthUrl2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String mpAppid = request.getParameter("mpAppid");
        String mpSecret = request.getParameter("mpSecret");
        String url = MpUrlFormatter.getFastregisterauthUrl(mpAppid, WechatOpenConfiguration.componentAppId,
                request.getHeader("referer").replace("goto_auth_url_show2", "jump2") + "?" + "mpAppid=" + mpAppid + "&mpSecret=" + mpSecret);
        response.sendRedirect(url);
        log.info("sendRedirect url:{}", url);

    }


    @ResponseBody
    @GetMapping("/auth/jump2")
    @ApiOperation(value = "jump2", notes = "回调跳转页")
    public Object jump2(@RequestParam("ticket") String ticket, @RequestParam("mpAppid") String
            mpAppid, @RequestParam("mpSecret") String
                                mpSecret) {
        log.info("auth_code :{}", ticket);

        BaseRequest baseRequest = new BaseRequest();
        baseRequest.put("ticket", ticket);
        AccountFastregisterResponse accountFastregisterResponse = cgibinClient.accountFastregister(getAccessToken(mpAppid, mpSecret), new AccountFastregisterRequest(ticket));
        ComponentApiQueryAuthResponse componentApiQueryAuthResponse = getQueryAuth(accountFastregisterResponse.getAuthorizationCode());

        saveAccessToken(componentApiQueryAuthResponse);
        return componentApiQueryAuthResponse;

    }

    public void saveAccessToken(ComponentApiQueryAuthResponse componentApiQueryAuthResponse) {
        stringRedis.set("CACHE_WX_ACCESSTOKEN:" + componentApiQueryAuthResponse.getAuthorizationInfo().getAuthorizerAppid(), componentApiQueryAuthResponse.getAuthorizationInfo().getAuthorizerAccessToken());
    }



    public String getComponentAccessToken() {
        String componentAccessToken = stringRedis.get("CACHE_WX_COMPONENT_ACCESSTOKEN");
        log.info("redis get componentAccessToken:{}", componentAccessToken);
        if (StringUtils.isBlank(componentAccessToken)) {
            ComponentTokenRequest componentTokenRequest = new ComponentTokenRequest();
            componentTokenRequest.setComponentAppid(WechatOpenConfiguration.componentAppId);
            componentTokenRequest.setComponentAppsecret(WechatOpenConfiguration.componentSecret);
            componentTokenRequest.setComponentVerifyTicket(stringRedis.get("CACHE_WX_COMPONENT_VERIFY_TICKET"));
            ComponentTokenResponse componentTokenResponse = cgibinClient.componentApiComponentToken(componentTokenRequest);
            log.info("redis set componentAccessToken:{}", componentTokenResponse.getComponentAccessToken());
            stringRedis.set("CACHE_WX_COMPONENT_ACCESSTOKEN", componentTokenResponse.getComponentAccessToken(), 1, TimeUnit.HOURS);
            componentAccessToken = componentTokenResponse.getComponentAccessToken();
        }
        return componentAccessToken;
    }

    public String getAccessToken(String appId, String secret) {
        String accessToken = stringRedis.get("CACHE_WX_ACCESSTOKEN:" + appId);
        log.info("redis get accessToken:{}", accessToken);
        if (StringUtils.isBlank(accessToken)) {
            ComponentTokenRequest componentTokenRequest = new ComponentTokenRequest();
            componentTokenRequest.setComponentAppid(WechatOpenConfiguration.componentAppId);
            componentTokenRequest.setComponentAppsecret(WechatOpenConfiguration.componentSecret);
            componentTokenRequest.setComponentVerifyTicket(stringRedis.get("CACHE_WX_COMPONENT_VERIFY_TICKET"));
            TokenResponse tokenResponse = cgibinClient.token(appId, secret);
            log.info("redis set accessToken:{}", tokenResponse.getAccessToken());
            stringRedis.set("CACHE_WX_ACCESSTOKEN:" + appId, tokenResponse.getAccessToken(), 1, TimeUnit.HOURS);
            accessToken = tokenResponse.getAccessToken();
        }
        return accessToken;
    }

    public ComponentApiQueryAuthResponse getQueryAuth(String authorizationCode) {
        ComponentApiQueryAuthRequest componentApiQueryAuthRequest = new ComponentApiQueryAuthRequest();
        componentApiQueryAuthRequest.setComponentAppid(WechatOpenConfiguration.componentAppId);
        componentApiQueryAuthRequest.setAuthorizationCode(authorizationCode);
        return cgibinClient.componentApiQueryAuth(getComponentAccessToken(), componentApiQueryAuthRequest);
    }
}
