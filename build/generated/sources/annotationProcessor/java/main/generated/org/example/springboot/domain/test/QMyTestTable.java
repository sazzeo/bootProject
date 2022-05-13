package org.example.springboot.domain.test;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMyTestTable is a Querydsl query type for MyTestTable
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMyTestTable extends EntityPathBase<MyTestTable> {

    private static final long serialVersionUID = -69302179L;

    public static final QMyTestTable myTestTable = new QMyTestTable("myTestTable");

    public final StringPath bizArea = createString("bizArea");

    public final StringPath dealerUserId = createString("dealerUserId");

    public final StringPath reqDealerId = createString("reqDealerId");

    public final StringPath reqNo = createString("reqNo");

    public QMyTestTable(String variable) {
        super(MyTestTable.class, forVariable(variable));
    }

    public QMyTestTable(Path<? extends MyTestTable> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMyTestTable(PathMetadata metadata) {
        super(MyTestTable.class, metadata);
    }

}

