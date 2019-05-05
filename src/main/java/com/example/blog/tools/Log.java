package com.example.blog.tools;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Log {
    @Value("${filepath}")
    public  String path;
    public  void addLog(String log){

        File file=new File(path);
        try {
            file.createNewFile();

            FileWriter writer=new FileWriter(path,true);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            String date=df.format(new Date());// new Date()为获取当前系统时间
            writer.write(date+"           "+log+"\r\n");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
