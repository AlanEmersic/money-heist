package com.app.moneyheist.repository;

import com.app.moneyheist.model.MemberSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberSkillRepository extends JpaRepository<MemberSkill, Long> {
}
