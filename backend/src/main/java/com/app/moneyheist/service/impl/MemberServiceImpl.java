package com.app.moneyheist.service.impl;

import com.app.moneyheist.model.Member;
import com.app.moneyheist.model.Skill;
import com.app.moneyheist.repository.MemberRepository;
import com.app.moneyheist.repository.MemberSkillRepository;
import com.app.moneyheist.repository.SkillRepository;
import com.app.moneyheist.service.MemberService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final MemberSkillRepository memberSkillRepository;
    private final SkillRepository skillRepository;

    public MemberServiceImpl(MemberRepository memberRepository, MemberSkillRepository memberSkillRepository, SkillRepository skillRepository) {
        this.memberRepository = memberRepository;
        this.memberSkillRepository = memberSkillRepository;
        this.skillRepository = skillRepository;
    }

    @Override
    public Member get(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Member> getAll() {
        return new HashSet<>(memberRepository.findAll());
    }

    @Override
    @Transactional
    public void save(Member member) {
        Skill mainSkill = skillRepository.findByNameIgnoreCase(member.getMainSkill().getName());
        member.setMainSkill(mainSkill);
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
