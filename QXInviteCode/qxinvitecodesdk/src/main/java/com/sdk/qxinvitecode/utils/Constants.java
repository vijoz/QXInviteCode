package com.sdk.qxinvitecode.utils;

/**
 * URL工具类
 * Created by vijoz on 2017/5/11.
 */
public class Constants {
    public static final String SERVER;
    /**
     * true为debug测试环境的url
     */
    public static final boolean DEBUG = false;

    static {
        if (DEBUG) {
            SERVER = "http://invitecode.quxueabc.com:8000/";
        } else {
            SERVER = "http://invitecode.quxueabc.com:8000/";
        }
    }

    //获得用户邀请码
    public static final String URL_GET_CODE = SERVER + "app/get_code?sig=";
    //用户使用邀请码
    public static final String URL_USE_CODE = SERVER + "app/use_code?sig=";
    //获取指定⽤户的成功邀请⽤户ID
    public static final String URL_GET_ECHOS = SERVER + "app/get_echos?sig=";
    //修改成功邀请用户的可读状态
    public static final String URL_WRITE_STATU = SERVER + "app/write_statu?sig=";
    //查询指定用户是否使用过邀请码
    public static final String URL_IS_ACTIVE = SERVER + "app/is_active?sig=";
    //判断邀请码是否可以使⽤
    public static final String URL_IS_CODE_ENABLE = SERVER + "app/is_code_enable?sig=";
}
