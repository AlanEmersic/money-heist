package com.app.moneyheist.form;

import com.app.moneyheist.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@AllArgsConstructor
public class MemberForm {
    @NotEmpty
    String name;

    @NotEmpty
    String sex;

    @NotEmpty
    String email;

    @NonNull
    Status status;

    @Valid
    SkillForm mainSkill;

    @Valid
    Set<MemberSkillForm> skills;
}
