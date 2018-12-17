package org.amin.crm.web.filter.Realms;

import org.amin.crm.domain.Employee;
import org.amin.crm.service.IEmployeeService;
import org.amin.crm.utils.MD5Utils;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author Amin
 * @Create 2018-12-04 9:30
 */

public class MyRealm extends AuthenticatingRealm {

    @Autowired
    private IEmployeeService employeeService;
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();
        Employee user = employeeService.findByUserName(username);
        if (user==null) {
            throw new UnknownAccountException(username);
        }
        Object principal = user;
        Object hashedCredentials = user.getPassword();
        ByteSource salt = ByteSource.Util.bytes(MD5Utils.SALT);//盐值
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal,hashedCredentials,salt,getName());
        return info;
    }
}
