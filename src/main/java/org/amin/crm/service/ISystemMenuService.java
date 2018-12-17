package org.amin.crm.service;

import org.amin.crm.domain.SystemMenu;
import org.amin.crm.service.IBaseService;

import java.util.List;

/**
 * @author Amin
 * @Create 2018-11-29 0:36
 */
public interface ISystemMenuService extends IBaseService<SystemMenu,Long> {
    List<SystemMenu> findMenuTree();
}
