package org.amin.crm.web.controller;

import org.amin.crm.domain.SystemDictionaryType;
import org.amin.crm.query.SystemDictionaryTypeQuery;
import org.amin.crm.service.ISystemDictionaryTypeService;
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
@RequestMapping("systemDictionaryType")
public class SystemDictionaryTypeController {

    @Autowired
    private ISystemDictionaryTypeService systemDictionaryTypeService;

    @RequestMapping("index")
    public String index(){
        return "systemDictionaryType/page";
    }

    @RequestMapping("page")
    @ResponseBody
    public Map<String,Object> getList(SystemDictionaryTypeQuery query){
        Map<String, Object> map = new HashMap<>();
        Page<SystemDictionaryType> pageQuery = systemDictionaryTypeService.findByQuery(query);
        map.put("rows",pageQuery.getList());
        map.put("total",pageQuery.getTotal());
        return map;
    }
    @RequestMapping("save")
    @ResponseBody
    public AjaxResult save(SystemDictionaryType systemDictionaryType){
        try {
            if (systemDictionaryType.getId()!=null) {
                systemDictionaryTypeService.update(systemDictionaryType);
            }else{
                systemDictionaryTypeService.insert(systemDictionaryType);
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
            systemDictionaryTypeService.delete(id);
            return new AjaxResult("删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("删除失败!"+e.getMessage(),-1002);
        }
    }



}
