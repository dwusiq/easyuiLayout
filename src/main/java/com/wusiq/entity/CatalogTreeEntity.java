package com.wusiq.entity;

import java.io.Serializable;

/**
 * 目录实体类
 */
public class CatalogTreeEntity implements Serializable{
    private static final long serialVersionUID = -1365162799316911562L;

    private Integer id;
    private Integer pid;
    private String text;
    private String state;
    private String url;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
