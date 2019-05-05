package com.example.blog.controller;

import com.example.blog.pojo.Blog;
import com.example.blog.pojo.Tags;
import com.example.blog.service.InsertService;
import com.example.blog.service.imp.GetBlogServiceImp;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GetController {

    @Autowired
    GetBlogServiceImp getBlogServiceImp;
    @Autowired
    InsertService insertService;
    @Autowired
    Blog blog;

    @Autowired
    private RedisTemplate<Object,Object> template;


    @PostMapping("/getAll")
    @ResponseBody
    public List<Blog> getAll(){

        return getBlogServiceImp.queryAll();
    }

    @RequestMapping("/get")
    @ResponseBody
    public Blog getNews(String blogid, HttpServletRequest request){

        String address=request.getRemoteAddr();

          blog = getBlogServiceImp.queryBlog(blogid,address);
          blog.setTags(getBlogServiceImp.queryTags(blogid));
        return blog;
    }


    @RequestMapping("/page/{blogid}")
    public String getpage(Model model, @PathVariable("blogid") String blogid){
        model.addAttribute("blogid",blogid);
        return "page";
    }


    @RequestMapping("/postContent")
    @ResponseBody
   public   Map insert(@RequestBody Blog blog){
        blog.setBlogid(String.valueOf(System.currentTimeMillis()));
        String regEx_html="<[^>]+>";
        //过滤html标签
        blog.setStart(blog.getContent().replaceAll("<code>.*<\\/code>","").replaceAll(regEx_html,"").replaceAll("[\\n|\\s|&nbsp;]","").replaceAll("gt",">").substring(0,60));
        String[] tags= blog.getTag().split("[, ，]");
        insertService.insertAll(blog,tags);

        Map map=new HashMap();
        map.put("result","ok");
        return map;
    }

    @RequestMapping("/write")
    public String getWritePage(){
        return "write";
    }

    @RequestMapping("/getblog")
    @ResponseBody
    public Blog getBlog(){
        blog.setBlogid("dadsadassda");
        blog.setDate("dsada");
        blog.setStart("dsadsadsad");

        template.opsForValue().set("user",blog);


        return blog;
    }

    @RequestMapping("/test")
    public String getTest(){
        return "Test";
    }
    @RequestMapping("/test1")
    @ResponseBody
    public List<Blog> getByTag(String tag){
       List<Tags> tags= getBlogServiceImp.query(tag);
       List<Blog> blogs_=new ArrayList<>();
        for (Tags tag_:tags) {
            blogs_.add(getBlogServiceImp.queryBlog(tag_.getBlogid(),""));
        }
        return blogs_;
    }


}
