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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "skill", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MemberSkill> memberSkills = new HashSet<>();
}
