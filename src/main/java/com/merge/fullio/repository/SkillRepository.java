package com.merge.fullio.repository;

import com.merge.fullio.model.skill.Skill;
import com.merge.fullio.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SkillRepository extends JpaRepository<Skill, Integer> {

    Optional<Skill> findByCreatedBy(User user);
}
