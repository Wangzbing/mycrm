package org.amin.crm.mapper;

import java.util.List;
import org.amin.crm.domain.Employee;

public interface EmployeeMapper extends BaseMapper<Employee,Long>{
    void left(Long id);
    void rework(Long id);
    Employee findByUserName(String username);
}