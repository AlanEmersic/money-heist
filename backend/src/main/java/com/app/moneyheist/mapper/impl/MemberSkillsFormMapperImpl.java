package com.app.moneyheist.mapper.impl;

import com.app.moneyheist.form.MemberSkillsForm;
import com.app.moneyheist.mapper.MemberSkillFormMapper;
import com.app.moneyheist.mapper.MemberSkillsFormMapper;
import com.app.moneyheist.model.Member;
import com.app.moneyheist.repository.SkillRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

@Component
public class MemberSkillsFormMapperImpl implements MemberSkillsFormMapper {
    private final MemberSkillFormMapper memberSkillFormMapper;
    private final SkillRepository skillRepository;

    public MemberSkillsFormMapperImpl(MemberSkillFormMapper memberSkillFormMapper, SkillRepository skillRepository) {
        this.memberSkillFormMapper = memberSkillFormMapper;
        this.skillRepository = skillRepository;
    }

    @Override
    @Transactional
    public Member map(Member member, MemberSkillsForm memberSkillsForm) {
        member.setMainSkill(skillRepository.findByNameIgnoreCase(memberSkillsForm.getMainSkill().getName()));
        member.getMemberSkills().clear();
        member.getMemberSkills().addAll(memberSkillsForm.getSkills().stream().map(memberSkillFormMapper::map).collect(Collectors.toSet()));

        return member;
    }
}
