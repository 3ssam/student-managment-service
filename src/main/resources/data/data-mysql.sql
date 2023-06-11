-- Authorities
INSERT INTO authority (id, name, status, created_at, updated_at, created_by, updated_by)
values (1, 'CREATE_ROLE', true, '2023-06-11 00:00:00.00', '2023-06-11 00:00:00.00', null, null);
INSERT INTO authority (id, name, status, created_at, updated_at, created_by, updated_by)
values (2, 'UPDATE_ROLE', true, '2023-06-11 00:00:00.00', '2023-06-11 00:00:00.00', null, null);
INSERT INTO authority (id, name, status, created_at, updated_at, created_by, updated_by)
values (3, 'DELETE_ROLE', true, '2023-06-11 00:00:00.00', '2023-06-11 00:00:00.00', null, null);
INSERT INTO authority (id, name, status, created_at, updated_at, created_by, updated_by)
values (4, 'READ_ROLE', true, '2023-06-11 00:00:00.00', '2023-06-11 00:00:00.00', null, null);
INSERT INTO authority (id, name, status, created_at, updated_at, created_by, updated_by)
values (5, 'READ_ALL_ROLES', true, '2023-06-11 00:00:00.00', '2023-06-11 00:00:00.00', null, null);
INSERT INTO authority (id, name, status, created_at, updated_at, created_by, updated_by)
values (6, 'ASSIGN_AUTHORITY_TO_ROLE', true, '2023-06-11 00:00:00.00', '2023-06-11 00:00:00.00', null, null);

INSERT INTO authority (id, name, status, created_at, updated_at, created_by, updated_by)
values (7, 'CREATE_AUTHORITY', true, '2023-06-11 00:00:00.00', '2023-06-11 00:00:00.00', null, null);
INSERT INTO authority (id, name, status, created_at, updated_at, created_by, updated_by)
values (8, 'UPDATE_AUTHORITY', true, '2023-06-11 00:00:00.00', '2023-06-11 00:00:00.00', null, null);
INSERT INTO authority (id, name, status, created_at, updated_at, created_by, updated_by)
values (9, 'DELETE_AUTHORITY', true, '2023-06-11 00:00:00.00', '2023-06-11 00:00:00.00', null, null);
INSERT INTO authority (id, name, status, created_at, updated_at, created_by, updated_by)
values (10, 'READ_AUTHORITY', true, '2023-06-11 00:00:00.00', '2023-06-11 00:00:00.00', null, null);
INSERT INTO authority (id, name, status, created_at, updated_at, created_by, updated_by)
values (11, 'READ_Authorities', true, '2023-06-11 00:00:00.00', '2023-06-11 00:00:00.00', null, null);

INSERT INTO authority (id, name, status, created_at, updated_at, created_by, updated_by)
values (12, 'UPDATE_Student', true, '2023-06-11 00:00:00.00', '2023-06-11 00:00:00.00', null, null);
INSERT INTO authority (id, name, status, created_at, updated_at, created_by, updated_by)
values (13, 'DELETE_Student', true, '2023-06-11 00:00:00.00', '2023-06-11 00:00:00.00', null, null);
INSERT INTO authority (id, name, status, created_at, updated_at, created_by, updated_by)
values (14, 'RETRIEVE_Student', true, '2023-06-11 00:00:00.00', '2023-06-11 00:00:00.00', null, null);
INSERT INTO authority (id, name, status, created_at, updated_at, created_by, updated_by)
values (15, 'RETRIEVE_Students', true, '2023-06-11 00:00:00.00', '2023-06-11 00:00:00.00', null, null);
INSERT INTO authority (id, name, status, created_at, updated_at, created_by, updated_by)
values (16, 'RETRIEVE_Students_Courses', true, '2023-06-11 00:00:00.00', '2023-06-11 00:00:00.00', null, null);
INSERT INTO authority (id, name, status, created_at, updated_at, created_by, updated_by)
values (17, 'DOWNLOAD_Students_Courses', true, '2023-06-11 00:00:00.00', '2023-06-11 00:00:00.00', null, null);
INSERT INTO authority (id, name, status, created_at, updated_at, created_by, updated_by)
values (18, 'ENROLL_Course', true, '2023-06-11 00:00:00.00', '2023-06-11 00:00:00.00', null, null);
INSERT INTO authority (id, name, status, created_at, updated_at, created_by, updated_by)
values (19, 'CANCEL_Course', true, '2023-06-11 00:00:00.00', '2023-06-11 00:00:00.00', null, null);


INSERT INTO authority (id, name, status, created_at, updated_at, created_by, updated_by)
values (20, 'CREATE_Course', true, '2023-06-11 00:00:00.00', '2023-06-11 00:00:00.00', null, null);
INSERT INTO authority (id, name, status, created_at, updated_at, created_by, updated_by)
values (21, 'UPDATE_Course', true, '2023-06-11 00:00:00.00', '2023-06-11 00:00:00.00', null, null);
INSERT INTO authority (id, name, status, created_at, updated_at, created_by, updated_by)
values (22, 'DELETE_Course', true, '2023-06-11 00:00:00.00', '2023-06-11 00:00:00.00', null, null);
INSERT INTO authority (id, name, status, created_at, updated_at, created_by, updated_by)
values (23, 'RETRIEVE_Course', true, '2023-06-11 00:00:00.00', '2023-06-11 00:00:00.00', null, null);
INSERT INTO authority (id, name, status, created_at, updated_at, created_by, updated_by)
values (24, 'RETRIEVE_Courses', true, '2023-06-11 00:00:00.00', '2023-06-11 00:00:00.00', null, null);
INSERT INTO authority (id, name, status, created_at, updated_at, created_by, updated_by)
values (25, 'DOWNLOAD_Courses', true, '2023-06-11 00:00:00.00', '2023-06-11 00:00:00.00', null, null);


-- Roles
INSERT INTO role (id, name, status, created_at, updated_at, created_by, updated_by)
values (1, 'SUPER_ADMIN', true, '2023-06-11 00:00:00.00', '2023-06-11 00:00:00.00', null, null);
INSERT INTO role (id, name, status, created_at, updated_at, created_by, updated_by)
values (2, 'STUDENT', true, '2023-06-11 00:00:00.00', '2023-06-11 00:00:00.00', null, null);

-- Roles-Authorities
-- Super Admin Authorities
INSERT INTO role_authority (role_id, authority_id)
VALUES (1, 1);
INSERT INTO role_authority (role_id, authority_id)
VALUES (1, 2);
INSERT INTO role_authority (role_id, authority_id)
VALUES (1, 3);
INSERT INTO role_authority (role_id, authority_id)
VALUES (1, 4);
INSERT INTO role_authority (role_id, authority_id)
VALUES (1, 5);
INSERT INTO role_authority (role_id, authority_id)
VALUES (1, 6);
INSERT INTO role_authority (role_id, authority_id)
VALUES (1, 7);
INSERT INTO role_authority (role_id, authority_id)
VALUES (1, 8);
INSERT INTO role_authority (role_id, authority_id)
VALUES (1, 9);
INSERT INTO role_authority (role_id, authority_id)
VALUES (1, 10);
INSERT INTO role_authority (role_id, authority_id)
VALUES (1, 11);
INSERT INTO role_authority (role_id, authority_id)
VALUES (1, 12);
INSERT INTO role_authority (role_id, authority_id)
VALUES (1, 13);
INSERT INTO role_authority (role_id, authority_id)
VALUES (1, 14);
INSERT INTO role_authority (role_id, authority_id)
VALUES (1, 15);
INSERT INTO role_authority (role_id, authority_id)
VALUES (1, 16);
INSERT INTO role_authority (role_id, authority_id)
VALUES (1, 17);
INSERT INTO role_authority (role_id, authority_id)
VALUES (1, 18);
INSERT INTO role_authority (role_id, authority_id)
VALUES (1, 19);
INSERT INTO role_authority (role_id, authority_id)
VALUES (1, 20);
INSERT INTO role_authority (role_id, authority_id)
VALUES (1, 21);
INSERT INTO role_authority (role_id, authority_id)
VALUES (1, 22);
INSERT INTO role_authority (role_id, authority_id)
VALUES (1, 23);
INSERT INTO role_authority (role_id, authority_id)
VALUES (1, 24);
INSERT INTO role_authority (role_id, authority_id)
VALUES (1, 25);

-- Student Authorities
INSERT INTO role_authority (role_id, authority_id)
VALUES (2, 12);
INSERT INTO role_authority (role_id, authority_id)
VALUES (2, 13);
INSERT INTO role_authority (role_id, authority_id)
VALUES (2, 14);
INSERT INTO role_authority (role_id, authority_id)
VALUES (2, 15);
INSERT INTO role_authority (role_id, authority_id)
VALUES (2, 16);
INSERT INTO role_authority (role_id, authority_id)
VALUES (2, 17);
INSERT INTO role_authority (role_id, authority_id)
VALUES (2, 18);
INSERT INTO role_authority (role_id, authority_id)
VALUES (2, 19);


-- Users
-- password for all user is 123456

-- Super Admin User
INSERT INTO user (id, name, email, username, password_hash, activated, suspended, role_id, created_at, updated_at,
                  created_by, updated_by, dtype)
values (1, 'Mohamed Essam', 'mohamed_ekamel@rayacorp.com', 'mohamed.essam',
        '$2a$10$DBTrOEC7LCBflu90yBg/8OBGiHK8dH3ddJGJp3ioneVrbGiUPKl1G', true, false, 1, '2023-06-11 00:00:00.00',
        '2023-06-11 00:00:00.00', null, null.'SUPER_ADMIN');

-- Student
INSERT INTO user (id, name, email, username, password_hash, activated, suspended, role_id, created_at, updated_at,
                  created_by, updated_by, dtype)
values (2, 'Omar Ahmed', 'omar.ahmed@rayacorp.com', 'omar.ahmed',
        '$2a$10$DBTrOEC7LCBflu90yBg/8OBGiHK8dH3ddJGJp3ioneVrbGiUPKl1G', true, false, 2, '2023-06-11 00:00:00.00',
        '2023-06-11 00:00:00.00', null, null, 'Student');

-- Student
INSERT INTO user (id, name, email, username, password_hash, activated, suspended, role_id, created_at, updated_at,
                  created_by, updated_by, dtype)
values (3, 'Ahmed Nasr', 'ahmed.nasr@rayacorp.com', 'ahmed.nasr',
        '$2a$10$DBTrOEC7LCBflu90yBg/8OBGiHK8dH3ddJGJp3ioneVrbGiUPKl1G', true, false, 2, '2023-06-11 00:00:00.00',
        '2023-06-11 00:00:00.00', null, null, 'Student');

-- Student
INSERT INTO user (id, name, email, username, password_hash, activated, suspended, role_id, created_at, updated_at,
                  created_by, updated_by, dtype)
values (4, 'Marwa Adel', 'yousef.rabie@rayacorp.com', 'marwa.adel',
        '$2a$10$DBTrOEC7LCBflu90yBg/8OBGiHK8dH3ddJGJp3ioneVrbGiUPKl1G', true, false, 2, '2023-06-11 00:00:00.00',
        '2023-06-11 00:00:00.00', null, null, 'Student');

