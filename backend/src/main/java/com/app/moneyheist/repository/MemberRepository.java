package com.app.moneyheist.repository;

import com.app.moneyheist.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
    Member findByNameIgnoreCase(String name);
}
