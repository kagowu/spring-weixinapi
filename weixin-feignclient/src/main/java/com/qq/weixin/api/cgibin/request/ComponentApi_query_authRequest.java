package com.qq.weixin.api.cgibin.request;

import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class ComponentApi_query_authRequest {
    private String component_appid;
    private String authorization_code;
}
