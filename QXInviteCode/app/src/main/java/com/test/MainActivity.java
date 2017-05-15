package com.test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.sdk.qxinvitecode.interfaces.OnCallBack;
import com.sdk.qxinvitecode.sdk.QXInviteCodeSDK;
import com.sdk.qxinvitecode.utils.LogUtil;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化SDK数据
//        QXInviteCodeSDK.initialize("1", "234erwsd2", "");
//        SDKDemo();
    }

    /**
     * 测试SDK方法
     */
    private void SDKDemo() {
        //添加接口的参数，获取参数的签名
        Map map = new HashMap();
        map.put("uid", "1010");
        //实例化SDK
        QXInviteCodeSDK inviteCode = QXInviteCodeSDK.getInstance();
        //获取Code邀请码
        inviteCode.getCode(map, new OnCallBack() {
            @Override
            public void onSuccess(String result) {
                LogUtil.i("Sig值getCode", result);
            }

            @Override
            public void onFiled(String errmsg) {
                LogUtil.i("Sig值getCode", errmsg.toString());
            }
        });
        //用户使⽤邀请码
        map = new HashMap();
        map.put("uid", "1000");
        map.put("code", "i1zuvjur");
        inviteCode.UseCode(map, new OnCallBack() {
            @Override
            public void onSuccess(String result) {
                LogUtil.i("Sig值UseCode", result);
            }

            @Override
            public void onFiled(String errmsg) {
                LogUtil.i("Sig值UseCode", errmsg.toString());
            }
        });

        //获取指定用户的成功邀请⽤户ID
        map = new HashMap();
        map.put("uid", "1010");
        inviteCode.getEchos(map, new OnCallBack() {
            @Override
            public void onSuccess(String result) {
                LogUtil.i("Sig值getEchos", result);
            }

            @Override
            public void onFiled(String errmsg) {
                LogUtil.i("Sig值getEchos", errmsg.toString());
            }
        });

        //修改成功邀请用户的可读状态
        map = new HashMap();
        map.put("uid", "1010");
        inviteCode.writeStatu(map, new OnCallBack() {
            @Override
            public void onSuccess(String result) {
                LogUtil.i("Sig值writeStatu", result);
            }

            @Override
            public void onFiled(String errmsg) {
                LogUtil.i("Sig值writeStatu", errmsg.toString());
            }
        });

        //查询指定⽤户是否使⽤用过邀请码
        map = new HashMap();
        map.put("uid", "1000");
        inviteCode.isActive(map, new OnCallBack() {
            @Override
            public void onSuccess(String result) {
                LogUtil.i("Sig值isActive", result);
            }

            @Override
            public void onFiled(String errmsg) {
                LogUtil.i("Sig值isActive", errmsg.toString());
            }
        });

    }
}
