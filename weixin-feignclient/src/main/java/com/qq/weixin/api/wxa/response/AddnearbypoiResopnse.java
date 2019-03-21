package com.qq.weixin.api.wxa.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.qq.weixin.api.BaseResponse;
import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class AddnearbypoiResopnse extends BaseResponse {
    private Entity data;

    @Data
    public static class Entity {
        @JSONField(name = "audit_id")
        @JsonProperty("audit_id")
        private String auditId;
        @JSONField(name = "poi_id")
        @JsonProperty("poi_id")
        private String poiId;
        @JSONField(name = "related_credential")
        @JsonProperty("related_credential")
        private String relatedCredential;
    }
}
