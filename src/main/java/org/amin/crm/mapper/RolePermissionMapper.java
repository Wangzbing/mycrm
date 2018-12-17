package org.amin.crm.mapper;

import java.util.List;
import org.amin.crm.domain.RolePermission;
import org.apache.ibatis.annotations.Param;

public interface RolePermissionMapper {
    int deleteByPrimaryKey(@Param("permissionId") Long permissionId, @Param("roleId") Long roleId);

    int insert(RolePermission record);

    List<RolePermission> selectAll();
}