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
public class GetPageResopnse extends BaseResponse {

    @JSONField(name = "page_list")
    @JsonProperty("page_list")
    private List<String> pageList;
}
