package com.fumanix.framework.leaf.strategy;

import com.fumanix.framework.leaf.util.Base32Tools;
import com.fumanix.framework.leaf.util.DateUtil;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Random;

/**
 * 资产交易号生成器
 */
public class TradingGenerator extends AbstractGenerator {

    private static final Random random = new Random();

    @Override
    public StringBuffer gen(StringBuffer sn, String... params) {
        Integer index = ArrayUtils.isEmpty(params)?32:NumberUtils.toInt(params[0], 32);
        return sn.append(DateUtil.formatNow(DateUtil.DATETIME_MS_PATTERN))
                .append(StringUtils.leftPad(Base32Tools.numericToString(random.nextInt(1073741823), 10), (index-17), "0"));    }
}
