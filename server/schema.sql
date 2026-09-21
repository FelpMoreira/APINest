CREATE TABLE users(
    id          BIGSERIAL       PRIMARY KEY,
    username    VARCHAR(50)     NOT NULL UNIQUE,
    email       VARCHAR(255)    NOT NULL UNIQUE,
    password    VARCHAR(255)    NOT NULL,
    created_at  TIMESTAMP       NOT NULL DEFAULT NOW(),
    role        VARCHAR(10)     NOT NULL DEFAULT 'user',
    ativo       BOOLEAN         NOT NULL DEFAULT TRUE
);

CREATE TABLE categoria(
    id          BIGSERIAL       PRIMARY KEY,
    nome        VARCHAR(20)     
);

CREATE TABLE apis(
    id          BIGSERIAL       PRIMARY KEY,
    nome        VARCHAR(128)    NOT NULL,
    descricao   VARCHAR(256)    NOT NULL,
    autor       BIGINT          NOT NULL REFERENCES user(id) ON DELETE CASCADE,
    url_base    VARCHAR(127)    NOT NULL UNIQUE,
    documentacao VARCHAR(255)   NOT NULL,
    categoria   BIGSERIAL       NOT NULL REFERENCES categoria(id) ON DELETE CASCADE
);
