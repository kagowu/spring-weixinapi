package com.qq.weixin.api.cgibin.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class ComponentApiAuthorizerTokenRequest {
    /**
     * 第三方平台appid
     */
    @JSONField(name = "component_appid")
    @JsonProperty("component_appid")
    private String componentAppid;
    /**
     * 授权方appid
     */
    @JSONField(name = "authorizer_appid")
    @JsonProperty("authorizer_appid")
    private String authorizerAppid;
    /**
     * 授权方的刷新令牌，刷新令牌主要用于第三方平台获取和刷新已授权用户的access_token，
     * 只会在授权时刻提供，请妥善保存。一旦丢失，只能让用户重新授权，才能再次拿到新的刷新令牌
     */
    @JSONField(name = "authorizer_refresh_token")
    @JsonProperty("authorizer_refresh_token")
    private String authorizerRefreshToken;
}
