package com.wusiq.service.impl;

import com.alibaba.fastjson.JSON;
import com.wusiq.Controller.UserController;
import com.wusiq.Dto.rsp.RspQueryCatalogTreeListDto;
import com.wusiq.base.CatalogTreeUtils;
import com.wusiq.dao.CatalogTreeDao;
import com.wusiq.entity.CatalogTreeEntity;
import com.wusiq.service.CatalogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 目录管理的实现类
 */
@Service
public class CatalogServiceImpl implements CatalogService {
    private static Logger LOGGER =  LoggerFactory.getLogger(CatalogServiceImpl.class);
    @Autowired
    CatalogTreeDao catalogTreeDao;

    /**
     * 获取目录树
     */
    @Override
    public List<RspQueryCatalogTreeListDto> queryCatalogTreeList() {
        LOGGER.info("CatalogServiceImpl.queryCatalogTreeList.start...");
        //获取目录数据
        List<CatalogTreeEntity> catalogList = catalogTreeDao.queryCatalogTreeList();
        LOGGER.info("catalogList:{}",JSON.toJSONString(catalogList));
        //将目录数据组织成树格式
        List<RspQueryCatalogTreeListDto> list = CatalogTreeUtils.list2Catalog(catalogList);
        LOGGER.info("CatalogServiceImpl.queryCatalogTreeList.end.result:{}",JSON.toJSONString(list));
        return list;
    }
}
