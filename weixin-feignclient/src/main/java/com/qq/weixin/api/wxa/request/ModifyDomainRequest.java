package com.qq.weixin.api.wxa.request;

import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class ModifyDomainRequest {
    private String action = "add";
    private String[] requestdomain;
    private String[] wsrequestdomain;
    private String[] uploaddomain;
    private String[] downloaddomain;
}
