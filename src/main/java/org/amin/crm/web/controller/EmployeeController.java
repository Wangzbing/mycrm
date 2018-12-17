package org.amin.crm.web.controller;

import org.amin.crm.domain.Employee;
import org.amin.crm.query.EmployeeQuery;
import org.amin.crm.service.IEmployeeService;
import org.amin.crm.utils.AjaxResult;
import org.amin.crm.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Amin
 * @Create 2018-11-29 0:57
 */
@Controller
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping("index")
    public String index(){
        return "employee/page";
    }

    @RequestMapping("page")
    @ResponseBody
    public Map<String,Object> getList(EmployeeQuery query){
        Map<String, Object> map = new HashMap<>();
        Page<Employee> pageQuery = employeeService.findByQuery(query);
        map.put("rows",pageQuery.getList());
        map.put("total",pageQuery.getTotal());
        return map;
    }
    @RequestMapping("save")
    @ResponseBody
    public AjaxResult save(Employee employee){

            try {
                if (employee.getId()!=null) {
                    employeeService.update(employee);
                }else{
                    employeeService.insert(employee);
                }
                return new AjaxResult("用户保存成功");
            }catch (Exception e){
                e.printStackTrace();
                return new AjaxResult("操作异常"+e.getMessage(),7708);
        }
    }
    @RequestMapping("leftAndRe")
    @ResponseBody
    public AjaxResult left(Long id){
        try {
            employeeService.leftAndRe(id);
            return new AjaxResult("操作成功");
        }catch (Exception e){
            e.printStackTrace();
            return new AjaxResult("操作失败",7709);
        }
    }

}
