package com.qq.weixin.api.xml.accept;

import lombok.Data;

@Data
public class BaseAcceptXml {
    private String ToUserName;
    private String FromUserName;
    private String CreateTime;
    private String MsgType;

}