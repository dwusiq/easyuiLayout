package com.wusiq.Dto.req;

/**
 * 修改用户信息页面入参实体类
 */
public class ReqUpdateUserDto {
    private Integer inputId;
    private String username;
    private Integer userage;

    public Integer getInputId() {
        return inputId;
    }

    public void setInputId(Integer inputId) {
        this.inputId = inputId;
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
        sb.append("\"inputId\":")
                .append(inputId);
        sb.append(",\"username\":\"")
                .append(username).append('\"');
        sb.append(",\"userage\":")
                .append(userage);
        sb.append('}');
        return sb.toString();
    }
}
