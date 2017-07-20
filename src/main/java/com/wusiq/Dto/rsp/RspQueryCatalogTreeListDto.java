package com.wusiq.Dto.rsp;

import com.wusiq.entity.CatalogTreeEntity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 查询目录列表，返回页面参数的实体类
 */
public class RspQueryCatalogTreeListDto implements Serializable {
    private static final long serialVersionUID = -1066349156385207607L;
    private Integer id;
    private String text;
    private String state;
    private Map<String,Object> attributes = new HashMap<>();
    private List<RspQueryCatalogTreeListDto> children;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public List<RspQueryCatalogTreeListDto> getChildren() {
        return children;
    }

    public void setChildren(List<RspQueryCatalogTreeListDto> children) {
        this.children = children;
    }
}
