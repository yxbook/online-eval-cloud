package com.eval.common.util;

import net.logstash.logback.encoder.org.apache.commons.lang.text.StrBuilder;

import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: online-eval-clould
 * @description:
 * @author: Created by youxun
 * @create: 2018-12-20 13:38
 **/
public class ValidateUtil{

    /** 整数 */
    private static final String V_INTEGER = "^-?[1-9]\\d*$";
    /** 正整数 */
    private static final String V_Z_INDEX = "^[1-9]\\d*$";
    /** 负整数 */
    private static final String V_NEGATIVE_INTEGER = "^-[1-9]\\d*$";
    /** 数字 */
    private static final String V_NUMBER = "^([+-]?)\\d*\\.?\\d+$";
    /** 正数 */
    private static final String V_POSITIVE_NUMBER = "^[1-9]\\d*|0$";
    /** 负数 */
    private static final String V_NEGATINE_NUMBER = "^-[1-9]\\d*|0$";
    /** 浮点数 */
    private static final String V_FLOAT = "^([+-]?)\\d*\\.\\d+$";
    /** 正浮点数 */
    private static final String V_POSTTIVE_FLOAT = "^[1-9]\\d*.\\d*|0.\\d*[1-9]\\d*$";
    /** 负浮点数 */
    private static final String V_NEGATIVE_FLOAT = "^-([1-9]\\d*.\\d*|0.\\d*[1-9]\\d*)$";
    /** 非负浮点数（正浮点数 + 0） */
    private static final String V_UNPOSITIVE_FLOAT = "^[1-9]\\d*.\\d*|0.\\d*[1-9]\\d*|0?.0+|0$";
    /** 非正浮点数（负浮点数 + 0） */
    private static final String V_UN_NEGATIVE_FLOAT = "^(-([1-9]\\d*.\\d*|0.\\d*[1-9]\\d*))|0?.0+|0$";
    /** 邮件 */
//    private static final String V_EMAIL = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
    private static final String V_EMAIL = "^([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)*@([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?$";
//    private static final String V_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    /** 颜色 */
    private static final String V_COLOR = "^[a-fA-F0-9]{6}$";
    /** url */
    private static final String V_URL = "^http[s]?:\\/\\/([\\w-]+\\.)+[\\w-]+([\\w-./?%&=]*)?$";
    /** 仅中文 */
    private static final String V_CHINESE = "^[\\u4E00-\\u9FA5\\uF900-\\uFA2D]+$";
    /** 仅ACSII字符 */
    private static final String V_ASCII = "^[\\x00-\\xFF]+$";
    /** 邮编 */
    private static final String V_ZIPCODE = "^\\d{6}$";
    /** 手机 */
    private static final String V_MOBILE = "^(1)[0-9]{10}$";
    /** ip地址 */
    private static final String V_IP4 = "^(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)$";
    /** 非空 */
    private static final String V_NOTEMPTY = "^\\S+$";
    /** 图片 */
    private static final String V_PICTURE = "(.*)\\.(jpg|bmp|gif|ico|pcx|jpeg|tif|png|raw|tga)$";
    /** 压缩文件 */
    private static final String V_RAR = "(.*)\\.(rar|zip|7zip|tgz)$";
    /** 日期 */
    private static final String V_DATE = "^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-)) (20|21|22|23|[0-1]?\\d):[0-5]?\\d:[0-5]?\\d$";
    /** QQ号码 */
    private static final String V_QQ_NUMBER = "^[1-9]*[1-9][0-9]*$";
    /** 电话号码的函数(包括验证国内区号,国际区号,分机号) */
    private static final String V_TEL = "^(([0\\+]\\d{2,3}-)?(0\\d{2,3})-)?(\\d{7,8})(-(\\d{3,}))?$";
    /** 用来用户注册。匹配由数字、26个英文字母或者下划线组成的字符串 */
    private static final String V_USERNAME = "^\\w+$";
    /** 字母 */
    private static final String V_LETTER = "^[A-Za-z]+$";
    /** 大写字母 */
    private static final String V_LETTER_U = "^[A-Z]+$";
    /** 小写字母 */
    private static final String V_LETTER_I = "^[a-z]+$";
    /** 身份证 */
    private static final String V_IDCARD = "^(\\d{15}$|^\\d{18}$|^\\d{17}(\\d|X|x))$";
    /** 验证密码(数字和英文同时存在) */
    private static final String V_PASSWORD_REG = "[A-Za-z]+[0-9]";
    /** 验证密码长度(6-18位) */
    private static final String V_PASSWORD_LENGTH = "^\\d{6,32}$";
    /** 验证两位数 */
    private static final String V_TWO＿POINT = "^[0-9]+(.[0-9]{2})?$";
    /** 验证一个月的31天 */
    private static final String V_31DAYS = "^((0?[1-9])|((1|2)[0-9])|30|31)$";

    /** 空字符串 */
    private static final String NULLSTR = "";

    /** 下划线 */
    private static final char SEPARATOR = '_';

    private ValidateUtil() {
    }
    /**
     * 验证是不是整数
     *
     * @param value
     *            要验证的字符串 要验证的字符串
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean Integer(String value) {
        return match(V_INTEGER, value);
    }
    /**
     * 验证是不是正整数
     *
     * @param value
     *            要验证的字符串
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean Z_index(String value) {
        return match(V_Z_INDEX, value);
    }
    /**
     * 验证是不是负整数
     *
     * @param value
     *            要验证的字符串
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean Negative_integer(String value) {
        return match(V_NEGATIVE_INTEGER, value);
    }
    /**
     * 验证是不是数字
     *
     * @param value
     *            要验证的字符串
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean Number(String value) {
        return match(V_NUMBER, value);
    }
    /**
     * 验证是不是正数
     *
     * @param value
     *            要验证的字符串
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean PositiveNumber(String value) {
        return match(V_POSITIVE_NUMBER, value);
    }
    /**
     * 验证是不是负数
     *
     * @param value
     *            要验证的字符串
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean NegatineNumber(String value) {
        return match(V_NEGATINE_NUMBER, value);
    }
    /**
     * 验证一个月的31天
     *
     * @param value
     *            要验证的字符串
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean Is31Days(String value) {
        return match(V_31DAYS, value);
    }
    /**
     * 验证是不是ASCII
     *
     * @param value
     *            要验证的字符串
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean ASCII(String value) {
        return match(V_ASCII, value);
    }
    /**
     * 验证是不是中文
     *
     * @param value
     *            要验证的字符串
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean Chinese(String value) {
        return match(V_CHINESE, value);
    }
    /**
     * 验证是不是颜色
     *
     * @param value
     *            要验证的字符串
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean Color(String value) {
        return match(V_COLOR, value);
    }
    /**
     * 验证是不是日期
     *
     * @param value
     *            要验证的字符串
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean Date(String value) {
        return match(V_DATE, value);
    }
    /**
     * 验证是不是邮箱地址
     *
     * @param value
     *            要验证的字符串
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean Email(String value) {
        return match(V_EMAIL, value);
    }
    /**
     * 验证是不是浮点数
     *
     * @param value
     *            要验证的字符串
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean Float(String value) {
        return match(V_FLOAT, value);
    }
    /**
     * 验证是不是正确的身份证号码
     *
     * @param value
     *            要验证的字符串
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean IDcard(String value) {
        return match(V_IDCARD, value);
    }
    /**
     * 验证是不是正确的IP地址
     *
     * @param value
     *            要验证的字符串
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean IP4(String value) {
        return match(V_IP4, value);
    }
    /**
     * 验证是不是字母
     *
     * @param value
     *            要验证的字符串
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean Letter(String value) {
        return match(V_LETTER, value);
    }
    /**
     * 验证是不是小写字母
     *
     * @param value
     *            要验证的字符串
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean Letter_i(String value) {
        return match(V_LETTER_I, value);
    }
    /**
     * 验证是不是大写字母
     *
     * @param value
     *            要验证的字符串
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean Letter_u(String value) {
        return match(V_LETTER_U, value);
    }
    /**
     * 验证是不是手机号码
     *
     * @param value
     *            要验证的字符串
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean Mobile(String value) {
        return match(V_MOBILE, value);
    }
    /**
     * 验证是不是负浮点数
     *
     * @param value
     *            要验证的字符串
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean Negative_float(String value) {
        return match(V_NEGATIVE_FLOAT, value);
    }
    /**
     * 验证非空
     *
     * @param value
     *            要验证的字符串
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean Notempty(String value) {
        return match(V_NOTEMPTY, value);
    }
    /**
     * 验证的长度
     */
    public static boolean length(String value, int min, int max) {
        return match("^\\S{"+min+","+max+"}$", value);
    }
    /**
     * 验证密码(数字和英文同时存在)
     *
     * @param value
     *            要验证的字符串
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean nomalStr(String value) {
        return match(V_PASSWORD_REG, value);
    }
    /**
     * 验证图片
     *
     * @param value
     *            要验证的字符串
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean Picture(String value) {
        return match(V_PICTURE, value);
    }
    /**
     * 验证正浮点数
     *
     * @param value
     *            要验证的字符串
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean Posttive_float(String value) {
        return match(V_POSTTIVE_FLOAT, value);
    }
    /**
     * 验证QQ号码
     *
     * @param value
     *            要验证的字符串
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean QQnumber(String value) {
        return match(V_QQ_NUMBER, value);
    }
    /**
     * 验证压缩文件
     *
     * @param value
     *            要验证的字符串
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean Rar(String value) {
        return match(V_RAR, value);
    }
    /**
     * 验证电话
     *
     * @param value
     *            要验证的字符串
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean Tel(String value) {
        return match(V_TEL, value);
    }
    /**
     * 验证两位小数
     *
     * @param value
     *            要验证的字符串
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean Two_point(String value) {
        return match(V_TWO＿POINT, value);
    }
    /**
     * 验证非正浮点数
     *
     * @param value
     *            要验证的字符串
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean Un_negative_float(String value) {
        return match(V_UN_NEGATIVE_FLOAT, value);
    }
    /**
     * 验证非负浮点数
     *
     * @param value
     *            要验证的字符串
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean Unpositive_float(String value) {
        return match(V_UNPOSITIVE_FLOAT, value);
    }
    /**
     * 验证URL
     *
     * @param value
     *            要验证的字符串
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean Url(String value) {
        return match(V_URL, value);
    }
    /**
     * 验证用户注册。匹配由数字、26个英文字母或者下划线组成的字符串
     *
     * @param value
     *            要验证的字符串
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean UserName(String value) {
        return match(V_USERNAME, value);
    }
    /**
     * 验证邮编
     *
     * @param value
     *            要验证的字符串
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean Zipcode(String value) {
        return match(V_ZIPCODE, value);
    }
    /**
     * @param regex
     *            正则表达式字符串
     * @param str
     *            要匹配的字符串
     * @return 如果str 符合 regex的正则表达式格式,返回true, 否则返回 false;
     */
    private static boolean match(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }


    /**
     * 获取参数不为空值
     *
     * @param value defaultValue 要判断的value
     * @return value 返回值
     */
    public static <T> T nvl(T value, T defaultValue)
    {
        return value != null ? value : defaultValue;
    }

    /**
     * * 判断一个Collection是否为空， 包含List，Set，Queue
     *
     * @param coll 要判断的Collection
     * @return true：为空 false：非空
     */
    public static boolean isEmpty(Collection<?> coll)
    {
        return isNull(coll) || coll.isEmpty();
    }

    /**
     * * 判断一个Collection是否非空，包含List，Set，Queue
     *
     * @param coll 要判断的Collection
     * @return true：非空 false：空
     */
    public static boolean isNotEmpty(Collection<?> coll)
    {
        return !isEmpty(coll);
    }

    /**
     * * 判断一个对象数组是否为空
     *
     * @param objects 要判断的对象数组
     ** @return true：为空 false：非空
     */
    public static boolean isEmpty(Object[] objects)
    {
        return isNull(objects) || (objects.length == 0);
    }

    /**
     * * 判断一个对象数组是否非空
     *
     * @param objects 要判断的对象数组
     * @return true：非空 false：空
     */
    public static boolean isNotEmpty(Object[] objects)
    {
        return !isEmpty(objects);
    }

    /**
     * * 判断一个Map是否为空
     *
     * @param map 要判断的Map
     * @return true：为空 false：非空
     */
    public static boolean isEmpty(Map<?, ?> map)
    {
        return isNull(map) || map.isEmpty();
    }

    /**
     * * 判断一个Map是否为空
     *
     * @param map 要判断的Map
     * @return true：非空 false：空
     */
    public static boolean isNotEmpty(Map<?, ?> map)
    {
        return !isEmpty(map);
    }

    /**
     * * 判断一个字符串是否为空串
     *
     * @param str String
     * @return true：为空 false：非空
     */
    public static boolean isEmpty(String str)
    {
        return isNull(str) || NULLSTR.equals(str.trim());
    }

    /**
     * * 判断一个字符串是否为非空串
     *
     * @param str String
     * @return true：非空串 false：空串
     */
    public static boolean isNotEmpty(String str)
    {
        return !isEmpty(str);
    }

    /**
     * * 判断一个对象是否为空
     *
     * @param object Object
     * @return true：为空 false：非空
     */
    public static boolean isNull(Object object)
    {
        if(object == null || object.equals("")){
            return true;
        }
        return false;
    }

    /**
     * * 判断一个对象是否非空
     *
     * @param object Object
     * @return true：非空 false：空
     */
    public static boolean isNotNull(Object object)
    {
        return !isNull(object);
    }

    /**
     * * 判断一个对象是否是数组类型（Java基本型别的数组）
     *
     * @param object 对象
     * @return true：是数组 false：不是数组
     */
    public static boolean isArray(Object object)
    {
        return isNotNull(object) && object.getClass().isArray();
    }

    /**
     * 去空格
     */
    public static String trim(String str)
    {
        return (str == null ? "" : str.trim());
    }

    /**
     * 截取字符串
     *
     * @param str 字符串
     * @param start 开始
     * @return 结果
     */
    public static String substring(final String str, int start)
    {
        if (str == null)
        {
            return NULLSTR;
        }

        if (start < 0)
        {
            start = str.length() + start;
        }

        if (start < 0)
        {
            start = 0;
        }
        if (start > str.length())
        {
            return NULLSTR;
        }

        return str.substring(start);
    }

    /**
     * 截取字符串
     *
     * @param str 字符串
     * @param start 开始
     * @param end 结束
     * @return 结果
     */
    public static String substring(final String str, int start, int end)
    {
        if (str == null)
        {
            return NULLSTR;
        }

        if (end < 0)
        {
            end = str.length() + end;
        }
        if (start < 0)
        {
            start = str.length() + start;
        }

        if (end > str.length())
        {
            end = str.length();
        }

        if (start > end)
        {
            return NULLSTR;
        }

        if (start < 0)
        {
            start = 0;
        }
        if (end < 0)
        {
            end = 0;
        }

        return str.substring(start, end);
    }

    /**
     * 格式化文本, {} 表示占位符<br>
     * 此方法只是简单将占位符 {} 按照顺序替换为参数<br>
     * 如果想输出 {} 使用 \\转义 { 即可，如果想输出 {} 之前的 \ 使用双转义符 \\\\ 即可<br>
     * 例：<br>
     * 通常使用：format("this is {} for {}", "a", "b") -> this is a for b<br>
     * 转义{}： format("this is \\{} for {}", "a", "b") -> this is \{} for a<br>
     * 转义\： format("this is \\\\{} for {}", "a", "b") -> this is \a for b<br>
     *
     * @param template 文本模板，被替换的部分用 {} 表示
     * @param params 参数值
     * @return 格式化后的文本
     */
    public static String format(String template, Object... params)
    {
        if (isEmpty(params) || isEmpty(template))
        {
            return template;
        }
        return StrFormatter.format(template, params);
    }

    /**
     * 驼峰首字符小写
     */
    public static String uncapitalize(String str)
    {
        int strLen;
        if (str == null || (strLen = str.length()) == 0)
        {
            return str;
        }
        return new StrBuilder(strLen).append(Character.toLowerCase(str.charAt(0))).append(str.substring(1)).toString();
    }

    /**
     * 下划线转驼峰命名
     */
    public static String toUnderScoreCase(String s)
    {
        if (s == null)
        {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);

            boolean nextUpperCase = true;

            if (i < (s.length() - 1))
            {
                nextUpperCase = Character.isUpperCase(s.charAt(i + 1));
            }

            if ((i > 0) && Character.isUpperCase(c))
            {
                if (!upperCase || !nextUpperCase)
                {
                    sb.append(SEPARATOR);
                }
                upperCase = true;
            }
            else
            {
                upperCase = false;
            }

            sb.append(Character.toLowerCase(c));
        }

        return sb.toString();
    }

    /**
     * 是否包含字符串
     *
     * @param str 验证字符串
     * @param strs 字符串组
     * @return 包含返回true
     */
    public static boolean inStringIgnoreCase(String str, String... strs)
    {
        if (str != null && strs != null)
        {
            for (String s : strs)
            {
                if (str.equalsIgnoreCase(trim(s)))
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 将下划线大写方式命名的字符串转换为驼峰式。如果转换前的下划线大写方式命名的字符串为空，则返回空字符串。 例如：HELLO_WORLD->HelloWorld
     *
     * @param name 转换前的下划线大写方式命名的字符串
     * @return 转换后的驼峰式命名的字符串
     */
    public static String convertToCamelCase(String name)
    {
        StringBuilder result = new StringBuilder();
        // 快速检查
        if (name == null || name.isEmpty())
        {
            // 没必要转换
            return "";
        }
        else if (!name.contains("_"))
        {
            // 不含下划线，仅将首字母大写
            return name.substring(0, 1).toUpperCase() + name.substring(1);
        }
        // 用下划线将原始字符串分割
        String[] camels = name.split("_");
        for (String camel : camels)
        {
            // 跳过原始字符串中开头、结尾的下换线或双重下划线
            if (camel.isEmpty())
            {
                continue;
            }
            // 首字母大写
            result.append(camel.substring(0, 1).toUpperCase());
            result.append(camel.substring(1).toLowerCase());
        }
        return result.toString();
    }

    private static Pattern linePattern = Pattern.compile("_(\\w)");
    private static Pattern humpPattern = Pattern.compile("[A-Z]");

    /**
     * 下划线转驼峰
     * @param str
     * @return
     */
    public static String lineToHump(String str) {
        if (null == str || "".equals(str)) {
            return str;
        }
        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);

        str = sb.toString();
        str = str.substring(0, 1).toUpperCase() + str.substring(1);

        return str;
    }

    /**
     * 首字母转小写
     * @param s
     * @return
     */
    public static String toLowerCaseFirstOne(String s) {
        if (org.apache.commons.lang3.StringUtils.isBlank(s)) {
            return s;
        }
        if (Character.isLowerCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }

    /**
     * 驼峰转下划线(简单写法，效率低于{@link #(String)})
     * @param str
     * @return
     */
    public static String humpToLine2(String str) {
        return str.replaceAll("[A-Z]", "_$0").toLowerCase();
    }
}
