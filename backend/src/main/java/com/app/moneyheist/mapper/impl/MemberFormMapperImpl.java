package com.app.moneyheist.mapper.impl;

import com.app.moneyheist.form.MemberForm;
import com.app.moneyheist.mapper.MemberFormMapper;
import com.app.moneyheist.mapper.MemberSkillFormMapper;
import com.app.moneyheist.mapper.SkillFormMapper;
import com.app.moneyheist.model.Member;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class MemberFormMapperImpl implements MemberFormMapper {
    private final MemberSkillFormMapper memberSkillFormMapper;
    private final SkillFormMapper skillFormMapper;

    public MemberFormMapperImpl(MemberSkillFormMapper memberSkillFormMapper, SkillFormMapper skillFormMapper) {
        this.memberSkillFormMapper = memberSkillFormMapper;
        this.skillFormMapper = skillFormMapper;
    }

    @Override
    public Member map(MemberForm memberForm) {
        Member member = new Member();
        member.setName(memberForm.getName());
        member.setSex(memberForm.getSex());
        member.setEmail(memberForm.getEmail());
        member.setStatus(memberForm.getStatus());
        member.setMainSkill(skillFormMapper.map(memberForm.getMainSkill()));
        member.setMemberSkills(memberForm.getSkills().stream().map(memberSkillFormMapper::map).collect(Collectors.toSet()));

        return member;
    }
}
