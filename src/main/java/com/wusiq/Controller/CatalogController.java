package com.wusiq.Controller;

import com.alibaba.fastjson.JSON;
import com.wusiq.Dto.req.ReqInsertUserDto;
import com.wusiq.Dto.rsp.RspQueryCatalogTreeListDto;
import com.wusiq.entity.Users;
import com.wusiq.service.CatalogService;
import com.wusiq.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 目录管理的控制器类
 */
@RequestMapping("catalogManage")
@ResponseBody
@Controller
public class CatalogController {
    private static Logger LOGGER =  LoggerFactory.getLogger(CatalogController.class);
    @Autowired
    CatalogService catalogService;

    @RequestMapping(value = "/queryCatalogTreeList.json",method = RequestMethod.GET)
    public String queryCatalogTreeList(){
        LOGGER.info("CatalogController.queryCatalogTreeList.start...");
        List<RspQueryCatalogTreeListDto> list = catalogService.queryCatalogTreeList();
        LOGGER.info("CatalogController.queryCatalogTreeList.end.result:{}", JSON.toJSONString(list));

        return JSON.toJSONString(list);
    }
}
