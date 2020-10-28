package cn.liziy.utils;

import java.security.MessageDigest;

/**
 * @author liziyang
 * @date 16:30 2020/9/23
 * md5密码加密
 **/
public class DataMd5 {
    /**
     * @param message 需要加密的字符串
     * @return String
     */
    public static String md5(String message){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(message.getBytes("utf-8"));
            return toHex(bytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param bytes byte参数
     * @return String
     */
    private static String toHex(byte[] bytes) {

        final char[] hexDigits = "0123456789ABCDEF".toCharArray();
        StringBuilder ret = new StringBuilder(bytes.length * 2);
        for (int i=0; i<bytes.length; i++) {
            ret.append(hexDigits[(bytes[i] >> 4) & 0x0f]);
            ret.append(hexDigits[bytes[i] & 0x0f]);
        }
        return ret.toString();
    }

}
