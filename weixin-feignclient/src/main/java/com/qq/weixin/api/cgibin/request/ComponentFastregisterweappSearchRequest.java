package com.qq.weixin.api.cgibin.request;

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
    private String legal_persona_wechat;
    /**
     * 法人姓名
     */
    private String legal_persona_name;

}
