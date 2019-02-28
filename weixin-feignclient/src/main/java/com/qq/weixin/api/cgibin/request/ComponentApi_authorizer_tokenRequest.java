package com.qq.weixin.api.cgibin.request;

import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class ComponentApi_authorizer_tokenRequest {
    /**
     * 第三方平台appid
     */
    private String component_appid;
    /**
     * 授权方appid
     */
    private String authorizer_appid;
    /**
     * 授权方的刷新令牌，刷新令牌主要用于第三方平台获取和刷新已授权用户的access_token，
     * 只会在授权时刻提供，请妥善保存。一旦丢失，只能让用户重新授权，才能再次拿到新的刷新令牌
     */
    private String authorizer_refresh_token;
}
