package com.qq.weixin.api.cgibin.request;

import lombok.Data;

import java.util.List;

/**
 * @author gong.hua
 */
@Data
public class WxopenModifycategoryRequest {

    private Integer first;
    private Integer second;
    private List<Certicate> certicates;

    @Data
    public static class Certicate {
        private String key;
        private String value;
    }

}
