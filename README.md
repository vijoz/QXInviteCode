# QXInviteCode
最新版本：1.0.5

Gradle中的引用

```
dependencies {compile 'com.github.vijoz:QXInviteCode:1.0.5'}
```

SDK的初始化

* void initialize(String appId, String accessKey, String secret); //在Application类中初始化SDK

SDK的调用
* SDK类是个单例类，通过调用getInstance()进行实例化

* void getCode(Map args, OnCallBack onCallBack); //获得用户邀请码
* void UseCode(Map args, OnCallBack onCallBack); //用户使用邀请码
* void getEchos(Map args, OnCallBack onCallBack); //获取指定⽤户的成功邀请⽤用户ID
* void writeStatu(Map args, OnCallBack onCallBack); //修改成功邀请用户的可读状态
* void isActive(Map args, OnCallBack onCallBack); //查询指定⽤户是否使⽤过邀请码
* void isCodeEnable(Map args, OnCallBack onCallBack); //判断邀请码是否可以使⽤


**更新Date:** 2017-5-15
