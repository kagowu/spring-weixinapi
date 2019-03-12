package com.qq.weixin.api.cgibin.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author gong.hua
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxopenQrcodejumpgetResponse {
    @JSONField(name = "rule_list")
    @JsonProperty("rule_list")
    private List<Rule> ruleList;

    @Data
    public static class Rule {
        private String prefix;
        /**
         * 位于rule_list字段内，测试范围：
         * 1为开发版（配置只对开发者生效）
         * 2为体验版（配置对管理员、体验者生效）
         * 3为线上版本（配置对管理员、开发者和体验者生效）
         */
        @JSONField(name = "open_version")
        @JsonProperty("open_version")
        private String openVersion;
        /**
         * 位于rule_list字段内，发布标志位，1表示未发布，2表示已发布
         */
        private String state;

        @JSONField(name = "permit_sub_rule")
        @JsonProperty("permit_sub_rule")
        private String permitSubRule;

        private String path;

        /**
         * 位于rule_list字段内，测试链接（选填）可填写不多于5个用于测试的二维码完整链接，此链接必须符合已填写的二维码规则。
         */
        @JSONField(name = "debug_url")
        @JsonProperty("debug_url")
        private List<String> debugUrl;

    }

    @JSONField(name = "qrcodejump_open")
    @JsonProperty("qrcodejump_open")
    private Integer qrcodejumpOpen;

    @JSONField(name = "list_size")
    @JsonProperty("list_size")
    private Integer listSize;

    @JSONField(name = "qrcodejump_pub_quota")
    @JsonProperty("qrcodejump_pub_quota")
    private Integer qrcodejumpPubQuota;

}
