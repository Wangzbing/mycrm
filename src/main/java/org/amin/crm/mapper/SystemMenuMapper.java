package org.amin.crm.mapper;

import java.util.List;
import org.amin.crm.domain.SystemMenu;

public interface SystemMenuMapper extends BaseMapper<SystemMenu,Long>{

    List<SystemMenu> loadMenuTree();
}