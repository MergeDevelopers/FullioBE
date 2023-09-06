package com.merge.fullio.repository;

import com.merge.fullio.model.strength.Strength;
import com.merge.fullio.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StrengthRepository extends JpaRepository<Strength, Long> {

    Optional<Strength> findByCreatedBy(User user);
}
