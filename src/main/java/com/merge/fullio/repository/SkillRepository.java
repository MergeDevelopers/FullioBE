package com.merge.fullio.repository;

import com.merge.fullio.model.strength.Skill;
import com.merge.fullio.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SkillRepository extends JpaRepository<Skill, Long> {

    Optional<Skill> findByCreatedByAndSkillNumber(User user, int number);
}
