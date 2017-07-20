package com.wusiq.service;

import com.wusiq.Dto.rsp.RspQueryCatalogTreeListDto;

import java.util.List;

/**
 * 目录管理的服务类
 */
public interface CatalogService {
    List<RspQueryCatalogTreeListDto> queryCatalogTreeList();
}
