package com.eval.common.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * 资源文件读取
 */
public class PropertiesUtil {

    // 当打开多个资源文件时，缓存资源文件
    private static HashMap<String, PropertiesUtil> configMap = new HashMap<String, PropertiesUtil>();
    // 打开文件时间，判断超时使用
    private Date loadTime = null;
    // 资源文件
    private ResourceBundle resourceBundle = null;
    // 默认资源文件名称
    private static final String NAME = "config";
    // 缓存时间
    private static final Integer TIME_OUT = 60 * 1000;

    // 私有构造方法，创建单例
    private PropertiesUtil(String name) {
        this.loadTime = new Date();
        this.resourceBundle = ResourceBundle.getBundle(name);
    }

    public static synchronized PropertiesUtil getInstance() {
        return getInstance(NAME);
    }

    public static synchronized PropertiesUtil getInstance(String name) {
        PropertiesUtil conf = configMap.get(name);
        if (null == conf) {
            conf = new PropertiesUtil(name);
            configMap.put(name, conf);
        }
        // 判断是否打开的资源文件是否超时1分钟
        if ((System.currentTimeMillis() - conf.getLoadTime().getTime()) > TIME_OUT) {
            conf = new PropertiesUtil(name);
            configMap.put(name, conf);
        }
        return conf;
    }

    // 根据key读取value
    public String get(String key) {
        try {
            String value = resourceBundle.getString(key);
            return value;
        } catch (MissingResourceException e) {
            return "";
        }
    }

    // 根据key读取value(整形)
    public Integer getInt(String key) {
        try {
            String value = resourceBundle.getString(key);
            return Integer.parseInt(value);
        } catch (MissingResourceException e) {
            return null;
        }
    }

    // 根据key读取value(布尔)
    public boolean getBool(String key) {
        try {
            String value = resourceBundle.getString(key);
            if ("true".equals(value)) {
                return true;
            }
            return false;
        } catch (MissingResourceException e) {
            return false;
        }
    }

    public Date getLoadTime() {
        return loadTime;
    }

    /*** 
    * @Description: 生成文件路径 
    * @Param: [file, url] 
    * @return: java.lang.String 
    * @Author: youxun 
    * @Date: 2018/12/15 
    */ 
    public static String uploadImage(MultipartFile file, String url) throws IOException {

        if (file != null && url != null) {
            new File(url).mkdirs();//创建文件夹(已存在则无效)
            UUID uuid = UUID.randomUUID();
            // 获取上传的文件的名称
            String filename = file.getOriginalFilename();
            //获取后缀
            String prefix=filename.substring(filename.lastIndexOf(".")+1);

            String originalFilename =uuid.toString().replaceAll("-", "");
            Long time = new Date().getTime();//获取当前时间为标识
            String newFileName = time.toString()+originalFilename+ "." + prefix;//新的文件名
            //String newFileName = time.toString()+originalFilename;//新的文件名
            File targetFile = null; //封装上传文件位置的全路径
            try {
                targetFile = new File(url,newFileName);
            } catch (Exception e) {
                throw new RuntimeException("保存图片异常：" + e.getMessage());
            }
            file.transferTo(targetFile);//把本地文件上传到 封装上传文件位置的全路径 下
            return newFileName;//返回新的文件路径名+文件名
        }
        return null;
    }
}
