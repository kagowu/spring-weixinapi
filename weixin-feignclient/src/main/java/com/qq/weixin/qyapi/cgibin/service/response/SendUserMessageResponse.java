package com.qq.weixin.qyapi.cgibin.service.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.qq.weixin.qyapi.QyBaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class SendUserMessageResponse extends QyBaseResponse {


    /**
     * 接收消息的非法成员，成员ID列表
     */
    @JSONField(name = "invaliduser")
    @JsonProperty("invaliduser")
    private String invalidUser;

    /**
     * 接收消息的非法部门，部门ID列表
     */
    @JSONField(name = "invalidparty")
    @JsonProperty("invalidparty")
    private String invalidParty;

    /**
     * 接收消息的非法标签，标签ID列表
     */
    @JSONField(name = "invalidtag")
    @JsonProperty("invalidtag")
    private String invalidTag;

}
