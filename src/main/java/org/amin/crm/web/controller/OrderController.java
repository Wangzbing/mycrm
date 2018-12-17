package org.amin.crm.web.controller;

import org.amin.crm.domain.Order;
import org.amin.crm.query.OrderQuery;
import org.amin.crm.service.IOrderService;
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
@RequestMapping("order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @RequestMapping("index")
    public String index(){
        return "order/page";
    }

    @RequestMapping("page")
    @ResponseBody
    public Map<String,Object> getList(OrderQuery query){
        Map<String, Object> map = new HashMap<>();
        Page<Order> pageQuery = orderService.findByQuery(query);
        map.put("rows",pageQuery.getList());
        map.put("total",pageQuery.getTotal());
        return map;
    }
    @RequestMapping("save")
    @ResponseBody
    public AjaxResult save(Order order){
        try {
            if (order.getId()!=null) {
                orderService.update(order);
            }else{
                orderService.insert(order);
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
            orderService.delete(id);
            return new AjaxResult("删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("删除失败!"+e.getMessage(),-1002);
        }
    }



}
