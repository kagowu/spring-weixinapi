package com.qq.weixin.xml.mp.accept;

import lombok.Data;

/**
 * 点击菜单跳转链接时的事件推送
 *
 * @author gong.hua
 */
@Data
public class ViewEvent extends BasicEvent {

    public ViewEvent() {
        super("VIEW");
    }
}
