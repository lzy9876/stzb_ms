package cn.liziy.entity;

import lombok.Data;

/**
 * @author Liziy
 * @date 2020/10/29 0:39
 **/
@Data
public class Role {
    /**
     * 主键 id
     */
    private int id;
    /**
     * 内容说明
     */
    private String text;
    /**
     * 标识
     */
    private String identName;
}
