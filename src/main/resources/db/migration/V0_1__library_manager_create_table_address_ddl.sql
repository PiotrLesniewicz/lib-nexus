CREATE TABLE IF NOT EXISTS address(
    address_id  SERIAL      NOT NULL,
    city        VARCHAR(32) NOT NULL,
    street      VARCHAR(64),
    number      VARCHAR(8),
    post_code   VARCHAR(6) NOT NULL,
    PRIMARY KEY (address_id)
);

CREATE TABLE IF NOT EXISTS users(
    user_id         SERIAL          NOT NULL,
    name            VARCHAR(32)     NOT NULL,
    surname         VARCHAR(64)     NOT NULL,
    email           VARCHAR(64)     NOT NULL,
    password        VARCHAR(255)    NOT NULL,
    phone_number    VARCHAR(20),
    role            VARCHAR(32)     NOT NULL,
    membership_date TIMESTAMPTZ     NOT NULL,
    hire_date       TIMESTAMPTZ,
    is_active       BOOLEAN         NOT NULL,
    address_id      INTEGER         NOT NULL,
    PRIMARY KEY (user_id),
    UNIQUE  (email),
    CONSTRAINT fk_users_address
    FOREIGN KEY (address_id)
    REFERENCES address (address_id)
    );