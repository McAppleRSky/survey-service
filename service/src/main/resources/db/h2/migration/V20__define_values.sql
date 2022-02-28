INSERT INTO person (login_person, password_person, name_person, email_person)
     VALUES ('${person.login}', '${person.password}', 'Admin', 'admin@host.loc');

INSERT INTO role (person_id, roles)
     VALUES (1, 'ADMIN');
