package com.app.moneyheist.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class SkillForm {
    @NotEmpty
    String name;
}
