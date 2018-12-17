package org.amin.crm.service.impl;

import org.amin.crm.domain.Employee;
import org.amin.crm.domain.SystemDictionaryItem;
import org.amin.crm.domain.SystemDictionaryType;
import org.amin.crm.domain.SystemLog;
import org.amin.crm.query.EmployeeQuery;
import org.amin.crm.query.SystemDictionaryItemQuery;
import org.amin.crm.query.SystemLogQuery;
import org.amin.crm.service.IEmployeeService;
import org.amin.crm.service.ISystemDictionaryItemService;
import org.amin.crm.service.ISystemDictionaryTypeService;
import org.amin.crm.service.ISystemLogService;
import org.amin.crm.utils.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Amin
 * @Create 2018-11-29 0:40
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class  EmployeeServiceImplTest{
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private ISystemDictionaryItemService systemDictionaryItemService;
    @Autowired
    private ISystemDictionaryTypeService systemDictionaryTypeService;

    @Autowired
    private ISystemLogService systemLogService;



    @Test
    public void test(){
        List<Employee> employees = employeeService.findAll();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
    @Test
    public void TestPage(){
        SystemDictionaryItem item1 = new SystemDictionaryItem();
        item1.setIntro("1");
        item1.setName("1");
        item1.setSequence(7);
        item1.setType(systemDictionaryTypeService.findOne(7L));
        systemDictionaryItemService.insert(item1);
    }
    @Test
    public void left(){
        employeeService.leftAndRe(9L);
        Employee two = employeeService.findOne(9L);
        System.out.println(two);
    }
    @Test
    public void findName(){
        employeeService.findByUserName("wenwen");
    }

    @Test
    public void findPage(){
        SystemLogQuery systemLogQuery = new SystemLogQuery();
        systemLogQuery.setPage(10);
        systemLogQuery.setRows(1);
        Page<SystemLog> query = systemLogService.findByQuery(systemLogQuery);
        List<SystemLog> queryList = query.getList();
        for (SystemLog log : queryList) {
            System.out.println(log);
        }
    }

}