insert into user_class(uid,first_name,age,user_name,pass_word,securityq,securitya) values(1,'jay',25,'jtsb','jtsb','dob','1996');
insert into user_class(uid,first_name,age,user_name,pass_word,securityq,securitya) values(2,'nat',27,'nat','nat','address','cck');

insert into insurance_class(iID,i_name, i_type, i_company, i_price, i_max_age) values(1, 'AIA Health Policy (Term)', 'Term', 'AIA', 100 , 50);
insert into insurance_class(iID,i_name, i_type, i_company, i_price, i_max_age) values(2, 'AIA Health Policy (Life)', 'Life', 'AIA', 200, 75);
insert into insurance_class(iID,i_name, i_type, i_company, i_price, i_max_age) values(3, 'AIA Critical Policy', 'Life', 'AIA', 145, 20);
insert into insurance_class(iID,i_name, i_type, i_company, i_price, i_max_age) values(4, 'NTUC TPolicy', 'Term', 'NTUC Income', 175, 75);
insert into insurance_class(iID,i_name, i_type, i_company, i_price, i_max_age) values(5, 'GE Health Policy', 'Life', 'Great Eastern', 200, 50);
insert into insurance_class(iID,i_name, i_type, i_company, i_price, i_max_age) values(6, 'Aviva NS Policy', 'Life', 'Aviva', 50, 50);
insert into insurance_class(iID,i_name, i_type, i_company, i_price, i_max_age) values(7, 'Pregnancy Policy', 'Life', 'Aviva', 170, 25);
insert into insurance_class(iID,i_name, i_type, i_company, i_price, i_max_age) values(8, 'Pregnancy Policy', 'Life', 'NTUC Income', 250 , 21);

insert into cart_class(sID,uid,i_name, i_type, i_company, i_price, i_paid) values(1,1,'AIA Health Policy (Term)', 'term', 'AIA', 100, null);
insert into cart_class(sID,uid,i_name, i_type, i_company, i_price, i_paid) values(2,2,'Aviva NS Policy', 'Life', 'Aviva', 50, 'T');
insert into cart_class(sID,uid,i_name, i_type, i_company, i_price, i_paid) values(3,1,'GE Health Policy', 'Life', 'Great Eastern', 200, null);

insert into condition_class(cID, iID, condition_name) values(1, 1, 'HeartCondition');
insert into condition_class(cID, iID, condition_name) values(2, 6, 'Pregnant');
insert into condition_class(cID, iID, condition_name) values(3, 7, 'HeartCondition');
insert into condition_class(cID, iID, condition_name) values(4, 7, 'Pregnant');
insert into condition_class(cID, iID, condition_name) values(5, 3, 'LungCondition');


