package com.qq.weixin.xml.open.accept;

import com.qq.weixin.xml.open.BaseAuthorizationEvent;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 取消授权通知
 * @author gong.hua
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.NONE)
@Data
public class UnauthorizedEvent extends BaseAuthorizationEvent {
    @XmlElement(name = "AuthorizerAppid")
    private String authorizerAppid;

    public UnauthorizedEvent() {
        super(BaseAuthorizationEvent.UNAUTHORIZED);
    }
}
