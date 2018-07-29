CREATE TABLE company (
    `id`              BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name`            VARCHAR(55) NOT NULL,
    `create_date`     TIMESTAMP DEFAULT NOW()
);