CREATE DATABASE IF NOT EXISTS fintech;
USE fintech;

DROP TABLE IF EXISTS `EMPLOYEE_TBL`;


CREATE TABLE employee_tbl (
                              id BIGSERIAL PRIMARY KEY,
                              first_name VARCHAR(100)    NOT NULL,
                              last_name  VARCHAR(100)    NOT NULL,
                              email      VARCHAR(150)    NOT NULL UNIQUE,
                              phone      VARCHAR(20),
                              position   VARCHAR(100),
                              role       VARCHAR(50),
                              status     VARCHAR(20)     NOT NULL,  -- stores EmployeeStatus as text
                              department VARCHAR(100),
                              start_date DATE
);

-- OnboardingTask table
CREATE TABLE onboarding_task (
                                 id BIGSERIAL PRIMARY KEY,
                                 title       VARCHAR(200)    NOT NULL,
                                 description TEXT,
                                 due_date    DATE,
                                 completed   BOOLEAN         NOT NULL DEFAULT FALSE,
                                 employee_id BIGINT          NOT NULL,
                                 CONSTRAINT fk_employee
                                     FOREIGN KEY(employee_id)
                                         REFERENCES employee_tbl(id)
                                         ON DELETE CASCADE
);

-- Optional: index to speed up task lookups by employee
CREATE INDEX idx_onboarding_task_employee
    ON onboarding_task(employee_id);


-- User table
CREATE TABLE user_tbl (
                          id BIGINT PRIMARY KEY,
                          username VARCHAR(100) NOT NULL UNIQUE,
                          email    VARCHAR(150) NOT NULL UNIQUE,
                          password VARCHAR(255) NOT NULL,
                          role     VARCHAR(50),
                          active   BOOLEAN NOT NULL DEFAULT TRUE
);