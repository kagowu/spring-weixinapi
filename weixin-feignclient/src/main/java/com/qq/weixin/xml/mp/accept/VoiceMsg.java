package com.qq.weixin.xml.mp.accept;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 语音消息
 */
@Data
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.NONE)
public class VoiceMsg extends BasicMediaMsg {

    /**
     * 语音格式，如amr，speex等
     */
    @XmlElement(name = "Format")
    private String format;

    public VoiceMsg() {
        super("voice");
    }
}
