package com.qq.weixin.api.cgibin.response;

import com.qq.weixin.api.BaseResponse;
import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class ComponentApi_create_preauthcodeResponse extends BaseResponse {
    private String pre_auth_code;
    private String expires_in;
}
