package com.fumanix.framework.leaf.strategy;

import com.fumanix.framework.leaf.support.RedisRepository;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.util.Assert;

/**
 * 随机数生成器
 */
public class RandomGenerator extends AbstractGenerator {

    @Override
    public StringBuffer gen(StringBuffer sn, String... params) {
        Integer length = ArrayUtils.getLength(params);
        Assert.isTrue((length>1), "参数格式错误,第2个或第3个参数未指定");
        String key = (length==2) ? params[1] : sn.substring(Integer.valueOf(params[1]), Integer.valueOf(params[2]));
        String random = RandomStringUtils.randomNumeric(Integer.valueOf(params[0]));
        while (RedisRepository.isSetMember(key, random)) {
            random = RandomStringUtils.randomNumeric(Integer.valueOf(params[0]));
        }
        RedisRepository.addToSet(key, random);
        return sn.append(random);
    }
}
