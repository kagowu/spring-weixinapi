package com.qq.weixin.api.wxa.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gong.hua
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeVisitstatusRequest {
    public static final String CLOSE = "close";
    public static final String OPEN = "open";
    /**
     * 设置可访问状态，发布后默认可访问，close为不可见，open为可见
     */
    private String action;
}
