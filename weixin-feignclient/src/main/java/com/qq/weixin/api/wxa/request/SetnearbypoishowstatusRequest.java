package com.qq.weixin.api.wxa.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gong.hua
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetnearbypoishowstatusRequest {
    /**
     * 0:不展示
     * 0:展示
     */
    private Integer status;
}
