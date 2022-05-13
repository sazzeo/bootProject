package org.example.springboot.web.validation;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springboot.domain.posts.Posts;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
public class PostsValidation {

    @NotEmpty(message = "제목을 입력하세요.")
    private String title;

    @NotEmpty(message = "내용을 입력하세요.")
    private String content;

    @NotEmpty(message = "작성자를 입력하세요.")
    private String author;


    @Builder
    public PostsValidation(String title, String content, String author) {
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(this.title)
                .content(this.content)
                .author(this.author)
                .build();

    }



}
