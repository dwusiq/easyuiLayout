package com.wusiq.Controller;

import com.alibaba.fastjson.JSON;
import com.wusiq.Dto.req.ReqDeleteUserDto;
import com.wusiq.Dto.req.ReqInsertUserDto;
import com.wusiq.Dto.req.ReqQueryUserByIdDto;
import com.wusiq.Dto.req.ReqUpdateUserDto;
import com.wusiq.entity.Users;
import com.wusiq.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户管理的控制器类
 */
@RequestMapping("userManage")
@Controller
public class UserController {
    private static Logger LOGGER =  LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;

    @RequestMapping(value = "/insertUser.do",method = RequestMethod.POST)
    public String insertUser(ReqInsertUserDto req){
        LOGGER.info("添加用户开始,{}",req);
        Users users = new Users();
        users.setUsername(req.getUsername());
        users.setUserage(req.getUserage());
        int i = userService.insertUser(users);
        LOGGER.info("添加用户结束,影响行数:{}",i);
        return "successPage";
    }


    @RequestMapping(value = "/deleteUser.do",method = RequestMethod.GET)
    public String deleteUser(ReqDeleteUserDto req){
        LOGGER.info("删除用户开始,{}",req);
        int i = userService.deleteUser(req.getId());
        LOGGER.info("删除用户结束,影响行数:{}",i);
        return "successPage";
    }

    @RequestMapping(value = "/updateUser.do",method = RequestMethod.GET)
    public String updateUser(ReqUpdateUserDto req){
        LOGGER.info("修改用户开始,{}",req);
        Users users = new Users();
        users.setId(req.getInputId());
        users.setUsername(req.getUsername());
        users.setUserage(req.getUserage());
        int i = userService.updateUser(users);
        LOGGER.info("修改用户结束,影响行数:{}",i);
        return "successPage";
    }

    @ResponseBody
    @RequestMapping(value = "/queryUserById.json",method = RequestMethod.GET)
    public String queryUserById(ReqQueryUserByIdDto req){
        LOGGER.info("查询用户开始,{}",req);
        Users users = userService.queryById(req.getId());
        String userStr = JSON.toJSONString(users);
        LOGGER.info("查询用户信息的结果：{}",userStr);
        return userStr;
    }
}
