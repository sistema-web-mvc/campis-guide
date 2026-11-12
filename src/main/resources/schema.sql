CREATE TABLE local (
    id               BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome           VARCHAR(150)   NOT NULL,
    tipo            VARCHAR(100)   NOT NULL,
    andar             integer    NOT NULL
);

CREATE TABLE caminho (
    id               BIGINT AUTO_INCREMENT PRIMARY KEY,
    origem           integer   NOT NULL,
    destino            integer  NOT NULL,
    distancia            integer    NOT NULL
);
