package com.qq.weixin.xml.mp.accept;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;

/**
 * 代码管理-审核通过
 *
 * @author gong.hua
 */
@Data
public class WeappAuditSuccessEvent extends BasicEvent {

    private String ret;
    private String nickname;
    private String reason;

    public WeappAuditSuccessEvent() {
        super("weapp_audit_success");
    }
}
