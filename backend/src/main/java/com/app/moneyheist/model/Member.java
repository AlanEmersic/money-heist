package com.app.moneyheist.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(unique = true)
    private String name;

    private String sex;

    private String email;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne
    @JoinColumn(name = "mainSkillId", referencedColumnName = "id")
    private Skill mainSkill;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private Set<MemberSkill> memberSkills = new HashSet<>();
}
