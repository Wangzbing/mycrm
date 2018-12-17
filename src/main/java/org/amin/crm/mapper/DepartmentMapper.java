package org.amin.crm.mapper;

import java.util.List;
import org.amin.crm.domain.Department;

public interface DepartmentMapper extends BaseMapper<Department,Long>{
    List<Department> findDeptTree();
}