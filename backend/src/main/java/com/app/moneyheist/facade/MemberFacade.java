package com.app.moneyheist.facade;

import com.app.moneyheist.dto.MemberDto;

import java.util.Set;

public interface MemberFacade {
    MemberDto get(Long id);

    Set<MemberDto> getAll();

}
