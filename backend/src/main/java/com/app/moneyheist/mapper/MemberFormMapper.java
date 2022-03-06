package com.app.moneyheist.mapper;

import com.app.moneyheist.form.MemberForm;
import com.app.moneyheist.model.Member;

public interface MemberFormMapper {
    Member map(MemberForm memberForm);
}
