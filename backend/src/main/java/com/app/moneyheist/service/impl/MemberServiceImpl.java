package com.app.moneyheist.service.impl;

import com.app.moneyheist.model.Member;
import com.app.moneyheist.repository.MemberRepository;
import com.app.moneyheist.repository.MemberSkillRepository;
import com.app.moneyheist.service.MemberService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final MemberSkillRepository memberSkillRepository;

    public MemberServiceImpl(MemberRepository memberRepository, MemberSkillRepository memberSkillRepository) {
        this.memberRepository = memberRepository;
        this.memberSkillRepository = memberSkillRepository;
    }

    @Override
    public Member get(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    @Override
    public Member getByName(String name) {
        return memberRepository.findByNameIgnoreCase(name);
    }

    @Override
    public Set<Member> getAll() {
        return new HashSet<>(memberRepository.findAll());
    }

    @Override
    @Transactional
    public void save(Member member) {
        memberRepository.save(member);

        member.getMemberSkills().forEach(memberSkill -> {
            memberSkill.setMember(member);
            memberSkillRepository.save(memberSkill);
        });
    }

    @Override
    public void delete(Member member) {
        memberRepository.delete(member);
    }
}
