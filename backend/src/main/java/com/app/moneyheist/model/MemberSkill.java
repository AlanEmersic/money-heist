package com.app.moneyheist.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class MemberSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    private Long level;

    @ManyToOne
    @JoinColumn(name = "skillId")
    private Skill skill;

    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member member;
}
