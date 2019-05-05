package com.example.blog.service.imp;

import com.example.blog.dao.GetDao;
import com.example.blog.pojo.Blog;
import com.example.blog.pojo.Tags;
import com.example.blog.service.GetBlogService;
import com.example.blog.tools.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GetBlogServiceImp implements GetBlogService {
   @Autowired
   GetDao getDao;
   @Autowired
   Log log;

    @Autowired
    private RedisTemplate<Object,Object> template;
    //根据tag标签搜索博客id
    @Override
    public List<Tags> query(String tag) {
        return getDao.query(tag) ;
    }
    //根据id搜索tag
    @Override
    public List<String> queryTags(String blogid) {
        return getDao.queryTags(blogid);
    }
    //根据id搜索博客
    @Override
    public Blog queryBlog(String blogid,String address) {
        if(template.hasKey("blog::"+blogid)) {//判断是否在redis中
            log.addLog(blogid+"走缓存"+"地址"+address);
            return (Blog) template.opsForValue().get("blog::"+blogid);
        }
        else {//不在就存入缓存中
            System.out.println("查数据库");
            Blog blog=getDao.queryBlog(blogid);
            template.opsForValue().set("blog::"+blogid,blog);
        }
        return (Blog) template.opsForValue().get("blog::"+blogid);
    }
    //搜索所有博客
    @Override
    public List<Blog> queryAll() {
        return getDao.queryAll();
    }
}
