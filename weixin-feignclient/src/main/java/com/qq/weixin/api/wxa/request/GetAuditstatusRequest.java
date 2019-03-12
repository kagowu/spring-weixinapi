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
public class GetAuditstatusRequest {
    private Integer auditid;
}
