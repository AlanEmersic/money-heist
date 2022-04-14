package com.app.moneyheist.repository;

import com.app.moneyheist.model.MemberSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberSkillRepository extends JpaRepository<MemberSkill, Long> {
    @Query("delete from MemberSkill ms where ms.member.id = :id")
    @Modifying
    void deleteAllByMemberId(Long id);
}
