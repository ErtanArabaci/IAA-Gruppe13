--@formatter:off

-- Test data for rooms
INSERT INTO ROOM (ID, BUILDING, ROOM_NUMBER, SEATS, PROJECTOR_PRESENT) VALUES (hibernate_sequence.nextval, 'A', 1, 45, true);

-- Test data for courses
INSERT INTO COURSE (ID, FIELD_OF_STUDY, NUMBER, LECTURER, TITLE) VALUES (hibernate_sequence.nextval, 'I', 148, 'Stephan Anft', 'Internet-Anwendungsarchitekturen');

-- Test data for clubMembers
INSERT INTO CLUBMEMBER (CLUBMEMBERID, CLUBMEMBER_NAME, CLUBMEMBER_ADRESS, CLUBMEMBER_BIRTHDAY, ENTRANCE_DATE, EXIT_DATE, MEMBERSHIP_TYPE, ANNUAL_FEE, IBAN, FIRST_ENTERED_FAMILYCLUBMEMBER) VALUES (hibernate_sequence.nextval, 'Peter', 'Hamburgerstr. 10, 25335 Elmshorn', '1960-01-01', '2020-09-01', '2021-01-01', 'FULL', 24, 'DE21392323023',null);
