package com.example.blog.pojo;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component("tags")
@Alias("tags")
public class Tags implements Serializable {
    private String blogid;
    private String tags;

    public String getBlogid() {
        return blogid;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void setBlogid(String blogsid) {
        this.blogid = blogsid;
    }
}
