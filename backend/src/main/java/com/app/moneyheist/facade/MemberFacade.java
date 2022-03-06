package com.app.moneyheist.facade;

import com.app.moneyheist.dto.MemberDto;
import com.app.moneyheist.form.MemberForm;

import java.util.Set;

public interface MemberFacade {
    MemberDto get(Long id);

    Set<MemberDto> getAll();

    void create(MemberForm memberForm);

    void delete(Long id);
}
