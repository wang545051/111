package com.util;

import cn.hutool.crypto.digest.DigestUtil;

/**
 * Md5加密
 */
public class Md5Util {
    /**
     * @param text 明文
     * @return 密文
     */
    public static String strToMd5(String text) {
        // 加密后的字符串
        text = DigestUtil.md5Hex(text);
        return text;
    }
}
