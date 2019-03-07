package com.qq.weixin.xml.mp.accept;

import com.qq.weixin.xml.mp.BaseAcceptMsg;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;

/**
 * 事件消息
 *
 * @author gong.hua
 */
@Data
public class BasicEvent extends BaseAcceptMsg {

    /**
     * 事件类型
     */
    @XmlElement(name = "Event")
    private String event;
    /**
     * 事件KEY值
     */
    @XmlElement(name = "EventKey")
    private String eventKey;

    protected BasicEvent(String event) {
        super("event");
        this.event = event;
    }
}
