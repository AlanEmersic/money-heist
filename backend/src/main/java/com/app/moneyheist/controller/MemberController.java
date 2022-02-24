package com.app.moneyheist.controller;

import com.app.moneyheist.dto.MemberDto;
import com.app.moneyheist.facade.MemberFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.Set;

@RestController
@RequestMapping("/api/members")
public class MemberController {
    private final MemberFacade memberFacade;

    public MemberController(MemberFacade memberFacade) {
        this.memberFacade = memberFacade;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberDto> get(@PathVariable Long id) {
        MemberDto dto = memberFacade.get(id);

        if (Objects.isNull(dto))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping
    public Set<MemberDto> getAll() {
        return memberFacade.getAll();
    }
}
