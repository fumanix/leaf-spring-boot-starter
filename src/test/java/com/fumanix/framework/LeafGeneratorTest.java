package com.fumanix.framework;

import com.fumanix.framework.leaf.generator.LeafGenerator;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @create: 2020-06-16 22:09
 */
@SpringBootTest
public class LeafGeneratorTest {

    private static final Logger log = LoggerFactory.getLogger(LeafGeneratorTest.class);

    @Test
    public void generator() {
        //OS + 20200617102056 + 自增序列(截取字符串0到16位为key自增, 取4位数字(不足位,前面补0))
        String orderSn = LeafGenerator.gen("str@OS|date@yyyyMMddHHmmss|seq@4,0,16");      //TS202006162224490001
        log.info("[orderSn] : {}", orderSn);
        //以 ESA 为Key 生成8位数字自增序列(不足8位前面补0)
        String seq = LeafGenerator.gen("seq@8,ESA");                                  //00000001 - 99999999
        log.info("[seq] : {}", seq);
        //SN + 20200617102056 + 随机字符(截取字符串0到16位为key比对随机生成的6位字符串是否已存在)
        String sn = LeafGenerator.gen("str@SN|date@yyyyMMddHHmmss|random@6,0,16");
        log.info("[sn] : {}", sn);
        //32位交易单号
        String trade32 = LeafGenerator.gen("trade@");
        log.info("[trade32] : {}", trade32);
        //28位交易单号
        String trade28 = LeafGenerator.gen("trade@28");
        log.info("[trade28] : {}", trade28);
    }
}
