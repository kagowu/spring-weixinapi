package com.qq.weixin.api.wxa.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.qq.weixin.api.BaseResponse;
import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class GetgrayreleaseplanResopnse extends BaseResponse {
    private GrayReleasePlan grayReleasePlan;

    public static class GrayReleasePlan{
        private Integer status;
        @JSONField(name = "create_timestamp")
        @JsonProperty("create_timestamp")
        private Integer createTimestamp;
        @JSONField(name = "gray_percentage")
        @JsonProperty("gray_percentage")
        private Integer grayPercentage;
    }
}
