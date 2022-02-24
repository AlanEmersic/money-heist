package com.app.moneyheist.mapper;

import com.app.moneyheist.dto.MemberDto;
import com.app.moneyheist.model.Member;

public interface MemberDtoMapper {
    MemberDto map(Member member);
}
