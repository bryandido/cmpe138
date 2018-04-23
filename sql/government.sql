-- 1. drop the database government if it exists
-- 2. create the database government
-- 3. set the current DB context to the newly created database, and then execute the DDL statements.

drop database if exists government;
create database government;
use government;

-- TODO: Decide which tables would require on delete/on update cascade/null options
CREATE TABLE citizen (
	ssn				char(9),
    first_name		varchar(15),
    middle_initial	char(1),
    last_name		varchar(15),
    birth_date		date,
    address			varchar(50),
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

-- is the foreign key setting right?
CREATE TABLE can_become (
	ssn			char(9),
    visa_number	char(8),
    primary key (ssn, visa_number),
    foreign key (ssn) references citizen(ssn) ON DELETE CASCADE,
    foreign key (visa_number) references immigrant(visa_number) ON DELETE CASCADE
);

CREATE TABLE deported (
	deporation_id	varchar(8),
    primary key (deporation_id)
);

CREATE TABLE can_be (
	visa_number		char(8),
    deporation_id	varchar(8),
    primary key (visa_number, deporation_id),
    foreign key (deporation_id) references deported(deporation_id)
);

CREATE TABLE workforce (
	tax_id		integer,
    employer	varchar(15),
    ssn			char(9),
    primary key (tax_id),
    foreign key (ssn) references citizen(ssn)
);

CREATE TABLE joins (
	visa_number	char(8),
    tax_id		integer,
    primary key (visa_number, tax_id),
    foreign key (visa_number) references immigrant(visa_number),
    foreign key (tax_id) references workforce(tax_id)
);

CREATE TABLE government (
	department_id	varchar(15),
    tax_id			integer,
    primary key (department_id),
    foreign key (tax_id) references workforce (tax_id)
);

CREATE TABLE justice_department (
	department_id	varchar(15),
    position		varchar(15),
    primary key (department_id),
    foreign key (department_id) references government(department_id)
);

CREATE TABLE criminal (
	prisoner_id	integer,
    sentence	varchar(10),
    ssn			varchar(9),
    primary key (prisoner_id),
    foreign key (ssn) references citizen(ssn)
);

CREATE TABLE imprisons (
	department_id	varchar(15),
    prisoner_id		integer,
    primary key (department_id, prisoner_id),
    foreign key (department_id) references justice_department(department_id),
    foreign key (prisoner_id) references criminal(prisoner_id)
);

CREATE TABLE military_personnel (
	military_id	varchar(9),
    start_date	date,
    end_date	date,
    rank		varchar(10),
    ssn			varchar(9),
    primary key (military_id),
    foreign key (ssn) references citizen(ssn)
);

CREATE TABLE military_branch (
	hq_address	varchar(50),
    military_id	varchar(9),
    primary key (hq_address),
    foreign key (military_id) references military_personnel(military_id)
);

CREATE TABLE airforce (
	hq_address	varchar(50),
    plane_type	varchar(20),
    primary key (hq_address),
    foreign key (hq_address) references military_branch(hq_address)
);

CREATE TABLE navy (
	hq_address	varchar(50),
    ship_type	varchar(20),
    primary key (hq_address),
    foreign key (hq_address) references military_branch(hq_address)
);

CREATE TABLE army (
	hq_address	varchar(50),
    tank_type	varchar(20),
    primary key (hq_address),
    foreign key (hq_address) references military_branch(hq_address)
);

CREATE TABLE politician (
	politician_id	varchar(9),
    primary key (politician_id)
);

CREATE TABLE is_elected (
	ssn				char(9),
    politician_id	varchar(9),
    primary key (ssn, politician_id),
    foreign key (ssn) references citizen(ssn),
    foreign key (politician_id) references politician(politician_id)
);

CREATE TABLE vote_for (
	ssn				char(9),
	politician_id	varchar(9),
    primary key (ssn, politician_id),
    foreign key (ssn) references citizen(ssn),
    foreign key (politician_id) references politician(politician_id)
);

-- term format '2000-2004'
CREATE TABLE senator (
	politician_id	varchar(9),
    state			varchar(15),
    term			char(9),		
    primary key (politician_id)
);

CREATE TABLE bill (
	bill_id	integer,
    primary key (bill_id)
);

CREATE TABLE writes (
	politician_id	varchar(9),
    bill_id			integer,
    primary key (politician_id, bill_id),
    foreign key (politician_id) references politician(politician_id),
    foreign key (bill_id) references bill(bill_id)
);

CREATE TABLE vote_on (
	politician_id	varchar(9),
    bill_id			integer,
    primary key (politician_id, bill_id),
    foreign key (politician_id) references politician(politician_id),
    foreign key (bill_id) references bill(bill_id)
);

-- do we need something to seperate politician and head_of_state??
CREATE TABLE head_of_state (
	politician_id	varchar(9),
    term			char(9),
    primary key (politician_id)
);

CREATE TABLE law (
	law_id		varchar(10),
    description	varchar(100),
    bill_id	integer,
    primary key (law_id),
    foreign key (bill_id) references bill(bill_id)
);

CREATE TABLE follows (
	department_id	varchar(15),
    bill_id			integer,
    primary key (department_id, bill_id),
    foreign key (department_id) references justice_department(department_id),
    foreign key (bill_id) references bill(bill_id)
);
