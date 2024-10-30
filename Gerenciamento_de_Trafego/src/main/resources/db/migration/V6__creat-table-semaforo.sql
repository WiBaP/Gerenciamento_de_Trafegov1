-- Criação da sequência para a tabela tbl_semaforos
CREATE SEQUENCE SEQ_SEMAFOROS
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

-- Criação da tabela tbl_semaforos
CREATE TABLE tbl_semaforos (
                               semaforo_id INTEGER DEFAULT SEQ_SEMAFOROS.NEXTVAL NOT NULL,
                               intersecao_id INT NOT NULL,
                               status VARCHAR(10) NOT NULL,
                               tempo_verde INT NOT NULL,
                               tempo_vermelho INT NOT NULL

);