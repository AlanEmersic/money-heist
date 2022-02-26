package com.app.moneyheist.mapper.impl;

import com.app.moneyheist.dto.MemberSkillDto;
import com.app.moneyheist.mapper.MemberSkillDtoMapper;
import com.app.moneyheist.model.MemberSkill;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class MemberSkillDtoMapperImpl implements MemberSkillDtoMapper {
    @Override
    public MemberSkillDto map(MemberSkill memberSkill) {
        if (Objects.isNull(memberSkill))
            return null;

        return new MemberSkillDto(memberSkill.getId(), memberSkill.getLevel(), memberSkill.getSkill().getName());
    }
}
