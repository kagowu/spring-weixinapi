package com.qq.weixin.api.wxa.request;

import lombok.Data;

import java.util.List;

/**
 * @author gong.hua
 */
@Data
public class WebviewdomainRequest {
    private String action = "add";
    private List<String> webviewdomain;

}
