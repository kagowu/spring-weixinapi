package com.qq.weixin.api.wxa.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.qq.weixin.api.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gong.hua
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiWxaQuerynicknameResponse extends BaseResponse {
    private String nickname;
    @JSONField(name = "audit_stat")
    @JsonProperty("audit_stat")
    private Integer auditStat;

    @JSONField(name = "fail_reason")
    @JsonProperty("fail_reason")
    private Integer failReason;

    @JSONField(name = "create_time")
    @JsonProperty("create_time")
    private Integer createTime;


    @JSONField(name = "audit_time")
    @JsonProperty("audit_time")
    private Integer auditTime;
}
