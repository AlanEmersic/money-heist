package com.app.moneyheist.mapper;

import com.app.moneyheist.form.MemberSkillsForm;
import com.app.moneyheist.model.Member;

public interface MemberSkillsFormMapper {
    Member map(Member member, MemberSkillsForm memberSkillsForm);
}
