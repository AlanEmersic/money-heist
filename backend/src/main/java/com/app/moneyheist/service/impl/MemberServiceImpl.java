package com.app.moneyheist.service.impl;

import com.app.moneyheist.model.Member;
import com.app.moneyheist.repository.MemberRepository;
import com.app.moneyheist.service.MemberService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member get(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Member> getAll() {
        return new HashSet<>(memberRepository.findAll());
    }
}
