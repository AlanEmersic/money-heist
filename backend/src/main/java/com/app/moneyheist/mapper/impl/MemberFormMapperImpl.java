package com.app.moneyheist.mapper.impl;

import com.app.moneyheist.form.MemberForm;
import com.app.moneyheist.mapper.MemberFormMapper;
import com.app.moneyheist.mapper.MemberSkillFormMapper;
import com.app.moneyheist.model.Member;
import com.app.moneyheist.repository.SkillRepository;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class MemberFormMapperImpl implements MemberFormMapper {
    private final MemberSkillFormMapper memberSkillFormMapper;
    private final SkillRepository skillRepository;

    public MemberFormMapperImpl(MemberSkillFormMapper memberSkillFormMapper, SkillRepository skillRepository) {
        this.memberSkillFormMapper = memberSkillFormMapper;
        this.skillRepository = skillRepository;
    }

    @Override
    public Member map(MemberForm memberForm) {
        Member member = new Member();
        member.setName(memberForm.getName());
        member.setSex(memberForm.getSex());
        member.setEmail(memberForm.getEmail());
        member.setStatus(memberForm.getStatus());
        member.setMainSkill(skillRepository.findByNameIgnoreCase(member.getName()));
        member.setMemberSkills(memberForm.getSkills().stream().map(memberSkillFormMapper::map).collect(Collectors.toSet()));

        return member;
    }
}
