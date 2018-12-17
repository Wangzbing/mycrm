package org.amin.crm.service.impl;

import org.amin.crm.domain.Employee;
import org.amin.crm.mapper.EmployeeMapper;
import org.amin.crm.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Amin
 * @Create 2018-11-29 0:37
 */

@Service
public class EmployeeServiceImpl extends BaseServiceImpl<Employee,Long> implements IEmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public void leftAndRe(Long id) {
        if (employeeMapper.findOne(id).getStatus() == 1) {
            employeeMapper.left(id);
        } else {
            employeeMapper.rework(id);
        }
    }

    @Override
    public Employee findByUserName(String username) {
        return employeeMapper.findByUserName(username);
    }
}
