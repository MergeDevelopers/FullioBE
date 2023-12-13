package com.merge.fullio.repository;

import com.merge.fullio.DTO.record.CategoryProjectionResDTO;
import com.merge.fullio.model.records.Category;
import com.merge.fullio.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    boolean existsCategoriesByCreatedByAndLocation(User user, int location);

    @Query(value = "SELECT C1.id AS id, C1.name AS name, C1.location AS location, C2.id AS categoryId " +
            "FROM category AS C1 " +
            "LEFT JOIN category AS C2 " +
            "ON C1.category_id = C2.id " +
            "WHERE C1.created_by = :userId " +
            "ORDER BY C1.category_id", nativeQuery = true)
    CategoryProjectionResDTO findProjectionById(long userId);

    boolean existsByCreatedByAndLocationAndCategory(User user, int location, Category category);

    List<Category> findCategoriesByCreatedBy(User user);
    @Query(value = "SELECT C1.id AS id, C1.name AS name, C1.location AS location, C2.id AS categoryId " +
            "FROM category AS C1 " +
            "LEFT JOIN category AS C2 " +
            "ON C1.category_id = C2.id " +
            "WHERE C1.created_by = :userId " +
            "ORDER BY C1.category_id", nativeQuery = true)
    List<CategoryProjectionResDTO> findProjectionCategories(Long userId);

    Long countSubCategoriesByCategoryIdAndCreatedBy(Long categoryId, User user);

}
