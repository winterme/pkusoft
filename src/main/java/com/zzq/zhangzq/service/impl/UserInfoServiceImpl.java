package com.zzq.zhangzq.service.impl;

import com.zzq.zhangzq.mapper.UserinfoMapper;
import com.zzq.zhangzq.po.Userinfo;
import com.zzq.zhangzq.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional(value = "baseTransationManager")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserinfoMapper userinfoMapper;

    @Override
    public int insertUser(Userinfo userinfo) {
        String uid = UUID.randomUUID().toString();
        userinfo.setUid( uid );

        return userinfoMapper.insertSelective(userinfo);
    }

    @Override
    public Userinfo selectByUid(String uid) {
        return userinfoMapper.selectByPrimaryKey(uid);
    }
}
