package com.app.moneyheist.repository;

import com.app.moneyheist.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
    Skill findByNameIgnoreCase(String name);
}
