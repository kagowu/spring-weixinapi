package com.qq.weixin.xml.mp.reply;

import com.qq.weixin.xml.mp.BaseReplyMsg;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * 回复图文消息
 *
 * @author gong.hua
 */
@Getter
@Setter
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.NONE)
public class NewsReply extends BaseReplyMsg {
    /**
     * 图文消息个数；当用户发送文本、图片、视频、图文、地理位置这五种消息时，开发者只能回复1条图文消息；其余场景最多可回复8条图文消息
     */
    @XmlElement(name = "ArticleCount")
    private String articleCount;

    @XmlElement(name = "Articles")
    private Articles articles;

    @Data
    @XmlRootElement(name = "Articles")
    @XmlAccessorType(XmlAccessType.NONE)
    public static class Articles {
        /**
         * 消息标题
         */
        @XmlElement(name = "item")
        private List<Item> items;
    }

    @Data
    @XmlRootElement(name = "item")
    @XmlAccessorType(XmlAccessType.NONE)
    public static class Item {
        /**
         * 消息标题
         */
        @XmlElement(name = "Title")
        private String title;
        /**
         * 消息描述
         */
        @XmlElement(name = "Description")
        private String description;
        /**
         * 消息链接
         */
        @XmlElement(name = "Url")
        private String url;
        /**
         * 图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
         */
        @XmlElement(name = "PicUrl")
        private String picUrl;
    }

    public NewsReply() {
        super("news");
    }


}
