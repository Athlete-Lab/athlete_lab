<<<<<<< HEAD

-- BANCO DE DADOS: ATHLETE LAB
-- Gerado a partir do diagrama UML enviado

CREATE DATABASE IF NOT EXISTS athletelab;
USE athletelab;

CREATE TABLE IF NOT EXISTS usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    telefone VARCHAR(20),
    data_nascimento DATE,
    cidade_uf VARCHAR(100),
    data_criacao DATE,
    ativo BOOLEAN DEFAULT TRUE,
    senha VARCHAR(15) NOT NULL,
    tipo_usuario VARCHAR(20) NOT NULL
);

INSERT INTO usuario (nome,email,telefone,data_nascimento,cidade_uf,data_criacao,ativo,senha,tipo_usuario) VALUES
('João Silva','joao@email.com','11999999999','1995-03-10','São Paulo - SP',CURDATE(),TRUE,'123','ATLETA');

INSERT INTO usuario (nome,email,telefone,data_nascimento,cidade_uf,data_criacao,ativo,senha,tipo_usuario) VALUES
('João Silva','carlos@email.com','11999999999','1995-03-10','São Paulo - SP',CURDATE(),TRUE,'1234','TREINADOR');
