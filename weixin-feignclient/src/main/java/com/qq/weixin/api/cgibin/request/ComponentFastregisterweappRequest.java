package com.qq.weixin.api.cgibin.request;

import lombok.Builder;
import lombok.Data;

/**
 * @author gong.hua
 */
@Data
@Builder(toBuilder = true)
public class ComponentFastregisterweappRequest {
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
    private String code_type;
    /**
     * 法人微信
     */
    private String legal_persona_wechat;
    /**
     * 法人姓名
     */
    private String legal_persona_name;
    /**
     * 第三方联系电话
     */
    private String component_phone;
}
