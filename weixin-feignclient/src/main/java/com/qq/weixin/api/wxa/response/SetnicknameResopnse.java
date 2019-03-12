package com.qq.weixin.api.wxa.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.qq.weixin.api.BaseResponse;
import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class SetnicknameResopnse extends BaseResponse {
    private String wording;

    @JSONField(name = "audit_id")
    @JsonProperty("audit_id")
    private String auditId;
}
