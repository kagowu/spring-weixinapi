package com.qq.weixin.api.cgibin.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class WxopenTemplateAddResponse {
    /**
     * errcode : 0
     * errmsg : ok
     * template_id : wDYzYZVxobJivW9oMpSCpuvACOfJXQIoKUm0PY397Tc
     */

    private int errcode;
    private String errmsg;
    @JSONField(name = "template_id")
    @JsonProperty("template_id")
    private String templateId;
}
