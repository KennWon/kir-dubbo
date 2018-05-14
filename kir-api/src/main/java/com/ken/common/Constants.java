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

    public final static long LOUKA_OFFICIAL = 18888; //楼官方

    //图片链接URI
    //开发
//    public final static String OSS_URI = "http://img.hboffice.cn/";
//    public final static String API_URI = "http://api.hboffice.cn";
    //正式
//    public final static String OSS_URI = "http://img.louka.net.cn/";
//    public final static String API_URI = "http://api.louka.net.cn";

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

    /**
     * 好友关系
     */
    public final static byte RELATIONSHIP_SINGLE = 1;   //单向关注
    public final static byte RELATIONSHIP_BOTH = 2;     //双向关注
    public final static byte RELATIONSHIP_BLOCK = 0;    //拉黑
    public final static byte RELATIONSHIP_NULL = -1;    //没关系

    /**
     * 群组
     */
    public static final long GROUP_DEFAULT_ID = 10000L;
    public static final String GROUP_DEFAULT_NAME = "未加入社区";

    public final static byte GROUP_ROLE_GUEST = 0; //社群角色：游客
    public final static byte GROUP_ROLE_MEMBER = 1;    //社群角色：普通成员
    public final static byte GROUP_ROLE_ADMIN = 2;     //社群角色：管理员
    public final static byte GROUP_ROLE_MASTER = 3;    //社群角色：群主
    public final static byte GROUP_ORIGIN_COMMUNITY = 1; //来源工社
    public final static byte GROUP_ORIGIN_TAG = 2;   //来源标签
    public static final byte GROUP_ORIGIN_PARTY = 3;  //来源聚会
    public final static byte GROUP_ORIGIN_SELF = 4; //来源自建

    //群组类型：true：公开群，false：私有群。
    public final static byte GROUP_OPEN = 1;
    // 是否只有群成员可以进来发言。true：是，false：否。该字段只能在群组详情中查看。
    public final static byte GROUP_ONLY_MEMBER = 1;
    //是否允许群成员邀请别人加入此群。 true：允许群成员邀请人加入此群，false：只有群主才可以往群里加人。
    public final static byte GROUP_ALLOW_INVITE = 0;
    //群成员上限，创建群组的时候设置，可修改。
    public final static int GROUP_MAX_USER = 2000;
    //加入公开群是否需要批准，默认值是false（加入公开群不需要群主批准），此属性为必选的，私有群必须为true
    public static final byte GROUP_APPROVAL = 1;

    /**
     * 标签
     */
    public final static byte TAG_CATEGORY_HOBBY = 1;  //兴趣标签
    public final static byte TAG_CATEGORY_SKILL = 2;  //技能标签
    public final static byte TAG_CATEGORY_SYSTEM = 3;    //系统标签
    public final static byte TAG_CATEGORY_PARTYING = 4;     //聚会

    public final static byte TAG_GROUP_MIN_USAGE = 4; //标签组群使用次数(要求5次)

    /**
     * 附近
     */
    public final static String NEARBY_USER_LOCATION = "NearbyUserLocation";
    public final static String NEARBY_USER_PREFIX = "NearbyUser:";
    public final static long NEARBY_USER_CACHE_TIME = 1296000L; //一天86400秒
    public final static double NEARBY_USER_RADIUS = 10000D;   //单位M
    public final static int NEARBY_USER_LIMIT = 100;    //查询附近用户数量限制

    /**
     * 友蒙 U-PUSH
     */
    public final static String UMENG_APP_KEY = "58049610e0f55a691200071d";
    public final static String UMENG_MESSAGE_SECRET = "0d4a26b5f24933c3c07636c74d4a0a0f";
    public final static String UMENT_MASTER_SECRET = "fqqgbpi4sphyedgtsb6i09wizmvpi53a";

    /**
     * 环信
     */
    public final static String EA_SERVICE_ID = "10000";  //客服ID

    /**
     * 消息
     */
    //消息分类
    public final static byte MESSAGE_REMIN = 1;       //提醒
    public final static byte MESSAGE_LETTER = 2;     //私信
    //    public final static byte MESSAGE_ANNOUNCE = 3;    //公告
    public final static byte MESSAGE_GREET = 4;        //打招呼
    public static final byte MESSAGE_SYSTEM = 5;        //系统消息
    //目标类型:1动态，2评论，3认证，4关注,5查令街,10举报
    /**
     * 系统提醒 1-99
     * 用户提醒 100-150
     * 动态提醒 151-160
     * 社群提醒 200-299
     * 聚会提醒 300-399
     * 商业服务 400-499
     * 钱包提醒 800-899
     *
     * 查令街  700-749
     * 楼咖秀  750-799
     */
//    public static final short NOTIFY_NEWSLETTER = 1;    //新动态
//    public static final short NOTIFY_COMMENT = 2;       //评论动态
//    public static final short NOTIFY_APPLAUD = 3;       //点赞动态
//    public static final short NOTIFY_AUTH = 4;          //认证
//    public static final short NOTIFY_FOLLOWED = 5;      //被关注
    public static final short NOTIFY_CHARING = 6;       //查令街
    //    public static final short NOTIFY_GROUP = 7;         //群
//    public static final short NOTIFY_COMPLAINT = 10;    //投诉
//    public static final short NOTIFY_LETTER = 11;       //私信
//    public static final short NOTIFY_GREET = 12;        //打招呼
//    public static final short NOTIFY_PARTY = 13;        //300 聚会(放弃)
//    public static final short NOTIFY_PARTY_COMMENT = 14; //301 聚会评论(放弃)
//    public static final short NOTIFY_PARTY_GRADE = 15;   //302 聚会评价(放弃)

    //后台推送
    public static final short NOTIFY_SYSTEM_UPGRADE = 66;           //APP升级提醒
    public static final short NOTIFY_SYSTEM_URGENT = 33;            //紧急通知
    public static final short NOTIFY_SYSTEM_PROMOTION = 99;         //系统推广
    //用户好友
    public static final short NOTIFY_USER_NEW_FANS = 100;           //新增粉丝 5
    public static final short NOTIFY_USER_NEW_FRIEND = 101;         //新增好友
    public static final short NOTIFY_USER_LIKED = 103;              //用户头像被点赞
    public static final short NOTIFY_USER_COMPLAINT = 104;          //用户被投诉
    //认证
    public static final short NOTIFY_AUTH = 111;                    //新认证申请 4
    public static final short NOTIFY_AUTH_FRIEND = 112;             //好友邀请帮其认证
    public static final short NOTIFY_AUTH_PASS = 113;               //认证通过
    public static final short NOTIFY_AUTH_PASS_FRIEND = 114;        //好友确认通过认证
    public static final short NOTIFY_AUTH_REJECT = 115;             //认证被拒
    //社群
    public static final short NOTIFY_GROUP_NEW = 120;               //新建群 7
    public static final short NOTIFY_GROUP_JOIN = 121;              //加入群
    public static final short NOTIFY_GROUP_EXIT = 122;              //退出群
    public static final short NOTIFY_GROUP_COMPLAINT = 124;         //群被投诉
    //动态
    public static final short NOTIFY_NEWSLETTER_NEW = 151;          //新动态 1
    public static final short NOTIFY_NEWSLETTER_COMMENT = 152;      //动态被评论 2
    public static final short NOTIFY_NEWSLETTER_APPLAUD = 153;      //动态被点赞 3
    public static final short NOTIFY_NEWSLETTER_COMPLAINT = 154;    //动态被投诉

    //聚会通知
    public static final short NOTIFY_PARTY_COMMENT = 301;           //聚会新评论 14
    public static final short NOTIFY_PARTY_GRADE = 302;             //聚会新评价 15
    public static final short NOTIFY_PARTY_CLOSE = 303;             //聚会关闭

    public static final short NOTIFY_PARTY_REGISTER = 320;          //聚会报名
    public static final short NOTIFY_PARTY_REGISTER_CANCEL = 321;   //聚会报名取消
    public static final short NOTIFY_PARTY_REGISTER_REJECT = 322;   //聚会报名被拒
    public static final short NOTIFY_PARTY_REGISTER_CONFIRM = 323;  //聚会报名确认
    public static final short NOTIFY_PARTY_SIGNIN = 324;            //签到报名的聚会
    public static final short NOTIFY_PARTY_SIGNIN_CONFIRM = 325;    //确认签到
    public static final short NOTIFY_PARTY_SYSTEM_SIGNIN = 326;     //系统定时签到聚会

    public static final short NOTIFY_PARTY_ALMOST = 330;            //聚会快开始提醒
    public static final short NOTIFY_PARTY_TODAY = 331;             //今天开始聚会提醒
    public static final short NOTIFY_PARTY_INVITATION = 332;        //邀请参加新聚会
    public static final short NOTIFY_PARTY_PAYED = 333;             //报名聚会付款成功
    public static final short NOTIFY_PARTY_NON_PAY = 334;           //报名聚会还未付款

    //钱包通知
    public static final short NOTIFY_WALLET_RECHARGE = 800;         //充值
    public static final short NOTIFY_WALLET_TRANSFER = 811;         //转账
    public static final short NOTIFY_WALLET_REFUNDED = 840;         //收到退款
    public static final short NOTIFY_WALLET_WITHDRAW = 888;         //提现成功
    public static final short NOTIFY_WALLET_PARTY_RECEIPT = 820;    //收到聚会报名款
    public static final short NOTIFY_WALLET_PARTY_REFUND = 821;     //收到聚会退款

    //服务通知
    public static final short NOTIFY_BUSINESS_COMMENT = 400;         //被评论 17
    public static final short NOTIFY_BUSINESS_GRADE = 401;           //被评价 18
    public static final short NOTIFY_BUSINESS_GRADE_REPLY = 402;     //回复评价 19
    public static final short NOTIFY_BUSINESS_RECOMMEND = 403;       //服务被推荐 20
    public static final short NOTIFY_BUSINESS_COMPLAINT = 404;       //服务被投诉
    public static final short NOTIFY_PROVIDER_CLOSE = 410;            //服务商被关闭 21
    public static final short NOTIFY_PROVIDER_REOPEN = 411;           //服务商重开 22
    public static final short NOTIFY_PROVIDER_REOPEN_DENY = 412;      //服务商重开被拒 23

    //消息开关
    public static final byte ENABLE_NOTIFY = 1; //开通通知
    public static final byte PRIVACY_ALLOW = 1;    //允许访问隐私
    public static final byte PRIVACY_REJECT = 0;    //禁止访问隐私
    /**
     * 用户认证
     */
    public final static byte CERTIFICATE_UPLOAD_WAY = 1; //上传资料认证方式
    public final static byte CERTIFICATE_INVATE_WAY = 2;
    //处理状态
    public final static byte CERTIFICATE_FINISH = 2;   //处理完
    /**
     * 真人秀
     */
    public final static int VIEW_QUANTITY_WHEN_NOT_CERTIFIED = 9;     //未认证用户可看真人秀照片数量
    public final static int VIEW_QUANTITY_WHEN_CERTIFIED = 2000;       //认证用户可看真人秀照片数量
    /**
     * 查令街
     */
    //收信动作
    public final static byte CHARING_RECEIVE_IGNORE = 0;   //收信：忽略
    public final static byte CHARING_RECEIVE_AFFIRM = 1;   //收信：确认
    //公开信息
    public final static byte CHARING_PUBLIC_NO = 0;    //不公开
    public final static byte CHARING_PUBLIC_YES = 1;   //公开
    public final static byte CHARING_PUBLIC_WAITE = 2; //再等等
    /**
     * 动态
     */
    public final static byte NEWSLETTER_ANONYMOUS_YES = 1; //匿名
    public final static byte NEWSLETTER_ANONYMOUS_NO = 0; //不匿名
    public final static int NEWSLETTER_DEFAULT_TAG = 1021;  //默认标签
    /**
     * 评论
     */
    public final static byte COMMENT_NEWSLETTER = 1; //评论动态
    public final static byte COMMENT_ANNOUNCE = 2;   //评论公告
    public final static byte COMMENT_SHOWTIME = 3;   //评论秀
    public static final byte COMMENT_PARTYING = 4;    //评论聚会
    public static final byte COMMENT_BUSINESS_SERVICE = 5;    //评论服务
    public static final byte COMMENT_SERVICE_GRADE = 6;    //评论评价


    /**
     * 举报
     */
    public static final byte COMPLAINT_NEWSLETTER = 1; //投诉动态
    public static final byte COMPLAINT_COMMENT = 2;   //投诉公告
    public static final byte COMPLAINT_SHOWTIME = 3;   //投诉秀
    /**
     * 抽奖
     */
    public final static byte LOTTERY_CHARING = 1;
    /**
     * 奖励积分
     */
    public static final byte TYPE_ACTIVATED = 1;            //启动APP
    public static final byte TYPE_REGISTER = 2;             //完成注册
    public static final byte TYPE_COMPLETE_PROFILE = 3;     //完善个人资料
    public static final byte TYPE_FINISH_CERTIFICATED = 4;  //完成认证
    public static final byte TYPE_FIRST_NEWSLETTER = 5;     //第一条动态
    public static final byte TYPE_FIRST_CHARING = 6;        //第一条查令街
    public static final byte TYPE_FIRST_SHOWTIME = 7;       //第一条秀
    public static final byte TYPE_CHECKIN = 8;              //签到
    public static final byte TYPE_SHARE = 9;                //分享
    public static final byte TYPE_BY_APPLAUD = 10;           //发布的内容被点赞
    public static final byte TYPE_BY_COMMENT = 11;          //发布的内容被评论
    public static final byte TYPE_APPLAUDED = 12;           //点赞别人内容
    public static final byte TYPE_COMMENTED = 13;           //评论别人内容
    public static final byte TYPE_PARTY = 14;               //发布聚会
    public static final byte TYPE_GRADED = 15;              //评价他人
    public static final byte TYPE_BY_GRADE = 16;            //被评价
    public static final byte TYPE_ADMIN__GIVE = 17;            //系统增送

    /**
     * 消费积分
     */
    public static final byte TYPE_LOTTERY = 20;             //抽奖
    public static final byte TYPE_CONVERT = 21;              //兑换
    /**
     * 积分对应内容
     */
    public static final byte TARGET_EMPTY = 0;          //无对应内容
    public static final byte TARGET_NEWSLETTER = 1;     //对应动态
    public static final byte TARGET_SHOWTIME = 2;       //楼咖秀
    public static final byte TARGET_AVATAR = 3;         //头像
    public static final byte TARGET_CONSUME = 4;          //消费积分
    public static final byte TARGET_PARTY = 5;          //聚会
    public static final byte TARGET_GRADE = 6;          //评价

    public final static byte ORDER_SELF = 1;
    public final static byte ORDER_DUIBA = 2;

    /**
     * 积分订单状态
     */
    public static final byte INTEGRAL_STATUS_CLOSE = 0;
    public static final byte INTEGRAL_STATUS_DOING = 1;
    public static final byte INTEGRAL_STATUS_OK = 2;
    public static final byte INTEGRAL_STATUS_FAIL = 4;
    public static final byte INTEGRAL_STATUS_DEL = 7;

    public static final MediaType TYPE_JSON = MediaType.parse("application/json; charset=utf-8");


    /**
     * Partying 角色
     */
    public static final byte PARTY_ROLE_SPONSOR = 1;        //发起人
    public static final byte PARTY_ROLE_ASSISTANT = 2;      //协助人
    public static final byte PARTY_ROLE_JOIN = 3;           //参加者

    public static final byte PARTY_DO_REGISTER = 1;         //报名
    public static final byte PARTY_DO_CANCEL_REGISTER = 2;  //取消报名
    public static final byte PARTY_DO_CLOSE = 3;            //关闭聚会
    public static final byte PARTY_DO_COMMENT = 4;          //评论聚会
    public static final byte PARTY_DO_GRADE = 5;            //评价聚会
    public static final byte PARTY_DO_EARLY_REMIND = 6;     //提前2小时提醒
    public static final byte PARTY_DO_TODAY_REMIND = 7;     //当天提醒
    public static final byte PARTY_DO_CONFIRM_REGISTER = 8; //报名确认
    public static final byte PARTY_DO_REMIND_FOLLOW = 9;     //通知粉丝
    public static final byte PARTY_DO_REMIND_TOGETHER = 10;  //通知一起参加聚会的人


    /**
     * 积分值
     */
    public final static int INTEGRAL_50 = 50; //50咖豆
    public final static int INTEGRAL_10 = 10; //10咖豆
    public final static int INTEGRAL_20 = 20; //20咖豆
    public final static int INTEGRAL_5 = 5; //5咖豆
    public final static int INTEGRAL_3 = 3; //3咖豆
    public final static int INTEGRAL_1 = 1; //1咖豆
    public final static int INTEGRAL_2 = 2; //2咖豆
    public final static int INTEGRAL_4 = 4; //4咖豆

    public final static int INTEGRAL_LIMIT_5 = 5; //限5咖豆
    public final static int INTEGRAL_LIMIT_10 = 10; //限10咖豆
    public final static int INTEGRAL_LIMIT_30 = 30; //限30咖豆

    /**
     * 身份证和手机号状态
     *
     */
    public final static String Dentity="身份证号码";
    public final static String PhoneNum="手机号码";

    /**
     * 微信缓存KEY
     */
    public final static String WEIXIN_APP = "Weixin:AccessToken:App";
    public final static String WEIXIN_PUBLIC = "Weixin:AccessToken:Public";

}

