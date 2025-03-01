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
('Camila Rocha', 'Rua da Esperança, 404', '55443-221', 'Brasília', 'DF'),
('Lucas Martins', 'Rua do Campo, 567', '23456-789', 'São Paulo', 'SP'),
('Isabela Costa', 'Av. Rio Branco, 678', '87654-321', 'Rio de Janeiro', 'RJ'),
('Marcos Pereira', 'Rua do Comércio, 234', '34567-890', 'Belo Horizonte', 'MG'),
('Larissa Silva', 'Av. Maracanã, 432', '76543-210', 'Curitiba', 'PR'),
('Felipe Almeida', 'Rua do Limoeiro, 654', '87656-432', 'Fortaleza', 'CE'),
('Carla Rocha', 'Av. dos Anjos, 765', '98765-432', 'Porto Alegre', 'RS'),
('Vinícius Santos', 'Rua da Liberdade, 876', '22334-556', 'Manaus', 'AM'),
('Beatriz Lima', 'Rua São João, 987', '66554-443', 'Recife', 'PE'),
('Eduardo Costa', 'Av. das Estrelas, 543', '55667-777', 'Salvador', 'BA'),
('Raquel Martins', 'Rua do Sol, 321', '44556-998', 'Brasília', 'DF');

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
('TELEFONE', '6133445566', 10),
-- Lucas Martins (id = 11)
('TELEFONE', '1122336677', 11),
('CELULAR', '11987654322', 11),
-- Isabela Costa (id = 12)
('CELULAR', '21999887767', 12),
('TELEFONE', '2133445567', 12),
-- Marcos Pereira (id = 13)
('TELEFONE', '3133445567', 13),
('CELULAR', '31988776656', 13),
-- Larissa Silva (id = 14)
('CELULAR', '41977665545', 14),
('TELEFONE', '4144556678', 14),
-- Felipe Almeida (id = 15)
('CELULAR', '85966554434', 15),
('TELEFONE', '8588776656', 15),
-- Carla Rocha (id = 16)
('TELEFONE', '5188776656', 16),
('CELULAR', '51999887767', 16),
-- Vinícius Santos (id = 17)
('TELEFONE', '9233445567', 17),
('CELULAR', '92988776656', 17),
-- Beatriz Lima (id = 18)
('TELEFONE', '8133445567', 18),
('CELULAR', '81988776656', 18),
-- Eduardo Costa (id = 19)
('CELULAR', '71999887767', 19),
('TELEFONE', '7133445567', 19),
-- Raquel Martins (id = 20)
('CELULAR', '61999887767', 20),
('TELEFONE', '6133445567', 20);
