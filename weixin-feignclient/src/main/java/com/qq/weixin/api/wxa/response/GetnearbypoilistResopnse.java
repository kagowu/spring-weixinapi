package com.qq.weixin.api.wxa.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.qq.weixin.api.BaseResponse;
import lombok.Data;

import java.util.List;

/**
 * @author gong.hua
 */
@Data
public class GetnearbypoilistResopnse extends BaseResponse {
    private Entity data;

    @Data
    public static class Entity {
        @JSONField(name = "left_apply_num")
        @JsonProperty("left_apply_num")
        private Integer leftApplyNum;
        @JSONField(name = "max_apply_num")
        @JsonProperty("max_apply_num")
        private Integer maxApplyNum;
        @JSONField(name = "related_credential")
        @JsonProperty("related_credential")
        private Entity2 data;
    }

    @Data
    public static class Entity2{
        @JSONField(name = "poi_list")
        @JsonProperty("poi_list")
        private List<Poi> poiList;
    }

    @Data
    public static class Poi{
        @JSONField(name = "poi_id")
        @JsonProperty("poi_id")
        private String poiId;

        @JSONField(name = "qualification_address")
        @JsonProperty("qualification_address")
        private String qualificationAddress;

        @JSONField(name = "qualification_num")
        @JsonProperty("qualification_num")
        private String qualificationNum;
        /**
         * 3:审核中
         * 4:审核失败
         * 5:审核通过
         */
        @JSONField(name = "audit_status")
        @JsonProperty("audit_status")
        private Integer auditStatus;
        /**
         * 0:未展示
         * 1:展示中
         */
        @JSONField(name = "display_status")
        @JsonProperty("display_status")
        private Integer displayStatus;
        /**
         * 审核失败原因，audit_status=4 时返回
         */
        @JSONField(name = "refuse_reason")
        @JsonProperty("refuse_reason")
        private String refuseReason;
    }
}
