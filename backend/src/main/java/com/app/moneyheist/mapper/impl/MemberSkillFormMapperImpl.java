package com.app.moneyheist.mapper.impl;

import com.app.moneyheist.form.MemberSkillForm;
import com.app.moneyheist.mapper.MemberSkillFormMapper;
import com.app.moneyheist.model.MemberSkill;
import com.app.moneyheist.model.Skill;
import com.app.moneyheist.repository.SkillRepository;
import org.springframework.stereotype.Component;

@Component
public class MemberSkillFormMapperImpl implements MemberSkillFormMapper {
    private final SkillRepository skillRepository;

    public MemberSkillFormMapperImpl(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Override
    public MemberSkill map(MemberSkillForm memberSkillForm) {
        MemberSkill memberSkill = new MemberSkill();
        memberSkill.setLevel(memberSkillForm.getLevel());
        Skill skill = skillRepository.findByNameIgnoreCase(memberSkillForm.getName());
        memberSkill.setSkill(skill);

        return memberSkill;
    }
}
