package com.app.moneyheist.mapper.impl;

import com.app.moneyheist.dto.SkillDto;
import com.app.moneyheist.mapper.SkillDtoMapper;
import com.app.moneyheist.model.Skill;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class SkillDtoMapperImpl implements SkillDtoMapper {
    @Override
    public SkillDto map(Skill skill) {
        if (Objects.isNull(skill))
            return null;

        return new SkillDto(skill.getId(), skill.getName());
    }
}
