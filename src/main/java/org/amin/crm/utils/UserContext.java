package org.amin.crm.utils;

import org.amin.crm.domain.Employee;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Amin
 * @Create 2018-12-04 14:21
 */
public class UserContext {

    private static final String LOGINUSER = "loginUser";

    /**
     * 把当前用户存入Session
     *
     * @param loginUser
     */
    public static void setUser(Employee loginUser) {

        // 获取当前主体
        Subject currentUser = SecurityUtils.getSubject();
        // 把用户放入Session
        currentUser.getSession().setAttribute(LOGINUSER, loginUser);
    }

    public static Employee getUser() {
        // 获取当前主体
        Subject currentUser = SecurityUtils.getSubject();
        // 把用户放入Session
        return (Employee) currentUser.getSession().getAttribute(LOGINUSER);
    }

    /**
     * 提供一个方法，获取全局的request
     *
     * @return
     */
    private static HttpServletRequest getRequest() {
        // 从全局请求对象持有者中，获取ServletRequestAttributes
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        // 从ServletRequestAttributes对象中，取出放入的request请求对象
        return requestAttributes.getRequest();
    }

    /**
     * 获取session

     */
    private static HttpSession getSession() {
        return getRequest().getSession(true);
    }

    /**
     * 移除session

     */
    public static void removeSession() {
        getRequest().getSession().invalidate();
    }
    /*获取ip*/
    public static String getRequestIP() {
        return getRequest().getRemoteAddr(); // 获取IP
    }
}
