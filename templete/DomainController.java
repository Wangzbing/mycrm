package org.amin.crm.web.controller;

import org.amin.crm.domain.${Domain};
import org.amin.crm.query.${Domain}Query;
import org.amin.crm.service.I${Domain}Service;
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
@RequestMapping("${domain}")
public class ${Domain}Controller {

    @Autowired
    private I${Domain}Service ${domain}Service;

    @RequestMapping("index")
    public String index(){
        return "${domain}/page";
    }

    @RequestMapping("page")
    @ResponseBody
    public Map<String,Object> getList(${Domain}Query query){
        Map<String, Object> map = new HashMap<>();
        Page<${Domain}> pageQuery = ${domain}Service.findByQuery(query);
        map.put("rows",pageQuery.getList());
        map.put("total",pageQuery.getTotal());
        return map;
    }
    @RequestMapping("save")
    @ResponseBody
    public AjaxResult save(${Domain} ${domain}){
        try {
            if (${domain}.getId()!=null) {
                ${domain}Service.update(${domain});
            }else{
                ${domain}Service.insert(${domain});
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
            ${domain}Service.delete(id);
            return new AjaxResult("删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("删除失败!"+e.getMessage(),-1002);
        }
    }



}
