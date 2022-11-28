DROP TABLE IF EXISTS users_deals;
DROP TABLE IF EXISTS users_operations;
DROP TABLE IF EXISTS contacts;
DROP TABLE IF EXISTS operations;
DROP TABLE IF EXISTS deals;
DROP TABLE IF EXISTS users;

DROP SEQUENCE IF EXISTS global_seq;
DROP SEQUENCE IF EXISTS user_deal_seq;


CREATE SEQUENCE global_seq start 1000;
CREATE SEQUENCE user_deal_seq start 1000;


-- DROP TABLE IF EXISTS test;
-- CREATE TABLE test
-- (
--     id   INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
--     test Integer
-- );

CREATE TABLE users
(
    id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    login      varchar(30) UNIQUE NOT NULL,
    password   varchar(30)        NOT NULL,
    email      varchar UNIQUE     NOT NULL,
    name       varchar,
    surname    varchar,
    nickname   varchar,
    registered timestamp          NOT NULL,
    balance    integer             DEFAULT 0
);


CREATE TABLE deals
(
    id                          integer PRIMARY KEY DEFAULT nextval('global_seq'),
    name                        varchar(30) NOT NULL,
    date_time                   timestamp   NOT NULL,
    status                      varchar     NOT NULL,
    sum                         integer     NOT NULL,
    currency                    integer     NOT NULL,
    date_time_of_last_operation timestamp


);

CREATE TABLE operations
(
    id        integer PRIMARY KEY DEFAULT nextval('global_seq'),
    deal_id   integer REFERENCES deals (id),
    name      varchar(30) NOT NULL,
    date_time timestamp   NOT NULL,
    status    varchar     NOT NULL,
    sum       integer     NOT NULL,
    currency  integer     NOT NULL

);




INSERT INTO users(id, login, password, email, name, surname, nickname, registered)
VALUES (1, 'kema', 'hooinKema9', 'hooinkema@gmail.com', 'Okabe', 'Rintaro', 'Hooin Kema', '2022-10-19 10:23:54');
INSERT INTO users(id, login, password, email, name, surname, nickname, registered)
VALUES (2, 'kurisu', 'kristina', 'kurisu@gmail.com', 'Kurisu', 'Makise', 'Zombie', '2022-10-15 13:30:00');
INSERT INTO users(id, login, password, email, name, surname, nickname, registered)
VALUES (3, 'mauri', 'shinamauri', 'maushi@gmail.com', 'Mauri', 'Shina', 'Maushi', '2022-10-22 17:00:00');
INSERT INTO users(id, login, password, email, name, surname, nickname, registered)
VALUES (4, 'johntitor', 'johntiter', 'johntitor@gmail.com', 'Suzuha', 'Amane', 'Sis Suzu', '1999-05-22 15:00:00');



INSERT INTO deals(id, name, date_time, status, sum, currency, date_time_of_last_operation)
VALUES (1, 'restaurants', '2022-10-19 10:23:54', 'OPEN', 300, 840, '2022-10-19 10:23:54');
INSERT INTO deals(id, name, date_time, status, sum, currency, date_time_of_last_operation)
VALUES (2, 'gadget lab', '2009-07-19 10:00:0', 'OPEN', 1000, 840, '2009-09-19 10:00:0');



INSERT INTO operations(id, name, deal_id, date_time, status, sum, currency)
VALUES (1, 'Nyan Nyan', 1, '2022-10-19 10:23:54', 'OPEN', 300, 840);
INSERT INTO operations(id, name, deal_id, date_time, status, sum, currency)
VALUES (2, 'Bananas', 2, '2009-07-19 10:00:0', 'OPEN', 400, 840);
INSERT INTO operations(id, name, deal_id, date_time, status, sum, currency)
VALUES (3, 'IBN 5100', 2, '2009-09-19 10:00:0', 'OPEN', 600, 840);



CREATE TABLE users_deals
(
    id integer PRIMARY KEY DEFAULT nextval('user_deal_seq'),
    user_id     integer REFERENCES users (id),
    deal_id     integer REFERENCES deals (id),
    approvement varchar DEFAULT 'NOT_APPROVE',
    balance     integer DEFAULT 0
);

INSERT INTO users_deals(user_id, deal_id, approvement)
VALUES (1, 1, 'APPROVE');
INSERT INTO users_deals(user_id, deal_id, approvement)
VALUES (2, 1, 'APPROVE');
INSERT INTO users_deals(user_id, deal_id, approvement)
VALUES (3, 1, 'APPROVE');
INSERT INTO users_deals(user_id, deal_id, approvement)
VALUES (1, 2, 'APPROVE');
INSERT INTO users_deals(user_id, deal_id, approvement)
VALUES (2, 2, 'APPROVE');
INSERT INTO users_deals(user_id, deal_id, approvement)
VALUES (3, 2, 'APPROVE');
INSERT INTO users_deals(user_id, deal_id, approvement)
VALUES (4, 2, 'APPROVE');
