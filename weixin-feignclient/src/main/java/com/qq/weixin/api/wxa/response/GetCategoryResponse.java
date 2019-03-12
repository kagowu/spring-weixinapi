package com.qq.weixin.api.wxa.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author gong.hua
 */
@Data
public class GetCategoryResponse {
    @JSONField(name = "category_list")
    @JsonProperty("category_list")
    private List<Category> categoryList;

    @Data
    public static class Category {
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
    }

}
