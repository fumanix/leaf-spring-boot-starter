package com.fumanix.framework.leaf.strategy;

import com.fumanix.framework.leaf.support.RedisRepository;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.util.Assert;

/**
 * 序列号生成器
 */
public class SequenceGenerator extends AbstractGenerator {

    @Override
    public StringBuffer gen(StringBuffer sn, String... params) {
        int length = ArrayUtils.getLength(params);
        Assert.isTrue((length>1), "参数格式错误.第2个或第3个参数未指定");
        String key = (length==2) ? params[1] : sn.substring(Integer.valueOf(params[1]), Integer.valueOf(params[2]));
        long sequence = RedisRepository.increment(key);
        return sn.append(("0".equals(params[0])) ? String.valueOf(sequence) : String.format("%0" + params[0] + "d", sequence));
    }
}
