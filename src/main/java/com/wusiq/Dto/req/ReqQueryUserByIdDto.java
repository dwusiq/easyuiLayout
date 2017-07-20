package com.wusiq.Dto.req;

/**
 * 根据Id查询用户信息的入参实体类
 */
public class ReqQueryUserByIdDto {
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
