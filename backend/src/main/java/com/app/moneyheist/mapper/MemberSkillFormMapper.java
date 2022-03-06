package com.app.moneyheist.mapper;

import com.app.moneyheist.form.MemberSkillForm;
import com.app.moneyheist.model.MemberSkill;

public interface MemberSkillFormMapper {
    MemberSkill map(MemberSkillForm memberSkillForm);
}
