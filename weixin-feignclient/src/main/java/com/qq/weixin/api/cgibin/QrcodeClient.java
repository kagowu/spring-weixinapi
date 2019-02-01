package com.qq.weixin.api.cgibin;


import com.qq.weixin.api.cgibin.request.QrcodeCreateRequest;
import com.qq.weixin.api.cgibin.response.QrcodeTicketResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "qrcode", url = "https://api.weixin.qq.com/cgi-bin/")
public interface QrcodeClient {
    /**
     * 生成带参数的二维码
     *
     * @param accessToken
     * @return
     * @link {https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1443433542}
     */
    @RequestMapping(value = "/qrcode/create", method = RequestMethod.GET)
    QrcodeTicketResponse create(@RequestParam("access_token") String accessToken, @RequestBody QrcodeCreateRequest qrcodeCreateRequest);

}
