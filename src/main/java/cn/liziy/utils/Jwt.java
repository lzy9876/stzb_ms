package cn.liziy.utils;

import cn.liziy.entity.User;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author liziyang
 * @date 16:27 2020/9/23
 * Jwt
 **/
public class Jwt {

    /**
     * 过期时间 15 分钟
     */
    private static final long EXPIRE_TIME = 15 * 60 * 1000;
    //24小时
    private static final long EXPIRE_TIME_PROJECT = 60*24 * 60 * 1000;

    /**
     * 加入的盐
     */
    private static final String TOKEN_SECRET = "dsdsa221";

    /**
     *
     * @param messgae 需要加密的数据
     * @return jwt格式字符串
     */
    public static String sign(String messgae) {
        try {
            // 设置过期时间
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME_PROJECT);
            // 私钥和加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            // 设置头部信息
            Map<String, Object> header = new HashMap<>(2);

            header.put("alg", "HS256");
            // 返回token字符串
            return com.auth0.jwt.JWT.create()
                    .withHeader(header)
                    .withClaim("messgae", messgae)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * 检验token是否正确和过期
     * @param token 检验的token字符串
     * @return boolean
     */
    public static boolean verify(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = com.auth0.jwt.JWT.require(algorithm).build();
            verifier.verify(token);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    /**
     * token数据解析
     * @param token 需要解析的token数据
     * @return String
     */
    public static String parseToken(String token) {
        DecodedJWT jwt = com.auth0.jwt.JWT.decode(token);
        return jwt.getClaim("messgae").asString();
    }

    /**
     * 生成UUID
     * @return UUID字符串
     */
    public static String salt(){
        UUID uuid = UUID.randomUUID();
        String[] arr = uuid.toString().split("-");
        return arr[0];
    }

    public static void main(String[] args) throws IOException {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJtZXNzZ2FlIjoie1wiaWRcIjo4LFwidXNlcm5hbWVcIjpcImxpenlcIixcInBhc3N3b3JkXCI6XCIwNTRBNjgwOTA3QjJGOUNBQ0YyMjIzMzI1ODI3OTJDQ1wiLFwic2FsdFwiOlwiZjYwMDhlOTNcIixcInJlZ2lzdGVyRGF0YVwiOlwiMjAyMC0wOS0yMyAxNjowOVwiLFwicm9sZVwiOjF9IiwiZXhwIjoxNjAwODU5OTE1fQ.h83JSAvxQPvVcoR6XVu4JHyokZzsJti_9V01YYE43L8";
        //token解密
        boolean verify = Jwt.verify(token);
        System.out.println("token_boolean " + verify);
        String s1 = Jwt.parseToken(token);
        System.out.println("json数据  "+ s1);
        User user1 = JsonUtil.JsonObject(s1, User.class);
        System.out.println(user1.getId() + "  " + user1.getUsername());


    }
}
