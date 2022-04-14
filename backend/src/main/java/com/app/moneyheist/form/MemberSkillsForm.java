package com.app.moneyheist.form;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.Valid;
import java.util.Set;

@Data
@AllArgsConstructor
public class MemberSkillsForm {
    @Valid
    SkillForm mainSkill;

    @Valid
    Set<MemberSkillForm> skills;
}
