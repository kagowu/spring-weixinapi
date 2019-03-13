package com.qq.weixin.xml.open.accept;

import com.qq.weixin.xml.open.BaseAuthorizationEvent;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author gong.hua
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.NONE)
@Data
public class AuthorizedAuthorizationEvent extends BaseAuthorizationEvent {
    @XmlElement(name = "AuthorizerAppid")
    private String authorizerAppid;
    @XmlElement(name = "AuthorizationCode")
    private String authorizationCode;
    @XmlElement(name = "AuthorizationCodeExpiredTime")
    private String authorizationCodeExpiredTime;
    @XmlElement(name = "PreAuthCode")
    private String preAuthCode;

    public AuthorizedAuthorizationEvent() {
        super(BaseAuthorizationEvent.AUTHORIZED);
    }

    public AuthorizedAuthorizationEvent(String infoType) {
        super(infoType);
    }
}
