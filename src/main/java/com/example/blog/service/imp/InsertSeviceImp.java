package com.example.blog.service.imp;

import com.example.blog.dao.GetDao;
import com.example.blog.pojo.Blog;
import com.example.blog.pojo.Tags;
import com.example.blog.service.InsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class InsertSeviceImp implements InsertService {
    @Autowired
    GetDao getDao;
    @Autowired
    Tags inTag;
    @Override
    public void insertNews(Blog blog) {
        getDao.insertBlog(blog);
    }

    @Override
    public void insertTags(Tags tags) {
        getDao.insertTags(tags);
    }

    @Override
    public void insertBriefly(Blog blog) {
        getDao.insertBriefly(blog);
    }

    @Transactional
    @Override
    public void insertAll(Blog blog, String[] tags) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        blog.setDate(df.format(new Date()));// new Date()为获取当前系统时间
            insertNews(blog);
            insertBriefly(blog);
           for(String tag:tags){
            inTag.setBlogid(blog.getBlogid());
            inTag.setTags(tag);
            insertTags(inTag);
        }
    }
}
