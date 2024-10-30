-- Criação da sequência para a tabela tbl_intersecoes
CREATE SEQUENCE SEQ_INTERSECOES
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

-- Criação da tabela tbl_intersecoes
CREATE TABLE tbl_intersecoes (
                                 intersecao_id INTEGER DEFAULT SEQ_INTERSECOES.NEXTVAL NOT NULL,
                                 nome VARCHAR(100) NOT NULL,
                                 latitude DECIMAL(10, 6) NOT NULL,
                                 longitude DECIMAL(10, 6) NOT NULL
);
