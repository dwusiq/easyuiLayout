package com.wusiq.dao;

import com.wusiq.entity.CatalogTreeEntity;

import java.util.List;

/**
 * 目录管理的数据库操作DAO类
 */
public interface CatalogTreeDao {
    //获取目录列表
    List<CatalogTreeEntity> queryCatalogTreeList();
}
