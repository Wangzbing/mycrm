package org.amin.crm.web.controller;

import org.amin.crm.domain.Employee;
import org.amin.crm.utils.AjaxResult;
import org.amin.crm.utils.UserContext;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Amin
 * @Create 2018-12-02 3:23
 */
@Controller
public class LoginController {

    @RequestMapping("login")
    @ResponseBody
    public AjaxResult check(String username,String password) {
        Subject user = SecurityUtils.getSubject();
        AjaxResult ajaxResult=null;
        if(!user.isAuthenticated()){
            //进行授权
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
            try {
                user.login(token);
                ajaxResult = new AjaxResult("登录成功!");
                //将用户信息存入到session中
                //获取用户信息
                Employee employee = (Employee) user.getPrincipal();
                //存入到session中，我们要将框架和Serviet进行解耦
                //使用shiro的会话管理
                //在web项目中，shiro的会话就是Serviet的HttpSession
                UserContext.setUser(employee);
                //捕获认证异常，处理认证结果
            }catch (UnknownAccountException e ){
                e.printStackTrace();
                ajaxResult=new AjaxResult("用户名或密码错误",7391);
            }catch (IncorrectCredentialsException e){
                e.printStackTrace();
                ajaxResult=new AjaxResult("用户名或密码错误",7392);
            }catch (LockedAccountException e ){
                e.printStackTrace();
                ajaxResult= new AjaxResult("账号锁定",7393);
            } catch (AuthenticationException e ){
                e.printStackTrace();
                ajaxResult=new AjaxResult("系统繁忙",7393);
            }
        }
        return ajaxResult;
    }

}
