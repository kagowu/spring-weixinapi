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
public class ComponentApiGetAuthorizerInfoRequest {
    @JSONField(name = "component_appid")
    @JsonProperty("component_appid")
    private String componentAppid;

    @JSONField(name = "authorizer_appid")
    @JsonProperty("authorizer_appid")
    private String authorizerAppid;
}
