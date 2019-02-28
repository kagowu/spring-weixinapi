package com.qq.weixin.message.xml.accept;

import com.qq.weixin.api.xml.accept.BaseAcceptXml;
import com.qq.weixin.api.xml.accept.TextAcceptXml;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author gong.hua
 */
//@XmlAccessorType(XmlAccessType.NONE)
@Data
//@ApiModel( value = "xml")
@XmlRootElement(name = "xml")

public class WholeAcceptXml{
    @XmlElement(name = "ToUserName")
    private String toUserName;
    private String FromUserName;
    private String CreateTime;
    private String MsgType;

    public TextAcceptXml getText() {
        TextAcceptXml text = new TextAcceptXml();
        BeanUtils.copyProperties(this, text);
        return text;
    }


}
