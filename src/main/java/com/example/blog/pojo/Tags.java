package com.example.blog.pojo;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

@Component("tags")
@Alias("tags")
public class Tags {
    private String newsid;
    private String tags;

    public String getNewsid() {
        return newsid;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void setNewsid(String newsid) {
        this.newsid = newsid;
    }
}
