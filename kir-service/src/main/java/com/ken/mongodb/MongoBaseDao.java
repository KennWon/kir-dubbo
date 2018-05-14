package com.ken.mongodb;


import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import javax.annotation.Resource;
import java.util.List;

public abstract class MongoBaseDao<T> {

    @Resource
    protected MongoTemplate mongoTemplate;


    /**
     * 保存一个对象存在则更新
     * @param t
     * @return
     */
    public void save(T t){
        this.mongoTemplate.save(t);
    }

    /**
     * 插入一个对象
     * @param t
     */
    public void insert(T t){
        this.mongoTemplate.insert(t);
    }

    /**
     * 根据Id从Collection中查询对象
     * @param id
     * @return
     */
    public T queryById(String id) {
        Query query = new Query();
        Criteria criteria = Criteria.where("_id").is(id);
        query.addCriteria(criteria);
        return this.mongoTemplate.findOne(query, this.getEntityClass());
    }

    /**
     * 根据条件查询集合
     * @param query
     * @return
     */
    public List<T> queryList(Query query){
        return this.mongoTemplate.find(query, this.getEntityClass());
    }

    /**
     * 根据条件查询单个记录
     * @param query
     * @return
     */
    public T queryOne(Query query){
        return this.mongoTemplate.findOne(query, this.getEntityClass());
    }

    /**
     * 通过条件进行分页查询
     * @param query
     * @param start
     * @param size
     * @return
     */
    public List<T> getPage(Query query, int start, int size){
        query.skip(start);
        query.limit(size);
        List<T> lists = this.mongoTemplate.find(query, this.getEntityClass());
        return lists;
    }


    /**
     * 通过条件查询记录数
     * @param query
     * @return long 汇总记录数
     */
    public long getCount(Query query){
        return this.mongoTemplate.count(query, this.getEntityClass());
    }

    /**
     * 根据Id删除用户
     * @param id
     */
    public void deleteById(String id) {
        Criteria criteria = Criteria.where("_id").in(id);
        if(null!=criteria){
            Query query = new Query(criteria);
            if(null!=query && this.queryOne(query)!=null){
                this.delete(query);
            }
        }
    }

    public  void delete(Query query){
        this.mongoTemplate.remove(query,this.getEntityClass());
    }


    /**
     * 删除对象
     * @param t
     */
    public void delete(T t){
        this.mongoTemplate.remove(t);
    }

    /**
     * 更新满足条件的第一个记录
     * @param query
     * @param update
     */
    public void updateFirst(Query query,Update update){
        this.mongoTemplate.updateFirst(query, update, this.getEntityClass());
    }

    /**
     * 更新满足条件的所有记录
     * @param query
     * @param update
     */
    public void updateMulti(Query query, Update update){
        this.mongoTemplate.updateMulti(query, update, this.getEntityClass());
    }

    /**
     * 查找更新,如果没有找到符合的记录,则将更新的记录插入库中
     * @param query
     * @param update
     */
    public void updateInsert(Query query, Update update){
        this.mongoTemplate.upsert(query, update, this.getEntityClass());
    }

    /**
     * 为属性自动注入bean服务
     * @param mongoTemplate
     */
    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    /**
     * 钩子方法,由子类实现返回反射对象的类型
     * */
    protected abstract Class<T> getEntityClass();

}

