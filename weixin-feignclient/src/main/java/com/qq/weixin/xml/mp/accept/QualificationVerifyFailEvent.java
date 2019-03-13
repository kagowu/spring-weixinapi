package com.qq.weixin.xml.mp.accept;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;

/**
 * 资质认证失败
 *
 * @author gong.hua
 */
@Data
public class QualificationVerifyFailEvent extends BasicEvent {

    @XmlElement(name = "FailReason")
    private String failReason;

    @XmlElement(name = "FailTime")
    private Integer failTime;

    public QualificationVerifyFailEvent() {
        super("weapp_audit_fail");
    }
}
