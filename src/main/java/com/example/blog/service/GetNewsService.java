package com.example.blog.service;

import com.example.blog.pojo.News;
import com.example.blog.pojo.Tags;

import java.util.ArrayList;
import java.util.List;

public interface GetNewsService {
   List<Tags> query(String tag);
    List<String> queryTags(String newsid);
    News queryNews(String newsid);
    List<News> queryAll();
}
