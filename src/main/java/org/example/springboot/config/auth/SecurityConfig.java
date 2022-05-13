package org.example.springboot.config.auth;

import lombok.RequiredArgsConstructor;
import org.example.springboot.domain.user.Role;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


//스프링 시큐리티 설정파일
@RequiredArgsConstructor
@EnableWebSecurity //스프링 시큐리티 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UsersService customOAuth2UsersService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //h2-console사용
        http.cors().and()
                .csrf().disable()
                .headers().frameOptions().disable()

                //URL별 권한 관리
        .and()
            .authorizeRequests()
            .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll()  //모든사람이 볼 수 있음
            .antMatchers("/api/v1/**").hasRole(Role.USER.name())  //Role을 가진 사람만 들어갈수 있음.
            .anyRequest().authenticated() //설정된 값 이외에 나머지 url


                //로그아웃후 이동하는 주소
        .and()
            .logout()
                 .logoutSuccessUrl("/")

                //소설 로그인 성공시 후속 조치를 진행할 구현체 등록 : customOAuth2UserService
        .and()
            .oauth2Login()
            .userInfoEndpoint()
            .userService(customOAuth2UsersService);

    }

}
