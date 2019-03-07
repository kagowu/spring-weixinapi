package com.qq.weixin.xml.mp.accept;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 视频消息
 */
@Data
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.NONE)
public class VideoMsg extends BasicMediaMsg {

    /**
     * 语音格式，如amr，speex等
     */
    @XmlElement(name = "ThumbMediaId")
    private String thumbMediaId;

    public VideoMsg() {
        super("video");
    }
}
