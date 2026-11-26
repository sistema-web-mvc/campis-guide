
CREATE TABLE local (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    tipo VARCHAR(100) NOT NULL,
    andar INT NOT NULL
);

CREATE TABLE caminho (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    origem BIGINT NOT NULL,
    destino BIGINT NOT NULL,
    distancia INT NOT NULL,

    FOREIGN KEY (origem) REFERENCES local(id),
    FOREIGN KEY (destino) REFERENCES local(id)
);

CREATE TABLE estudante (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    matricula VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    curso VARCHAR(100) NOT NULL
);


CREATE TABLE localizacao_atual (
    estudante_id BIGINT PRIMARY KEY,
    latitude DOUBLE NOT NULL,
    longitude DOUBLE NOT NULL,
    ultima_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (estudante_id) REFERENCES estudante(id)
);




