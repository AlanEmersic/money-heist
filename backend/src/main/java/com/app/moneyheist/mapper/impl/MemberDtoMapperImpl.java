package com.app.moneyheist.mapper.impl;

import com.app.moneyheist.dto.MemberDto;
import com.app.moneyheist.mapper.MemberDtoMapper;
import com.app.moneyheist.mapper.MemberSkillDtoMapper;
import com.app.moneyheist.mapper.SkillDtoMapper;
import com.app.moneyheist.model.Member;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class MemberDtoMapperImpl implements MemberDtoMapper {
    private final MemberSkillDtoMapper memberSkillDtoMapper;
    private final SkillDtoMapper skillDtoMapper;

    public MemberDtoMapperImpl(MemberSkillDtoMapper memberSkillDtoMapper, SkillDtoMapper skillDtoMapper) {
        this.memberSkillDtoMapper = memberSkillDtoMapper;
        this.skillDtoMapper = skillDtoMapper;
    }

    @Override
    public MemberDto map(Member member) {
        if (Objects.isNull(member))
            return null;

        return new MemberDto(member.getId(), member.getName(), member.getSex(), member.getEmail(), member.getStatus(),
                skillDtoMapper.map(member.getMainSkill().getSkill()),
                member.getMemberSkills().stream().map(memberSkillDtoMapper::map).collect(Collectors.toSet()));
    }
}
