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

CREATE TABLE estudante (
    id               BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome           VARCHAR(100)   NOT NULL,
    matricula       VARCHAR(100)   NOT NULL,
    email            VARCHAR(100)   NOT NULL,
    senha           VARCHAR(100)   NOT NULL,
    curso           VARCHAR(100)   NOT NULL
);

CREATE TABLE amigos (
    id               BIGINT AUTO_INCREMENT PRIMARY KEY,
    solicitate_id           VARCHAR(100)   NOT NULL,
    destinario_id       VARCHAR(100)   NOT NULL,
    status            VARCHAR(100)   NOT NULL,
    data_solicitacao           date   NOT NULL

    FOREIGN KEY (solicitante_id) REFERENCES estudante(id),
    FOREIGN KEY (destinatario_id) REFERENCES estudante(id),

);
