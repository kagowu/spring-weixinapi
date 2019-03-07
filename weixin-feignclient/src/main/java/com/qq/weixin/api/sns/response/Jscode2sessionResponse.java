package com.qq.weixin.api.sns.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.qq.weixin.api.BaseResponse;
import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class Jscode2sessionResponse extends BaseResponse {
    private String openid;
    @JSONField(name = "session_key")
    @JsonProperty("session_key")
    private String sessionKey;
    private String unionid;
}
