package com.example.blog.service.imp;

import com.example.blog.dao.GetDao;
import com.example.blog.pojo.News;
import com.example.blog.pojo.Tags;
import com.example.blog.service.GetNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class GetNewsServiceImp implements GetNewsService {
   @Autowired
   GetDao getDao;

    @Override
    public List<Tags> query(String tag) {
        return getDao.query(tag) ;
    }

    @Override
    public List<String> queryTags(String newsid) {
        return getDao.queryTags(newsid);
    }

    @Override
    public News queryNews(String newsid) {
        return getDao.queryNews(newsid);
    }

    @Override
    public List<News> queryAll() {
        return getDao.queryAll();
    }
}
