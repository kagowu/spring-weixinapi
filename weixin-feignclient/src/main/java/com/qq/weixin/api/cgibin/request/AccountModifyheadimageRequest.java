package com.qq.weixin.api.cgibin.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class AccountModifyheadimageRequest {
    @JSONField(name = "head_img_media_id")
    @JsonProperty("head_img_media_id")
    private String headImgMediaId;

    private float x1;
    private float y1;
    private float x2;
    private float y2;

}
