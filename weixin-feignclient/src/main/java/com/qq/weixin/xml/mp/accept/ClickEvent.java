package com.qq.weixin.xml.mp.accept;

import lombok.Data;

/**
 * 点击菜单拉取消息时的事件推送
 *
 * @author gong.hua
 */
@Data
public class ClickEvent extends BasicEvent {

    public ClickEvent() {
        super("CLICK");
    }
}
