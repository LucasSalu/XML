CREATE DATABASE nanodata;

\c nanodata;

CREATE SEQUENCE nfe_proc_seq;
CREATE SEQUENCE binario_seq;

    CREATE TABLE binario (
    id SERIAL PRIMARY KEY,
    nome_arquivo VARCHAR(255),
    conteudo_arquivo BYTEA
);


CREATE TABLE nfe_proc (
    id SERIAL PRIMARY KEY,
    codigo VARCHAR(255) ,
    dh_emi TIMESTAMP,
    n_nf VARCHAR(255),
    c_uf VARCHAR(255),
    emmit_cnpj VARCHAR(255),
    x_fant VARCHAR(255),
    dest_cnpj VARCHAR(255),
    x_nome VARCHAR(255),
    v_tot_trib VARCHAR(255),
    v_nf VARCHAR(255),
    id_binario BIGINT REFERENCES binario(id)
);

