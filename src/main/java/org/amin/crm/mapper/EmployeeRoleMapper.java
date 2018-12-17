package org.amin.crm.mapper;

import java.util.List;
import org.amin.crm.domain.EmployeeRole;
import org.apache.ibatis.annotations.Param;

public interface EmployeeRoleMapper {
    int deleteByPrimaryKey(@Param("employeeId") Long employeeId, @Param("roleId") Long roleId);

    int insert(EmployeeRole record);

    List<EmployeeRole> selectAll();
}