package com.qq.weixin.api.cgibin.response;

import com.qq.weixin.api.BaseResponse;
import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class QrcodeTicketResponse extends BaseResponse {
    private String ticket;
    private Integer expire_seconds;
    private String url;
}