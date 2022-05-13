package org.example.springboot.web;

import lombok.RequiredArgsConstructor;
import org.example.springboot.config.auth.LoginUser;
import org.example.springboot.config.auth.dto.SessionUser;
import org.example.springboot.service.posts.PostsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model , @LoginUser SessionUser user) {


        model.addAttribute("posts",  postsService.findAllDesc());

        if(user != null) {
            model.addAttribute("myName" , user.getName());
        }

        return "index"; //앞의 경로가 resources/templates 자동으로 붙고 뒤에 .mustache도 자동으로 붙음
    }


    @GetMapping("/posts/save")
    public String postsSave(Model model , @LoginUser SessionUser user) {

        model.addAttribute("myName" , user.getName());

        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id , Model model) {

        model.addAttribute("post" , postsService.findById(id));
        return "posts-update";
    }



}

