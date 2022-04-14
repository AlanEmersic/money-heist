CREATE TABLE IF NOT EXISTS Skill
(
    id   NUMBER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) UNIQUE
);

CREATE TABLE IF NOT EXISTS Member
(
    id          NUMBER PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(255) UNIQUE,
    sex         VARCHAR(2),
    email       VARCHAR(255),
    status      VARCHAR(45),
    mainSkillId NUMBER
);

CREATE TABLE IF NOT EXISTS MemberSkill
(
    id       NUMBER PRIMARY KEY AUTO_INCREMENT,
    memberId NUMBER,
    skillId  NUMBER,
    level    Number DEFAULT 1
);