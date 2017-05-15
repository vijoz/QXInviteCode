package com.sdk.qxinvitecode.sdk;

import android.util.Log;

import com.sdk.qxinvitecode.interfaces.InviteCodeSDK;
import com.sdk.qxinvitecode.interfaces.OnCallBack;
import com.sdk.qxinvitecode.utils.Constants;
import com.sdk.qxinvitecode.utils.HmacSHA1;
import com.sdk.qxinvitecode.utils.HttpUtil;
import com.sdk.qxinvitecode.utils.LogUtil;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 邀请码SDK [Android端]
 * <p>
 * Created by vijoz on 2017/5/10.
 */
public class QXInviteCodeSDK implements Serializable, InviteCodeSDK {

    private static QXInviteCodeSDK INSTANCE = null;
    private static String APP_ID = "";
    private static String ACCESS_KEY = "";
    private static String SECRET = "";

    /**
     * private的构造函数用于避免外界直接使用new来实例化对象
     */
    private QXInviteCodeSDK() {
    }


    /**
     * 单例的实例化方法
     *
     * @return
     */
    public synchronized static QXInviteCodeSDK getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new QXInviteCodeSDK();
        }
        return INSTANCE;
    }

    /**
     * 初始化方法
     *
     * @param appID
     * @param accessKey
     * @param secret
     */
    public static void initialize(String appID, String accessKey, String secret) {
        APP_ID = appID;
        ACCESS_KEY = accessKey;
        SECRET = secret;
    }

    /**
     * 获取邀请码
     *
     * @param args
     * @param onCallBack
     */
    @Override
    public void getCode(Map args, OnCallBack onCallBack) {
        getDatas(args, onCallBack, Constants.URL_GET_CODE);
    }

    /**
     * 用户使用邀请码
     *
     * @param args
     * @param onCallBack
     */
    @Override
    public void UseCode(Map args, OnCallBack onCallBack) {
        getDatas(args, onCallBack, Constants.URL_USE_CODE);
    }


    /**
     * 获取指定用户的成功邀请用户ID
     *
     * @param args
     * @param onCallBack
     */
    @Override
    public void getEchos(Map args, OnCallBack onCallBack) {
        getDatas(args, onCallBack, Constants.URL_GET_ECHOS);
    }

    /**
     * 修改成功邀请用户的可读状态
     *
     * @param args
     * @param onCallBack
     */
    @Override
    public void writeStatu(Map args, OnCallBack onCallBack) {
        getDatas(args, onCallBack, Constants.URL_WRITE_STATU);
    }

    /**
     * 修改成功邀请用户的可读状态
     *
     * @param args
     * @param onCallBack
     */
    @Override
    public void isActive(Map args, OnCallBack onCallBack) {
        getDatas(args, onCallBack, Constants.URL_IS_ACTIVE);
    }

    /**
     * 判断邀请码是否可以使⽤
     *
     * @param args
     * @param onCallBack
     */
    @Override
    public void isCodeEnable(Map args, OnCallBack onCallBack) {
        getDatas(args, onCallBack, Constants.URL_IS_CODE_ENABLE);
    }

    /**
     * 公用接口数据请求方法
     *
     * @param args
     * @param onCallBack
     * @param URL
     */
    private void getDatas(Map args, OnCallBack onCallBack, String URL) {
        try {
            if ("".equals(ACCESS_KEY)) {
                onCallBack.onFiled("ACCESS_KEY IS NULL");
                return;
            } else {
                //参数排序
                String argsString = keySort(args, APP_ID);
                //用参数获取签名
                final String url = URL + HmacSHA1.getHmacSHA1(ACCESS_KEY, argsString) + "&" + argsString;
                //get请求数据
                HttpUtil.get(url, onCallBack);
                LogUtil.i("Sig值url", url);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }

    }


    /**
     * 给url的key值进行排序
     */
    private String keySort(Map sortArgs, String appId) {
        //参数的集合排序
        Map<String, String> args = new TreeMap(
                new Comparator<String>() {
                    public int compare(String obj1, String obj2) {
                        // 升序排序
                        return obj1.compareTo(obj2);
                    }
                });
        args.putAll(sortArgs);
        //参数传入appId，需要参数
        args.put("appid", appId);
        Set<String> keySet = args.keySet();
        Iterator<String> iter = keySet.iterator();
        StringBuffer stringBuffer = new StringBuffer();
        //排序后拼接字符串
        boolean isOnceArg = false;
        while (iter.hasNext()) {
            String key = iter.next();
            if (isOnceArg) {
                stringBuffer.append("&" + key + "=" + args.get(key));
            } else {
                stringBuffer.append(key + "=" + args.get(key));
            }
            isOnceArg = true;
        }
        return String.valueOf(stringBuffer);
    }


    /**
     * readResolve方法应对单例对象被序列化时候又被重新实例化
     */
    private Object readResolve() {
        return getInstance();
    }

}
