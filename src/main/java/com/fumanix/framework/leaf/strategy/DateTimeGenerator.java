package com.fumanix.framework.leaf.strategy;

import com.fumanix.framework.leaf.util.DateUtil;

/**
 * 时间格式字符生成器
 */
public class DateTimeGenerator extends AbstractGenerator {

    @Override
    public StringBuffer gen(StringBuffer sn, String... params) {
        return sn.append(DateUtil.formatNow(params[0]));
    }
}
