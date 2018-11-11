package com.zzq.usercenter.service;

import com.zzq.usercenter.po.SysUser;

public interface SysUserService {

    SysUser getUserByUserNameWithPermission(String username);

    SysUser getUserByUserName(String username);

    int insertSysUser( SysUser sysUser );

    boolean cheackUserName( String username );

}
