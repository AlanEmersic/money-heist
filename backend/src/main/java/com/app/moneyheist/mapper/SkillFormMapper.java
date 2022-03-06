package com.app.moneyheist.mapper;

import com.app.moneyheist.form.SkillForm;
import com.app.moneyheist.model.Skill;

public interface SkillFormMapper {
    Skill map(SkillForm skillForm);
}
