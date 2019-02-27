package com.qq.weixin.api.wxa.response;

import com.qq.weixin.api.BaseResponse;
import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class ModifyDomainResopnse extends BaseResponse {
    private String action;
    private String[] requestdomain;
    private String[] wsrequestdomain;
    private String[] uploaddomain;
    private String[] downloaddomain;
}
