package com.qq.weixin.api.wxa.request;

import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class WebviewdomainRequest {
    private String action = "add";
    private String[] webviewdomain;

}
