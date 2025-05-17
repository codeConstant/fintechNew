CREATE DATABASE IF NOT EXISTS fintech;
USE fintech;

DROP TABLE IF EXISTS `EMPLOYEE_TBL`;


CREATE TABLE EMPLOYEE_TBL (
                           id SERIAL PRIMARY KEY,
                           first_name VARCHAR(100),
                           last_name VARCHAR(100),
                           email VARCHAR(100) UNIQUE,
                           phone VARCHAR(20),
                           position VARCHAR(100),
                           department VARCHAR(100),
                           role VARCHAR(100),
                           start_date DATE
);