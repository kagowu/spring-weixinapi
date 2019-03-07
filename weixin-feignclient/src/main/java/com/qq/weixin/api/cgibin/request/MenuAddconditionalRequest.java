package com.qq.weixin.api.cgibin.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class MenuAddconditionalRequest extends MenuCreateRequest {
    private Matchrule matchrule;

    @Data
    public static class Matchrule {
        @JSONField(name = "tag_id")
        @JsonProperty("tag_id")
        private String tagId;
        private String sex;
        private String country;
        private String province;
        private String city;
        /**
         * 客户端版本，当前只具体到系统型号：IOS(1), Android(2),Others(3)，不填则不做匹配
         */
        @JSONField(name = "client_platform_type")
        @JsonProperty("client_platform_type")
        private String clientPlatformType;
        /**
         * 语言信息，是用户在微信中设置的语言，具体请参考语言表： 1、简体中文 "zh_CN" 2、繁体中文TW "zh_TW" 3、繁体中文HK "zh_HK"
         * 4、英文 "en" 5、印尼 "id" 6、马来 "ms" 7、西班牙 "es" 8、韩国 "ko" 9、意大利 "it" 10、日本 "ja"
         * 11、波兰 "pl" 12、葡萄牙 "pt" 13、俄国 "ru" 14、泰文 "th" 15、越南 "vi" 16、阿拉伯语 "ar" 17、北印度 "hi"
         * 18、希伯来 "he" 19、土耳其 "tr" 20、德语 "de" 21、法语 "fr"
         */
        private String language;
    }
}
