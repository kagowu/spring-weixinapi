package com.qq.weixin.xml.open.accept;

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
    private String appid;
    private String status;
    @XmlElement(name = "auth_code")
    private String authCode;
    private String msg;
    // FIXME
    private String info;


    public NotifyThirdFasteregisterEvent() {
        super(BaseAuthorizationEvent.NOTIFY_THIRD_FASTEREGISTER);
    }
}
