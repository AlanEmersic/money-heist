DELETE FROM MemberSkill;
DELETE FROM Member;
DELETE FROM Skill;

INSERT INTO Skill (name)
VALUES ('leadership');
INSERT INTO Skill (name)
VALUES ('combat');
INSERT INTO Skill (name)
VALUES ('money-laundering');
INSERT INTO Skill (name)
VALUES ('driving');

INSERT INTO Member (name, sex, email, mainSkillId, status)
VALUES ('Berlin', 'M', 'berlin@gmail.com', 1, 'AVAILABLE');
INSERT INTO Member (name, sex, email, mainSkillId, status)
VALUES ('Denver', 'M', 'denver@gmail.com', 3, 'AVAILABLE');

INSERT INTO MemberSkill (memberId, skillId, level)
VALUES (1, 1, 5);
INSERT INTO MemberSkill (memberId, skillId, level)
VALUES (1, 2, 3);
INSERT INTO MemberSkill (memberId, skillId)
VALUES (2, 3);