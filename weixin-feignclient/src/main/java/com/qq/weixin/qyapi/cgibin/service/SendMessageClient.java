package com.qq.weixin.qyapi.cgibin.service;

import com.qq.weixin.api.FeignConfiguration;
import com.qq.weixin.qyapi.cgibin.service.request.SendUserMiniProgramMsgRequest;
import com.qq.weixin.qyapi.cgibin.service.request.SendUserTextCardMsgRequest;
import com.qq.weixin.qyapi.cgibin.service.response.SendUserMessageResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "SendMessageClient", url = "https://qyapi.weixin.qq.com/cgi-bin/", configuration = FeignConfiguration.class)
public interface SendMessageClient {


    /**
     * 消息推送 - 文本卡片消息
     *
     * @param accessToken 调用接口凭证
     * @param request     消息体
     * @return 推送结果
     * @link {https://work.weixin.qq.com/api/doc/90001/90143/90372}
     */
    @RequestMapping(value = "message/send", method = RequestMethod.POST)
    SendUserMessageResponse sendUserTextCardMsg(@RequestParam("access_token") String accessToken, @RequestBody SendUserTextCardMsgRequest request);


    /**
     * 消息推送 - 小程序消息
     *
     * @param accessToken 调用接口凭证
     * @param request     消息体
     * @return 推送结果
     * @link {https://work.weixin.qq.com/api/doc/90001/90143/90372}
     */
    @RequestMapping(value = "message/send", method = RequestMethod.POST)
    SendUserMessageResponse sendUserMiniProgramMsg(@RequestParam("access_token") String accessToken, @RequestBody SendUserMiniProgramMsgRequest request);

}
