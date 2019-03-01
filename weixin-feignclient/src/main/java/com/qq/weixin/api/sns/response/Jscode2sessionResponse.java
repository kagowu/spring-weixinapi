package com.qq.weixin.api.sns.response;

import com.qq.weixin.api.BaseResponse;
import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class Jscode2sessionResponse extends BaseResponse {
    private String openid;
    private String session_key;
    private String unionid;
}
