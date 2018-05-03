-- create the government DB if it does not exist and set it to current DB context

drop database if exists government;
create database government;
use government;

CREATE TABLE citizen (
	ssn				char(9),
    first_name		varchar(15),
    middle_initial	varchar(1) NULL,
    last_name		varchar(15),
    birth_date		date,
    address			varchar(50),
    password		varchar(5) NULL,
    primary key (ssn)
);

CREATE TABLE immigrant (
	visa_number		char(8),
    visa_type		varchar(4),
    date_issued		date,
    expiration_date	date,
    first_name		varchar(15),
    middle_initial	char(1),
    last_name		varchar(15),
    primary key (visa_number)
);

CREATE TABLE can_become (
	ssn			char(9),
    visa_number	char(8),
    primary key (ssn, visa_number),
    foreign key (ssn) references citizen(ssn)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
    foreign key (visa_number) references immigrant(visa_number)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);

CREATE TABLE deported (
	deporation_id	integer,
    primary key (deporation_id)
);

CREATE TABLE can_be (
	visa_number		char(8),
    deporation_id	integer,
    primary key (visa_number, deporation_id),
    foreign key (visa_number) references immigrant(visa_number)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
    foreign key (deporation_id) references deported(deporation_id)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);


CREATE TABLE government (
	department_id	varchar(15),
    primary key (department_id)
    
);

CREATE TABLE workforce (
	tax_id			integer,
    employer		varchar(15),
    ssn				char(9),
    department_id	varchar(15),
    primary key (tax_id),
    foreign key (ssn) references citizen(ssn)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
	foreign key (department_id) references government(department_id)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);

CREATE TABLE joins (
	visa_number	char(8),
    tax_id		integer,
    primary key (visa_number, tax_id),
    foreign key (visa_number) references immigrant(visa_number)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
    foreign key (tax_id) references workforce(tax_id)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);

CREATE TABLE justice_department (
	department_id	varchar(15),
    primary key (department_id),
    foreign key (department_id) references government(department_id)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);

-- sentence can be something like '10 years' or '6 months'
CREATE TABLE criminal (
	prisoner_id	integer,
    sentence	varchar(10),
    ssn			varchar(9),
    primary key (prisoner_id),
    foreign key (ssn) references citizen(ssn)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);

CREATE TABLE imprisons (
	department_id	varchar(15),
    prisoner_id		integer,
    primary key (department_id, prisoner_id),
    foreign key (department_id) references justice_department(department_id)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
    foreign key (prisoner_id) references criminal(prisoner_id)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);

CREATE TABLE politician (
	politician_id	varchar(9),
    ssn				char(9),
    primary key (politician_id),
    foreign key (ssn) references citizen(ssn)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);

CREATE TABLE head_of_state (
	politician_id	varchar(9),
    term			char(9),
    primary key (politician_id),
    foreign key (politician_id) references politician(politician_id)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);

CREATE TABLE votes_for (
	ssn				char(9),
	politician_id	varchar(9),
    primary key (ssn, politician_id),
    foreign key (ssn) references citizen(ssn)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
    foreign key (politician_id) references politician(politician_id)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);

-- term format '2000-2004'
CREATE TABLE senator (
	politician_id	varchar(9),
    state			varchar(15),
    term			char(9),		
    primary key (politician_id),
    foreign key (politician_id) references politician(politician_id)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);

CREATE TABLE military_branch (
	hq_address		varchar(50),
    politician_id	varchar(9),
    primary key (hq_address),
    foreign key (politician_id) references head_of_state(politician_id)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);

CREATE TABLE military_personnel (
	military_id	varchar(9),
    start_date	date,
    end_date	date,
    rank		varchar(10),
    hq_address	varchar(50),
    primary key (military_id),
    foreign key (hq_address) references military_branch(hq_address)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);

CREATE TABLE airforce (
	hq_address	varchar(50),
    plane_type	varchar(20),
    primary key (hq_address),
    foreign key (hq_address) references military_branch(hq_address)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);

CREATE TABLE navy (
	hq_address	varchar(50),
    ship_type	varchar(20),
    primary key (hq_address),
    foreign key (hq_address) references military_branch(hq_address)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);

CREATE TABLE army (
	hq_address	varchar(50),
    tank_type	varchar(20),
    primary key (hq_address),
    foreign key (hq_address) references military_branch(hq_address)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);

CREATE TABLE bill (
	bill_id		varchar(10),
    description	varchar(100),
    primary key (bill_id)
);

CREATE TABLE writes (
	politician_id	varchar(9),
    bill_id			varchar(10),
    primary key (politician_id, bill_id),
    foreign key (politician_id) references politician(politician_id)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
    foreign key (bill_id) references bill(bill_id)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);

CREATE TABLE votes_on (
	politician_id	varchar(9),
    bill_id			varchar(10),
    primary key (politician_id, bill_id),
    foreign key (politician_id) references politician(politician_id)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
    foreign key (bill_id) references bill(bill_id)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);

CREATE TABLE law (
	law_id		varchar(10),
    description	varchar(100),
    primary key (law_id)
);

CREATE TABLE follows (
	department_id	varchar(15),
    law_id			varchar(10),
    primary key (department_id, law_id),
    foreign key (department_id) references justice_department(department_id)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
    foreign key (law_id) references law(law_id)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);

CREATE TABLE gets_passed (
	bill_id		varchar(10),
    law_id		varchar(10),
    primary key (bill_id, law_id),
    foreign key (bill_id) references bill(bill_id)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
	foreign key (law_id) references law(law_id)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);

ALTER TABLE citizen
ADD COLUMN prisoner_id 		integer,
ADD COLUMN tax_id 			integer,
ADD COLUMN military_id 		varchar(9),
ADD COLUMN politician_id 	varchar(9),
ADD foreign key (prisoner_id) references criminal(prisoner_id),
ADD foreign key (tax_id) references workforce(tax_id),
ADD foreign key (military_id) references military_personnel(military_id),
ADD foreign key (politician_id) references politician(politician_id);
