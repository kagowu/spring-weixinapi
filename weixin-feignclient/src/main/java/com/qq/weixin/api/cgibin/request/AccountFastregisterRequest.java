package com.qq.weixin.api.cgibin.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gong.hua
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountFastregisterRequest {
    private String ticket;
}
