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
public class GettemplatedraftlistResopnse extends BaseResponse {
    @JSONField(name = "draft_list")
    @JsonProperty("draft_list")
    private List<Draft> draftList;

    @Data
    public static class Draft {
        @JSONField(name = "create_time")
        @JsonProperty("create_time")
        private Integer createTime;
        @JSONField(name = "user_version")
        @JsonProperty("user_version")
        private String userVersion;
        @JSONField(name = "user_desc")
        @JsonProperty("user_desc")
        private String userDesc;
        @JSONField(name = "draft_id")
        @JsonProperty("draft_id")
        private Integer draftId;
    }

}
