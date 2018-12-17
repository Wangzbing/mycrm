package org.amin.crm.web.controller;

import org.amin.crm.domain.SystemLog;
import org.amin.crm.query.SystemLogQuery;
import org.amin.crm.service.ISystemLogService;
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
@RequestMapping("systemLog")
public class SystemLogController {

    @Autowired
    private ISystemLogService systemLogService;

    @RequestMapping("index")
    public String index(){
        return "systemLog/page";
    }

    @RequestMapping("page")
    @ResponseBody
    public Map<String,Object> getList(SystemLogQuery query){
        Map<String, Object> map = new HashMap<>();
        Page<SystemLog> pageQuery = systemLogService.findByQuery(query);
        map.put("rows",pageQuery.getList());
        map.put("total",pageQuery.getTotal());
        return map;
    }



}
