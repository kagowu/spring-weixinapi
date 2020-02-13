package com.qq.weixin.qyapi.cgibin.service.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.qq.weixin.qyapi.QyBaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GetSuiteTokenResponse extends QyBaseResponse {

    /**
     * 第三方应用access_token,最长为512字节
     */
    @JSONField(name = "suite_access_token")
    @JsonProperty("suite_access_token")
    private String suiteAccessToken;

    /**
     * 有效期
     */
    @JSONField(name = "expires_in")
    @JsonProperty("expires_in")
    private int expiresIn;
}
