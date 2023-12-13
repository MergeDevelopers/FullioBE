package com.merge.fullio.repository;

import com.merge.fullio.model.records.Category;
import com.merge.fullio.model.records.Records;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecordsRepository extends JpaRepository<Records, Long> {

    List<Records> findAllByCategory(Category category);
}
