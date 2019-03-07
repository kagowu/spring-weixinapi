package com.qq.weixin.api.cgibin.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class ComponentFastregisterweappSearchRequest {
    /**
     * 企业名
     */
    private String name;
    /**
     * 法人微信
     */
    @JSONField(name = "legal_persona_wechat")
    @JsonProperty("legal_persona_wechat")
    private String legalPersonaWechat;
    /**
     * 法人姓名
     */
    @JSONField(name = "legal_persona_name")
    @JsonProperty("legal_persona_name")
    private String legalPersonaName;

}
