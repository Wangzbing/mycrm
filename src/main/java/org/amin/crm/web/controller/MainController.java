package org.amin.crm.web.controller;

import org.amin.crm.domain.Employee;
import org.amin.crm.utils.UserContext;
import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Amin
 * @Create 2018-12-02 17:54
 */
@Controller
public class MainController {

    @RequestMapping("main")
    public String index(){
        return "main";
    }

}
