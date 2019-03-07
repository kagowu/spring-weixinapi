package com.qq.weixin.xml.mp.accept;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 小视频消息
 */
@Data
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.NONE)
public class ShortVideoMsg extends BasicMediaMsg {

    /**
     * 语音格式，如amr，speex等
     */
    @XmlElement(name = "ThumbMediaId")
    private String thumbMediaId;

    public ShortVideoMsg() {
        super("shortvideo");
    }
}
