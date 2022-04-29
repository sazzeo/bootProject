package org.example.springboot.config.auth;

import lombok.RequiredArgsConstructor;
import org.example.springboot.config.auth.dto.SessionUser;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Component
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {

    private final HttpSession httpSession;

    //파라미터에 @LoginUser어노테이션이 붙어 있고, 파라미터 클래스 타입이 SessionUser.class인 경우 true를 반환함.
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        //파라미터 어노테이션인 로그인유저클래스의 파라미터들을 가져온다.
        boolean isLoginUserAnnotaion = parameter.getParameterAnnotation(LoginUser.class) !=null;
        boolean isUserClass = SessionUser.class.equals(parameter.getParameterType());
        return isLoginUserAnnotaion && isUserClass;

    }

    //위가 true일경우 전달됨
    //파라미터에 전달할 객체를 생성한다
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        return httpSession.getAttribute("user");
    }
}
