package com.qq.weixin.api.wxa.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class SetnicknameRequest {
    @JSONField(name = "nick_name")
    @JsonProperty("nick_name")
    private String nickName;

    @JSONField(name = "id_card")
    @JsonProperty("id_card")
    private String idCard;


    private String license;

    @JSONField(name = "naming_other_stuff_1")
    @JsonProperty("naming_other_stuff_1")
    private String namingOtherStuff1;


    @JSONField(name = "naming_other_stuff_2")
    @JsonProperty("naming_other_stuff_2")
    private String namingOtherStuff2;
}
