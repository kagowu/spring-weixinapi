package com.qq.weixin.xml.mp.accept;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 代码管理-审核通过
 *
 * @author gong.hua
 */
@Data
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.NONE)
public class WeappAuditSuccessEvent extends BasicEvent {

    private String ret;
    private String nickname;
    private String reason;

    public WeappAuditSuccessEvent() {
        super("weapp_audit_success");
    }
}
