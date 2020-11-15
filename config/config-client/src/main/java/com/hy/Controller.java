package com.hy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: $- Controller -$ #-->
 * @Author: 寒夜
 * @CreateDate: 2020/11/12 16:00
 * @UpdateUser: 寒夜
 * @UpdateDate: 2020/11/12 16:00
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@RestController
public class Controller {
    //直接从github注入
    @Value("${name}")
    private String name;

    //将远程注入到本地，再从本地获取
    @Value("${myWords}")
    private String words;

    @GetMapping("name")
    public String getName(){
        return name;
    }

    @GetMapping("words")
    public String getWords(){
        return words;
    }
}
