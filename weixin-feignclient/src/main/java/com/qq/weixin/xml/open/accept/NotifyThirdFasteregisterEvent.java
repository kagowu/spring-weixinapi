package com.qq.weixin.xml.open.accept;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.qq.weixin.xml.open.BaseAuthorizationEvent;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 注册审核事件
 *
 * @author gong.hua
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.NONE)
@Data
public class NotifyThirdFasteregisterEvent extends BaseAuthorizationEvent {
    /**
     * 创建小程序appid
     */
    private String appid;
    private String status;
    /**
     * xxxxx第三方授权码
     */
    @XmlElement(name = "auth_code")
    private String authCode;
    private String msg;
    private Info info;


    public NotifyThirdFasteregisterEvent() {
        super(BaseAuthorizationEvent.NOTIFY_THIRD_FASTEREGISTER);
    }

    public static class Info{
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
        @XmlElement(name = "code_type")
        private String codeType;
        /**
         * 法人微信
         */
        @XmlElement(name = "legal_persona_wechat")
        private String legalPersonaWechat;
        /**
         * 法人姓名
         */
        @XmlElement(name = "legal_persona_name")
        private String legalPersonaName;
        /**
         * 第三方联系电话
         */
        @XmlElement(name = "component_phone")
        private String componentPhone;
    }
}
