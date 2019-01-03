package com.sjy.eval.auth.generate;


import com.eval.common.util.GeneratorUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 代码生成器
 */
public class Generator {
    // 根据命名规范，只修改此常量值即可
    private static String AUTHOR = "youxun";
    private static String MODULE = "sjy-eval-auth";
    private static String DATABASE = "eval";
    private static String TABLE_NAME = "d_class";
    private static String PACKAGE_NAME = "com.sjy.eval.auth";
    private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/eval?useSSL=false&serverTimezone=UTC&allowMultiQueries=true";
    private static String JDBC_USERNAME = "root";
    private static String JDBC_PASSWORD = "root";
    // 需要insert后返回主键的表配置，key:表名,value:主键名
    private static Map<String, String> LAST_INSERT_ID_TABLES = new HashMap<>();
    static {
        LAST_INSERT_ID_TABLES.put("d_class", "code");
    }

    /**
     * 自动代码生成
     */
    @Test
    public void generateCode() throws Exception {
        GeneratorUtil.generator(JDBC_DRIVER, JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD, MODULE, DATABASE, TABLE_NAME, PACKAGE_NAME, LAST_INSERT_ID_TABLES, AUTHOR);
    }
}
