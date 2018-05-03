-- dummy data

use government;
INSERT INTO citizen VALUES ('123456789', 'Bob', 'H', 'Schultz', '2000-01-01', '123 Random St.', password = NULL, prisoner_id = NULL, tax_id = NULL, military_id = NULL, politician_id = NULL);
INSERT INTO citizen VALUES ('112233445', 'Alice', 'K', 'Vida', '1998-05-20', '71 Pilgrim Ave.', password = NULL, prisoner_id = NULL, tax_id = NULL, military_id = NULL, politician_id = NULL);
INSERT INTO citizen VALUES ('987654321', 'Vojtech', 'C', 'Cruyssen', '2002-11-09', '4 Goldfield Rd.', password = NULL, prisoner_id = NULL, tax_id = NULL, military_id = NULL, politician_id = NULL);
INSERT INTO citizen VALUES ('998877665', 'Troy', 'M', 'Idoni', '1960-02-15', '44 Shirley Ave.', password = NULL, prisoner_id = NULL, tax_id = NULL, military_id = NULL, politician_id = NULL);
INSERT INTO citizen VALUES ('192837465', 'Hildegard', 'T', 'Holgersen', '1972-12-05', '99 Bowman St.', password = NULL, prisoner_id = NULL, tax_id = NULL, military_id = NULL, politician_id = NULL);
INSERT INTO citizen VALUES ('987698765', 'Malin', 'S', 'Garnett', '2000-08-04', '123 Random St.', password = NULL, prisoner_id = NULL, tax_id = NULL, military_id = NULL, politician_id = NULL);
INSERT INTO citizen VALUES ('123451234', 'Roydon', 'L', 'Quinn', '1890-04-28', '514 S. Magnolia St.', password = NULL, prisoner_id = NULL, tax_id = NULL, military_id = NULL, politician_id = NULL);
INSERT INTO citizen VALUES ('000001111', 'Octavia', 'A', 'Braddock', '1992-06-03', '51 Oakland St.', password = NULL, prisoner_id = NULL, tax_id = NULL, military_id = NULL, politician_id = NULL);
INSERT INTO citizen VALUES ('999999999', 'Bartholomaios', 'V', 'Arthur', '2005-09-29', '610 Sunnyslope Ave.', password = NULL, prisoner_id = NULL, tax_id = NULL, military_id = NULL, politician_id = NULL);
INSERT INTO citizen VALUES ('111112222', 'Ema', NULL, 'Yonina', '2001-10-03', '834 Fawn Lane', password = NULL, prisoner_id = NULL, tax_id = NULL, military_id = NULL, politician_id = NULL);


INSERT INTO immigrant VALUES ('00001234', 'A-1', '2000-01-02', '2020-12-31', 'Suzanna', 'A', 'Demetria');
INSERT INTO immigrant VALUES ('00002222', 'A-2', '2001-02-09', '2018-06-30', 'Alice', 'K', 'Vida');
INSERT INTO immigrant VALUES ('00003333', 'B-1', '2002-03-08', '2025-01-31', 'Malin', 'S', 'Garnett');
INSERT INTO immigrant VALUES ('00004444', 'B-1', '2003-04-07', '2019-06-30', 'Steinar', 'W', 'Lieberenz');
INSERT INTO immigrant VALUES ('00015555', 'A-1', '2004-05-06', '2021-12-31', 'Patrick', NULL, 'Rolan');

-- alice and malin became citizens
INSERT INTO can_become VALUES ('112233445','00002222');
INSERT INTO can_become VALUES ('987698765','00003333');

-- patrick was deported
INSERT INTO deported VALUES (1);
INSERT INTO can_be VALUES ('00015555', 1);

INSERT INTO government VALUES ('DMV');
INSERT INTO government VALUES ('Police');
INSERT INTO government VALUES ('Courthouse');
INSERT INTO government VALUES ('Prison');

INSERT INTO workforce VALUES (1, 'New Google', NULL);
INSERT INTO workforce VALUES (2, 'Best DMV', 'DMV');
INSERT INTO workforce VALUES (3, 'Superior Court', 'Courthouse');
INSERT INTO workforce VALUES (4, 'Best DMV', 'DMV');
INSERT INTO workforce VALUES (5, 'Brighton Elem', NULL);

UPDATE citizen SET tax_id = 1 WHERE ssn = '123456789';
UPDATE citizen SET tax_id = 2 WHERE ssn = '112233445';
UPDATE citizen SET tax_id = 3 WHERE ssn = '123451234';

INSERT INTO joins VALUES ('00001234', 4);
INSERT INTO joins VALUES ('00004444', 5);

INSERT INTO justice_department VALUES ('Police');
INSERT INTO justice_department VALUES ('Courthouse');

-- Vojtech robbed a bank
INSERT INTO criminal VALUES (1, '3 years', '987654321');
UPDATE citizen SET prisoner_id = 1 WHERE ssn = '987654321';
INSERT INTO imprisons VALUES ('Police', 1);

INSERT INTO politician VALUES ('111111111');
INSERT INTO politician VALUES ('222222222');
INSERT INTO politician VALUES ('333333333');
UPDATE citizen set politician_id = '111111111' WHERE ssn = '123451234';
UPDATE citizen set politician_id = '222222222' WHERE ssn = '999999999';
UPDATE citizen set politician_id = '333333333' WHERE ssn = '111112222';

-- Bartholomaios is head of state
INSERT INTO head_of_state VALUES ('222222222', '2015-2020');

INSERT INTO military_branch VALUES ('1 Thomas Road', '222222222');

INSERT INTO military_personnel  VALUES ('1', '2010-07-20', NULL, 'SFC', '1 Thomas Road');
UPDATE citizen set politician_id = '333333333' WHERE ssn = '000001111';

INSERT INTO law VALUES ('L254-1', 'A really important law.');


