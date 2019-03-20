package org.spring.springcloud.weixinfeignclienttest;

import com.qq.weixin.mp.MpUrlFormatter;
import lombok.val;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * @author gong.hua
 */
public class MpUrlFormatterTest {
    private String pre_auth_code = "preauthcode@@@eymeq_YOZcqZWlRtriL0gLnLDgsz4yRoOFtXZg1PTFI3vPtU-bARS_NJah77pPNH";

    @Test
    public void test() throws UnsupportedEncodingException {
        val val = MpUrlFormatter.getComonentloginpage("wxe3987587f06091cf", pre_auth_code, "http://***/wxopen/api/auth/jump");

    }
}
