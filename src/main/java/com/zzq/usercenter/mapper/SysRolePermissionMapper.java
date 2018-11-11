package com.zzq.usercenter.mapper;

import com.zzq.usercenter.po.SysRolePermission;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysRolePermissionMapper extends Mapper<SysRolePermission> {

    List<SysRolePermission> getRoleNameByUserId(@Param("uid")String uid);

}