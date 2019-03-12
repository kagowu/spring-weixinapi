package com.qq.weixin.api.cgibin.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gong.hua
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComponentTokenRequest {
    /**
     * 第三方平台appid
     */
    @JSONField(name = "component_appid")
    @JsonProperty("component_appid")
    private String componentAppid;

    @JSONField(name = "component_appsecret")
    @JsonProperty("component_appsecret")
    private String componentAppsecret;

    @JSONField(name = "component_verify_ticket")
    @JsonProperty("component_verify_ticket")
    private String componentVerifyTicket;
}
