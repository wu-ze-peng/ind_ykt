package com.ykt.ind_ykt.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @Autor guoyh
 * @Date 2019/6/4 0004
 * @Usage
 */
@Component("redisUtil")
public class RedisUtil {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    public boolean expired(String key,long time){
        if(time>0){
            redisTemplate.expire(key,time,TimeUnit.SECONDS);
            return true;
        }
        return false;
    }

    /**
     * 获取超时时间
     * @param key
     * @return
     */
    public long getExpire(String key){
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    public boolean hasKey(String key){
        return redisTemplate.hasKey(key);
    }

    /**
     * 删除键值
     * @param key
     * @return
     */
    public Long delete(String ... key){
        if(key !=null && key.length>0){
            return redisTemplate.delete(Arrays.asList(key));
        }
        return 0L;
    }

    /**
     * 获取键值
     * @param key
     * @return
     */
    public Object get(String key){
        if(hasKey(key)){
            return redisTemplate.opsForValue().get(key);
        }
        return null;
    }

    /**
     * 键值设置
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key,Object value){
        return set(key,value,0);

    }

    public boolean set(String key,Object value,long time){
        try{
            redisTemplate.opsForValue().set(key,value);
            if(time>0){
                expired(key,time);
            }
            return true;
        }catch (Exception e){
            logger.error("Error in setting key ["+key+"] into redis server");
            return false;
        }
    }

    /**
     * 键值递增
     * @param key
     * @return
     */
    public long increment (String key){
        return add(key,1);
    }

    /**
     * 键值递减
     * @param key
     * @return
     */
    public long decrement (String key){
        return add(key,-1);
    }

    /**
     * 键值加减
     * @param key
     * @param delta
     * @return
     */
    public long add(String key,long delta){
        if(delta>0){
            return redisTemplate.opsForValue().increment(key,delta);
        }else{
            return redisTemplate.opsForValue().decrement(key,delta);
        }
    }

    /**
     * 获取hash类型key中包含的item键对应的值
     * @param key
     * @param item
     * @return
     */
    public Object hget(String key,String item){
        return redisTemplate.opsForHash().get(key,item);
    }

    /**
     * 获取hash类型key中包含的所有键值对
     * @param key
     * @return
     */
    public Map<Object,Object> hmget(String key){
        return redisTemplate.opsForHash().entries(key);
    }


    /**
     * 添加一个名字为key的键值对对象
     * @param key
     * @param k
     * @param v
     */
    public void hset(String key,Object k,Object v){
        hset(key,k,v,0);
    }

    public void hset(String key,Object k,Object v,long time){
        redisTemplate.opsForHash().put(key,k,v);
        if(time>0){
            expired(key,time);
        }
    }

    /**
     * 将所有Map对象存入到key中
     * @param key
     * @param items
     */
    public void hmset(String key,Map<String,Object> items){
        hmset(key,items,0);
    }

    public void hmset(String key,Map<String,Object> items,long time){
        redisTemplate.opsForHash().putAll(key,items);
        if(time>0){
            expired(key, time);
        }
    }

    /**
     * 删除hash类型的key中包含的items对象
     * @param key
     * @param items
     */
    public void hdel(String key,Object ... items){
        redisTemplate.opsForHash().delete(key,items);
    }

    /**
     * 判断hash类型的key中是否包含item对象
     * @param key
     * @param item
     * @return
     */
    public boolean hHasKey(String key,String item){
        return redisTemplate.opsForHash().hasKey(key,item);
    }

    /**
     * hash类型key下所有item的值进行加1
     * @param key
     * @param items
     * @return
     */
    public double hincrement(String key,String items){
        return hadd(key,items,1);
    }
    /**
     * hash类型key下所有item的值进行减1
     * @param key
     * @param items
     * @return
     */
    public double hdecrement(String key,String items){
        return hadd(key,items,-1);
    }
    public double hadd(String key,String items,long delta){
        return redisTemplate.opsForHash().increment(key,items,delta);
    }

    /**
     * 返回set类型对象
     * @param key
     * @return
     */
    public Set<Object> sGet(String key){
        return redisTemplate.opsForSet().members(key);
    }

    /**
     * 添加Set类型对象
     * @param key
     * @param values
     * @return
     */
    public long sSet(String key,List values){
        return sSet(key,values,0);
    }

    public long sSet(String key,List values,long time){
        long cnt = redisTemplate.opsForSet().add(key, values);
        if (time > 0) {
            expired(key, time);
        }
        return cnt;
    }

    /**
     * 获取set长度
     * @param key
     * @return
     */
    public long sSizeofSet(String key){
        return redisTemplate.opsForSet().size(key);
    }

    /**
     * 移除key中值为values的set
     * @param key
     * @param values
     * @return
     */
    public long setRemove(String key,List values){
        return redisTemplate.opsForSet().remove(key, values);
    }

    /**
     * 获取key下全部list
     * @param key
     * @return
     */
    public List<Object> lGet(String key){
        return lGet(key,0,sizeOfList(key));
    }

    /**
     * 获取list中第index个值
     * @param key
     * @param index
     * @return
     */
    public Object lGet(String key,long index){
        return redisTemplate.opsForList().index(key, index);
    }

    public List<Object> lGet(String key,long start,long end){
        return redisTemplate.opsForList().range(key,start,end);
    }

    public long sizeOfList(String key) {
        return redisTemplate.opsForList().size(key);
    }


    public boolean lSet(String key,List values){
        return lSet(key, values,0);
    }

    public boolean lSet(String key, List values, long time) {
        redisTemplate.opsForList().rightPushAll(key, values);
        if (time > 0) {
            expired(key, time);
        }
        return true;
    }

    public boolean lSet(String key,Object value){
        return lSet(key, value,0);
    }

    public boolean lSet(String key, Object value, long time) {
        redisTemplate.opsForList().rightPush(key, value);
        if (time > 0) {
            expired(key, time);
        }
        return true;
    }

    public long lRemove(String key, long count, Object value) {
        try {
            Long remove = redisTemplate.opsForList().remove(key, count, value);
            return remove;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}
