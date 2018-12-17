package org.amin.crm.web.controller;

import org.amin.crm.domain.SystemMenu;
import org.amin.crm.query.SystemMenuQuery;
import org.amin.crm.service.ISystemMenuService;
import org.amin.crm.utils.AjaxResult;
import org.amin.crm.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Amin
 * @Create 2018-11-29 0:57
 */
@Controller
@RequestMapping("systemMenu")
public class SystemMenuController {

    @Autowired
    private ISystemMenuService systemMenuService;

    @RequestMapping("index")
    public String index(){
        return "systemMenu/page";
    }

    @RequestMapping("page")
    @ResponseBody
    public Map<String,Object> getList(SystemMenuQuery query){
        Map<String, Object> map = new HashMap<>();
        Page<SystemMenu> pageQuery = systemMenuService.findByQuery(query);
        map.put("rows",pageQuery.getList());
        map.put("total",pageQuery.getTotal());
        return map;
    }
    @RequestMapping("save")
    @ResponseBody
    public AjaxResult save(SystemMenu systemMenu){
        try {
            if (systemMenu.getId()!=null) {
                systemMenuService.update(systemMenu);
            }else{
                systemMenuService.insert(systemMenu);
            }
            return new AjaxResult("用户保存成功");
        }catch (Exception e){
            e.printStackTrace();
            return new AjaxResult("操作异常"+e.getMessage(),7708);
        }
}


    /**
     * 删除一条数据
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public AjaxResult delete(Long id){
        try {
            systemMenuService.delete(id);
            return new AjaxResult("删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("删除失败!"+e.getMessage(),-1002);
        }
    }

    @RequestMapping("findMenuTree")
    @ResponseBody
    public List<SystemMenu> getTree(){
        return  systemMenuService.findMenuTree();
    }



}
