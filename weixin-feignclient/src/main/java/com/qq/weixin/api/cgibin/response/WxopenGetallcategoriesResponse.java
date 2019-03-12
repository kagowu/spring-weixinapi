package com.qq.weixin.api.cgibin.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.qq.weixin.api.BaseResponse;
import lombok.Data;

import java.util.List;
import java.util.Locale;

/**
 * @author gong.hua
 */
@Data
public class WxopenGetallcategoriesResponse extends BaseResponse {
    @JSONField(name = "category_list")
    @JsonProperty("category_list")
    private CategoryList categoryList;


    @Data
    public static class CategoryList {
        private List<Category> categories;

    }

    @Data
    public static class Category {
        private List<Integer> children;
        private Integer father;
        private Integer id;
        private Integer level;
        private String name;
        private Qualify qualify;
        @JSONField(name = "sensitive_type")
        @JsonProperty("sensitive_type")
        private Integer sensitiveType;

    }

    @Data
    public static class Qualify {
        @JSONField(name = "exter_list")
        @JsonProperty("exter_list")
        private List<Exter> exterList;

    }

    @Data
    public static class Exter {
        @JSONField(name = "inner_list")
        @JsonProperty("inner_list")
        private List<Inner> innerList;
    }


    @Data
    public static class Inner {
        private String name;
        private String url;
    }
}