package cn.liziy.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * user 实体类
 * @author Liziy
 * @date 2020/10/29 0:52
 **/
@Data
public class User {
    /**
     * 主键 id
     */
    private int id;
    /**
     * 用户账号
     */
    private String username;
    /**
     * 登录密码
     */
    private String password;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 盐
     */
    private String salt;
    /**
     * 创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone="GMT+8")
    private Date createTime;
    /**
     * 当前状态
     */
    private int status;

}
