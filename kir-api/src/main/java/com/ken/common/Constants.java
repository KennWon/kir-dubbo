package com.ken.common;


import com.google.common.net.MediaType;


final public class Constants {

    /**
     * 响应代码
     */
    public final static int RESPONSE_SUCCESS = 200;         //请求成功
    public final static int RESPONSE_CREATED = 201;         //创建成功
    public final static int RESPONSE_NOT_CONTENT = 204;     //请求成功，但无内容
    public final static int RESPONSE_PARAM_ERROR = 400;     //参数错误
    public final static int RESPONSE_UNAUTHORIZED = 401;    //未授权(指未登录)
    public final static int RESPONSE_FORBIDDEN = 403;       //无权限(指登录 ，但权限不够) Forbidden/禁止
    public final static int RESPONSE_NOT_FOUND = 404;       //找不到请求资源
    public final static int SERVER_ERROR = 500;             //服务器内部错误

    //每页数量
    public final static int PER_PAGE_MIN = 10;
    public final static int PER_PAGE_QUANTITY = 20;
    public final static int PER_PAGE_MEDIUM = 50;
    public final static int PER_PAGE_MAX = 1000;

    //状态
    public final static byte STATUS_VALID = 1;   //valid
    public final static byte STATUS_INVALID = 0;  //草稿，关闭

    //校验正则表达式
    public final static String REGEXP_USER_ID = "^[1-9]\\d{3,15}$";
    public final static String REGEXP_MOBILE = "^1[34578]\\d{9}$";
    public final static String REGEXP_FLOOR = "^-?\\d{1,3}[a-zA-z]?$";
    public final static String REGEXP_LOCATION = "^-?[1-9]\\d{0,2}\\.\\d{1,16},-?[1-9]\\d{0,2}\\.\\d{1,16}$";
    public final static String REGEXP_GPS = "^-?\\d{1,3}\\.\\d{1,8}";
    public final static String REGEXP_URL = "^(http|https):\\/\\/.*\\.[a-z]+\\/?.*$";

    /**
     * ID最小限制
     */
    public static final int MIN_INT_ID = 1001;
    public static final long MIN_LONG_ID = 1001L;
    public static final long USER_MIN_ID = 10000L;
    public static final long NEWSLETTER_MIN_ID = 1001L;
    public static final long COMMENT_MIN_ID = 1001L;
    public static final long APPLAUD_MIN_ID = 1001L;
    public static final long GROUP_MIN_ID = 10001L;
    public static final long CHARING_MIN_ID = 1001L;
    public static final long SHOWTIME_MIN_ID = 1001L;
    public static final long GRADE_MIN_ID = 1001L;
    public static final long PARTYING_MIN_ID = 1001L;
    public static final long SERVICE_MIN_ID = 10001L;


    public static final int TAG_MIN_ID = 1001;
    public static final int COMPLAINT_MIN_ID = 1001;
    public static final int TOPIC_MIN_ID = 1001;
    public static final int SLOGAN_MIN_ID = 1001;
    public static final int SLOGAN_RELATION_MIN = 1001;

    //广告
    public static final int AD_MATERIAL_MIN_ID = 1001;      //广告物料
    public static final int AD_PLACEMENT_MIN_ID = 1001;     //广告位置
    public static final long AD_SCHEDULE_MIN_ID = 1001L;    //广告投放计划


    /**
     * 用户
     */
    public final static String HB_SALT = "c8B9KhNpW5";
    public final static int HB_SHA_LEN = 256;           //SHA-256
    public final static int HB_EXPIRED_TIME = 5184000;  //一天86400秒*60天
    public final static String USER_CACHE_PREFIX = "UC:";  //用户缓存前缀

    //用户状态
    public final static byte USER_DISABLE = 0;     //禁用
    public final static byte USER_NORMAL = 1;      //正常
    public final static byte USER_REGISTER_2 = 2;  //注册第2步
    public final static byte USER_REGISTER_3 = 3;  //注册第3步

    public final static byte USER_CERTIFICATED = 1;    //用户已经认证

    public final static byte LOCK_PUBLISH = 1; //禁用户发布
    public final static byte LOCK_PUBLISH_TALK = 2;    //禁用户发布，发言

    //性别
    public final static byte GENDER_BOTH = 0; //全部
    public final static byte GENDER_MALE = 1; //男
    public final static byte GENDER_FEMALE = 2; //女



}

