CREATE TABLE users( 
    username VARCHAR(255) NOT NULL,
    password CHAR(68) NOT NULL,
    enabled BOOLEAN NOT NULL,
    PRIMARY KEY (username),
    UNIQUE KEY unique_user (username)   
);

DROP TABLE IF EXISTS customers;
CREATE TABLE customers(
    id INT NOT NULL, 
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    u_name VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_userid FOREIGN KEY (u_name) REFERENCES users (username)
);

CREATE TABLE authorities( 
	authorities_id INTEGER NOT NULL,
    authority VARCHAR(255) NOT NULL,
    PRIMARY KEY (authorities_id)
);

CREATE TABLE users_authorities (
  user_name VARCHAR(255) NOT NULL,
  authority_id INT NOT NULL,
  PRIMARY KEY (user_name,authority_id),
  CONSTRAINT fk_authorities FOREIGN KEY (authority_id) REFERENCES authorities (authorities_id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT fk_users FOREIGN KEY (user_name) REFERENCES users (username) ON DELETE CASCADE ON UPDATE CASCADE
)
