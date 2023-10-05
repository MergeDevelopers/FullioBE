package com.merge.fullio.repository;

import com.merge.fullio.model.record.Category;
import com.merge.fullio.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByCreatedBy(User user);

    Optional<Category> findById(long id);

    //TODO: 쿼리DSL로 수정하지 않으면 할 수 없나?
    Optional<Category> findByCreatedByAndLocationAndSubCategoriesIsEmpty(User user, int location);

//    Optional<Category> findByCreatedByAndCategoryAndLocation(User user, Long id, int location);
}
