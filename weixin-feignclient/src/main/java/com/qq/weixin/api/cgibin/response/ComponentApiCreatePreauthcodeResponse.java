package com.qq.weixin.api.cgibin.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.qq.weixin.api.BaseResponse;
import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class ComponentApiCreatePreauthcodeResponse extends BaseResponse {
    @JSONField(name = "pre_auth_code")
    @JsonProperty("pre_auth_code")
    private String preAuthCode;

    @JSONField(name = "expires_in")
    @JsonProperty("expires_in")
    private Integer expiresIn;
}
