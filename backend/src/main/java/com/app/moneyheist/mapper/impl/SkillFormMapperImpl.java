package com.app.moneyheist.mapper.impl;

import com.app.moneyheist.form.SkillForm;
import com.app.moneyheist.mapper.SkillFormMapper;
import com.app.moneyheist.model.Skill;
import org.springframework.stereotype.Component;

@Component
public class SkillFormMapperImpl implements SkillFormMapper {
    @Override
    public Skill map(SkillForm skillForm) {
        Skill skill = new Skill();
        skill.setName(skillForm.getName());

        return skill;
    }
}
