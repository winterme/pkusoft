package com.zzq.usercenter.service.impl;

import com.zzq.usercenter.mapper.SysPermissionMapper;
import com.zzq.usercenter.mapper.SysRolePermissionMapper;
import com.zzq.usercenter.mapper.SysUserMapper;
import com.zzq.usercenter.po.SysPermission;
import com.zzq.usercenter.po.SysRolePermission;
import com.zzq.usercenter.po.SysUser;
import com.zzq.usercenter.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysUserSerivceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;

    @Override
    public SysUser getUserByUserNameWithPermission(String username) {
        // 用户名唯一，此处用用户名查出当前用户
        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",username);
        List<SysUser> lists = sysUserMapper.selectByExample(example);
        if( lists.size()==0 ){
            return null;
        }

        SysUser sysUser = lists.get(0);
        // 查出所有的角色名
        List<SysRolePermission> roles = sysRolePermissionMapper.getRoleNameByUserId(sysUser.getUid());
        // 查出所有的权限
        List<SysPermission> permissions = sysPermissionMapper.getSysPermissionByUid(sysUser.getUid());

        // roleName
        List<String> rolesName = new ArrayList<>();
        for (SysRolePermission role : roles ) {
            rolesName.add( role.getRoleName() );
        }
        sysUser.setRoles( rolesName );

        // permissions
        List<String> permissionsByUser = new ArrayList<>();
        for (SysPermission p  : permissions) {
            permissionsByUser.add( p.getPermission() );
        }
        sysUser.setPermission( permissionsByUser );

        return sysUser;
    }

    @Override
    public SysUser getUserByUserName(String username) {
        // 用户名唯一，此处用用户名查出当前用户
        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",username);
        List<SysUser> lists = sysUserMapper.selectByExample(example);
        if( lists.size()==0 ){
            return new SysUser();
        }

        SysUser sysUser = lists.get(0);

        return sysUser;
    }

    @Override
    public int insertSysUser(SysUser sysUser) {

        return 0;
    }

    @Override
    public boolean cheackUserName(String username) {
        return false;
    }


}
