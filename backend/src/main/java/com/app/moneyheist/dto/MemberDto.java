package com.app.moneyheist.dto;

import com.app.moneyheist.model.Status;

public record MemberDto(Long id, String name, String sex, String email, Status status, Long mainSkillId) {
}
