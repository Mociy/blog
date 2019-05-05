package com.example.blog.service;

import com.example.blog.pojo.Blog;
import com.example.blog.pojo.Tags;

import java.util.List;

public interface GetBlogService {
   List<Tags> query(String tag);
    List<String> queryTags(String newsid);
    Blog queryBlog(String blogid,String address);
    List<Blog> queryAll();
}
