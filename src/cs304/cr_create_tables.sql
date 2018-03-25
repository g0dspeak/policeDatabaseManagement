create table Officer (
  2  ID integer not null,
  3  Address char(30) not null,
  4  Name char(20) not null,
  5  Access_date date not null,
  6  primary key(ID));

create table Record (
  2  ID char(7) not null,
  3  Description char(100) not null,
  4  Case_date char(11) not null,
  5  primary key (ID));

create table Charge (
  2  OfficerID integer not null,
  3  recordID char(7) not null,
  4  primary key (officerID, recordID),
  5  foreign key (officerID) references Officer);

create table People(
  2  PhoneNumber char(15) not null,
  3  SIN integer not null,
  4  Name char(20) not null,
  5  Address char(20) not null,
  6  primary key (SIN));

create table Court (
  2  RecordID char(7) not null,        
  3  CourtID integer not null,
  4  Judge char(20) not null,
  5  Description char(300) not null,
  6  Result char(300) not null,
  7  Hearing char(11) not null,
  8  primary key (CourtID),
  9  foreign key (RecordID) references Record);

create table CriminalType (
  2  TypeName char(10) not null,
  3  Frequency integer not null,
  4  primary key (TypeName));

 
create table CriminalRecordType (
  2  RecordID char(7) not null,
  3  TypeName char(10) not null,
  4  primary key (RecordID, TypeName),
  5  foreign key (RecordID) references Record,
  6  foreign key (TypeName) references CriminalType);

create table PeopleInvolved (
  2  RecordID char(7) not null,
  3  SIN integer not null,
  4  primary key(RecordID, SIN),
  5  foreign key (RecordID) references Record,
  6  foreign key (SIN) references People); 


commit;

