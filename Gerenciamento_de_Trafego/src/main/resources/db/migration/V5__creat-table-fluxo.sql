-- Criação da sequência para a tabela tbl_fluxos
CREATE SEQUENCE SEQ_FLUXOS
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

-- Criação da tabela tbl_fluxos
CREATE TABLE tbl_fluxos (
                            fluxo_id INTEGER DEFAULT SEQ_FLUXOS.NEXTVAL NOT NULL,
                            intersecao_id INT NOT NULL,
                            data_hora DATE NOT NULL,
                            quantidade_veiculos INT NOT NULL
);
