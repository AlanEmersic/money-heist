package com.app.moneyheist.dto;

import com.app.moneyheist.model.Status;

import java.util.Set;

public record MemberDto(Long id, String name, String sex, String email, Status status,
                        SkillDto mainSkill, Set<MemberSkillDto> skills) {
}
