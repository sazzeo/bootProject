package org.example.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {

        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("jee@naver.com")
                .build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);


    }


    //시간 자동 저장되는지 테스트하기
    @Test
    public void BastTimeTest() {

        //포스트 저장
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());


        //포스트 찾기
        List<Posts> postsList = postsRepository.findAll();

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(postsList.get(0).getCreateDate());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>");


    }


}
