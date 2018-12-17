package org.amin.crm.web.controller;

import org.amin.crm.domain.Department;
import org.amin.crm.query.DepartmentQuery;
import org.amin.crm.service.IDepartmentService;
import org.amin.crm.utils.AjaxResult;
import org.amin.crm.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Amin
 * @Create 2018-11-29 0:57
 */
@Controller
@RequestMapping("department")
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    @RequestMapping("index")
    public String index(){
        return "department/page";
    }

   /* @RequestMapping("departmentList")
    @ResponseBody
    public Map<String,Object> getList(DepartmentQuery query){
        Map<String, Object> map = new HashMap<>();
        Page<> pageQuery = departmentService.findByQuery(query);
        map.put("rows",pageQuery.getList());
        map.put("total",pageQuery.getTotal());
        return map;
    }*/
   @RequestMapping("findDeptTree")
   @ResponseBody
   public List<Department> getList(){
       List<Department> departments = new ArrayList<>();
       departments=departmentService.findDeptTree();
       return departments;
   }
    @RequestMapping("save")
    @ResponseBody
    public AjaxResult save(Department department){
        if (department.getId()!=null){
            try {
                departmentService.update(department);
                return new AjaxResult("用户更改成功");
            }catch (Exception e){
                return new AjaxResult("操作异常",7709);
            }
        }else{
            try {
                departmentService.insert(department);
                return new AjaxResult("用户添加成功");
            }catch (Exception e){
                return new AjaxResult("操作异常",7708);
            }
        }
    }
}
