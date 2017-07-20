package com.wusiq.Dto.req;

/**
 * 新增用户页面入参实体类
 */
public class ReqInsertUserDto {
    private String username;
    private Integer userage;

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
        sb.append("\"username\":\"")
                .append(username).append('\"');
        sb.append(",\"userage\":")
                .append(userage);
        sb.append('}');
        return sb.toString();
    }
}
