package com.wusiq.Dto.req;

/**
 * 删除用户信息实体类
 */
public class ReqDeleteUserDto {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append('}');
        return sb.toString();
    }
}
