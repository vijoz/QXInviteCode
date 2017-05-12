package com.sdk.qxinvitecode.utils;

import android.util.Base64;
import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import static com.sdk.qxinvitecode.utils.BytesToHex.toHexString;

/**
 * 获取签名的工具（老大的签名方式）
 * Created by vijoz on 2017/5/10.
 */

public class HmacSHA1 {
    /**
     * @param access_key //加密密钥
     * @param data       //需要加密的数据
     * @return
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     */
    public static String getHmacSHA1(String access_key, String data) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        SecretKeySpec localSecretKeySpec = new SecretKeySpec(access_key.getBytes("UTF-8"), "HmacSHA1");//加密密钥
        Mac localMac = Mac.getInstance("HmacSHA1");
        localMac.init(localSecretKeySpec);
        byte[] digest = localMac.doFinal(data.getBytes("UTF-8"));
        return Base64.encodeToString(toHexString(digest).getBytes(), Base64.DEFAULT).trim(); //获取加密结果并转BASE64
    }
}
