package org.amin.crm.service;

import org.amin.crm.domain.Employee;
import org.amin.crm.service.IBaseService;

import java.util.List;

/**
 * @author Amin
 * @Create 2018-11-29 0:36
 */
public interface IEmployeeService extends IBaseService<Employee,Long> {
    void leftAndRe(Long id);

    Employee findByUserName(String username);
}
