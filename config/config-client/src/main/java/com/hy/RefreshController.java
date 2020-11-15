package com.hy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: $- RefreshController -$ #-->
 * @Author: 寒夜
 * @CreateDate: 2020/11/13 12:09
 * @UpdateUser: 寒夜
 * @UpdateDate: 2020/11/13 12:09
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@RestController
@RequestMapping("/refresh")
@RefreshScope
public class RefreshController {

    @Value("${words}")
    private String words;

    @Value("${food}")
    private String food;

    @GetMapping("/words")
    public String getWords() {
        return words;
    }


    @GetMapping("/dinner")
    public String dinner() {
        return "May I have one "+food;
    }

}
