--@formatter:off

create sequence CLUBMEMBERID_SEQ start with 1 increment by 1;

-- Test data for clubMembers
INSERT INTO CLUBMEMBER (CLUBMEMBERID, CLUBMEMBER_NAME, CLUBMEMBER_ADRESS, CLUBMEMBER_BIRTHDAY, ENTRANCE_DATE, TERMINATION_DATE, EXIT_DATE, MEMBERSHIP_TYPE, ANNUAL_FEE, IBAN) VALUES (CLUBMEMBERID_SEQ.nextval, 'Peter', 'Hamburgerstr. 10, 25335 Elmshorn', '1960-01-01', '2020-09-01', null, null, 'Vollmitglied', 25, 'DE21392323023');
INSERT INTO CLUBMEMBER (CLUBMEMBERID, CLUBMEMBER_NAME, CLUBMEMBER_ADRESS, CLUBMEMBER_BIRTHDAY, ENTRANCE_DATE, TERMINATION_DATE, EXIT_DATE, MEMBERSHIP_TYPE, ANNUAL_FEE, IBAN) VALUES (CLUBMEMBERID_SEQ.nextval, 'Frank', 'Sandwichrstr. 82, 25337 Flensburg', '1970-01-01', '2020-09-01', null,null, 'Ermaessigt', 23, 'DE92938128');
INSERT INTO CLUBMEMBER (CLUBMEMBERID, CLUBMEMBER_NAME, CLUBMEMBER_ADRESS, CLUBMEMBER_BIRTHDAY, ENTRANCE_DATE, TERMINATION_DATE, EXIT_DATE, MEMBERSHIP_TYPE, ANNUAL_FEE, IBAN) VALUES (CLUBMEMBERID_SEQ.nextval, 'Max', 'Hauptstr. 94, 37182 Aachen', '1970-01-01', '2020-09-01', null, null, 'Vollmitglied', 25, 'DE92938128');
INSERT INTO CLUBMEMBER (CLUBMEMBERID, CLUBMEMBER_NAME, CLUBMEMBER_ADRESS, CLUBMEMBER_BIRTHDAY, ENTRANCE_DATE, TERMINATION_DATE, EXIT_DATE, MEMBERSHIP_TYPE, ANNUAL_FEE, IBAN) VALUES (CLUBMEMBERID_SEQ.nextval, 'Franzi', 'Dorfstr. 2, 37182 ', '1970-01-01', '2020-09-01', null,null, 'Jugendlich', 15, 'DE92938128');
INSERT INTO CLUBMEMBER (CLUBMEMBERID, CLUBMEMBER_NAME, CLUBMEMBER_ADRESS, CLUBMEMBER_BIRTHDAY, ENTRANCE_DATE, TERMINATION_DATE, EXIT_DATE, MEMBERSHIP_TYPE, ANNUAL_FEE, IBAN) VALUES (CLUBMEMBERID_SEQ.nextval, 'Marc', 'Snapchatstr. 32, 25337 Berlin', '1970-01-01', '2020-04-03', null,null, 'Foerdermitglied', 10, 'DE92938128');
INSERT INTO CLUBMEMBER (CLUBMEMBERID, CLUBMEMBER_NAME, CLUBMEMBER_ADRESS, CLUBMEMBER_BIRTHDAY, ENTRANCE_DATE, TERMINATION_DATE, EXIT_DATE, MEMBERSHIP_TYPE, ANNUAL_FEE, IBAN) VALUES (CLUBMEMBERID_SEQ.nextval, 'Stefanie', 'Notebookstr. 7, 25337 Dresden', '1970-01-01', '2020-09-01', null,null, 'Foerdermitglied', 10, 'DE92938128');
INSERT INTO CLUBMEMBER (CLUBMEMBERID, CLUBMEMBER_NAME, CLUBMEMBER_ADRESS, CLUBMEMBER_BIRTHDAY, ENTRANCE_DATE, TERMINATION_DATE, EXIT_DATE, MEMBERSHIP_TYPE, ANNUAL_FEE, IBAN) VALUES (CLUBMEMBERID_SEQ.nextval, 'Frauke', 'Linuxstr. 98, 25337 Bremen', '1970-01-01', '2020-09-01', null,null, 'Vollmitglied', 25, 'DE92938128');
INSERT INTO CLUBMEMBER (CLUBMEMBERID, CLUBMEMBER_NAME, CLUBMEMBER_ADRESS, CLUBMEMBER_BIRTHDAY, ENTRANCE_DATE, TERMINATION_DATE, EXIT_DATE, MEMBERSHIP_TYPE, ANNUAL_FEE, IBAN) VALUES (CLUBMEMBERID_SEQ.nextval, 'Henning', 'Oraclestr. 12, 25337 Berlin', '1970-01-01', '2020-09-01', null,null, 'Foerdermitglied', 10, 'DE92938128');
INSERT INTO CLUBMEMBER (CLUBMEMBERID, CLUBMEMBER_NAME, CLUBMEMBER_ADRESS, CLUBMEMBER_BIRTHDAY, ENTRANCE_DATE, TERMINATION_DATE, EXIT_DATE, MEMBERSHIP_TYPE, ANNUAL_FEE, IBAN) VALUES (CLUBMEMBERID_SEQ.nextval, 'Julia', 'Javastr. 91, 25337 Lengau', '1970-01-01', '2020-09-01', null,null, 'Ermaessigt', 23, 'DE92938128');
INSERT INTO CLUBMEMBER (CLUBMEMBERID, CLUBMEMBER_NAME, CLUBMEMBER_ADRESS, CLUBMEMBER_BIRTHDAY, ENTRANCE_DATE, TERMINATION_DATE, EXIT_DATE, MEMBERSHIP_TYPE, ANNUAL_FEE, IBAN) VALUES (CLUBMEMBERID_SEQ.nextval, 'Monika', 'Sunstr. 12, 25337 Barmstedt', '1970-01-01', '2020-09-01', null,null, 'Vollmitglied', 25, 'DE92938128');
INSERT INTO CLUBMEMBER (CLUBMEMBERID, CLUBMEMBER_NAME, CLUBMEMBER_ADRESS, CLUBMEMBER_BIRTHDAY, ENTRANCE_DATE, TERMINATION_DATE, EXIT_DATE, MEMBERSHIP_TYPE, ANNUAL_FEE, IBAN) VALUES (CLUBMEMBERID_SEQ.nextval, 'Laura', 'Microsoftstr. 42, 25337 Kiel', '1970-01-01', '2020-09-01', '2020-08-24','2020-12-31', 'Foerdermitglied', 10, 'DE92938128');
INSERT INTO CLUBMEMBER (CLUBMEMBERID, CLUBMEMBER_NAME, CLUBMEMBER_ADRESS, CLUBMEMBER_BIRTHDAY, ENTRANCE_DATE, TERMINATION_DATE, EXIT_DATE, MEMBERSHIP_TYPE, ANNUAL_FEE, IBAN) VALUES (CLUBMEMBERID_SEQ.nextval, 'Hannah', 'Teslastr. 19, 25337 Flensburg', '1970-01-01', '2020-09-01', null,null, 'Vollmitglied', 25, 'DE92938128');

drop sequence CLUBMEMBERID_SEQ;

create sequence ANNUALPAYMENT_SEQ start with 1 increment by 1;

INSERT INTO ANNUALPAYMENT(ANNUALPAYMENTID, CLUBMEMBER_ID, ANNUALPAYMENT_YEAR, ANNUALPAYMENT_FEE, ANNUALPAYMENT_PAID_FEE) VALUES (ANNUALPAYMENT_SEQ.nextval, 1, 2020, 20, 18);
INSERT INTO ANNUALPAYMENT(ANNUALPAYMENTID, CLUBMEMBER_ID, ANNUALPAYMENT_YEAR, ANNUALPAYMENT_FEE, ANNUALPAYMENT_PAID_FEE) VALUES (ANNUALPAYMENT_SEQ.nextval, 1, 2019, 20, 15);
INSERT INTO ANNUALPAYMENT(ANNUALPAYMENTID, CLUBMEMBER_ID, ANNUALPAYMENT_YEAR, ANNUALPAYMENT_FEE, ANNUALPAYMENT_PAID_FEE) VALUES (ANNUALPAYMENT_SEQ.nextval, 1, 2018, 20, 20);
INSERT INTO ANNUALPAYMENT(ANNUALPAYMENTID, CLUBMEMBER_ID, ANNUALPAYMENT_YEAR, ANNUALPAYMENT_FEE, ANNUALPAYMENT_PAID_FEE) VALUES (ANNUALPAYMENT_SEQ.nextval, 2, 2020, 20, 20);

drop sequence ANNUALPAYMENT_SEQ;

