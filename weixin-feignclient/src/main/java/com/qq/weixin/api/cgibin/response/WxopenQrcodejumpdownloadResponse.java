package com.qq.weixin.api.cgibin.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.qq.weixin.api.BaseResponse;
import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class WxopenQrcodejumpdownloadResponse extends BaseResponse {
    @JSONField(name = "file_name")
    @JsonProperty("file_name")
    private String fileName;
    @JSONField(name = "file_content")
    @JsonProperty("file_content")
    private String fileContent;

}