DROP DATABASE IF EXISTS primerparcial;
CREATE DATABASE primerparcial;
USE primerparcial;

CREATE TABLE users (
	id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(45) UNIQUE NOT NULL,
    password VARCHAR(45) NOT NULL,
    token VARCHAR(128)
);