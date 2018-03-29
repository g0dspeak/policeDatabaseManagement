create table Officer
( Address char(30) not null,
    ID Integer not null, 
    Name char(25) not null, 
    Hired char(10) not null,
    PRIMARY KEY (ID) );

create table Record
( ID char(7) not null,
    Description char(100) not null, 
    Case_date char(10) not null,
    PRIMARY KEY (ID) );

create table People
( PhoneNumber char(15) not null,
    SIN integer not null,
    Name char(25) not null,
    Address char(25) not null,
    Age integer not null,
    PRIMARY KEY (SIN) );

create table CriminalType
( TypeName char(10) not null,
    PRIMARY KEY (TypeName) );

create table Court 
( RecordID char(7) not null,
    CourtID integer not null,
    Judge char(25) not null,
    Description char(300) not null,
    Result char(10) not null,
    Hearing char(10) not null,  
    PRIMARY KEY (CourtID),
    foreign key (RecordID) references Record on delete cascade);

create table CriminalRecordType 
( RecordID char(7) not null, 
    TypeName char(15) not null, 
    PRIMARY KEY (RecordID), 
    foreign key (RecordID) references Record on delete cascade, 
    foreign key (TypeName) references CriminalType on delete cascade);

create table peopleInvolved
( recordID    char(7) not null,
    Sin        INTEGER not null,
    Primary key(recordID, Sin),
    foreign key (recordID) references Record(ID) on delete cascade,
    foreign key (Sin) references people(SIN) on delete cascade);

create table Charge
( officerID integer not null,
    recordID char(7) not null, 
    PRIMARY KEY (officerID, recordID),
    foreign key (officerID) references Officer(ID) on delete cascade,
    foreign key (recordID) references Record(ID) on delete cascade);
    
create table Victim (
SIN integer not null,
primary key (SIN),
foreign key (SIN) references People(SIN) on delete cascade);

create table Suspect (
SIN integer not null,
primary key (SIN),
foreign key (SIN) references People(SIN) on delete cascade);

