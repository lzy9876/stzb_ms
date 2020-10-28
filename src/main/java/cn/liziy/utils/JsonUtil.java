package cn.liziy.utils;

import cn.liziy.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/** 自定义json数据的转换工具类
 * @author liziyang
 * @date 17:52 2020/9/22
 **/
public class JsonUtil {
    /**
     * Jackson的核心对象  ObjectMapper
     */
    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 对象转json
     * @param object java对象
     * @return 转换后的json数据
     * @throws JsonProcessingException
     */
    public static String ObjectJson(Object object) throws JsonProcessingException {
           return objectMapper.writeValueAsString(object);
    }

    /**
     *
     * @param json 需要转换的json数据
     * @param clazz 转换的对象 (对象.Class)
     * @param <T>
     * @return json转换的对象
     * @throws IOException
     */
    public static<T> T JsonObject(String json, Class<T> clazz) throws IOException {
       return objectMapper.readValue(json, clazz);
    }

    public static void main(String[] args) throws Exception {
        User user = new User();
        user.setId(1);
        user.setUsername("lzy");
        String json = null;
        json = JsonUtil.ObjectJson(user);
        System.out.println("转换后的json数据  " + json );
        User user1 = JsonUtil.JsonObject(json, User.class);
        System.out.println("id " + user1.getId() + "username" + user1.getUsername());
    }
}
