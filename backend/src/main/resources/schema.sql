DROP TABLE IF EXISTS Member;
CREATE TABLE Member
(
    id          NUMBER PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(255) UNIQUE,
    sex         VARCHAR(255),
    email       VARCHAR(255),
    status      VARCHAR(45),
    mainSkillId NUMBER
);

DROP TABLE IF EXISTS Skill;
CREATE TABLE Skill
(
    id   NUMBER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255)
);

DROP TABLE IF EXISTS MemberSkill;
CREATE TABLE MemberSkill
(
    id       NUMBER PRIMARY KEY AUTO_INCREMENT,
    memberId NUMBER,
    skillId  NUMBER,
    level    Number DEFAULT 1
);