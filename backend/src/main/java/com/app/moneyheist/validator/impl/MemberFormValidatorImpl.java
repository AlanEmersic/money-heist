package com.app.moneyheist.validator.impl;

import com.app.moneyheist.exception.MemberValidationException;
import com.app.moneyheist.form.MemberForm;
import com.app.moneyheist.form.MemberSkillForm;
import com.app.moneyheist.form.SkillForm;
import com.app.moneyheist.form.MemberSkillsForm;
import com.app.moneyheist.model.Member;
import com.app.moneyheist.service.MemberService;
import com.app.moneyheist.validator.MemberFormValidator;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class MemberFormValidatorImpl implements MemberFormValidator {
    private final MemberService memberService;

    public MemberFormValidatorImpl(MemberService memberService) {
        this.memberService = memberService;
    }

    @Override
    public void validateCreate(MemberForm form) {
        Set<Member> members = memberService.getAll();

        boolean isMemberCreated = members.stream().anyMatch(member -> member.getName().equals(form.getName()));

        if (isMemberCreated)
            throw new MemberValidationException("Member with same name exists!");

        checkMemberSkillsConstraints(form.getSkills(), form.getMainSkill());
    }

    @Override
    public void validateUpdateMemberSkills(MemberSkillsForm form) {
        checkMemberSkillsConstraints(form.getSkills(), form.getMainSkill());
    }

    private void checkMemberSkillsConstraints(Set<MemberSkillForm> formSkills, SkillForm formMainSkill) {
        Set<String> skills = new HashSet<>();
        formSkills.forEach(memberSkillForm -> {
            if (!skills.add(memberSkillForm.getName()))
                throw new MemberValidationException("Can't have duplicate skills!");
        });

        if (!skills.contains(formMainSkill.getName())) {
            throw new MemberValidationException("Main skill must be in skills!");
        }
    }
}
