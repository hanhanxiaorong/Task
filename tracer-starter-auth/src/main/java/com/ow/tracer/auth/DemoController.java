package com.ow.tracer.auth;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: Easy
 * @Date: 18-9-13 00:43
 * @Description:
 */
@RestController
@RequestMapping("/api")
public class DemoController {
    @RequestMapping("/blog/{id}")
    public String getBlogById(@PathVariable long id) {
        return "this is blog "+id;
    }
}
