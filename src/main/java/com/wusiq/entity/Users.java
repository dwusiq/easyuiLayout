package com.wusiq.entity;

import java.io.Serializable;

/**
 * 对应数据库的用户实体类
 */
public class Users implements Serializable{
    private Integer id;
    private String username;
    private Integer userage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUserage() {
        return userage;
    }

    public void setUserage(Integer userage) {
        this.userage = userage;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"username\":\"")
                .append(username).append('\"');
        sb.append(",\"userage\":")
                .append(userage);
        sb.append('}');
        return sb.toString();
    }
}
