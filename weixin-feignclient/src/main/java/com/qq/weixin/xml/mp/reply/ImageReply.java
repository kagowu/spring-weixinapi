package com.qq.weixin.xml.mp.reply;

import com.qq.weixin.xml.mp.BaseReplyMsg;
import com.qq.weixin.xml.util.JAXBUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 回复图片消息
 *
 * @author gong.hua
 */
@Getter
@Setter
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.NONE)
public class ImageReply extends BaseReplyMsg {

    @XmlElement(name = "Image")
    private Image image;

    @Data
    @XmlRootElement(name = "Image")
    @XmlAccessorType(XmlAccessType.NONE)
    @AllArgsConstructor
    public static class Image {
        /**
         * 通过素材管理中的接口上传多媒体文件，得到的id。
         */
        @XmlElement(name = "MediaId")
        private String mediaId;
    }

    public ImageReply() {
        super("image");
    }


}
