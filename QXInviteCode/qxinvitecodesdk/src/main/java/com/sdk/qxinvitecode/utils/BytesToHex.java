package com.sdk.qxinvitecode.utils;

import java.math.BigInteger;

/**
 * 进制转换工具类
 * Created by vijoz on 2017/5/11.
 */

public class BytesToHex {
    /**
     * 数组转成十六进制的方法(转完是小写的)
     *
     * @param bytes
     * @return
     */
    public static String toHexString(byte[] bytes) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < bytes.length; ++i) {
            buffer.append(toHexString(bytes[i]));
        }
        return buffer.toString();
    }

    /**
     * 上面需要这个方法转十六进制
     *
     * @param bytes
     * @return
     */
    public static String toHexString(byte bytes) {
        String s = Integer.toHexString(bytes & 0xFF);
        if (s.length() == 1) {
            return "0" + s;
        } else {
            return s;
        }
    }

    /**
     * 数组转成二进制的方法
     *
     * @param bytes
     * @param radix
     * @return
     */
    public static String binary(byte[] bytes, int radix) {
        return new BigInteger(1, bytes).toString(radix);// 这里的1代表正数
    }


    /**
     * 数组转换成十六进制字符串(转完是大写的)
     *
     * @param bArray
     * @return
     */
    public static final String bytesToHexString(byte[] bArray) {
        StringBuffer sb = new StringBuffer(bArray.length);
        String sTemp;
        for (int i = 0; i < bArray.length; i++) {
            sTemp = Integer.toHexString(0xFF & bArray[i]);
            if (sTemp.length() < 2)
                sb.append(0);
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }
}
