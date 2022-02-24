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
public class Skill {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "skill", cascade = CascadeType.ALL)
    private Set<MemberSkill> memberSkills = new HashSet<>();
}
