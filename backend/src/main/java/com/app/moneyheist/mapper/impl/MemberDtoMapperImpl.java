package com.app.moneyheist.mapper.impl;

import com.app.moneyheist.dto.MemberDto;
import com.app.moneyheist.mapper.MemberDtoMapper;
import com.app.moneyheist.model.Member;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class MemberDtoMapperImpl implements MemberDtoMapper {
    @Override
    public MemberDto map(Member member) {
        if (Objects.isNull(member))
            return null;

        return new MemberDto(member.getId(), member.getName(), member.getSex(), member.getEmail(), member.getStatus(), member.getMainSkill().getId());
    }
}
