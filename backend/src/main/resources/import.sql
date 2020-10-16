--@formatter:off

-- Test data for rooms
INSERT INTO ROOM (ID, BUILDING, ROOM_NUMBER, SEATS, PROJECTOR_PRESENT) VALUES (hibernate_sequence.nextval, 'A', 1, 45, true);

-- Test data for courses
INSERT INTO COURSE (ID, FIELD_OF_STUDY, NUMBER, LECTURER, TITLE) VALUES (hibernate_sequence.nextval, 'I', 148, 'Stephan Anft', 'Internet-Anwendungsarchitekturen');
