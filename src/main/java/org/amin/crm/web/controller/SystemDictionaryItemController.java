package org.amin.crm.web.controller;

import org.amin.crm.domain.SystemDictionaryItem;
import org.amin.crm.query.SystemDictionaryItemQuery;
import org.amin.crm.service.ISystemDictionaryItemService;
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
@RequestMapping("systemDictionaryItem")
public class SystemDictionaryItemController {

    @Autowired
    private ISystemDictionaryItemService systemDictionaryItemService;

    @RequestMapping("index")
    public String index(){
        return "systemDictionaryItem/page";
    }

    @RequestMapping("page")
    @ResponseBody
    public Map<String,Object> getList(SystemDictionaryItemQuery query){
        Map<String, Object> map = new HashMap<>();
        Page<SystemDictionaryItem> pageQuery = systemDictionaryItemService.findByQuery(query);
        map.put("rows",pageQuery.getList());
        map.put("total",pageQuery.getTotal());
        return map;
    }
    @RequestMapping("save")
    @ResponseBody
    public AjaxResult save(SystemDictionaryItem systemDictionaryItem){
        try {
            if (systemDictionaryItem.getId()!=null) {
                systemDictionaryItemService.update(systemDictionaryItem);
            }else{
                systemDictionaryItemService.insert(systemDictionaryItem);
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
            systemDictionaryItemService.delete(id);
            return new AjaxResult("删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("删除失败!"+e.getMessage(),-1002);
        }
    }

    @RequestMapping("leftAndRe")
    @ResponseBody
    public AjaxResult left(Long id){
        try {
            systemDictionaryItemService.leftAndRe(id);
            return new AjaxResult("操作成功");
        }catch (Exception e){
            e.printStackTrace();
            return new AjaxResult("操作失败",7709);
        }
    }

}
