package org.example.springboot.service.posts;


import lombok.RequiredArgsConstructor;
import org.example.springboot.common.code.ResponseCode;
import org.example.springboot.common.exception.HandleableException;
import org.example.springboot.domain.posts.Posts;
import org.example.springboot.domain.posts.PostsRepository;
import org.example.springboot.web.dto.PostsListResponseDto;
import org.example.springboot.web.dto.PostsResponseDto;
import org.example.springboot.web.dto.PostsSaveRequestDto;
import org.example.springboot.web.dto.PostsUpdateRequestDto;
import org.example.springboot.web.validation.PostsValidation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsValidation requestDto) {

        return postsRepository.save(requestDto.toEntity()).getId();

    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {

        //해당 게시글이 있는지 없는지 찾기
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new HandleableException(ResponseCode.BAD_REQUEST));

        posts.update(requestDto.getTitle(), requestDto.getContent());  //update 메소드

        return id;
    }

    @Transactional
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new HandleableException(ResponseCode.BAD_REQUEST));

        return new PostsResponseDto(entity);

    }


    //모든 데이터 select
    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {

        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());


    }

    @Transactional
    public void delete(Long id) {

        postsRepository.findById(id)
                .orElseThrow(() -> new HandleableException(ResponseCode.DELETE));
        postsRepository.deleteById(id);

    }
}



