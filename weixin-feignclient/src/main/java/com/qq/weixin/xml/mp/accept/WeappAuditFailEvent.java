package com.qq.weixin.xml.mp.accept;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;

/**
 * 代码管理-审核不通过
 *
 * @author gong.hua
 */
@Data
public class WeappAuditFailEvent extends BasicEvent {

    @XmlElement(name = "Reason")
    private String reason;

    @XmlElement(name = "FailTime")
    private Integer failTime;

    public WeappAuditFailEvent() {
        super("weapp_audit_fail");
    }
}
