package com.qq.weixin.api.cgibin.request;

import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class ComponentApi_get_authorizer_infoRequest {
    private String component_appid;
    private String authorizer_appid;
}
