CREATE DATABASE IF NOT EXISTS athletelab;
USE athletelab;


-- TABELA: Usuario (classe base)
CREATE TABLE usuario (
                         id_usuario INT AUTO_INCREMENT PRIMARY KEY,
                         nome VARCHAR(100) NOT NULL,
                         email VARCHAR(150) NOT NULL UNIQUE,
                         telefone VARCHAR(20),
                         data_nascimento DATE,
                         cidade_uf VARCHAR(100),
                         senha VARCHAR(255) NOT NULL,
                         data_criacao DATE,
                         ativo BOOLEAN DEFAULT TRUE
);

-- TABELA: Administrador (herança de Usuario)
CREATE TABLE administrador (
                               id_usuario INT PRIMARY KEY,
                               FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
                                   ON DELETE CASCADE
);


-- TABELA: Treinador (herança de Usuario)
CREATE TABLE treinador (
                           id_treinador INT AUTO_INCREMENT PRIMARY KEY,
                           id_usuario INT UNIQUE,
                           data_criacao DATE,
                           ativo BOOLEAN DEFAULT TRUE,
                           FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
                               ON DELETE CASCADE
);


-- TABELA: PerfilTreinador
CREATE TABLE perfil_treinador (
        id_perfil_treinador INT AUTO_INCREMENT PRIMARY KEY,
        id_treinador INT UNIQUE,
        modalidade VARCHAR(100),
        nivel_experiencia VARCHAR(50),
        objetivo VARCHAR(100),
        ambiente VARCHAR(100),
        sexo VARCHAR(20),
        restricao_fisica VARCHAR(255),
        FOREIGN KEY (id_treinador) REFERENCES treinador(id_treinador)
        ON DELETE CASCADE
);


-- TABELA: Atleta (herança de Usuario)
CREATE TABLE atleta (
                        id_atleta INT AUTO_INCREMENT PRIMARY KEY,
                        id_usuario INT UNIQUE,
                        ativo BOOLEAN DEFAULT TRUE,
                        data_criacao DATE,
                        FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
                            ON DELETE CASCADE
);


-- TABELA: PerfilAtleta
CREATE TABLE perfil_atleta (
                               id_perfil_atleta INT AUTO_INCREMENT PRIMARY KEY,
                               id_atleta INT UNIQUE,
                               modalidade VARCHAR(100),
                               nivel_experiencia VARCHAR(50),
                               objetivo VARCHAR(100),
                               altura FLOAT,
                               peso FLOAT,
                               dias_semana VARCHAR(100),
                               tempo_sessao VARCHAR(50),
                               ambiente VARCHAR(100),
                               sexo VARCHAR(20),
                               restricao_fisica VARCHAR(255),
                               FOREIGN KEY (id_atleta) REFERENCES atleta(id_atleta)
                                   ON DELETE CASCADE
);


-- TABELA: Esporte
CREATE TABLE esporte (
                         id_esporte INT AUTO_INCREMENT PRIMARY KEY,
                         nome_treino VARCHAR(100)
);


-- TABELA: Equipe
CREATE TABLE equipe (
                        id_equipe INT AUTO_INCREMENT PRIMARY KEY,
                        nome VARCHAR(100),
                        quantidade_membros INT,
                        id_treinador INT,
                        id_esporte INT,
                        FOREIGN KEY (id_treinador) REFERENCES treinador(id_treinador)
                            ON DELETE SET NULL,

                        FOREIGN KEY (id_esporte) REFERENCES esporte(id_esporte)
                            ON DELETE SET NULL
);


-- TABELA: Relacionamento N:N Atleta x Equipe
CREATE TABLE atleta_equipe (
                               id_atleta INT,
                               id_equipe INT,
                               PRIMARY KEY (id_atleta, id_equipe),
                               FOREIGN KEY (id_atleta) REFERENCES atleta(id_atleta)
                                   ON DELETE CASCADE,

                               FOREIGN KEY (id_equipe) REFERENCES equipe(id_equipe)
                                   ON DELETE CASCADE
);

-- TABELA: Ranking
CREATE TABLE ranking (
                         id_ranking INT AUTO_INCREMENT PRIMARY KEY,
                         posicao INT,
                         pontuacao INT,
                         data_atualizacao DATE,
                         id_equipe INT,
                         id_treinador INT,
                         FOREIGN KEY (id_equipe) REFERENCES equipe(id_equipe)
                             ON DELETE CASCADE,

                         FOREIGN KEY (id_treinador) REFERENCES treinador(id_treinador)
                             ON DELETE SET NULL
);


-- TABELA: Treino
CREATE TABLE treino (
                        id_treino INT AUTO_INCREMENT PRIMARY KEY,
                        nome VARCHAR(100),
                        data_criacao DATE,
                        duracao_total INT,
                        status VARCHAR(50)
);


-- TABELA: TreinoPersonalizado (herança de Treino)
CREATE TABLE treino_personalizado (
                                      id_treino_personalizado INT PRIMARY KEY,
                                      FOREIGN KEY (id_treino_personalizado) REFERENCES treino(id_treino)
                                          ON DELETE CASCADE
);


-- TABELA: TreinoPronto (herança de Treino)

CREATE TABLE treino_pronto (
                               id_treino_pronto INT PRIMARY KEY,
                               FOREIGN KEY (id_treino_pronto) REFERENCES treino(id_treino)
                                   ON DELETE CASCADE
);


-- TABELA: ItemTreino
CREATE TABLE item_treino (
                             id_item_treino INT AUTO_INCREMENT PRIMARY KEY,
                             id_treino INT NOT NULL,
                             nome_exercicio VARCHAR(100),
                             series INT,
                             repeticoes INT,
                             tempo INT,
                             ordem INT,
                             observacao VARCHAR(255),

                             FOREIGN KEY (id_treino) REFERENCES treino(id_treino)
                                 ON DELETE CASCADE
);


-- TABELA: HistoricoTreino
CREATE TABLE historico_treino (
                                  id_historico_treino INT AUTO_INCREMENT PRIMARY KEY,
                                  id_atleta INT,
                                  id_treino INT,
                                  data_execucao DATE,
                                  observacao VARCHAR(255),
                                  desempenho VARCHAR(100),
                                  FOREIGN KEY (id_atleta) REFERENCES atleta(id_atleta)
                                      ON DELETE CASCADE,

                                  FOREIGN KEY (id_treino) REFERENCES treino(id_treino)
                                      ON DELETE CASCADE
);

-- CREATE INDEX é um comando do MySQL usado para acelerar buscas em uma tabela.

CREATE INDEX idx_usuario_email ON usuario(email);
CREATE INDEX idx_item_treino_treino ON item_treino(id_treino);
CREATE INDEX idx_historico_atleta ON historico_treino(id_atleta);