package cn.liziy.utils;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author liziyang
 * @date 16:33 2020/9/23
 * 控制器返回值的封装对象
 **/
@Data
public class R {
    /**
     * 状态码
     */
    private int code;
    /**
     * 描述信息
     */
    private String message;
    /**
     * 返回的具体数据
     */
    private Object data;
    /**
     * 数据条数
     */
    private long count;

    public R() {
    }

    public R(int code, String message, Object data, long count) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.count = count;
    }

    /**
     * 请求成功 返回的需要传回的数据 （默认使用200 success）
     * @param data 返回的数据
     * @return R
     */
    public static R ofSuccess(Object data, long count){
        return new R(Status.SUCCESS.stuCode, Status.SUCCESS.stuMsg,data,count);
    }

    /**
     * 请求成功 layui表格需要传回的数据 （默认使用200 success）
     * @param  data 返回的数据
     * @param count 数据总条数
     * @return utils.R
     **/
    public static R layuiSuccess(Object data, long count){
        return new R(Status.LAYUI_SUCCESS.stuCode, Status.SUCCESS.stuMsg,data,count);
    }

    /**
     * 不需要传回数据的
     * @param status 返回编码信息
     * @return R
     */
    public static R ofMessgae(Status status){
        return new R(status.stuCode, status.stuMsg,null,0);
    }

    /**
     * 目前RFC标准里边规定的状态码是三位数的， 所以取值范围是从000到999， 但是喜闻乐见的状态码范围是100~599
     * 与RFC 区分开 代码中自定义的 状态码取值范围从1000~9999
     */
    public enum Status{
        /**
         * 自定义字段
         */


        /**
         * 成功处理了请求的状态码
         */
        LAYUI_SUCCESS(0,"success"),
        SUCCESS(200,"success"),

        /**
         * 客户端发生错误， 请求报文有误， 服务器无法处理400~499
         */
        PARAMS_IS_NULL(401,"params is null"),
        BAD_REQUEST(402,"bad request"),
        LOGINTOKEN_ERROR(403,"令牌错误"),
        /**
         * 服务器错误， 服务器在处理请求的时候内部发生了错误500~599
         */
        UPDATE_NULL(501,"update is error"),
        DELETE_NULL(502,"delete is error"),
        INSERT_NULL(503,"insert is error"),
        QUERY_NULL(504,"query is null"),

        LOGIN_USERNAME_ERROR(505,"账号错误"),
        LOGIN_PASSWORD_ERROR(506,"密码错误"),
        REGISTER_NULL(507,"注册失败"),
        REGISTER_USERNAME_EXIST(507,"用户名存在 注册失败"),
        ACCOUNT_LOCKED(508,"账号被锁定"),
        LOGIN_ERROR(509,"账号或者密码错误"),
        LOGINOUT_ERROR(510,"退出登录异常"),


        TOKEN_EXPIRED_ERROR(511,"令牌过期&令牌错误"),
        JSON_CONVERSION_ERROR(512,"Json数据转换异常"),
        USERNAME_ERROR(513,"用户名错误"),
        PHONE_ERROR(514,"手机号存在"),
        IDCARD_ERROR(515,"身份证已绑定"),

        REDIS_ADD_ERROR(516,"redis 添加失败"),
        REDIS_ADD_DATA_ERROR(517,"redis 添加失败 数据不符合");



        @Getter
        @Setter
        private int stuCode;
        @Getter
        @Setter
        private String stuMsg;

        Status(int stuCode, String stuMsg) {
            this.stuCode = stuCode;
            this.stuMsg = stuMsg;
        }
    }
}
