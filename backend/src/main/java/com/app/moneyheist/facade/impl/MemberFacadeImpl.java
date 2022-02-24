package com.app.moneyheist.facade.impl;

import com.app.moneyheist.dto.MemberDto;
import com.app.moneyheist.facade.MemberFacade;
import com.app.moneyheist.mapper.MemberDtoMapper;
import com.app.moneyheist.service.MemberService;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MemberFacadeImpl implements MemberFacade {
    private final MemberService memberService;
    private final MemberDtoMapper memberDtoMapper;

    public MemberFacadeImpl(MemberService memberService, MemberDtoMapper memberDtoMapper) {
        this.memberService = memberService;
        this.memberDtoMapper = memberDtoMapper;
    }

    @Override
    public MemberDto get(Long id) {
        return memberDtoMapper.map(memberService.get(id));
    }

    @Override
    public Set<MemberDto> getAll() {
        return memberService.getAll().stream().map(memberDtoMapper::map).collect(Collectors.toSet());
    }
}
