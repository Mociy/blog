package com.example.blog.service;

import com.example.blog.pojo.Blog;
import com.example.blog.pojo.Tags;



public interface InsertService {

    void insertNews(Blog blog);
    void insertTags(Tags tags);
    void insertBriefly(Blog blog);
    void insertAll(Blog blog, String[] tags);
}
