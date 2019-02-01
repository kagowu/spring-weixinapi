package com.qq.weixin.api.cgibin.response;

import com.qq.weixin.api.BaseResponse;
import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class ApiComponentTokenResponse extends BaseResponse {
    private String component_access_token;
    private String expires_in;
}
