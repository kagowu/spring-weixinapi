package com.qq.weixin.api.wxa.request;

import lombok.Data;

import java.util.List;

/**
 * @author gong.hua
 */
@Data
public class ModifyDomainRequest {
    private String action = "add";
    private List<String> requestdomain;
    private List<String> wsrequestdomain;
    private List<String> uploaddomain;
    private List<String> downloaddomain;
}
