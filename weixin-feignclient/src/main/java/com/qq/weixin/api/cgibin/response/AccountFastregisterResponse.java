package com.qq.weixin.api.cgibin.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.qq.weixin.api.BaseResponse;
import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class AccountFastregisterResponse extends BaseResponse {
    private String appid;

    @JSONField(name = "authorization_code")
    @JsonProperty("authorization_code")
    private String authorizationCode;

    @JSONField(name = "is_wx_verify_succ")
    @JsonProperty("is_wx_verify_succ")
    private String isWxVerifySucc;

    @JSONField(name = "is_link_succ")
    @JsonProperty("is_link_succ")
    private String isLinkSucc;
}
