package com.wusiq.base;

import com.alibaba.fastjson.JSON;
import com.wusiq.Dto.rsp.RspQueryCatalogTreeListDto;
import com.wusiq.entity.CatalogTreeEntity;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 目录树的数据组织工具
 */
public class CatalogTreeUtils {
    private static Logger LOGGER =  LoggerFactory.getLogger(CatalogTreeUtils.class);
    /**
     * 数据列表转换成目录
     */
    public static final List<RspQueryCatalogTreeListDto> list2Catalog(List<CatalogTreeEntity> catalogList){
        LOGGER.info("CatalogTreeUtils.list2Catalog.start.param:{}", JSON.toJSONString(catalogList));
        if(catalogList==null){
            return null;
        }
        //顶层父目录列表
        List<RspQueryCatalogTreeListDto> topCatalogList = new ArrayList<>();
        for(CatalogTreeEntity catalog:catalogList){
            if(catalog.getPid()==null){
                //顶层目录对象
                RspQueryCatalogTreeListDto topCatalog = new RspQueryCatalogTreeListDto();
                //获取父目录下的子目录
                List<RspQueryCatalogTreeListDto> childCatalogList= getChildrenNode(catalog.getId(),catalogList);
                topCatalog.setChildren(childCatalogList);
                topCatalog.setId(catalog.getId());
                topCatalog.setState(catalog.getState());
                topCatalog.setText(catalog.getText());

                topCatalogList.add(topCatalog);
            }
        }
        LOGGER.info("CatalogTreeUtils.list2Catalog.end.result:{}", JSON.toJSONString(topCatalogList));
        return topCatalogList;
    }

    /**
     * 根据父目录id和数据列表获取子目录
     */
    private static final List<RspQueryCatalogTreeListDto> getChildrenNode(int parentId,List<CatalogTreeEntity> catalogList){
        //子目录列表
        List<RspQueryCatalogTreeListDto> childCatalogList = new ArrayList<>();
        for(CatalogTreeEntity catalogTreeEntity:catalogList){
            if(catalogTreeEntity.getPid()==null){
                continue;
            }
            if(catalogTreeEntity.getPid().equals(parentId)){

                //子目录对象
                RspQueryCatalogTreeListDto childCatalog = new RspQueryCatalogTreeListDto();
                childCatalog.setId(catalogTreeEntity.getId());//id
                childCatalog.setText(catalogTreeEntity.getText());//显示文本
                childCatalog.setState(catalogTreeEntity.getState());//状态

                //目录的其他属性
                Map<String,Object> attributes = new HashMap<>();
                attributes.put("url",catalogTreeEntity.getUrl());
                childCatalog.setAttributes(attributes);//其他属性

                //继续获取更下一层的所有子目录
                List<RspQueryCatalogTreeListDto> nextChildCatalogList = getChildrenNode(catalogTreeEntity.getId(),catalogList);
                if(nextChildCatalogList != null){
                    //更一层的子目录
                    childCatalog.setChildren(nextChildCatalogList);
                }

                childCatalogList.add(childCatalog);
            }
        }
        return childCatalogList;
    }
}
