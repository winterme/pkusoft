package com.zzq.usercenter.mapper;

import com.zzq.usercenter.po.SysPermission;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysPermissionMapper extends Mapper<SysPermission> {

    List<SysPermission> getSysPermissionByUid(@Param("uid")String uid);

}