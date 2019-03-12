package com.qq.weixin.api.cgibin.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author gong.hua
 */
@Data
public class WxopenAddcategoryRequest {

    private List<Category> categories;

    @Data
    public static class Category{

        private Integer first;
        private Integer second;
        private List<Certicate> certicates;
    }

    @Data
    public static class Certicate{
        private String key;
        private String value;
    }

}
