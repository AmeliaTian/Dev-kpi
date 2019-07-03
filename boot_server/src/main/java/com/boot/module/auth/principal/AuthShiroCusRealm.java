package com.boot.module.auth.principal;

import com.boot.constant.WebConstants;
import com.boot.module.auth.bean.Au01UserVoFilter;
import com.boot.module.auth.service.IAu01UserService;
import com.boot.module.sys.ObjectBeanTools;
import com.boot.repository.Au01UserVO;
import com.boot.repository.Au03RoleVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author h3dwy
 * @Description
 * @CreateDate 创建时间：2018-07-26 16:39
 * @ModifiedBy
 * @ModifiedDate
 */
@Component
public class AuthShiroCusRealm extends AuthorizingRealm {

    @Resource(name = "au01UserService")
    private IAu01UserService au01UserService;

    // 用于授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 根据用户配置用户与权限
        if (principals == null) {
            throw new AuthorizationException();
        }
        Au01UserVO loadUser = (Au01UserVO) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for (Au03RoleVO au03RoleVO : loadUser.getUserRoles()) {
            info.addRole(au03RoleVO.getRoleCode());
        }
        return info;
    }

    //用于权限验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        System.out.println(token);
        //根据用户名查询用户信息
        Au01UserVO loadUser = au01UserService.queryEntityByUserName(token.getUsername());
        System.out.println(loadUser);
        if (null == loadUser) {
            //帐户不存在
            throw new UnknownAccountException();
        } else if (!new String(token.getPassword()).equals(loadUser.getPassword())) {
            //密码错误
            throw new IncorrectCredentialsException();
        } else if (WebConstants.IS_YES_STR.equals(loadUser.getAccountExpired())) {
            //帐号是否过期，Y则验证不通过
            throw new ExpiredCredentialsException();
        } else if (WebConstants.IS_YES_STR.equals(loadUser.getAccountLocked())) {
            //帐号是否锁定，Y则验证不通过
            throw new LockedAccountException();
        } else if (WebConstants.IS_NO_STR.equals(loadUser.getAccountEnabled())) {
            //该帐号是否启用，N则验证不通过
            throw new DisabledAccountException();
        }
        //过滤敏感字段
        Au01UserVoFilter filterVO= new Au01UserVoFilter();
        ObjectBeanTools.copyPropertiesIgnoreNull(loadUser,filterVO);
        return new SimpleAuthenticationInfo(filterVO, loadUser.getPassword(), getName());
    }




}
