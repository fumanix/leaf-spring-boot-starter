package com.fumanix.framework.leaf.util;

/**
 * 32进制工具
 */
public class Base32Tools {

    final static char[] digits = {
            '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
            'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P',
            'R', 'S', 'T', 'U', 'W', 'X', 'Y', 'Z'};

    /**
     * 。
     *
     * @param i      十进制的数字。
     * @param system 指定的进制，常见的2/8/16。
     * @return 转换后的字符串。
     */
    public static String numericToString(long i, int system) {
        long num = 0;
        if (i < 0) {
            num = ((long) 2 * 0x7fffffff) + i + 2;
        } else {
            num = i;
        }
        char[] buf = new char[32];
        int charPos = 32;
        while ((num / system) > 0) {
            buf[--charPos] = digits[(int) (num % system)];
            num /= system;
        }
        buf[--charPos] = digits[(int) (num % system)];
        return new String(buf, charPos, (32 - charPos));
    }

    public static String numericToString(int i, int system) {
        return numericToString((long) i, system);
    }
}
