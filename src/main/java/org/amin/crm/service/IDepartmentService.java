package org.amin.crm.service;

import org.amin.crm.domain.Department;
import org.amin.crm.domain.Employee;
import org.amin.crm.service.IBaseService;

import java.util.List;

/**
 * @author Amin
 * @Create 2018-11-29 0:36
 */
public interface IDepartmentService extends IBaseService<Department,Long> {
    List<Department> findDeptTree();
}
