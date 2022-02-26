package com.app.moneyheist.mapper;

import com.app.moneyheist.dto.SkillDto;
import com.app.moneyheist.model.Skill;

public interface SkillDtoMapper {
    SkillDto map(Skill skill);
}
