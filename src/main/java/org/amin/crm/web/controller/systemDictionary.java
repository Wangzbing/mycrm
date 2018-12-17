package org.amin.crm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Amin
 * @Create 2018-12-01 23:54
 */
@Controller
@RequestMapping("systemDictionary")
public class systemDictionary {

    @RequestMapping("index")
    public String index(){
        return "systemDictionary/page";
    }

}
