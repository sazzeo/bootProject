package org.example.springboot.domain.posts;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPosts is a Querydsl query type for Posts
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPosts extends EntityPathBase<Posts> {

    private static final long serialVersionUID = -292067729L;

    public static final QPosts posts = new QPosts("posts");

    public final org.example.springboot.domain.QBaseTimeEntity _super = new org.example.springboot.domain.QBaseTimeEntity(this);

    public final StringPath author = createString("author");

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDate = _super.createDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final StringPath title = createString("title");

    public QPosts(String variable) {
        super(Posts.class, forVariable(variable));
    }

    public QPosts(Path<? extends Posts> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPosts(PathMetadata metadata) {
        super(Posts.class, metadata);
    }

}

