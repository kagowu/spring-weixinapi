package com.qq.weixin.api.wxa.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gong.hua
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddtotemplateRequest {
    @JSONField(name = "draft_id")
    @JsonProperty("draft_id")
    private Integer draftId;
}
