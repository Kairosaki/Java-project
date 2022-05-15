INSERT INTO customers (id, first_name, last_name) VALUES ('1000','John', 'Doe');
INSERT INTO customers (id, first_name, last_name) VALUES ('1001','Michel', 'Derick');
INSERT INTO customers (id, first_name, last_name) VALUES ('1002','Kevin', 'Calbert');
INSERT INTO customers (id, first_name, last_name) VALUES ('1003','Marie', 'Popins');
INSERT INTO customers (id, first_name, last_name) VALUES ('1004','Gerard', 'Buttler');
INSERT INTO customers (id, first_name, last_name) VALUES ('1005','Jack', 'Brown');


INSERT INTO users (username, password, enabled) VALUES ('user', '$2a$04$/zW0OaZbTxERtfXI8Z0KgepM9eN20uOXoMR8ucbXUnNUwiTzLA1Za', true);
INSERT INTO users (username, password, enabled) VALUES ('admin', '$2a$04$8KVDNuvpI0sp2dFDSaUuYewVZ8xKekNSQm1HUn7k4XdLGc7NIdlVq', true);

INSERT INTO authorities (authorities_id, authority) VALUES ('1','ROLE_USER');
INSERT INTO authorities (authorities_id, authority) VALUES ('2','ROLE_ADMIN');

INSERT INTO users_authorities (user_name, authority_id) VALUES ('user', '1');
INSERT INTO users_authorities (user_name, authority_id) VALUES ('admin', '1');
INSERT INTO users_authorities (user_name, authority_id) VALUES ('admin', '2');

INSERT INTO customers (id, first_name, last_name,u_name) VALUES ('1050','Jules', 'VERNE', 'user');
INSERT INTO customers (id, first_name, last_name,u_name) VALUES ('1150','victor', 'HUGO', 'admin');