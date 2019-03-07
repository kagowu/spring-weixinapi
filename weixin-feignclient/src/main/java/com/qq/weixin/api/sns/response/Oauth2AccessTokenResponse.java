package com.qq.weixin.api.sns.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.qq.weixin.api.BaseResponse;
import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class Oauth2AccessTokenResponse extends BaseResponse {
    @JSONField(name = "access_token")
    @JsonProperty("access_token")
    private String accessToken;

    @JSONField(name = "expires_in")
    @JsonProperty("expires_in")
    private Integer expiresIn;

    @JSONField(name = "refresh_token")
    @JsonProperty("refresh_token")
    private String refreshToken;
    private String openid;
    private String scope;
}