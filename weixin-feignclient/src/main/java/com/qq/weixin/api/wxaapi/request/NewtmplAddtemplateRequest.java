package com.qq.weixin.api.wxaapi.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class NewtmplAddtemplateRequest {

    /**
     * tid : 401
     * kidList : [1,2]
     * sceneDesc : 测试数据
     */

    private String tid;
    private String sceneDesc;
    private List<Integer> kidList;
}
