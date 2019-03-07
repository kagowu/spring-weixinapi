package com.qq.weixin.api.cgibin.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class TemplateApiSetIndustryRequest {
    @JSONField(name = "industry_id1")
    @JsonProperty("industry_id1")
    private String industryId1;

    @JSONField(name = "industry_id2")
    @JsonProperty("industry_id2")
    private String industryId2;
}
