CREATE DATABASE clinica;

USE clinica;

CREATE TABLE pacientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    cpf VARCHAR(14) UNIQUE,
    email VARCHAR(100)
);

CREATE TABLE medicos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    especialidade VARCHAR(100)
);

CREATE TABLE consultas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    paciente_id INT,
    medico_id INT,
    data_consulta DATETIME,
    status VARCHAR(20) DEFAULT 'AGENDADA',
    FOREIGN KEY (paciente_id) REFERENCES pacientes(id),
    FOREIGN KEY (medico_id) REFERENCES medicos(id)
);

CREATE TABLE especialidades (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
);

INSERT INTO especialidades (nome) VALUES 
('Clínico Geral'),
('Cardiologia'),
('Pediatria'),
('Ortopedia'),
('Dermatologia'),
('Ginecologia'),
('Urologia'),
('Neurologia'),
('Psiquiatria'),
('Oftalmologia'),
('Otorrinolaringologia'),
('Endocrinologia'),
('Gastroenterologia'),
('Reumatologia'),
('Oncologia'),
('Nefrologia'),
('Infectologia'),
('Hematologia'),
('Anestesiologia');
