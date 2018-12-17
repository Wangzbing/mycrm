package org.amin.crm.service.impl;

import org.amin.crm.domain.Department;
import org.amin.crm.domain.Employee;
import org.amin.crm.mapper.DepartmentMapper;
import org.amin.crm.service.IDepartmentService;
import org.amin.crm.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Amin
 * @Create 2018-11-29 0:37
 */

@Service
public class DepartmentServiceImpl extends BaseServiceImpl<Department,Long> implements IDepartmentService {
    @Autowired
    private  DepartmentMapper departmentMapper;
    @Override
    public List<Department> findDeptTree() {
        return departmentMapper.findDeptTree();
    }
}
