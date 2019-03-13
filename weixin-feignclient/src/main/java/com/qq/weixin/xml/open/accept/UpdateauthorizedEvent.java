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
public class UpdateauthorizedEvent extends AuthorizedAuthorizationEvent {

    public UpdateauthorizedEvent() {
        super(BaseAuthorizationEvent.UPDATEAUTHORIZED);
    }
}
