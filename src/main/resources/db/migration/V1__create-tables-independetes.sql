-- V1__create-tables-base.sql
CREATE TABLE curso (
  id BIGINT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL,
  categoria VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE perfil (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE usuario (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE usuario_perfil (
    usuario_id BIGINT NOT NULL,
    perfil_id BIGINT NOT NULL,
    PRIMARY KEY (usuario_id, perfil_id),
    CONSTRAINT fk_usuario_perfil_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id),
    CONSTRAINT fk_usuario_perfil_perfil FOREIGN KEY (perfil_id) REFERENCES perfil(id)
);


CREATE TABLE topico (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    mensagem TEXT NOT NULL,
    data_criacao TIMESTAMP NOT NULL,
    status VARCHAR(50) NOT NULL,
    autor_id BIGINT NOT NULL,
    curso_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_topico_autor FOREIGN KEY (autor_id) REFERENCES usuario(id),
    CONSTRAINT fk_topico_curso FOREIGN KEY (curso_id) REFERENCES curso(id)
);

-- V3__create-table-resposta.sql
CREATE TABLE resposta (
   id BIGINT NOT NULL AUTO_INCREMENT,
   mensagem TEXT NOT NULL,
   topico_id BIGINT NOT NULL,
   data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   autor_id BIGINT NOT NULL,
   solucao BOOLEAN DEFAULT FALSE,
   PRIMARY KEY (id),
   CONSTRAINT fk_resposta_topico FOREIGN KEY (topico_id) REFERENCES topico(id),
   CONSTRAINT fk_resposta_autor FOREIGN KEY (autor_id) REFERENCES usuario(id)
);