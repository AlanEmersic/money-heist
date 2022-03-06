package com.app.moneyheist.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class MemberSkillForm {
    @NotEmpty
    String name;

    @NotNull
    @Positive
    Long level;
}
