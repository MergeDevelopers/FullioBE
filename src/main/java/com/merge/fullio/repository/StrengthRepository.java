package com.merge.fullio.repository;

import com.merge.fullio.model.strength.Strength;
import com.merge.fullio.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StrengthRepository extends JpaRepository<Strength, Long> {

    Optional<Strength> findByCreatedBy(User user);

    boolean existsByCreatedBy(User user);

    @Query(value = "SELECT COUNT(*) = 0 FROM strength AS s " +
            "WHERE " +
            "(s.strength_1 IS NULL AND s.strength_2 IS NULL AND s.strength_3 IS NULL AND s.strength_4 IS NULL AND s.strength_5 IS NULL) " +
            "AND s.createdby = :user", nativeQuery = true)
    boolean existsStrengthByCreatedBy(User user);
}
