USE master
GO
DROP DATABASE faculdade

CREATE DATABASE faculdade
GO
USE faculdade
GO
CREATE TABLE titulacao
(
	codigo				INT 			NOT NULL,
	titulo				VARCHAR(40) 	NOT NULL
	PRIMARY KEY (codigo)
)
GO
CREATE TABLE professor
(
	registro			INT 			NOT NULL,
	nome				VARCHAR(100)	NOT NULL,
	titulacao			INT 			NOT NULL
	PRIMARY KEY (registro)
	FOREIGN KEY (titulacao) REFERENCES titulacao (codigo)
)
GO
CREATE TABLE disciplina
(
	codigo				INT 			NOT NULL,
	nome				VARCHAR(80),
	carga_horaria		INT
	PRIMARY KEY (codigo)
)
GO
CREATE TABLE disciplina_professor
(
	disciplina_codigo	INT 			NOT NULL,
	professor_registro 	INT 			NOT NULL
	PRIMARY KEY (disciplina_codigo, professor_registro)
	FOREIGN KEY (disciplina_codigo) REFERENCES disciplina (codigo),
	FOREIGN KEY (professor_registro) REFERENCES professor (registro)
)
GO
CREATE TABLE aluno
(
	ra					INT 			NOT NULL,
	nome				VARCHAR(100) 	NOT NULL,
	idade				INT				NOT NULL
	PRIMARY KEY (ra)
)
GO
CREATE TABLE aluno_disciplina
(
	aluno_ra			INT				NOT NULL,
	disciplina_codigo	INT 			NOT NULL
	PRIMARY KEY (aluno_ra, disciplina_codigo)
	FOREIGN KEY (aluno_ra) REFERENCES aluno (ra),
	FOREIGN KEY (disciplina_codigo) REFERENCES disciplina (codigo)
)
GO
CREATE TABLE curso
(
	codigo				INT				NOT NULL,
	nome				VARCHAR(50)		NOT NULL,
	area				VARCHAR(50)		NOT NULL
	PRIMARY KEY (codigo)
)
GO
CREATE TABLE curso_disciplina
(
	curso_codigo		INT 			NOT NULL,
	disciplina_codigo	INT 			NOT NULL
	PRIMARY KEY (curso_codigo, disciplina_codigo)
	FOREIGN KEY (curso_codigo) REFERENCES curso (codigo),
	FOREIGN KEY (disciplina_codigo) REFERENCES disciplina (codigo)
)




