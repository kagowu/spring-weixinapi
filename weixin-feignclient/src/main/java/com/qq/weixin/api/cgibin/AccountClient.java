package com.qq.weixin.api.cgibin;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author gong.hua
 */
@FeignClient(name = "account", url = "https://api.weixin.qq.com/cgi-bin/")
public interface AccountClient {
}
