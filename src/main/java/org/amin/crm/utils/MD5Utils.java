package org.amin.crm.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @author Amin
 * @Create 2018-12-04 11:25
 */
public class MD5Utils {

    public static final String SALT = "crm";//盐值
    public static final int COUNT = 1000;//加密次数

    /**
     * 加密
     * @param source
     * @return
     */
    public static String encrypt(String source){
        String algorithmName = "MD5";//加密算法
        SimpleHash sh = new SimpleHash(algorithmName,source,SALT,COUNT);
        return sh.toString();
    }
 }
