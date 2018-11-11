package com.zzq.config.shiro;

import com.zzq.usercenter.po.SysUser;
import com.zzq.usercenter.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义 realm
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public String getName() {
        return "myRealm";
    }
    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String)authenticationToken.getPrincipal();
        // 获取用户名。通过 username 找到该用户
        SysUser user = sysUserService.getUserByUserNameWithPermission(username);
        if( !"1".equals(user.getStatus()) ){
            throw new LockedAccountException();
        }
        // 从数据库查询出来的用户名密码，进行验证
        // 用户名，密码，密码盐值，realm 名称
        // 登陆的时候直接调用 subject.login() 即可自动调用该方法
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
                authenticationToken.getPrincipal() , user.getPassword() , ByteSource.Util.bytes( user.getPasswordSalt()) , getName()
        );
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("USER_SESSION", user);
        return info;
    }

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 从session中获取 user 对象
        Session session = SecurityUtils.getSubject().getSession();
        SysUser user = (SysUser)session.getAttribute("USER_SESSION");

        // 权限信息对象
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles( user.getRoles() );
        info.addStringPermissions( user.getPermission() );

        return info;
    }

}
