INSERT INTO local (nome, tipo, andar) VALUES
('Entrada', 'Entrada', 1),
('Secretaria', 'Secretaria', 1),
('Auditorio', 'Auditorio', 1),
('CRCA', 'Secretaria', 1),
('Cantina', 'Cantina', 1),
('Diretoria', 'Secretaria', 1),
('Cantina_professores', 'Cantina', 1),
('Biblioteca', 'Biblioteca', 1),
('BanheiroF_biblioteca', 'Banheiro', 1),
('BanheiroM_biblioteca', 'Banheiro', 1),
('BanheiroPCD_biblioteca', 'Banheiro', 1),
('Patio', 'Patio', 1),
('Lanchonete', 'Lanchonete', 1),
('Vestiario1', 'Vestiario', 1),
('Vestiario2', 'Vestiario', 1),
('Vestiario3', 'Vestiario', 1),
('Vestiario4', 'Vestiario', 1),
('Patio_quadra', 'Patio', 1),
('BanheiroF_estacionamento', 'Banheiro', 1),
('BanheiroM_estacionamento', 'Banheiro', 1),
('BanheiroPCD_estacionamento', 'Banheiro', 1),
('Estacionamento', 'Estacionamento', 1),
('Jardim', 'Jardim', 1),
('Laboratorio1', 'Laboratorio', 1),
('Laboratorio2', 'Laboratorio', 1),
('Laboratorio3', 'Laboratorio', 1),
('Laboratorio4', 'Laboratorio', 1),
('Escada1', 'Escada', 1),
('Escada2', 'Escada', 1),
('Sala_professores', 'Sala', 1),
('CAE', 'Secretaria', 1),
('CAPNE', 'Secretaria', 1);


INSERT INTO estudante (nome, matricula, email, senha, curso) VALUES
('Laila', '14486152670', 'laila.alves@estudante.iftm.edu.br', 'laila123', 'Sistemas para Internet'),
('Matheus', '14587159640', 'matheus.roldao@estudante.iftm.edu.br', 'matheus123', 'Sistemas para Internet'),
('Lazaro', '12365489752', 'lazaro.araujo@estudante.iftm.edu.br', 'lazaro123', 'Sistemas para Internet'),
('Gabriel', '14589632175', 'gabriel.st@estudante.iftm.edu.br', 'gabriel123', 'Sistemas para Internet'),
('Victor', '18879456238', 'victor.caua@estudante.iftm.edu.br', 'victor123', 'Sistemas para Internet');



INSERT INTO caminho (origem, destino, distancia) VALUES
-- Como os IDs são gerados automaticamente pelo AUTO_INCREMENT, considerando que você executou o cadastro dos locais na ordem que enviou, eles serão de 1 a 32.
-- Sala dos professores <-> Laboratório 1
(30, 24, 92),
(24, 30, 92),

-- Laboratório 1 <-> Laboratório 2
(24, 25, 1107),
(25, 24, 1107),

-- Laboratório 2 <-> Laboratório 3
(25, 26, 106),
(26, 25, 106),

-- Laboratório 3 <-> Laboratório 4
(26, 27, 606),
(27, 26, 606),

-- Biblioteca <-> Banheiro PCD
(8, 11, 391),
(11, 8, 391),

-- Banheiro PCD <-> Banheiro feminino
(11, 9, 363),
(9, 11, 363),

-- Banheiro feminino <-> Banheiro masculino
(9, 10, 90),
(10, 9, 90),

-- Cantina <-> Laboratório 1
(5, 24, 2150),
(24, 5, 2150),

-- Cantina <-> Diretoria
(5, 6, 2280),
(6, 5, 2280),

-- Cantina <-> Banheiro PCD
(5, 11, 2120),
(11, 5, 2120);
