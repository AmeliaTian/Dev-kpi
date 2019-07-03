package com.boot.module.auth.controller;

import com.boot.common.HttpOutMsgBean;
import com.boot.constant.WebConstants;
import com.boot.module.auth.bean.Au01UserVoFilter;
import com.boot.module.auth.principal.AuthShiroCusRealm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author h3dwy
 * @Description 用户登录登出
 * @CreateDate 创建时间：2018-07-26 18:24
 * @ModifiedBy
 * @ModifiedDate
 */
@Slf4j
@RestController
@Api(tags = "用户登录/登出", description = "权限认证相关的api")
public class AuthLoginCtl {

    @ApiOperation(value = "用户登录", notes = "传入参数为用户名、密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", required = true, value = "登录用户名", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "password", required = true, value = "登录密码", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "rememberMe", value = "记住我，Y/N", dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/auth/login", method = {RequestMethod.POST, RequestMethod.GET})
    public HttpOutMsgBean login(HttpSession session, @RequestParam(value = "username") String username, @RequestParam(value = "password") String password, @RequestParam(value = "rememberMe", required = false) String rememberMe) {
        String msg;
        try {
            Subject subject = SecurityUtils.getSubject();
            //如果是已登录状态
            if (subject.isAuthenticated()) {
                return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.INFO).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("auth").msgContent("你已登录,请不要重复登录").build();
            }
            UsernamePasswordToken userInfo = new UsernamePasswordToken(username, password, WebConstants.IS_YES_STR.equals(rememberMe));
            subject.login(userInfo);
            if (subject.isAuthenticated()) {
                //
                session.setAttribute("userAuth", subject.getPrincipal());
                //登录成功
                return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.OBJ).msgDes("auth:login").msgContent(subject.getPrincipal()).build();
            } else {
                return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.ERROR).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("auth:login").msgContent("用户名密码不正确").build();
            }
        } catch (IncorrectCredentialsException e) {
            msg = "登录密码错误";
        } catch (ExcessiveAttemptsException e) {
            msg = "登录失败次数过多";
        } catch (LockedAccountException e) {
            msg = "帐号已被锁定";
        } catch (DisabledAccountException e) {
            msg = "帐号已被禁用";
        } catch (ExpiredCredentialsException e) {
            msg = "帐号已过期";
        } catch (UnknownAccountException e) {
            msg = "帐号不存在";
        } catch (UnauthorizedException e) {
            msg = "没有得到相应的授权";
        } catch (AuthorizationException e) {
            msg = e.getMessage();
        }
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.ERROR).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("auth:login").msgContent(msg).build();
    }

    @ApiOperation(value = "用户注销", notes = "用户退出登录")
    @RequestMapping(value = "/auth/logout", method = {RequestMethod.POST, RequestMethod.GET})
    public HttpOutMsgBean logout(HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        if (null != subject) {
            try {
                session.removeAttribute("userAuth");
                subject.logout();
            } catch (Exception e) {
                log.error("logout", e);
            }
        }
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.INFO).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("auth:logout").msgContent("用户注销成功").build();
    }

    //用户未登录返回消息
    @RequestMapping(value = "/auth/nologin", method = {RequestMethod.POST, RequestMethod.GET})
    public HttpOutMsgBean nologin() {
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.ERROR).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("auth:nologin").msgContent("未授权访问").build();
    }

    //获取用户角色信息
    @RequestMapping(value = "/auth/userAuth", method = {RequestMethod.POST, RequestMethod.GET})
    public HttpOutMsgBean userRoles(HttpSession session) {
        Au01UserVoFilter loadUser = (Au01UserVoFilter) session.getAttribute("userAuth");
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.ERROR).msgType(WebConstants.RET_MSG_TYPE_ENUM.OBJ).msgDes("auth:user").msgContent(loadUser).build();
    }

}
