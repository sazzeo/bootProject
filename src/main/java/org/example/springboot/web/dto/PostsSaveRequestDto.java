package org.example.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springboot.domain.posts.Posts;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String author;



    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .title(content)
                .author(author)
                .build();

    }


}
