package org.amin.crm.service.impl;

import org.amin.crm.domain.SystemMenu;
import org.amin.crm.mapper.SystemMenuMapper;
import org.amin.crm.service.ISystemMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Amin
 * @Create 2018-11-29 0:37
 */

@Service
public class SystemMenuServiceImpl extends BaseServiceImpl<SystemMenu,Long> implements ISystemMenuService {
    @Autowired
    private SystemMenuMapper systemMenuMapper;
    @Override

    public List<SystemMenu> findMenuTree() {
        return systemMenuMapper.loadMenuTree();
    }
}
