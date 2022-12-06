--      REFRESHING
DROP TABLE IF EXISTS user_deal;
DROP TABLE IF EXISTS user_operation;
DROP TABLE IF EXISTS contacts;
DROP TABLE IF EXISTS operations;
DROP TABLE IF EXISTS deals;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS contacts;

DROP SEQUENCE IF EXISTS global_seq;
DROP SEQUENCE IF EXISTS user_deal_seq;
DROP SEQUENCE IF EXISTS user_operation_seq;
DROP SEQUENCE IF EXISTS contact_seq;





CREATE SEQUENCE global_seq start 1000;
CREATE SEQUENCE user_deal_seq start 1000;
CREATE SEQUENCE user_operation_seq start 1000;
CREATE SEQUENCE contact_seq start 1000;


--      MAIN ENTITIES
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


-- LINK ENTITIES

CREATE TABLE contacts
(
    id integer PRIMARY KEY DEFAULT nextval('contact_seq'),
    user_id    integer REFERENCES users (id),
    contact_id integer REFERENCES users (id)
);


CREATE TABLE user_deal
(
    id          integer PRIMARY KEY DEFAULT nextval('user_deal_seq'),
    user_id     integer REFERENCES users (id),
    deal_id     integer REFERENCES deals (id),
    approvement varchar             DEFAULT 'NOT_APPROVE',
    balance     integer             DEFAULT 0
);


CREATE TABLE user_operation
(
    id           INTEGER PRIMARY KEY DEFAULT nextval('user_operation_seq'),
    user_id      integer REFERENCES users (id),
    operation_id integer REFERENCES operations (id),
    status       varchar NOT NULL    DEFAULT 'OPEN',
    approvement  varchar NOT NULL    DEFAULT 'NOT_APPROVE',
    contribution DECIMAL             DEFAULT 0.0,
    debt         DECIMAL             DEFAULT 0.0,
    reduce       DECIMAL             DEFAULT 0.0
);


--         INSERTS


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





INSERT INTO user_deal(user_id, deal_id, approvement)
VALUES (1, 1, 'APPROVE');
INSERT INTO user_deal(user_id, deal_id, approvement)
VALUES (2, 1, 'APPROVE');
INSERT INTO user_deal(user_id, deal_id, approvement)
VALUES (3, 1, 'APPROVE');
INSERT INTO user_deal(user_id, deal_id, approvement)
VALUES (1, 2, 'APPROVE');
INSERT INTO user_deal(user_id, deal_id, approvement)
VALUES (2, 2, 'APPROVE');
INSERT INTO user_deal(user_id, deal_id, approvement)
VALUES (3, 2, 'APPROVE');
INSERT INTO user_deal(user_id, deal_id, approvement)
VALUES (4, 2, 'APPROVE');



INSERT INTO user_operation(user_id, operation_id, contribution, debt, reduce)
VALUES (2, 1, 300.0, 0.0, 0.0);
INSERT INTO user_operation(user_id, operation_id)
VALUES (1, 1);
INSERT INTO user_operation(user_id, operation_id)
VALUES (3, 1);

INSERT INTO user_operation(user_id, operation_id, contribution, debt, reduce)
VALUES (3, 2, 400.0, 0.0, 0.0);
INSERT INTO user_operation(user_id, operation_id)
VALUES (2, 2);
INSERT INTO user_operation(user_id, operation_id, contribution, debt, reduce)
VALUES (1, 2, 0.0, 0.0, 100.0);


INSERT INTO user_operation(user_id, operation_id, contribution, debt, reduce)
VALUES (1, 3, 400.0, 0.0, 0.0);
INSERT INTO user_operation(user_id, operation_id, contribution, debt, reduce)
VALUES (4, 3, 200.0, 0.0, 0.0);
INSERT INTO user_operation(user_id, operation_id, contribution, debt, reduce)
VALUES (2, 3, 0.0, 100.0, 0.0);
INSERT INTO user_operation(user_id, operation_id, contribution, debt, reduce)
VALUES (3, 3, 0.0, 0.0, 100.0);


INSERT INTO contacts(user_id, contact_id)
VALUES (1, 2);
INSERT INTO contacts(user_id, contact_id)
VALUES (1, 3);
INSERT INTO contacts(user_id, contact_id)
VALUES (1, 4);
INSERT INTO contacts(user_id, contact_id)
VALUES (2, 3);
INSERT INTO contacts(user_id, contact_id)
VALUES (2, 4);
INSERT INTO contacts(user_id, contact_id)
VALUES (3, 4);