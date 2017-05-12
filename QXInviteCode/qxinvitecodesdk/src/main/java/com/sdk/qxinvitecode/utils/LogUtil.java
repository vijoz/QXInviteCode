package com.sdk.qxinvitecode.utils;

import android.util.Log;

/**
 * @author vijoz
 *         创建时间：2015年12月15日 下午1:25:27
 *         类 描述 Log打印日志类
 */
public class LogUtil {

    private static final String TAG = "InviteCodeSDK";

    public static final boolean DEBUG = false;  //测试环境为true,生产环境为false

    public static void v(Object message) {
        if (DEBUG) {
            Log.v(TAG, message.toString());
        }
    }

    public static void v(String tag, Object message) {
        if (DEBUG) {
            Log.v(tag, message.toString());
        }
    }

    public static void i(Object message) {
        if (DEBUG) {
            Log.i(TAG, message.toString());
        }
    }

    public static void i(String tag, Object message) {
        if (DEBUG) {
            Log.i(tag, message.toString());
        }
    }

    public static void e(Object message) {
        if (DEBUG) {
            Log.e(TAG, message.toString());
        }
    }

    public static void e(String tag, Object message) {
        if (DEBUG) {
            Log.e(tag, message.toString());
        }
    }

    public static void d(Object message) {
        if (DEBUG) {
            Log.d(TAG, message.toString());
        }
    }

    public static void d(String tag, Object message) {
        if (DEBUG) {
            Log.d(tag, message.toString());
        }
    }

    public static void w(Object message) {
        if (DEBUG) {
            Log.w(TAG, message.toString());
        }
    }

    public static void w(String tag, Object message) {
        if (DEBUG) {
            Log.w(tag, message.toString());
        }
    }

    public static void w(Object message, Throwable tr) {
        if (DEBUG) {
            Log.w(TAG, message.toString(), tr);
        }
    }

    public static void w(String tag, Object message, Throwable tr) {
        if (DEBUG) {
            Log.w(tag, message.toString(), tr);
        }
    }
}
