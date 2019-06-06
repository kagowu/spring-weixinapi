package com.qq.weixin.api.cgibin.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class WxopenTemplateListRequest {

    /**
     * offset : 0
     * count : 20
     */

    private int offset;
    private int count;
}
