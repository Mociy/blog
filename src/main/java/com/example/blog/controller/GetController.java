package com.example.blog.controller;

import com.example.blog.pojo.News;
import com.example.blog.service.imp.GetNewsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GetController {

    @Autowired
    GetNewsServiceImp getNewsServiceImp;
    @Autowired
    News news;

    @PostMapping("/getAll")
    @ResponseBody
    public List<News> getAll(){
                     char cr='你';
        return getNewsServiceImp.queryAll();
    }

    @RequestMapping("/get")
    @ResponseBody
    public News getNews(String newsid){

          news=getNewsServiceImp.queryNews(newsid);
          news.setTags(getNewsServiceImp.queryTags(newsid));
        return news;
    }


}
