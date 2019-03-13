package com.qq.weixin.xml.mp.accept;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;

/**
 * 小程序名称设置回调
 *
 * @author gong.hua
 */
@Data
public class WxaNicknameAuditEvent extends BasicEvent {


    @XmlElement(name = "SuccTime")
    private String succTime;

    public WxaNicknameAuditEvent() {
        super("wxa_nickname_audit");
    }
}
