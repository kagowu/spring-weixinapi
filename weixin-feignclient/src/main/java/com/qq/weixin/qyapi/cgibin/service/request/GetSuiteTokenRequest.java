package com.qq.weixin.qyapi.cgibin.service.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class GetSuiteTokenRequest {


    /**
     * 套件id
     */
    @JSONField(name = "suite_id")
    @JsonProperty("suite_id")
    private String suiteId;

    /**
     * 应用secret
     */
    @JSONField(name = "suite_secret")
    @JsonProperty("suite_secret")
    private String suiteSecret;

    /**
     * 企业微信后台推送的ticket
     */
    @JSONField(name = "suite_ticket")
    @JsonProperty("suite_ticket")
    private String suiteTicket;
}
