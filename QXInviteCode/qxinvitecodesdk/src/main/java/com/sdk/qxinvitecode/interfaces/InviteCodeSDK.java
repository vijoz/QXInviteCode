package com.sdk.qxinvitecode.interfaces;

import java.util.Map;

/**
 * SDK的接口
 * Created by vijoz on 2017/5/11.
 */

public interface InviteCodeSDK {
    void init(String appid, String access, String secret); //初始化SDK

    void getCode(Map args, OnCallBack onCallBack); //获得用户邀请码

    void UseCode(Map args, OnCallBack onCallBack); //用户使用邀请码

    void getEchos(Map args, OnCallBack onCallBack); //获取指定⽤用户的成功邀请⽤用户ID

    void writeStatu(Map args, OnCallBack onCallBack); //修改成功邀请⽤用户的可读状态

    void isActive(Map args, OnCallBack onCallBack); //查询指定⽤用户是否使⽤用过邀请码
}
