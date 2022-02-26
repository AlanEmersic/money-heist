package com.app.moneyheist.mapper;

import com.app.moneyheist.dto.MemberSkillDto;
import com.app.moneyheist.model.MemberSkill;

public interface MemberSkillDtoMapper {
    MemberSkillDto map(MemberSkill memberSkill);
}
