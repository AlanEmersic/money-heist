package com.app.moneyheist.validator;

import com.app.moneyheist.form.MemberForm;
import com.app.moneyheist.form.MemberSkillsForm;

public interface MemberFormValidator {
    void validateCreate(MemberForm form);

    void validateUpdateMemberSkills(MemberSkillsForm form);
}
