INSERT INTO person (login, password, name, email)
    VALUES('${oper.login}', '${oper.password}', 'Admin', 'admin@host.loc');

INSERT INTO person_role (person_id, roles)
    VALUES(1, 'ADMIN');
