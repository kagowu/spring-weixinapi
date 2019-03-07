package com.qq.weixin.api.cgibin.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.qq.weixin.api.BaseResponse;
import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class ComponentApiAuthorizerTokenResponse extends BaseResponse {
    @JSONField(name = "authorizer_access_token")
    @JsonProperty("authorizer_access_token")
    private String authorizerAccessToken;

    @JSONField(name = "expires_in")
    @JsonProperty("expires_in")
    private Integer expiresIn;

    @JSONField(name = "authorizer_refresh_token")
    @JsonProperty("authorizer_refresh_token")
    private String authorizerRefreshToken;
}
