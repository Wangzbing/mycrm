package org.amin.crm.service.impl;

import org.amin.crm.BaseTest;
import org.amin.crm.domain.Department;
import org.amin.crm.mapper.DepartmentMapper;
import org.amin.crm.service.IDepartmentService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author Amin
 * @Create 2018-11-29 17:23
 */
public class DepartmentServiceImplTest extends BaseTest {

    @Autowired
    private IDepartmentService departmentService;

    @Test
    public void findDeptTree() {
        for (Department department : departmentService.findDeptTree()) {
            System.out.println(department);
        }
    }

}