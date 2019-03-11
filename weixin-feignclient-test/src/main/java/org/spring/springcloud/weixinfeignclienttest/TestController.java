package org.spring.springcloud.weixinfeignclienttest;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gong.hua
 */
@RestController
@RequestMapping("/test")
@Api(tags = "test", description = "test")
@Slf4j
public class TestController {
}
