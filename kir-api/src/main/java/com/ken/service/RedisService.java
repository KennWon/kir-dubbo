package com.ken.service;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public interface RedisService {

    /**
     * @author admin@devwang.cn
     * @Description 缓存K-V
     * @date 2017年5月6日 下午6:02:03
     * @param key
     *            键
     * @param value
     *            值
     * @return void
     */
    void set(String key, String value);

    /**
     * @author admin@devwang.cn
     * @Description 缓存K-V并设置该键值对超时时间
     * @date 2017年5月6日 下午6:02:22
     * @param key
     *            键
     * @param value
     *            值
     * @param expire
     *            超时时间，单位：秒
     * @return void
     */
    void set(String key, String value, int expire);

    /**
     * @author admin@devwang.cn
     * @Description 缓存K-V
     * @date 2017年5月6日 下午6:02:50
     * @param key
     *            键
     * @param value
     *            值
     * @return void
     */
    void set(String key, int value);

    /**
     * @author admin@devwang.cn
     * @Description 缓存K-V并设置该键值对超时时间
     * @date 2017年5月6日 下午6:03:03
     * @param key
     *            键
     * @param value
     *            值
     * @param expire
     *            超时时间，单位：秒
     * @return void
     */
    void set(String key, int value, int expire);

    /**
     * @author admin@devwang.cn
     * @Description 查询键的超时时间
     * @date 2017年5月6日 下午6:03:19
     * @param key
     *            键
     * @return long 秒
     */
    int ttl(String key);

    /**
     * @author admin@devwang.cn
     * @Description get值
     * @date 2017年5月6日 下午6:03:40
     * @param key
     *            键
     * @return String
     */
    String get(String key);

    /**
     * 从json数据中反序列化出对象
     *
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    <T> T getFromJson(String key, Class<T> clazz);

    /**
     * 冲json数据中，反序列化出list集合
     *
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    <T> List<T> getListFromJson(String key, Class<T> clazz);

    /**
     * @author admin@devwang.cn
     * @Description 检查key是否存在
     * @date 2017年5月5日 下午4:47:50
     * @param key
     *            键
     * @return boolean 存在与否
     */
    boolean exists(String key);

    /**
     * @author admin@devwang.cn
     * @Description 删除键
     * @date 2017年5月5日 下午4:48:07
     * @param key
     *            键
     * @return void
     */
    void del(String key);

    /**
     * 删除多个
     *
     * @param keys
     */
    void dels(List<String> keys);

    /**
     * 匹配删除
     *
     * @param pattern
     */
    void delByPattern(String pattern);

    /**
     * @author admin@devwang.cn
     * @Description 键值自增1
     * @date 2017年5月7日 下午3:00:22
     * @param key
     *            键
     * @return int 自增后的值
     */
    int incr(String key);

    /**
     * @author admin@devwang.cn
     * @Description 给键的值增加一个数
     * @date 2017年5月7日 下午3:01:52
     * @param key
     *            键
     * @param value
     *            加数
     * @return int 增加后的值
     */
    int incr(String key, int value);

    /**
     * @author admin@devwang.cn
     * @Description 自减1
     * @date 2017年5月7日 下午3:05:58
     * @param key
     *            键
     * @return int 自减后的值
     */
    int decr(String key);

    /**
     * @author admin@devwang.cn
     * @Description 给键的值减去一个数
     * @date 2017年5月7日 下午3:06:03
     * @param key
     *            键
     * @param value
     *            减数
     * @return int 减去后的值
     */
    int decr(String key, int value);

    /**
     * @author admin@devwang.cn
     * @Description 缓存对象到redis
     * @date 2017年5月6日 下午2:33:21
     * @param obj
     * @return void
     */
    void cacheObj(Object obj) throws Exception;

    /**
     * @author admin@devwang.cn
     * @Description 获取缓存的对象
     * @date 2017年5月6日 下午3:38:28
     * @param id
     *            目标对象id
     * @param beanClass
     *            目标对象class
     * @return T 传入类型的实例
     */
    <T> T getCachedObj(int id, Class<T> beanClass);

    /**
     * 设置过期时间
     *
     * @param key
     * @param seconds
     */
    void expire(String key, int seconds);

    /**
     * 放字符串队列到
     *
     * @param key
     * @param value
     */
    long putAllList(String key, Collection<String> value);

    /**
     * 获取队列某个下标范围的值
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    List<String> range(String key, int start, int end);

    /**
     * 获取队列的长度
     *
     * @param key
     * @return
     */
    long countListSize(String key);

    /**
     * 有序集合 add
     *
     * @param key
     * @param value
     * @param score
     */
    boolean zsetAdd(String key, String value, final double score);

    /**
     * 计算SortedSet（有序集合）某key对应的set的size
     *
     * @param key
     * @return
     */
    long zsetCard(String key);

    /**
     * 获取全部
     *
     * @param key
     * @return
     */
    Set<String> getAllZset(String key);

    /**
     * 删除
     *
     * @param key
     * @return
     */
    long deleteAllZset(String key);

    /**
     * 唯一集合 add
     *
     * @param key
     * @param value
     * @return
     */
    long setAdd(String key, String... value);

    /**
     * 左 入列
     *
     * @param key
     * @param value
     * @return
     */
    long lpush(String key, String value);

    /**
     * 右 出列
     *
     * @param key
     * @return
     */
    String rpop(String key);

    /**
     * 右 出列
     *
     * @param key
     * @return
     */
    String rpop(String key, long timeout);

    /**
     * 右 出列
     *
     * @param key
     * @return
     */
    String rpop(String key, long timeout, TimeUnit unit);

    /**
     * 设置 hash
     *
     * @param key
     * @param hashKey
     * @param value
     */
    void setHash(String key, Object hashKey, Object value);

    /**
     * 获取hash的值
     *
     * @param key
     * @param hashKey
     * @return
     */
    Object getHashVal(String key, Object hashKey);

    /**
     * 获取key 的所有hash值
     *
     * @param key
     * @return
     */
    List<Object> getAllHash(String key);

    /**
     * 删除hash里的某个值
     *
     * @param key
     * @param hashKey
     */
    long deleteHash(String key, Object... hashKey);

    /**
     * @author：admin@devwang.cn
     * @description：添加元素至set
     * @time：2017年7月19日 下午2:49:46
     * @param key
     * @param member
     * @return：void
     */
    void sadd(String key, String member);

    /**
     * @author：admin@devwang.cn
     * @description：判断元素是否是set成员
     * @time：2017年7月19日 下午2:50:04
     * @param key
     * @param member
     * @return：boolean
     */
    boolean sismember(String key, String member);

    byte[] getByte(String key);
}

