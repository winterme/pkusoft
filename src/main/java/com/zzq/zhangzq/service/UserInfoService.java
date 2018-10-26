package com.zzq.zhangzq.service;

import com.zzq.zhangzq.po.Userinfo;

public interface UserInfoService {

    int insertUser(Userinfo userinfo);

    Userinfo selectByUid(String uid);

}
