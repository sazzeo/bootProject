package org.example.springboot.web;

import lombok.RequiredArgsConstructor;
import org.example.springboot.service.posts.PostsService;
import org.example.springboot.web.dto.PostsResponseDto;
import org.example.springboot.web.dto.PostsSaveRequestDto;
import org.example.springboot.web.dto.PostsUpdateRequestDto;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor  //자동으로 생성자 주입됨. @AutoWired 와 같은 기능
@RestController
public class PostApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {

        return postsService.save(requestDto);

    }


    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id , @RequestBody PostsUpdateRequestDto requestDto) {

        return postsService.update(id , requestDto);

    }

    @GetMapping("/api/vi/posts/{id}")
    @ResponseBody
    public PostsResponseDto findById (@PathVariable long id) {
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    @ResponseBody
    public Long delete(@PathVariable Long id) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        postsService.delete(id);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        return id;
    }

}
