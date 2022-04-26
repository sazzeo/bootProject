package org.example.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {

        return "index"; //앞의 경로가 resources/templates 자동으로 붙고 뒤에 .mustache도 자동으로 붙음
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }
}
