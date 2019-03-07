package com.qq.weixin.xml.mp.accept;

import lombok.Data;

/**
 * 取消关注事件
 *
 * @author gong.hua
 */
@Data
public class UnsubscribeEvent extends BasicEvent {

    public UnsubscribeEvent() {
        super("unsubscribe");
    }
}
