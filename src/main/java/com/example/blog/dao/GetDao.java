package com.example.blog.dao;

import com.example.blog.pojo.Blog;
import com.example.blog.pojo.Tags;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface GetDao {
    List<Tags> query(String tag);

    List<String> queryTags(String newsid);

    Blog queryBlog(String newsid);
    List<Blog> queryAll();

    void insertBlog(Blog blog);
    void insertTags(Tags tags);
    void insertBriefly(Blog blog);
}
