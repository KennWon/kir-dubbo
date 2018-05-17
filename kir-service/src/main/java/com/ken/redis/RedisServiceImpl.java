package com.ken.redis;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.alibaba.dubbo.config.annotation.Service;
import com.ken.Utils.JSONUtil;
import com.ken.Utils.ObjectUtil;
import com.ken.Utils.ThreadLocalStringBuilder;
import com.ken.service.RedisService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

// 注册为 Dubbo 服务
@Service(version = "1.0.0")
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private final static Logger logger = LoggerFactory.getLogger(RedisServiceImpl.class);

    @Override
    public boolean exists(String key) {
        return this.redisTemplate.hasKey(key);
    }

    @Override
    public void set(String key, String value) {
        this.redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public void set(String key, int value) {
        this.redisTemplate.opsForValue().set(key, String.valueOf(value));
    }

    @Override
    public String get(String key) {
        return this.redisTemplate.opsForValue().get(key);
    }

    /**
     * Gets from json.
     *
     * @param <T>
     *            the type parameter
     * @param key
     *            the key
     * @param clazz
     *            the clazz
     * @return the from json
     */
    @Override
    public <T> T getFromJson(String key, Class<T> clazz) {
        String json = get(key);
        if (StringUtils.isNotEmpty(json)) {
            return JSONUtil.fromJson(json, clazz);
        }
        return null;
    }

    /**
     * Gets list from json.
     *
     * @param <T>
     *            the type parameter
     * @param key
     *            the key
     * @param clazz
     *            the clazz
     * @return the list from json
     */
    @Override
    public <T> List<T> getListFromJson(String key, Class<T> clazz) {
        String json = get(key);
        if (json != null && !json.equals("")) {
            return JSONUtil.json2List(json, clazz);
        }
        return null;
    }


    @Override
    public void del(String key) {
        this.redisTemplate.delete(key);
    }

    @Override
    public void dels(List<String> keys) {
        this.redisTemplate.delete(keys);
    }

    @Override
    public void delByPattern(String pattern) {
        this.redisTemplate.delete(stringRedisTemplate.keys(pattern));
    }

    @Override
    public void set(String key, String value, int expire) {
        this.redisTemplate.opsForValue().set(key, value);
        this.expire(key, expire);
    }

    @Override
    public void set(String key, int value, int expire) {
        this.set(key, String.valueOf(value), expire);
    }

    @Override
    public int ttl(String key) {
        return this.redisTemplate.getExpire(key, TimeUnit.SECONDS).intValue();
    }

    @Override
    public void cacheObj(Object obj) throws Exception {
        try {
            Field id = obj.getClass().getDeclaredField("id");
            id.setAccessible(true);
            int idValue = id.getInt(obj);
            StringBuilder builder = ThreadLocalStringBuilder.get();
            String key = builder.append(obj.getClass().getSimpleName()).append(":").append(idValue).toString();
            this.set(key, new String(ObjectUtil.serialize(obj), "UTF-8"));
        } catch (Exception e) {
            logger.error("CLASS " + obj.getClass().getName() + " instance cache failed!, caused by:" + e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T getCachedObj(int id, Class<T> beanClass) {
        StringBuilder builder = ThreadLocalStringBuilder.get();
        String key = builder.append(beanClass.getSimpleName()).append(":").append(id).toString();
        return (T) ObjectUtil.deserialize(this.get(key).getBytes());
    }

    @Override
    public int incr(String key) {
        return this.operationsForNumber(key, 1);
    }

    @Override
    public int incr(String key, int value) {
        return this.operationsForNumber(key, value);
    }

    @Override
    public int decr(String key) {
        return this.operationsForNumber(key, -1);
    }

    @Override
    public int decr(String key, int value) {
        return this.operationsForNumber(key, -value);
    }

    /**
     * @author admin@devwang.cn
     * @Description 数字操作
     * @date 2017年5月7日 下午3:11:42
     * @param key
     *            键
     * @param value
     *            值
     * @return int 操作后的值
     */
    private int operationsForNumber(String key, int value) {
        return this.redisTemplate.boundValueOps(key).increment(value).intValue();
    }

    /**
     * 设置过期时间
     *
     * @param key
     * @param seconds
     */
    public void expire(String key, int seconds) {
        if (seconds <= 0) {
            return;
        }
        this.redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
    }

    /**
     * Put all list.
     *
     * @param key
     *            the key
     * @param value
     *            the value Created on 2017-05-26 12:16:20
     * @author hxl
     */
    @Override
    public long putAllList(String key, Collection<String> value) {
        return redisTemplate.opsForList().rightPushAll(key, value);
    }

    /**
     * Range list.
     *
     * @param key
     *            the key
     * @param start
     *            the start
     * @param end
     *            the end
     * @return the list Created on 2017-05-26 12:16:22
     * @author hxl
     */
    @Override
    public List<String> range(String key, int start, int end) {
        return redisTemplate.opsForList().range(key, start, end);
    }

    /**
     * Count list size long.
     *
     * @param key
     *            the key
     * @return the long Created on 2017-05-26 12:16:24
     * @author hxl
     */
    @Override
    public long countListSize(String key) {
        return redisTemplate.opsForList().size(key);
    }

    /**
     * Zset add.
     *
     * @param key
     *            the key
     * @param value
     *            the value
     * @param score
     *            the score Created on 2017-05-26 14:27:09
     * @author hxl
     */
    @Override
    public boolean zsetAdd(String key, String value, double score) {
        if (key == null || value == null) {
            logger.error("zsetAdd exception. key or value is null.");
        }
        return redisTemplate.opsForZSet().add(key, value, score);
    }

    /**
     * Zset card long.
     *
     * @param key
     *            the key
     * @return the long Created on 2017-05-26 14:35:11
     * @author hxl
     */
    @Override
    public long zsetCard(String key) {
        return redisTemplate.opsForZSet().zCard(key);
    }

    /**
     * Gets all zset.
     *
     * @param key
     *            the key
     * @return the all zset
     */
    @Override
    public Set<String> getAllZset(String key) {
        long size = redisTemplate.opsForZSet().size(key);
        return redisTemplate.opsForZSet().range(key, 0l, size);
    }

    /**
     * Delete all zset long.
     *
     * @param key
     *            the key
     * @return the long Created on 2017-05-26 15:45:08
     * @author hxl
     */
    @Override
    public long deleteAllZset(String key) {
        long size = redisTemplate.opsForZSet().size(key);
        return redisTemplate.opsForZSet().removeRange(key, 0l, size);
    }

    /**
     * Sets add.
     *
     * @param key
     *            the key
     * @param value
     *            the value
     * @return the add
     */
    @Override
    public long setAdd(String key, String... value) {
        return redisTemplate.opsForSet().add(key, value);
    }

    /**
     * Lpush long.
     *
     * @param key
     *            the key
     * @param value
     *            the value
     * @return the long Created on 2017-05-26 14:41:06
     * @author hxl
     */
    @Override
    public long lpush(String key, String value) {
        return redisTemplate.opsForList().leftPush(key, value);
    }

    /**
     * Rpop string.
     *
     * @param key
     *            the key
     * @return the string Created on 2017-05-26 14:43:04
     * @author hxl
     */
    @Override
    public String rpop(String key) {
        return this.rpop(key, 0, TimeUnit.SECONDS);
    }

    /**
     * Rpop string.
     *
     * @param key
     *            the key
     * @param timeout
     *            the timeout
     * @return the string Created on 2017-05-26 14:43:09
     * @author hxl
     */
    @Override
    public String rpop(String key, long timeout) {
        return this.rpop(key, timeout, TimeUnit.SECONDS);
    }

    /**
     * Rpop string.
     *
     * @param key
     *            the key
     * @param timeout
     *            the timeout
     * @param unit
     *            the unit
     * @return the string Created on 2017-05-26 14:43:13
     * @author hxl
     */
    @Override
    public String rpop(String key, long timeout, TimeUnit unit) {
        return redisTemplate.opsForList().rightPop(key, timeout, unit);
    }

    /**
     * Sets hash.
     *
     * @param key
     *            the key
     * @param hashKey
     *            the hash key
     * @param value
     *            the value
     */
    @Override
    public void setHash(String key, Object hashKey, Object value) {
        redisTemplate.opsForHash().put(key, hashKey, value);
    }

    /**
     * Gets hash val.
     *
     * @param key
     *            the key
     * @param hashKey
     *            the hash key
     * @return the hash val
     */
    @Override
    public Object getHashVal(String key, Object hashKey) {
        return redisTemplate.opsForHash().get(key, hashKey);
    }

    /**
     * Gets all hash.
     *
     * @param key
     *            the key
     * @return the all hash
     */
    @Override
    public List<Object> getAllHash(String key) {
        return redisTemplate.opsForHash().values(key);
    }

    /**
     * Delete hash.
     *
     * @param key
     *            the key
     * @param hashKey
     *            the hash key Created on 2017-05-26 15:04:38
     * @author hxl
     */
    @Override
    public long deleteHash(String key, Object... hashKey) {
        return redisTemplate.opsForHash().delete(key, hashKey);
    }

    @Override
    public void sadd(String key, String member) {
        redisTemplate.opsForSet().add(key, member);
    }

    @Override
    public boolean sismember(String key, String member) {
        return redisTemplate.opsForSet().isMember(key, member);
    }

    @Override
    public byte[] getByte(String key) {
        final byte[][] data = { null };
        this.redisTemplate.execute((RedisCallback<Object>) redisConnection -> {
            data[0] = redisConnection.get(key.getBytes());
            return null;
        });
        return data[0];
    }
}
