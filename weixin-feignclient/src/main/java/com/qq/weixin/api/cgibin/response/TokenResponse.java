package com.qq.weixin.api.cgibin.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.qq.weixin.api.BaseResponse;
import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class TokenResponse extends BaseResponse {
    @JSONField(name = "access_token")
    @JsonProperty("access_token")
    private String accessToken;

    @JSONField(name = "expires_in")
    @JsonProperty("expires_in")
    private Integer expiresIn;
}