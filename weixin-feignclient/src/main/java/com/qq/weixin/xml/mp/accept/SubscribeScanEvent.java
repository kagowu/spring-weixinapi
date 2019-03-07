package com.qq.weixin.xml.mp.accept;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author gong.hua
 * 用户未关注时，进行关注后的事件推送
 */
@Data
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.NONE)
public class SubscribeScanEvent extends ScanEvent {
    public SubscribeScanEvent() {
        setEvent("subscribe");
    }

}
