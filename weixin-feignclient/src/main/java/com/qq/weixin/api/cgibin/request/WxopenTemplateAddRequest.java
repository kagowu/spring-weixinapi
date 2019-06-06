package com.qq.weixin.api.cgibin.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class WxopenTemplateAddRequest {
    /**
     * id : AT0793
     * keyword_id_list : [1,2,7]
     */

    private String id;
    @JSONField(name = "keyword_id_list")
    @JsonProperty("keyword_id_list")
    private List<Integer> keywordIdList;
}
