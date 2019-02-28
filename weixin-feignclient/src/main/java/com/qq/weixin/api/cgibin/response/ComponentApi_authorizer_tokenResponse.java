package com.qq.weixin.api.cgibin.response;

import com.qq.weixin.api.BaseResponse;
import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class ComponentApi_authorizer_tokenResponse extends BaseResponse {

    private String authorizer_access_token;

    private Integer expires_in;

    private String authorizer_refresh_token;
}
