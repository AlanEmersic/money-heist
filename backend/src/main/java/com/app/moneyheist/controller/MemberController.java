package com.app.moneyheist.controller;

import com.app.moneyheist.dto.MemberDto;
import com.app.moneyheist.facade.MemberFacade;
import com.app.moneyheist.form.MemberForm;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/api/members")
public class MemberController {
    private final MemberFacade memberFacade;

    public MemberController(MemberFacade memberFacade) {
        this.memberFacade = memberFacade;
    }

    @GetMapping("/{id}")
    public MemberDto get(@PathVariable final Long id) {
        return memberFacade.get(id);
    }

    @GetMapping
    public Set<MemberDto> getAll() {
        return memberFacade.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody final MemberForm memberForm) {
        memberFacade.create(memberForm);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final Long id) {
        memberFacade.delete(id);
    }
}
