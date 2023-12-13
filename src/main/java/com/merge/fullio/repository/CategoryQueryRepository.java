package com.merge.fullio.repository;

import com.merge.fullio.model.records.Category;
import com.merge.fullio.util.Querydsl4RepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryQueryRepository extends Querydsl4RepositorySupport {

    public CategoryQueryRepository() {
        super(Category.class);
    }

    //TODO: 쿼리DSL을 이용한 카테고리 검색
}
