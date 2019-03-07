package com.qq.weixin.api.cgibin.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class ComponentFastregisterweappCreateRequest {
    /**
     * 企业名
     */
    private String name;
    /**
     * 企业代码
     */
    private String code;
    /**
     * 企业代码类型（1：统一社会信用代码， 2：组织机构代码，3：营业执照注册号）
     */
    @JSONField(name = "code_type")
    @JsonProperty("code_type")
    private String codeType;
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
    /**
     * 第三方联系电话
     */
    @JSONField(name = "component_phone")
    @JsonProperty("component_phone")
    private String componentPhone;
}
