-- Criação da sequência para a tabela tbl_acidentes
CREATE SEQUENCE SEQ_ACIDENTES
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

-- Criação da tabela tbl_acidentes
CREATE TABLE tbl_acidentes (
                               acidente_id INTEGER DEFAULT SEQ_ACIDENTES.NEXTVAL NOT NULL,
                               intersecao_id INT NOT NULL,
                               data_hora DATE,
                               descricao VARCHAR(255) NOT NULL,
                               gravidade VARCHAR(20) NOT NULL,
                               PRIMARY KEY (acidente_id)
);
