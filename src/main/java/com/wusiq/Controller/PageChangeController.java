package com.wusiq.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用于切换页面的控制器
 */
@Controller
@RequestMapping(value = "pageChange")
public class PageChangeController {
    /*首页*/
    @RequestMapping(value = "login.do",method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/firstPage");
        return mv;
    }

    /*新增页*/
    @RequestMapping(value = "toAddUserPage.do",method = RequestMethod.GET)
    public ModelAndView toAddUserPage(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("addUserPage");
        return mv;
    }

    /*修改页*/
    @RequestMapping(value = "toUpdatePage.do",method = RequestMethod.GET)
    public ModelAndView toUpdatePage(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("updatePage");
        return mv;
    }

    /*删除页*/
    @RequestMapping(value = "toDeletePage.do",method = RequestMethod.GET)
    public ModelAndView toDeletePage(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("deletePage");
        return mv;
    }


}
