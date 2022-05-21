package org.example.springboot.common.validator;

import org.example.springboot.domain.posts.Posts;

public enum ValidCode {

    POST(Posts.class , "");


    private Class<?> entity;
    private String methodName;


    ValidCode(Class<?> entity, String methodName) {
        this.entity = entity;
        this.methodName = methodName;
    }
}
