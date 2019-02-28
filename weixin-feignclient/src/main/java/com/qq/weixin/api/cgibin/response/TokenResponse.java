package com.qq.weixin.api.cgibin.response;

import com.qq.weixin.api.BaseResponse;
import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class TokenResponse extends BaseResponse {
    private String access_token;
    private int expires_in;
}