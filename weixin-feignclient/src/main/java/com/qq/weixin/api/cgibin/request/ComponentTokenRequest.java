package com.qq.weixin.api.cgibin.request;

import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class ComponentTokenRequest {
    private String component_appid;
    private String component_appsecret;
    private String component_verify_ticket;
}
