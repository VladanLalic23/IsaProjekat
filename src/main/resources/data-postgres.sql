insert into clinic (id, city, description, country, flat_number, postal_code, street_name, street_number, average_grade,name) 
values (1, 'Novi Sad', '', 'Republika Srbija', 0, '21000', 'Bulevar oslobodjenja', 123, 4.7,'Klinika1');

insert into clinic (id, city, description, country, flat_number, postal_code, street_name, street_number, average_grade,name) 
values (2, 'Novi Sad', '', 'Republika Srbija', 0, '21000', 'Laze teleckog', 123, 4.0,'Klinika2');


INSERT INTO users (id, city, country, flat_number, postal_code, street_name, street_number, email, gender,info,initial_password_changed, is_activated,jmbg, name, password, last_password_reset_date, phone,profession,surname,role)
values (2, 'Bijeljina', 'Bosna', 23, '763000', 'AAAaadAA', 18, 'admin@gmail.com', 'MALE', 'info',true, true,'1231231231231','Nikola','$2y$10$oVutWPmlktcw/hSDyklg7uF8jt7r1vXXkPUEwGoOllqZSwN2KaQmS', '2021-02-02', '012345678','doktrcina', 'Zigic', 'ROLE_ADMIN');
INSERT INTO users (id, city, country, flat_number, postal_code, street_name, street_number, email, gender,info,initial_password_changed, is_activated,jmbg, name, password, last_password_reset_date, phone,profession, surname,role)
values (4, 'Tuzla', 'Bosna', 23, '763000', 'AAAsaAA', 18, 'donor@gmail.com', 'MALE', 'info',true, true,'1112223331122','Marko','$2y$10$oVutWPmlktcw/hSDyklg7uF8jt7r1vXXkPUEwGoOllqZSwN2KaQmS', '2021-02-02', '0611518128','krvi daj', 'Pantelic', 'ROLE_DONOR');
INSERT INTO users (id, city, country, flat_number, postal_code, street_name, street_number, email, gender,info,initial_password_changed, is_activated,jmbg, name, password, last_password_reset_date, phone,profession, surname,role)
values (5, 'Pariz', 'Francuska', 23, '763000', 'AAAsaAA', 18, 'isaProj23@gmail.com', 'MALE', 'info',true, true,'13123','Ziko','$2y$10$oVutWPmlktcw/hSDyklg7uF8jt7r1vXXkPUEwGoOllqZSwN2KaQmS', '2021-02-02', '0611518128','litre krvi', 'Pero', 'ROLE_DONOR');

INSERT INTO users (id, city, country, flat_number, postal_code, street_name, street_number, email, gender,info,initial_password_changed, is_activated,jmbg, name, password, last_password_reset_date, phone,profession,surname,role)
values (6, 'Srbija', 'Bosna', 23, '763000', 'AAAAsadA', 18, 'radnik@gmail.com', 'MALE', 'info',true, true,'1212223331122','Marko','$2y$10$oVutWPmlktcw/hSDyklg7uF8jt7r1vXXkPUEwGoOllqZSwN2KaQmS', '2021-02-02', '0611518128','doktrcina', 'Lazic', 'ROLE_STAFF');


INSERT INTO authorities (id, name) VALUES (1,'ROLE_ADMIN');
INSERT INTO authorities (id, name) VALUES (2,'ROLE_STAFF');
INSERT INTO authorities (id, name) VALUES (3,'ROLE_DONOR');

--INSERT INTO donor (loyalty_points, donor_category, penalty_points, id) values (5, 'REGULAR', 0, 4);

INSERT INTO user_authority (user_id, authority_id) VALUES (4, 3);
INSERT INTO user_authority (user_id, authority_id) VALUES (6, 2);
INSERT INTO user_authority (user_id, authority_id) VALUES (2, 1);
INSERT INTO user_authority (user_id, authority_id) VALUES (5, 3);


INSERT INTO staffs(id,clinic_id) values (6,1);

INSERT INTO appointments (id, staff_id, loyalty_points, status, end_time, start_time, clinic_id, donor_id)
values (1,6,4,'AVAILABLE', '2023-12-21 11:00:00', '2023-12-21 10:30:00',1,null);
INSERT INTO appointments (id, staff_id, loyalty_points, status, end_time, start_time, clinic_id, donor_id)
values (2,6,4,'AVAILABLE', '2023-12-21 13:00:00', '2023-12-21 12:30:00',1,null);

INSERT INTO donors (loyalty_points,form,last_donacion ,donor_category, penalty_points, id)
values (5,true,'2022-12-21', 'REGULAR', 0, 4);

INSERT INTO donors (loyalty_points,form,last_donacion ,donor_category, penalty_points, id)
values (5,true,'2022-12-21', 'REGULAR', 0, 5);