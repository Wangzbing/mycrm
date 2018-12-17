package org.amin.crm;

import org.amin.crm.domain.SystemMenu;
import org.amin.crm.mapper.SystemMenuMapper;
import org.amin.crm.service.ISystemLogService;
import org.amin.crm.service.ISystemMenuService;
import org.amin.crm.utils.MD5Utils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Amin
 * @Create 2018-12-05 0:18
 */
public class TestName extends BaseTest{
    @Autowired
    private ISystemMenuService systemMenuService;

    @Autowired
    private SystemMenuMapper systemMenuMapper;

    @Test
    public void testMain(){
        List<SystemMenu> menus = systemMenuMapper.loadMenuTree();
        for (SystemMenu menu : menus) {
            System.out.println(menu);
        }
    }
    @Test
    public void test(){
        String s = MD5Utils.encrypt("admin1");
        System.out.println(s);
    }

}
