package com.app.moneyheist.service;

import com.app.moneyheist.model.Member;

import java.util.Set;

public interface MemberService {

    Member get(Long id);

    Member getByName(String name);

    Set<Member> getAll();

    void save(Member member);

    void delete(Member member);
}
