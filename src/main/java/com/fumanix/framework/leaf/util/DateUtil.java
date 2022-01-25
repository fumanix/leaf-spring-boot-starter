package com.fumanix.framework.leaf.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @create: 2021-07-28 16:18
 */
public class DateUtil {

    public final static String DATETIME_MS_PATTERN = "yyyyMMddHHmmssSSS";

    /**
     * 获取当前时间的指定格式.
     *
     * @param pattern
     * @return java.lang.String
     */
    public static String formatNow(String pattern) {
        return formatTime(LocalDateTime.now(), pattern);
    }

    /**
     * 获取指定时间的指定格式.
     *
     * @param time
     * @param pattern
     * @return java.lang.String
     */
    public static String formatTime(LocalDateTime time, String pattern) {
        return time.format(DateTimeFormatter.ofPattern(pattern));
    }
}
