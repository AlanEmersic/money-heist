package com.app.moneyheist.facade.impl;

import com.app.moneyheist.dto.MemberDto;
import com.app.moneyheist.exception.ApiNotFoundException;
import com.app.moneyheist.facade.MemberFacade;
import com.app.moneyheist.form.MemberForm;
import com.app.moneyheist.form.MemberSkillsForm;
import com.app.moneyheist.mapper.MemberDtoMapper;
import com.app.moneyheist.mapper.MemberFormMapper;
import com.app.moneyheist.mapper.MemberSkillsFormMapper;
import com.app.moneyheist.model.Member;
import com.app.moneyheist.service.MemberService;
import com.app.moneyheist.validator.MemberFormValidator;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MemberFacadeImpl implements MemberFacade {
    private final MemberService memberService;
    private final MemberDtoMapper memberDtoMapper;
    private final MemberFormValidator memberFormValidator;
    private final MemberFormMapper memberFormMapper;
    private final MemberSkillsFormMapper memberSkillFormMapper;

    private static final String MEMBER_NOT_FOUND_TEXT = "Member not found with id ";

    public MemberFacadeImpl(MemberService memberService, MemberDtoMapper memberDtoMapper, MemberFormValidator memberFormValidator,
                            MemberFormMapper memberFormMapper, MemberSkillsFormMapper memberSkillFormMapper) {
        this.memberService = memberService;
        this.memberDtoMapper = memberDtoMapper;
        this.memberFormValidator = memberFormValidator;
        this.memberFormMapper = memberFormMapper;
        this.memberSkillFormMapper = memberSkillFormMapper;
    }

    @Override
    public MemberDto get(Long id) {
        return Optional.ofNullable(memberDtoMapper.map(memberService.get(id))).orElseThrow(() -> new ApiNotFoundException(MEMBER_NOT_FOUND_TEXT + id));
    }

    @Override
    public Set<MemberDto> getAll() {
        return memberService.getAll().stream().map(memberDtoMapper::map).collect(Collectors.toSet());
    }

    @Override
    public void create(MemberForm memberForm) {
        memberFormValidator.validateCreate(memberForm);
        memberService.save(memberFormMapper.map(memberForm));
    }

    @Override
    public void delete(Long id) {
        memberService.delete(Optional.ofNullable(memberService.get(id)).orElseThrow(() -> new ApiNotFoundException(MEMBER_NOT_FOUND_TEXT + id)));
    }

    @Override
    public void updateMemberSkills(Long id, MemberSkillsForm memberSkillForm) {
        Member member = Optional.ofNullable(memberService.get(id)).orElseThrow(() -> new ApiNotFoundException(MEMBER_NOT_FOUND_TEXT + id));
        memberFormValidator.validateUpdateMemberSkills(memberSkillForm);
        memberService.save(memberSkillFormMapper.map(member, memberSkillForm));
    }
}
