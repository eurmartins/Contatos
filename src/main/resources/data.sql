INSERT INTO pessoa (nome, endereco, cep, cidade, uf) VALUES
('João Silva', 'Rua das Flores, 123', '12345-678', 'São Paulo', 'SP'),
('Maria Oliveira', 'Av. Brasil, 456', '98765-432', 'Rio de Janeiro', 'RJ'),
('Carlos Santos', 'Rua da Paz, 789', '45678-123', 'Belo Horizonte', 'MG'),
('Ana Souza', 'Rua do Sol, 321', '11223-445', 'Curitiba', 'PR'),
('Pedro Lima', 'Av. Central, 555', '55667-889', 'Fortaleza', 'CE'),
('Juliana Mendes', 'Rua Primavera, 888', '33445-667', 'Porto Alegre', 'RS'),
('Rafael Ferreira', 'Travessa dos Sonhos, 101', '99887-776', 'Manaus', 'AM'),
('Fernanda Costa', 'Rua das Árvores, 202', '77665-554', 'Recife', 'PE'),
('Gustavo Almeida', 'Av. Oceano, 303', '66554-332', 'Salvador', 'BA'),
('Camila Rocha', 'Rua da Esperança, 404', '55443-221', 'Brasília', 'DF');

INSERT INTO contato (tipo_contato, contato, pessoa_id) VALUES
-- João Silva (id = 1)
('TELEFONE', '1122334455', 1),
('CELULAR', '11987654321', 1),
-- Maria Oliveira (id = 2)
('CELULAR', '21999887766', 2),
('TELEFONE', '2133445566', 2),
-- Carlos Santos (id = 3)
('TELEFONE', '3133445566', 3),
('CELULAR', '31988776655', 3),
-- Ana Souza (id = 4)
('CELULAR', '41977665544', 4),
('TELEFONE', '4144556677', 4),
-- Pedro Lima (id = 5)
('CELULAR', '85966554433', 5),
('TELEFONE', '8588776655', 5),
-- Juliana Mendes (id = 6)
('TELEFONE', '5188776655', 6),
('CELULAR', '51999887766', 6),
-- Rafael Ferreira (id = 7)
('TELEFONE', '9233445566', 7),
('CELULAR', '92988776655', 7),
-- Fernanda Costa (id = 8)
('TELEFONE', '8133445566', 8),
('CELULAR', '81988776655', 8),
-- Gustavo Almeida (id = 9)
('CELULAR', '71999887766', 9),
('TELEFONE', '7133445566', 9),
-- Camila Rocha (id = 10)
('CELULAR', '61999887766', 10),
('TELEFONE', '6133445566', 10);

