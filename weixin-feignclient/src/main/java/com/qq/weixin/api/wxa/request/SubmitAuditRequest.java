package com.qq.weixin.api.wxa.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author gong.hua
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubmitAuditRequest {
    @JSONField(name = "item_list")
    @JsonProperty("item_list")
    private List<Item> itemList;

    @Data
    public static class Item {
        private String address;
        private String tag;
        @JSONField(name = "first_class")
        @JsonProperty("first_class")
        private String firstClass;

        @JSONField(name = "second_class")
        @JsonProperty("second_class")
        private String secondClass;

        @JSONField(name = "third_class")
        @JsonProperty("third_class")
        private String thirdClass;


        @JSONField(name = "first_id")
        @JsonProperty("first_id")
        private Integer firstId;

        @JSONField(name = "second_id")
        @JsonProperty("second_id")
        private Integer secondId;


        @JSONField(name = "third_id")
        @JsonProperty("third_id")
        private Integer thirdId;

        private String title;

    }
    @JSONField(name = "feedback_info")
    @JsonProperty("feedback_info")
    private String feedbackInfo;

    /**
     * 图片media_id列表，中间用“丨”分割，xx丨yy丨zz，不超过5张图片, 其中 media_id 可以通过新增临时素材接口上传而得到
     */
    @JSONField(name = "feedback_stuff")
    @JsonProperty("feedback_stuff")
    private String feedbackStuff;
}
