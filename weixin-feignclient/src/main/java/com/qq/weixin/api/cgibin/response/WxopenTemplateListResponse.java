package com.qq.weixin.api.cgibin.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class WxopenTemplateListResponse {

    private int errcode;
    private String errmsg;
    private List<ListBean> list;

    @Data
    public static class ListBean {
        @JSONField(name = "template_id")
        @JsonProperty("template_id")
        private String templateId;
        private String title;
        private String content;
        private String example;
    }
}
