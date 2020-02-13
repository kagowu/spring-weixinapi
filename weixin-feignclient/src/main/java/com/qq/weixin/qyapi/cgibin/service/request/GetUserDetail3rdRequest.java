package com.qq.weixin.qyapi.cgibin.service.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class GetUserDetail3rdRequest {


    /**
     * 成员票据
     */
    @JSONField(name = "user_ticket")
    @JsonProperty("user_ticket")
    private String userTicket;


}
