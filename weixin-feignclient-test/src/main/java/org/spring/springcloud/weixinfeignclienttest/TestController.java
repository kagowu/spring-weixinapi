package org.spring.springcloud.weixinfeignclienttest;

import com.qq.weixin.message.xml.accept.WholeAcceptXml;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author gong.hua
 */
@RestController
@RequestMapping("/test")
@Api(tags = "test", description = "test")
@Slf4j
public class TestController {
    @RequestMapping(value = "/receiveXml", method = RequestMethod.POST,
            produces = { "application/xml" },
            consumes = { "application/xml"  })
    @ApiOperation(value = "test", notes = "test")
    @ResponseBody
    public WholeAcceptXml receiverSMS(@RequestBody WholeAcceptXml xml) {
        log.info("回调参数：" + xml.toString());
        return xml;
    }

}
