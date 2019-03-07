package com.qq.weixin.api.wxa.response;

import com.qq.weixin.api.BaseResponse;
import lombok.Data;

import java.util.List;

/**
 * @author gong.hua
 */
@Data
public class ModifyDomainResopnse extends BaseResponse {
    private String action;
    private List<String> requestdomain;
    private List<String> wsrequestdomain;
    private List<String> uploaddomain;
    private List<String> downloaddomain;
}
