package com.qq.weixin.api.cgibin.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class ComponentApiGetAuthorizerOptionResponse {
    @JSONField(name = "component_appid")
    @JsonProperty("component_appid")
    private String componentAppid;

    @JSONField(name = "authorizer_appid")
    @JsonProperty("authorizer_appid")
    private String authorizerAppid;


    @JSONField(name = "option_value")
    @JsonProperty("option_value")
    private String optionValue;
}
