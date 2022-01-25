package com.fumanix.framework.leaf.generator;

import com.fumanix.framework.leaf.strategy.AbstractGenerator;
import com.fumanix.framework.leaf.strategy.GeneratorFactory;
import com.fumanix.framework.leaf.support.GeneratorType;
import com.fumanix.framework.leaf.support.RedisRepository;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.util.Assert;

import java.util.Arrays;

/**
 * 序列号生成器
 */
public class LeafGenerator {

    private static final String COMMA = ",";

    /**
     * 生成序列号
     * @return 生成好的序列号
     */
    public static String gen(String snPattern) {
        String[] patterns = snPattern.split("\\|");
        Assert.notEmpty(patterns, "The snPattern is invalid. ");
        StringBuffer sn = new StringBuffer();
        Arrays.stream(patterns).forEach(pattern -> {
            //解析生成器
            String[] patternArgs = pattern.split("@");
            //根据生成器类型选择对应的生成器
            GeneratorType type = GeneratorType.valueOf(patternArgs[0]);
            AbstractGenerator generator = GeneratorFactory.getInstance().getGenerator(type);
            if (ArrayUtils.getLength(patternArgs) >= 2) {
                String[] args = patternArgs[1].split(COMMA);
                generator.gen(sn, args);
            } else {
                generator.gen(sn);
            }
        });
        if (snPattern.contains(GeneratorType.date.name())) {
            Object[] arrays = snPattern.split(COMMA);
            int length = NumberUtils.toInt(String.valueOf(arrays[2]));
            RedisRepository.expire(StringUtils.left(sn.toString(), length));
        }
        return sn.toString();
    }
}
