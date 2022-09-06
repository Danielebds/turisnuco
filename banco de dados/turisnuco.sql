/* Logico_1: */

CREATE TABLE usuario (
    nome VARCHAR,
    email VARCHAR,
    senha VARCHAR,
    id INT PRIMARY KEY,
    fk_endereco_endereco_PK INT
);

CREATE TABLE viagens (
    fk_refeicao_refeicao_PK INT,
    fk_hospedagem_hospedagem_PK INT,
    id INT PRIMARY KEY,
    data_de_origem DATE,
    data_de_destino DATE,
    origem_ VARCHAR,
    destino VARCHAR,
    acompanhantes VARCHAR,
    nome VARCHAR,
    valor DOUBLE
);

CREATE TABLE endereco (
    endereco_PK INT NOT NULL,
    cep INT,
    logradouro VARCHAR,
    cidade VARCHAR,
    estado VARCHAR,
    numero INT,
    PRIMARY KEY (endereco_PK, cep)
);

CREATE TABLE refeicao (
    refeicao_PK INT NOT NULL PRIMARY KEY,
    tipo_rf VARCHAR,
    nome_rf VARCHAR,
    valor_rf DOUBLE
);

CREATE TABLE hospedagem (
    hospedagem_PK INT NOT NULL,
    tv BOOLEAN,
    quartos INT,
    tipo_hosp VARCHAR,
    valor_hosp DOUBLE,
    nome_hosp VARCHAR,
    PRIMARY KEY (hospedagem_PK, nome_hosp)
);

CREATE TABLE faz (
    fk_usuario_id INT,
    fk_viagens_id INT
);

CREATE TABLE endereco (
    endereco_PK INT NOT NULL,
    cep INT,
    logradouro VARCHAR,
    cidade VARCHAR,
    estado VARCHAR,
    numero INT,
    PRIMARY KEY (endereco_PK, cep)
);
 
ALTER TABLE usuario ADD CONSTRAINT FK_usuario_2
    FOREIGN KEY (fk_endereco_endereco_PK, ???)
    REFERENCES endereco (endereco_PK, ???)
    ON DELETE SET NULL;
 
ALTER TABLE viagens ADD CONSTRAINT FK_viagens_2
    FOREIGN KEY (fk_refeicao_refeicao_PK)
    REFERENCES refeicao (refeicao_PK)
    ON DELETE SET NULL;
 
ALTER TABLE viagens ADD CONSTRAINT FK_viagens_3
    FOREIGN KEY (fk_hospedagem_hospedagem_PK, ???)
    REFERENCES hospedagem (hospedagem_PK, ???)
    ON DELETE SET NULL;
 
ALTER TABLE faz ADD CONSTRAINT FK_faz_1
    FOREIGN KEY (fk_usuario_id)
    REFERENCES usuario (id)
    ON DELETE RESTRICT;
 
ALTER TABLE faz ADD CONSTRAINT FK_faz_2
    FOREIGN KEY (fk_viagens_id)
    REFERENCES viagens (id)
    ON DELETE RESTRICT;